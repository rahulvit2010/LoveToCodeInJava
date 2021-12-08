package com.lovetocode.ratelimit.dto;

public class OrganizationDto {
  private final Long id;
  private final String name;
  private final String domain;
  private final String headCount;
  private final String headQuater;

  public OrganizationDto(Long id, String name, String domain, String headCount,
      String headQuater) {
    super();
    this.id = id;
    this.name = name;
    this.domain = domain;
    this.headCount = headCount;
    this.headQuater = headQuater;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getDomain() {
    return domain;
  }

  public String getHeadCount() {
    return headCount;
  }

  public String getHeadQuater() {
    return headQuater;
  }
}
