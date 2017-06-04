package com.websystique.springmvc.service;

import java.util.List;

import com.customerdetail.model.Customer;
import com.customerdetail.model.Product;
import com.customerdetail.model.Subscriptions;
import com.customerdetail.model.Vehicle;

public interface CustomerMongoDao {
	
	public void create(Customer customer);
	 
    public void update(Customer customer);
 
    public void delete(Customer customer);
 
    public void deleteAll();
 
    public Customer find(Customer customer);
 
    public List < Customer > findAll();
    
  //Product
    
    public void create(Product product);
    
    public void update(Product product);
    
    public void delete(Product product);
 
 
    public Product find(Product product);
 
    public List < Product > findAllProduct();
    
    
    //Vehicle
    
    public void create(Vehicle vehicle);
    
    public void update(Vehicle vehicle);
    
    public void delete(Vehicle vehicle);
 
 
    public Vehicle find(Vehicle vehicle);
 
    public List < Vehicle > findAllVehicle();
    
    //Subscription

    public void create(Subscriptions subscription);
    
    public void update(Subscriptions subscription);
    
    public void delete(Subscriptions subscription);
 
 
    public Subscriptions find(Subscriptions subscription);
 
    public List < Subscriptions > findAllSubscription();


}
