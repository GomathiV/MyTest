package com.customerdetail.service;

import com.customerdetail.model.Customer;
import com.customerdetail.model.Product;

public class CustomerServiceImpl implements CustomerService {

	@Override
	public void createCustomer(Customer customer) {
		customer.setInternalCustomerId(customer.getFirstName()+customer.getLastName());
	}

	@Override
	public void createProduct(Product product) {
		
	}



}
