package com.ipru.mca.BikeOpedia;

import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ipru.mca.BikeOpedia.dao.CustomJDBCQuery;
import com.ipru.mca.BikeOpedia.model.BikeBO;
import com.ipru.mca.BikeOpedia.model.BikeInput;
import com.ipru.mca.BikeOpedia.model.BikeTypeKey;
import com.ipru.mca.BikeOpedia.services.OTCService;

@SpringBootTest
public class BikeDetailsTest {
	@Autowired
	OTCService service;
	@MockBean
	CustomJDBCQuery custom;
	@Autowired
	BikeTypeKey typeKey;
	@Test
	public void checkOtcService()
	{
		//stub
		//List<BikeBO> stub= new ArrayList<>();
		//stub.add(new BikeBO("gixer", "db", 125000, "achi bike"));
		//System.out.println(stub.size());
		
		when(custom.getBikeData(new BikeInput("ranchi", "naked", 100000, 150000))).thenReturn(Arrays.asList(new BikeBO("gixer", "db", 125000, "achi bike")));
		System.out.println(custom.getBikeData(new BikeInput("ranchi", "naked", 100000, 150000)));
		//assertion
		Assertions.assertEquals(1, service.getBikeDeatails(new BikeInput("ranchi", "naked", 100000, 150000)).getBikedetails().size());
	}

}
