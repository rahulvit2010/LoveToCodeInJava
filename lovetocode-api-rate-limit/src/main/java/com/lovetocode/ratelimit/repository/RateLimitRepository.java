package com.lovetocode.ratelimit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lovetocode.ratelimit.domain.RateLimitEntity;

public interface RateLimitRepository extends JpaRepository<RateLimitEntity, Long>{
		
}
