package com.customerdetail.valueobject;

import java.util.HashMap;
import java.util.Map;

	public class ProductVO {
	
	
	private String internalProductId;
	private String name;
	private String region;
	private String autoRenew;
	private String price;
	private String curreny;
	private String createdDateTime;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	
	public ProductVO() {
	
	}
	
	public ProductVO(String internalProductId, String name, 
			String region, String autoRenew, String price, String curreny) {
		
		this.internalProductId = internalProductId;
		this.name = name;
		this.region = region;
		this.autoRenew = autoRenew;
		this.price = price;
		this.curreny = curreny;
		
	}
	
	public String getInternalProductId() {
	return internalProductId;
	}
	
	public void setInternalProductId(String internalProductId) {
	this.internalProductId = internalProductId;
	}
	
	public String getName() {
	return name;
	}
	
	public void setName(String name) {
	this.name = name;
	}
	
	public String getRegion() {
	return region;
	}
	
	public void setRegion(String region) {
	this.region = region;
	}
	
	public String getAutoRenew() {
	return autoRenew;
	}
	
	public void setAutoRenew(String autoRenew) {
	this.autoRenew = autoRenew;
	}
	
	public String getPrice() {
	return price;
	}
	
	public void setPrice(String price) {
	this.price = price;
	}
	
	public String getCurreny() {
	return curreny;
	}
	
	public void setCurreny(String curreny) {
	this.curreny = curreny;
	}
	
	public String getCreatedDateTime() {
	return createdDateTime;
	}
	
	public void setCreatedDateTime(String createdDateTime) {
	this.createdDateTime = createdDateTime;
	}
	
	@Override
	public String toString() {
	return "Product : " + name;
	}
	
	public Map<String, Object> getAdditionalProperties() {
	return this.additionalProperties;
	}
	
	public void setAdditionalProperty(String name, Object value) {
	this.additionalProperties.put(name, value);
	}
	
	
	
}
