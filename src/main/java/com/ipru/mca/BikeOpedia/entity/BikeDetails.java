package com.ipru.mca.BikeOpedia.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class BikeDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "b_id")
 private long bikeid;
	private String model;
	private String version;
	@Lob
	private String details;
	private double exshowroom;
	private double p_bangalore;
	private double p_mumbai;
	private double p_pune;
	private double p_new_Delhi;
	private double p_chennai;
	private double p_kolkata;
	private double p_hyderabad;
	private double p_chandigarh;
	private double p_ahmedabad;
	public long getBikeid() {
		return bikeid;
	}
	public void setBikeid(long bikeid) {
		this.bikeid = bikeid;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public double getExshowroom() {
		return exshowroom;
	}
	public void setExshowroom(double exshowroom) {
		this.exshowroom = exshowroom;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public double getP_bangalore() {
		return p_bangalore;
	}
	public void setP_bangalore(double p_bangalore) {
		this.p_bangalore = p_bangalore;
	}
	public double getP_mumbai() {
		return p_mumbai;
	}
	public void setP_mumbai(double p_mumbai) {
		this.p_mumbai = p_mumbai;
	}
	public double getP_pune() {
		return p_pune;
	}
	public void setP_pune(double p_pune) {
		this.p_pune = p_pune;
	}
	public double getP_new_Delhi() {
		return p_new_Delhi;
	}
	public void setP_new_Delhi(double p_new_Delhi) {
		this.p_new_Delhi = p_new_Delhi;
	}
	public double getP_chennai() {
		return p_chennai;
	}
	public void setP_chennai(double p_chennai) {
		this.p_chennai = p_chennai;
	}
	public double getP_kolkata() {
		return p_kolkata;
	}
	public void setP_kolkata(double p_kolkata) {
		this.p_kolkata = p_kolkata;
	}
	public double getP_hyderabad() {
		return p_hyderabad;
	}
	public void setP_hyderabad(double p_hyderabad) {
		this.p_hyderabad = p_hyderabad;
	}
	public double getP_chandigarh() {
		return p_chandigarh;
	}
	public void setP_chandigarh(double p_chandigarh) {
		this.p_chandigarh = p_chandigarh;
	}
	public double getP_ahmedabad() {
		return p_ahmedabad;
	}
	public void setP_ahmedabad(double p_ahmedabad) {
		this.p_ahmedabad = p_ahmedabad;
	}
	public BikeDetails(String model, String version, double exshowroom, String details, double p_bangalore,
			double p_mumbai, double p_pune, double p_new_Delhi, double p_chennai, double p_kolkata, double p_hyderabad,
			double p_chandigarh, double p_ahmedabad) {
		super();
		this.model = model;
		this.version = version;
		this.exshowroom = exshowroom;
		this.details = details;
		this.p_bangalore = p_bangalore;
		this.p_mumbai = p_mumbai;
		this.p_pune = p_pune;
		this.p_new_Delhi = p_new_Delhi;
		this.p_chennai = p_chennai;
		this.p_kolkata = p_kolkata;
		this.p_hyderabad = p_hyderabad;
		this.p_chandigarh = p_chandigarh;
		this.p_ahmedabad = p_ahmedabad;
	}
	public BikeDetails() {
		super();
	}
	@Override
	public String toString() {
		return "BikeDetails [bikeid=" + bikeid + ", model=" + model + ", version=" + version + ", exshowroom="
				+ exshowroom + ", details=" + details + ", p_bangalore=" + p_bangalore + ", p_mumbai=" + p_mumbai
				+ ", p_pune=" + p_pune + ", p_new_Delhi=" + p_new_Delhi + ", p_chennai=" + p_chennai + ", p_kolkata="
				+ p_kolkata + ", p_hyderabad=" + p_hyderabad + ", p_chandigarh=" + p_chandigarh + ", p_ahmedabad="
				+ p_ahmedabad + "]";
	}
	
	
	}
