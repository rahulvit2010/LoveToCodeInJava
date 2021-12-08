package com.lovetocode.ratelimit;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ApiRateLimitGetRequestTest {

  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  public void apiRequest_rateLimit_withinLimit_user1() throws Exception {
    HttpHeaders headers = new HttpHeaders();
    headers.set("user-name", "user1");
    HttpEntity entity = new HttpEntity(headers);

    ResponseEntity<String> response = this.restTemplate.exchange(
        "http://localhost:"+port+"/"+"api/v1/developers", HttpMethod.GET, entity, String.class);
    System.out.println(response.getBody());
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat (response.getHeaders().getFirst("X-Rate-Limit-Remaining")).isNotNull();
  }
  
  @Test
  public void apiRequest_rateLimit_limitExceeded_user2() throws Exception {
    HttpHeaders headers = new HttpHeaders();
    headers.set("user-name", "user2");
    HttpEntity entity = new HttpEntity(headers);

    for(int i=1;i<3;i++)
    {
      ResponseEntity<String> response = this.restTemplate.exchange(
          "http://localhost:"+port+"/"+"api/v1/developers", HttpMethod.GET, entity, String.class);
      System.out.println(response.getHeaders().getFirst("X-Rate-Limit-Remaining"));
    }
    ResponseEntity<String> response = this.restTemplate.exchange(
        "http://localhost:"+port+"/"+"api/v1/developers", HttpMethod.GET, entity, String.class);
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.TOO_MANY_REQUESTS);
    assertThat (response.getHeaders().getFirst("X-Rate-Limit-Retry-After-Milliseconds")).isNotNull();
  }
  
  @Test
  public void apiRequest_defaultrateLimit_user6() throws Exception {
    HttpHeaders headers = new HttpHeaders();
    headers.set("user-name", "user6");
    HttpEntity entity = new HttpEntity(headers);

    ResponseEntity<String> response = this.restTemplate.exchange(
        "http://localhost:"+port+"/"+"api/v1/developers", HttpMethod.GET, entity, String.class);
    System.out.println(response.getBody());
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat (response.getHeaders().getFirst("X-Rate-Limit-Remaining")).isNotNull();
  }
}
