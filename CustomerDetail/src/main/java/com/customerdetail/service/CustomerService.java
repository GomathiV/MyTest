package com.customerdetail.service;

import com.customerdetail.model.Customer;
import com.customerdetail.model.Product;

public interface CustomerService {
	
	public void createCustomer(Customer customer);
	
	/*//Get user
	
	public void findCustomer(Customer customer);
	
	//update user
	
	public void updateCustomer(Customer customer);
	
	//Delete User
	
	public void deleteCustomer(Customer customer);*/
	
	public void createProduct(Product product);

}
