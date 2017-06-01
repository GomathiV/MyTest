package com.customerdetail.service;

import com.customerdetail.model.Customer;
import com.customerdetail.model.Product;

public interface CustomerDAO {
	
	public void saveOrUpdate(Customer customer);
    
/*    public void delete(int customerId);
     
    public Customer get(int customerId);
     
    public List<Customer> list();*/
	
	public void createProduct(Product product);

}
