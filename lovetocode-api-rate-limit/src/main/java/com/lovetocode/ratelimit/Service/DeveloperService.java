package com.lovetocode.ratelimit.Service;

import java.util.List;

import com.lovetocode.ratelimit.domain.DeveloperEntity;

public interface DeveloperService {

  public List<DeveloperEntity> findAllDevelopers();
}
