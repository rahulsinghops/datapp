package com.ipru.mca.BikeOpedia.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipru.mca.BikeOpedia.dao.CustomJDBCQuery;
import com.ipru.mca.BikeOpedia.model.BikeBO;
import com.ipru.mca.BikeOpedia.model.BikeInput;
import com.ipru.mca.BikeOpedia.model.BikeOutput;
import com.ipru.mca.BikeOpedia.model.BikeTypeKey;

@Service
public class OTCService {

	@Autowired
	CustomJDBCQuery custom;
	
	@Autowired
	BikeTypeKey typeKey;
	Logger log = LoggerFactory.getLogger(OTCService.class);

	public BikeOutput getBikeDeatails(BikeInput input) {
		//getting values for bike type from shared properties
		if(input.getType().equalsIgnoreCase("CRUISE"))
			input.setType(typeKey.getCRUISE());
		if(input.getType().equalsIgnoreCase("ECONOMY"))
			input.setType(typeKey.getECONOMY());
		if(input.getType().equalsIgnoreCase("NAKED"))
			input.setType(typeKey.getNAKED());
		if(input.getType().equalsIgnoreCase("SCOOTER"))
			input.setType(typeKey.getSCOOTER());
		if(input.getType().equalsIgnoreCase("SPORTS"))
			input.setType(typeKey.getSPORTS());
		log.info("getBikeDeatails service invoked ,input:" + input);
		List<BikeBO> bikedetails = custom.getBikeData(input);
		log.info("getBikeDeatails service list of bike ,output:" + bikedetails);
		BikeOutput output = new BikeOutput(input.getCity(), input.getType(), null, bikedetails);
		log.info("getBikeDeatails service completed ,output:" + output);
		return output;
	}
}
