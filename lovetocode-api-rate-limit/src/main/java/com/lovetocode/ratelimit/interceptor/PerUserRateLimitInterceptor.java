package com.lovetocode.ratelimit.interceptor;

import java.time.Duration;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.lovetocode.ratelimit.config.DbConfigLoader;
import com.lovetocode.ratelimit.constant.RestConstant;
import com.lovetocode.ratelimit.domain.PerUserApiKey;
import com.lovetocode.ratelimit.domain.RateLimitEntity;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Bucket4j;
import io.github.bucket4j.ConsumptionProbe;
import io.github.bucket4j.Refill;

@Component
public class PerUserRateLimitInterceptor implements HandlerInterceptor {

  @Autowired
  DbConfigLoader dbConfigLoader;

  private Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());

  /* keeping bucket info for per (User+api) */
  private final Map<PerUserApiKey, Bucket> buckets = new ConcurrentHashMap<>();

  /* Default Bucket with default rate in case no rate limit is definer for per (User+api) */
  private final Bucket defaultBucket = Bucket4j.builder()
      .addLimit(Bandwidth.classic(10, Refill.intervally(10, Duration.ofMinutes(1)))).build();

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    logger.info("before the api [{}] handler is invoked",request.getRequestURI());
    String userName = request.getHeader("user-name");
    
    //missing header check
    if (Objects.isNull(userName)) {
      response.getWriter().write(RestConstant.MISSING_HEADER);
      response.setStatus(HttpStatus.BAD_REQUEST.value());
      return false;
    }
    
    return createBucketAndCheckLimit(request,response,userName);

  }
  
  /*
   * this method will create buckets
   * 1- defined bucket as per the rate limit defined  for per (user + api)
   * 2- if there is no limit defined for user then default bucket will be
   *    created as per the default rate limit 10
   */
  private boolean createBucketAndCheckLimit(HttpServletRequest request,
      HttpServletResponse response, String userName) throws Exception  {
    Bucket requestBucket;
    String uri = request.getRequestURI();
    PerUserApiKey apiKey = new PerUserApiKey(userName, uri);
    if (dbConfigLoader.getRateLimitConfigPerUser().containsKey(apiKey)) {
      RateLimitEntity rateLimitConfig = dbConfigLoader.getRateLimitConfigPerUser().get(apiKey);
      requestBucket = this.buckets.computeIfAbsent(apiKey, key -> definedBucket(rateLimitConfig));
    } else {
      requestBucket = this.defaultBucket;
    }
    ConsumptionProbe probe = requestBucket.tryConsumeAndReturnRemaining(1);
    if (probe.isConsumed()) {
      response.addHeader("X-Rate-Limit-Remaining", Long.toString(probe.getRemainingTokens()));
      return true;
    }

    response.setStatus(HttpStatus.TOO_MANY_REQUESTS.value()); // 429
    response.addHeader("X-Rate-Limit-Retry-After-Milliseconds",
        Long.toString(TimeUnit.NANOSECONDS.toMillis(probe.getNanosToWaitForRefill())));
    response.getWriter()
        .write("Retry after "
            + Long.toString(TimeUnit.NANOSECONDS.toMillis(probe.getNanosToWaitForRefill()))
            + " milliseconds");
    return false;
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
      ModelAndView modelAndView) throws Exception {
    logger.info("api [{}] handler is executed",request.getRequestURI());
    HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
      Object handler, Exception ex) throws Exception {
    logger.info("Reuest to api [{}] has completed",request.getRequestURI());
    HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
  }
  
  /* defining the bucket as per the rate limit defined per (user + api) */
  private static Bucket definedBucket(RateLimitEntity rateLimitConfig) {
    return Bucket4j.builder()
        .addLimit(Bandwidth.classic(rateLimitConfig.getRateLimit(),
            Refill.intervally(rateLimitConfig.getRateLimit(),
                Duration.ofMinutes(rateLimitConfig.getResetInterval()))))
        .build();
  }

}
