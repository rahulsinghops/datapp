package com.ipru.mca.BikeOpedia.model;

import java.util.Date;

public class BikeException {
	private Date timestamp;
	private String message;
	private String responseCode;
	public BikeException(Date timestamp, String message, String responseCode) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.responseCode = responseCode;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public BikeException() {
		super();
	}
	@Override
	public String toString() {
		return "BikeException [timestamp=" + timestamp + ", message=" + message + ", responseCode=" + responseCode
				+ "]";
	}
	
}
