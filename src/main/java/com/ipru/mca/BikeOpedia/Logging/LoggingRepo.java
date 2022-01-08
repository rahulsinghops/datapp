package com.ipru.mca.BikeOpedia.Logging;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface LoggingRepo extends JpaRepository<BikeLogging, Long> {

}
