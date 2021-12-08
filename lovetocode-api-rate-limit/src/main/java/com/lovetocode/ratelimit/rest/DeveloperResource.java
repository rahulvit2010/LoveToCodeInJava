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

import com.lovetocode.ratelimit.Service.DeveloperService;
import com.lovetocode.ratelimit.constant.RestConstant;
import com.lovetocode.ratelimit.domain.DeveloperEntity;
import com.lovetocode.ratelimit.dto.DeveloperDto;
import com.lovetocode.ratelimit.rest.converter.DeveloperEntityToDtoConverter;

@RestController
@RequestMapping(RestConstant.API+RestConstant.V1+RestConstant.DEVELOPERS)
public class DeveloperResource {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	DeveloperService developerService;
	
	@Autowired
	DeveloperEntityToDtoConverter developerEntityToDtoConverter;

	@GetMapping(produces = { "application/json"})
	public ResponseEntity<Object> getAllDevelopers(@RequestHeader(value = "user-name") String userName, HttpServletRequest req) {

		logger.info("{}", req.getRequestURI());
		 List<DeveloperEntity> developerEntities=developerService.findAllDevelopers();
		 
		 List<DeveloperDto> dtos=developerEntities.stream().map(entity->developerEntityToDtoConverter.convert(entity)).collect(Collectors.toList());
		 
		return new ResponseEntity<>(dtos,HttpStatus.OK);

	}

}
