package com.lovetocode.ratelimit.rest;

import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lovetocode.ratelimit.Service.OrganizationService;
import com.lovetocode.ratelimit.constant.RestConstant;
import com.lovetocode.ratelimit.domain.OrganizationEntity;
import com.lovetocode.ratelimit.dto.OrganizationDto;
import com.lovetocode.ratelimit.rest.converter.OrganizationEntityToDtoConverter;

@RestController
@RequestMapping(RestConstant.API+RestConstant.V1+RestConstant.ORGANIZATIONS)
public class OrganizationResource {

  private Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());

  @Autowired
  private OrganizationService organizationService;
  
  @Autowired
  OrganizationEntityToDtoConverter organizationEntityToDtoConverter;

  @GetMapping
  public ResponseEntity<Object> getAllOrganization(@RequestHeader(value = "user-name") String userName,
      HttpServletRequest req) {
    logger.info("{}", req.getRequestURI());
    List<OrganizationEntity> organizationEntities = organizationService.findAllOrganizations();
    List<OrganizationDto> dtos=organizationEntities.stream().map(entity->organizationEntityToDtoConverter.convert(entity)).collect(Collectors.toList());
    return new ResponseEntity<>(dtos, HttpStatus.OK);
  }

}
