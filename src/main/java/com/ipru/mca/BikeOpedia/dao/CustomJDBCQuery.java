package com.ipru.mca.BikeOpedia.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.ipru.mca.BikeOpedia.Logging.BikeLogging;
import com.ipru.mca.BikeOpedia.entity.CarDetails;
import com.ipru.mca.BikeOpedia.model.BikeBO;
import com.ipru.mca.BikeOpedia.model.BikeInput;

@Service
public class CustomJDBCQuery {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	@Qualifier("loggingtemplate")
	JdbcTemplate jdbclogTemplate;

	Logger log = LoggerFactory.getLogger(CustomJDBCQuery.class);
	public void insertData(CarDetails details) {
		log.info("insertData service called");
		jdbcTemplate.update("Insert into CARDETAILS (HIGHERRANGE,LOWERRANGE,TYPE) VALUES (?,?,?)",
				details.getHigherRange(), details.getLowerRange(), details.getType());
	}

	public void insertData(BikeLogging details) {
		jdbclogTemplate.update("INSERT into  BIKELOGGING (REQUEST,RESPONSE,ERROR,S_NAME) values (?,?,?,?)",
				details.getRequest(), details.getResponse(), details.getError(), details.getServiceName());
	}

	public List<BikeBO> getBikeData(BikeInput input) {
		log.info("getBikeData service called,input:"+input);
		List<BikeBO> bikebo = new ArrayList<>();
		List<Map<String, Object>> result = jdbcTemplate.queryForList(
				"SELECT * FROM BIKEDETAILS where exshowroom between ? and ? AND POSITION( ? IN DETAILS)",
				input.getMinvalue(), input.getMaxvalue(), input.getType());
		Iterator<Map<String, Object>> listiterator = result.iterator();
		while (listiterator.hasNext()) {
			BikeBO bike = new BikeBO();
			Map<String, Object> resultMAp = listiterator.next();
			Set<Entry<String, Object>> resultset = resultMAp.entrySet();
			Iterator<Entry<String, Object>> entryIterator = resultset.iterator();
			while (entryIterator.hasNext()) {
				Entry<String, Object> entry = entryIterator.next();
				System.out.println("entry class" + entry.getKey() + ":" + entry.getValue());
				
				// BikeDetails details=(BikeDetails)entry.getValue();
				// BikeBO bike = new BikeBO();
				/*
				 * switch (entry.getKey()) { case "DETAILS": bike.setDetails((String)
				 * entry.getValue());
				 * 
				 * case "MODEL": bike.setModel((String) entry.getValue()); case "VERSION":
				 * bike.setVersion((String) entry.getValue()); case "EXSHOWROOM":
				 * System.out.println(entry.getKey()+":::::" +entry.getValue()); //
				 * bike.setExshowroom((Double) entry.getValue()); }
				 */
			if(entry.getKey().equals("DETAILS"))
				bike.setDetails((String) entry.getValue());
				 
			
				if(entry.getKey().equals("MODEL"))
				bike.setModel((String) entry.getValue());
			
				if(entry.getKey().equals("VERSION"))
				bike.setVersion((String) entry.getValue());
			
				if(entry.getKey().equals("EXSHOWROOM"))
					bike.setExshowroom((Double) entry.getValue());
			 // System.out.println(entry.getKey()+":::::" +entry.getValue());
			 

			}
			bikebo.add(bike);
		}
		//System.out.println(bikebo);
		log.info("getBikeData service executed,output:"+bikebo);
		return bikebo;

	}

}
