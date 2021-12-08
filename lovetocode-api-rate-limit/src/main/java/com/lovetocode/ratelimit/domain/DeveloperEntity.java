package com.lovetocode.ratelimit.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "developers")
public class DeveloperEntity {

  @Id
  @Column(name = "id")
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "position")
  private String position;

  @Column(name = "project_assigned")
  private String projectAssigned;

  @Column(name = "primary_skill")
  private String primarySkill;

  public DeveloperEntity() {}

  public DeveloperEntity(Long id, String name, String position, String projectAssigned,
      String primarySkill) {
    super();
    this.id = id;
    this.name = name;
    this.position = position;
    this.projectAssigned = projectAssigned;
    this.primarySkill = primarySkill;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getPosition() {
    return position;
  }

  public String getProjectAssigned() {
    return projectAssigned;
  }

  public String getPrimarySkill() {
    return primarySkill;
  }
}
