package com.customerdetail.service;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.customerdetail.model.Customer;
import com.customerdetail.model.Product;

public class CustomerDAOImpl implements CustomerDAO {

	private JdbcTemplate jdbcTemplate;
	 
    public CustomerDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
 
    @Override
    public void saveOrUpdate(Customer customer) {
    	
    	String sql = "INSERT INTO CUSTOMER (internalCustomerId, firstName, lastName, userName, email, phoneNumber)"
                + " VALUES (?, ?, ?, ?, ?, ?)";
    jdbcTemplate.update(sql, customer.getInternalCustomerId(), customer.getFirstName(), customer.getLastName(), 
    					customer.getUserName(), customer.getEmail(), customer.getPhoneNumber());	
    }

	@Override
	public void createProduct(Product product) {
		
		String sql = "INSERT INTO PRODUCT (internalProductId, productName, region, autoRenew, price, curreny)"
                + " VALUES (?, ?, ?, ?, ?, ?)";
    jdbcTemplate.update(sql, product.getInternalProductId(), product.getName(), product.getRegion(), 
    		product.getAutoRenew(), product.getPrice(), product.getCurreny());
		
	}
    
    
    
    

}
