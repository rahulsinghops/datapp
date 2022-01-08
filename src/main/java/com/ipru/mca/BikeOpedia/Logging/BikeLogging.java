package com.ipru.mca.BikeOpedia.Logging;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class BikeLogging {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long logid;
	@Column(name="s_name")
	private String serviceName;
	@Lob
	private String request;
	@Lob
	private String response;
	@Lob
	private String error;
	public BikeLogging(String serviceName, String request, String response, String error) {
		super();
		this.serviceName = serviceName;
		this.request = request;
		this.response = response;
		this.error = error;
	}
	public BikeLogging() {
		super();
	}
	public long getLogid() {
		return logid;
	}
	public void setLogid(long logid) {
		this.logid = logid;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	

}
