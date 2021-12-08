package com.lovetocode.ratelimit.Service;

import java.util.List;

import com.lovetocode.ratelimit.domain.OrganizationEntity;

public interface OrganizationService {

  public List<OrganizationEntity> findAllOrganizations();
}
