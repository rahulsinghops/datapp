package com.ipru.mca.BikeOpedia.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "bre.output")
public class BikeTypeKey {
	private String CRUISE;
	private String NAKED;
	private String SPORTS;
	private String ECONOMY;
	private String SCOOTER;
	public BikeTypeKey(String cRUISE, String nAKED, String sPORTS, String eCONOMY, String sCOOTER) {
		super();
		CRUISE = cRUISE;
		NAKED = nAKED;
		SPORTS = sPORTS;
		ECONOMY = eCONOMY;
		SCOOTER = sCOOTER;
	}
	public String getCRUISE() {
		return CRUISE;
	}
	public void setCRUISE(String cRUISE) {
		CRUISE = cRUISE;
	}
	public String getNAKED() {
		return NAKED;
	}
	public void setNAKED(String nAKED) {
		NAKED = nAKED;
	}
	public String getSPORTS() {
		return SPORTS;
	}
	public void setSPORTS(String sPORTS) {
		SPORTS = sPORTS;
	}
	public String getECONOMY() {
		return ECONOMY;
	}
	public void setECONOMY(String eCONOMY) {
		ECONOMY = eCONOMY;
	}
	public String getSCOOTER() {
		return SCOOTER;
	}
	public void setSCOOTER(String sCOOTER) {
		SCOOTER = sCOOTER;
	}
	public BikeTypeKey() {
		super();
	}
	
	
	
}
