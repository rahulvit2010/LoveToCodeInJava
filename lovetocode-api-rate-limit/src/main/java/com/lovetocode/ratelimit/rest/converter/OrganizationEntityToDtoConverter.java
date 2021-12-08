package com.lovetocode.ratelimit.rest.converter;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;
import com.lovetocode.ratelimit.domain.OrganizationEntity;
import com.lovetocode.ratelimit.dto.OrganizationDto;

@Component
public class OrganizationEntityToDtoConverter
    implements Converter<OrganizationEntity, OrganizationDto> {

  @Override
  public OrganizationDto convert(OrganizationEntity entity) {
    return new OrganizationDto(entity.getId(), entity.getName(), entity.getDomain(),
        entity.getHeadCount(), entity.getHeadQuater());
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
