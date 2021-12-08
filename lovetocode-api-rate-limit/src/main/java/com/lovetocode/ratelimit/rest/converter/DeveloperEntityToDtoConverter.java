package com.lovetocode.ratelimit.rest.converter;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;
import com.lovetocode.ratelimit.domain.DeveloperEntity;
import com.lovetocode.ratelimit.dto.DeveloperDto;

@Component
public class DeveloperEntityToDtoConverter implements Converter<DeveloperEntity, DeveloperDto> {

  @Override
  public DeveloperDto convert(DeveloperEntity entity) {
    return new DeveloperDto(entity.getId(), entity.getName(), entity.getPosition(),
        entity.getProjectAssigned(), entity.getPrimarySkill());
  }

  @Override
  public JavaType getInputType(TypeFactory typeFactory) {
    return null;
  }

  @Override
  public JavaType getOutputType(TypeFactory typeFactory) {
    return null;
  }

}
