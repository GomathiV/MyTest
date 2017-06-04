package com.customerdetail.service;

import java.util.List;

import com.customerdetail.model.Customer;
import com.customerdetail.model.Product;
import com.customerdetail.model.Subscription;
import com.customerdetail.model.Vehicle;

public interface CustomerDAO {
	
	public void saveOrUpdate(Customer customer);
    
/*    public void delete(int customerId);
     
    public Customer get(int customerId);
     
    public List<Customer> list();*/
	
	public void createProduct(Product product);
	
	public void createVehicle(Vehicle vehicle);
	
	public void createSubscription(Subscription subscription);
	
	public Customer getCustomer(String id);
	
	public Vehicle getVehicle(String vin) ;
	
	public List<Product> getProductList(String subscriptionId);
	
	public Subscription getSubscription(String subscriptionId, String custId, String vin) ;
	
	public void saveCustomer(Customer customer);


}
