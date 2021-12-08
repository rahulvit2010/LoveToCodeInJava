package com.lovetocode.ratelimit.dto;

public class DeveloperDto {

  private Long id;
  private final String name;
  private final String position;
  private final String projectAssigned;
  private final String primarySkill;

  public DeveloperDto(Long id, String name, String position, String projectAssigned,
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

  public String getProjectAssign() {
    return projectAssigned;
  }

  public String getPrimarySkill() {
    return primarySkill;
  }

}
