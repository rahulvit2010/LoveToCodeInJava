package com.lovetocode.ratelimit.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rate_limit_config")
public class RateLimitEntity {

  @Id
  @Column(name = "id")
  private Long id;

  @Column(name = "user_id")
  private String userName; // Should be unique

  @Column(name = "api_uri")
  private String uri;

  @Column(name = "rate_limit")
  private Integer rateLimit;

  @Column(name = "reset_interval")
  private Integer resetInterval;

  public RateLimitEntity() {}

  public RateLimitEntity(String userName, Integer rateLimit, String uri,Integer resetInterval) {
    super();
    this.userName = userName;
    this.rateLimit = rateLimit;
    this.uri = uri;
    this.resetInterval = resetInterval;
  }



  public String getUser() {
    return userName;
  }

  public void setUser(String userName) {
    this.userName = userName;
  }

  public Integer getRateLimit() {
    return rateLimit;
  }

  public void setRateLimit(Integer rateLimit) {
    this.rateLimit = rateLimit;
  }

  public String getUri() {
    return uri;
  }

  public void setUri(String uri) {
    this.uri = uri;
  }

  public Integer getResetInterval() {
    return resetInterval;
  }

  public void setResetInterval(Integer resetInterval) {
    this.resetInterval = resetInterval;
  }



}
