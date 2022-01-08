package com.ipru.mca.BikeOpedia.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class CarDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "c_id")
 private long carid;
	
	private String type;
	private long    lowerRange;
	 private long   higherRange;
	public CarDetails( String type, long lowerRange, long higherRange) {
		super();
		//this.bikeid = bikeid;
		this.type = type;
		this.lowerRange = lowerRange;
		this.higherRange = higherRange;
	}
	public CarDetails() {
		super();
	}
	public long getBikeid() {
		return carid;
	}
	public void setBikeid(long carid) {
		this.carid = carid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public long getLowerRange() {
		return lowerRange;
	}
	public void setLowerRange(long lowerRange) {
		this.lowerRange = lowerRange;
	}
	public long getHigherRange() {
		return higherRange;
	}
	public void setHigherRange(long higherRange) {
		this.higherRange = higherRange;
	}
	@Override
	public String toString() {
		return "CarDetails [carid=" + carid + ", type=" + type + ", lowerRange=" + lowerRange + ", higherRange="
				+ higherRange + "]";
	}
}
