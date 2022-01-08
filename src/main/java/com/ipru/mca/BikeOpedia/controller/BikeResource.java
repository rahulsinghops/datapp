package com.ipru.mca.BikeOpedia.controller;

import java.util.Date;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ipru.mca.BikeOpedia.Logging.BikeLogging;
import com.ipru.mca.BikeOpedia.Logging.LoggingRepo;
import com.ipru.mca.BikeOpedia.model.BikeException;
import com.ipru.mca.BikeOpedia.model.BikeInput;
import com.ipru.mca.BikeOpedia.model.BikeOutput;
import com.ipru.mca.BikeOpedia.services.OTCService;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/mca")
public class BikeResource {
	@Autowired
	LoggingRepo logging;
	@Autowired
	OTCService service;
	
	Logger log = LoggerFactory.getLogger(BikeResource.class);
	
	//for swagger documentation 
		@ApiOperation(value = " To get Bike Details",consumes = "application/json")
	@RequestMapping(method = RequestMethod.POST,path = "/bikes",consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> getBikes( @RequestBody @Valid BikeInput input)
	{
		log.info("getBikes called");
		BikeLogging bikelog=logging.save(new BikeLogging("getBikes", input.toString(), null, null));
		
		try {
		BikeOutput response = service.getBikeDeatails(input);
		response.setResponsecode(HttpStatus.ACCEPTED.value()+"");
		log.info("getBikes executed");
		bikelog.setResponse(response.toString());
		logging.save(bikelog);
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
		}
		catch(Exception e)
		{
			log.error("getBikes error occured");
			bikelog.setError(e.getMessage());
			logging.save(bikelog);
			return new ResponseEntity<>(new BikeException(new Date(), "Try Again", HttpStatus.LOCKED.toString()), HttpStatus.LOCKED);
		}
		
		
		

		
	}
	
	

}
