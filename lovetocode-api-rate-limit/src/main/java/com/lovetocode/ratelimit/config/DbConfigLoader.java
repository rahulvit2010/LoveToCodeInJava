package com.lovetocode.ratelimit.config;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import com.lovetocode.ratelimit.domain.PerUserApiKey;
import com.lovetocode.ratelimit.domain.RateLimitEntity;
import com.lovetocode.ratelimit.repository.RateLimitRepository;

@Component
@EnableScheduling
public class DbConfigLoader {

  @Autowired
  private RateLimitRepository repository;

  private Map<PerUserApiKey, RateLimitEntity> rateLimitConfigPerUser;

  /* This initMethod will retrieve the rate limit configuration
   * from database and load into the map, which can be accessed 
   * across the application
   */
  @PostConstruct
  public void initMethod() {
    List<RateLimitEntity> rateLimitConfigList = repository.findAll();
    rateLimitConfigPerUser = rateLimitConfigList.stream().collect(Collectors
        .toMap(obj -> new PerUserApiKey(obj.getUser(), obj.getUri()), Function.identity()));
  }

  public Map<PerUserApiKey, RateLimitEntity> getRateLimitConfigPerUser() {
    return rateLimitConfigPerUser;
  }

}
