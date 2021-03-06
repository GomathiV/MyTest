package com.customerdetail.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "subscriptions")
public class Subscriptions {
	@Id
	private String subscriptionId;
	private String vin;
	private String primarySubscriberId;
	private List<String> subscriptionReferenceId = null;
	private List<Product> products = null;
	private String createdDateTime;
	private String lastUpdatedDateTime;
	private Object archivedDateTime;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	
	public Subscriptions() {
	
	}
	
	public Subscriptions(String subscriptionId, String vin, String primarySubscriberId,
			List<String> subscriptionReferenceId, List<Product> products, String createdDateTime, 
			String lastUpdatedDateTime, Object archivedDateTime) {
	super();
	this.subscriptionId = subscriptionId;
	this.vin = vin;
	this.primarySubscriberId = primarySubscriberId;
	this.subscriptionReferenceId = subscriptionReferenceId;
	this.products = products;
	this.createdDateTime = createdDateTime;
	this.lastUpdatedDateTime = lastUpdatedDateTime;
	this.archivedDateTime = archivedDateTime;
	}
	
	public String getSubscriptionId() {
	return subscriptionId;
	}
	
	public void setSubscriptionId(String subscriptionId) {
	this.subscriptionId = subscriptionId;
	}
	
	public String getVin() {
	return vin;
	}
	
	public void setVin(String vin) {
	this.vin = vin;
	}
	
	public String getPrimarySubscriberId() {
	return primarySubscriberId;
	}
	
	public void setPrimarySubscriberId(String primarySubscriberId) {
	this.primarySubscriberId = primarySubscriberId;
	}
	
	public List<String> getSubscriptionReferenceId() {
	return subscriptionReferenceId;
	}
	
	public void setSubscriptionReferenceId(List<String> subscriptionReferenceId) {
	this.subscriptionReferenceId = subscriptionReferenceId;
	}
	
	public List<Product> getProducts() {
	return products;
	}
	
	public void setProducts(List<Product> products) {
	this.products = products;
	}
	
	public String getCreatedDateTime() {
	return createdDateTime;
	}
	
	public void setCreatedDateTime(String createdDateTime) {
	this.createdDateTime = createdDateTime;
	}
	
	public String getLastUpdatedDateTime() {
	return lastUpdatedDateTime;
	}
	
	public void setLastUpdatedDateTime(String lastUpdatedDateTime) {
	this.lastUpdatedDateTime = lastUpdatedDateTime;
	}
	
	public Object getArchivedDateTime() {
	return archivedDateTime;
	}
	
	public void setArchivedDateTime(Object archivedDateTime) {
	this.archivedDateTime = archivedDateTime;
	}
	
	public Map<String, Object> getAdditionalProperties() {
	return this.additionalProperties;
	}
	
	public void setAdditionalProperty(String name, Object value) {
	this.additionalProperties.put(name, value);
	}
	
	
}
