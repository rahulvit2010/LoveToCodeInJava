package com.lovetocode.ratelimit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lovetocode.ratelimit.domain.DeveloperEntity;

public interface DeveloperRepository extends JpaRepository<DeveloperEntity, Long> {

}
