package com.lovetocode.ratelimit.Service.impl;

import java.util.List;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lovetocode.ratelimit.Service.DeveloperService;
import com.lovetocode.ratelimit.domain.DeveloperEntity;
import com.lovetocode.ratelimit.repository.DeveloperRepository;

@Service
public class DeveloperServiceImpl implements DeveloperService {

  private Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());
  
  @Autowired
  private DeveloperRepository repo;
  
  @Override
  public List<DeveloperEntity> findAllDevelopers() {
    logger.info("fetching the developer data");
    return repo.findAll();
  }

}
