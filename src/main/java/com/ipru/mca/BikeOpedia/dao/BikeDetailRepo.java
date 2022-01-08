package com.ipru.mca.BikeOpedia.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ipru.mca.BikeOpedia.entity.BikeDetails;
@Repository
public interface BikeDetailRepo extends JpaRepository<BikeDetails, Long> {

}
