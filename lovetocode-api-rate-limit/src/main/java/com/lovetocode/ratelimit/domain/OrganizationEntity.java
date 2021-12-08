package com.lovetocode.ratelimit.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "organizations")
public class OrganizationEntity {

  @Id
  @Column(name = "id")
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "domain")
  private String domain;

  @Column(name = "head_count")
  private String headCount;

  @Column(name = "head_quater")
  private String headQuater;

  public OrganizationEntity() {}

  public OrganizationEntity(Long id, String name, String domain, String headCount,
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
