package com.lovetocode.ratelimit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lovetocode.ratelimit.domain.OrganizationEntity;

public interface OrganizationRepository extends JpaRepository<OrganizationEntity, Long> {
}
