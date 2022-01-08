package com.ipru.mca.BikeOpedia.Logging;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration	
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "loggingEntityManagerFactory", transactionManagerRef = "loggingTransactionManager", basePackages = {
		"com.ipru.mca.BikeOpedia.Logging" })
public class LoggingConfiguration {

	@Bean(name = "loggingDataSource")
	@ConfigurationProperties(prefix = "logging.datasource")

	public DataSource getLoggingDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "loggingEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("loggingDataSource") DataSource dataSource) {
		return builder.dataSource(dataSource).packages(BikeLogging.class).persistenceUnit("db2")
				.build();
	}

	@Bean(name = "loggingTransactionManager")
	public PlatformTransactionManager customerTransactionManager(
			@Qualifier("loggingEntityManagerFactory") EntityManagerFactory loggingEntityManagerFactory) {
		return new JpaTransactionManager(loggingEntityManagerFactory);
	}

}
