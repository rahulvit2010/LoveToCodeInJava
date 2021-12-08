package com.lovetocode.ratelimit.Service.impl;

import java.util.List;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lovetocode.ratelimit.Service.OrganizationService;
import com.lovetocode.ratelimit.domain.OrganizationEntity;
import com.lovetocode.ratelimit.repository.OrganizationRepository;

@Service
public class OrganizationServiceImpl implements OrganizationService {

  private Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());
  
  @Autowired
  OrganizationRepository organizationRepository;
  
  @Override
  public List<OrganizationEntity> findAllOrganizations() {
    logger.info("fetching the Organization Data");
    return organizationRepository.findAll();
  }

}
