package com.lovetocode.ratelimit.domain;

import java.util.Objects;

/*it is immutable class which we are using  as a key 
 to keep the bucket info in concurrent hash map for
  per (user and api) combination */
public class PerUserApiKey {

  private final String user;
  private final String api;

  public PerUserApiKey(String user, String api) {
    this.user = user;
    this.api = api;
  }

  public String getUser() {
    return user;
  }

  public String getApi() {
    return api;
  }

  @Override
  public int hashCode() {
    return Objects.hash(api, user);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    PerUserApiKey other = (PerUserApiKey) obj;
    return Objects.equals(api, other.api) && Objects.equals(user, other.user);
  }



}
