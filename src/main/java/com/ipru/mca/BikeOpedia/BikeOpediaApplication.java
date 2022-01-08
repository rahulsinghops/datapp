package com.ipru.mca.BikeOpedia;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ipru.mca.BikeOpedia.dao.CustomJDBCQuery;
import com.ipru.mca.BikeOpedia.services.GetStockBikeData;

@SpringBootApplication
public class BikeOpediaApplication implements CommandLineRunner {
	@Value("${app.author}")
	private String author;

	@Autowired
	CustomJDBCQuery query;
	
	@Autowired
	GetStockBikeData stockdata;

	@Primary
	@Bean
	public JdbcTemplate db1template(@Qualifier("bikeDataSource") DataSource datasource) {
		return new JdbcTemplate(datasource);
	}

	@Bean("loggingtemplate")
	public JdbcTemplate db2template(@Qualifier("loggingDataSource") DataSource datasource) {
		return new JdbcTemplate(datasource);
	}

	public static void main(String[] args) {
		SpringApplication.run(BikeOpediaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	//	query.insertData(new CarDetails("xuv2", 11111, 22222));
		//query.insertData(new BikeLogging("testservice", "nA", "NA", "NA"));
		System.out.println("author:"+author);
		stockdata.getBikeDetails();
	//	List<BikeBO> bo= query.getBikeData(new BikeInput(author, "naked", 100000, 150000));
		//System.out.println("list:"+bo);
		String directory=System.getProperty("user.dir");
		System.out.println("directory"+directory);

	}

}
