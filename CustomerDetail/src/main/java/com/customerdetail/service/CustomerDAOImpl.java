package com.customerdetail.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.customerdetail.model.Customer;
import com.customerdetail.model.Product;
import com.customerdetail.model.Subscription;
import com.customerdetail.model.Vehicle;

public class CustomerDAOImpl implements CustomerDAO {

	private JdbcTemplate jdbcTemplate;
	 
    public CustomerDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
 
    
    
    
    
    @Autowired
    MongoTemplate mongoTemplate;
	/*
	public CustomerRepositoryDAOImpl(MongoTemplate mongoTemplate){
			this.mongoTemplate = mongoTemplate;
	}*/

	@Override
	public void saveCustomer(Customer customer) {

		mongoTemplate.insert(customer);
		
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

	@Override
	public void createVehicle(Vehicle vehicle) {
		String sql = "INSERT INTO VEHICLE (internalVehicleId, vin, region)"
                + " VALUES (?, ?, ?)";
		jdbcTemplate.update(sql, vehicle.getInternalVehicleId(), vehicle.getVin(), vehicle.getRegion());
		
	}

	@Override
	public void createSubscription(Subscription subscription) {
		
		String sql = "INSERT INTO SUBSCRIPTION (subscriptionId, vin, customerId, productId) "
				+ "VALUES (?,?,?,?)";
				
		jdbcTemplate.update(sql, subscription.getSubscriptionId(), subscription.getVehicle().getVin(), subscription.getCustomer().getInternalCustomerId(), 
				subscription.getProduct().getInternalProductId());
		
		
	}

	@Override
	public Customer getCustomer(String id) {
		
		String sql = "Select internalCustomerId, firstName, lastName, userName, email, phoneNumber from CUSTOMER where internalCustomerId = ?";
		
		//List<Customer> customers =  jdbcTemplate.query(sql, new BeanPropertyRowMapper(Customer.class));
		
		Customer customers =  (Customer) jdbcTemplate.queryForObject(sql, new Object[] { id }, new CustomerRowMapper());
		
		System.out.println("customer  select size: " + customers.getFirstName());
		return customers;
	}
	

	@Override
	public Vehicle getVehicle(String vin) {
		
		vin = "32";
		
		String sql = "Select internalVehicleId, vin, region from VEHICLE where vin = ?";
		
		Vehicle  vehicle =  (Vehicle) jdbcTemplate.queryForObject(sql, new Object[] { vin}, new VehicleRowMapper());
		
		System.out.println("vehicle  select size: " + vehicle.getVin());
		return vehicle;
	}
	
	@Override
	public List<Product> getProductList(String subscriptionId) {
		
		String sql = "Select PD.internalProductId, PD.productName, PD.region, PD.autoRenew, PD.price  from SUBSCRIPTION SUB "
				+ "LEFT JOIN PRODUCT PD ON SUB.productId = PD.internalProductId "
				+ "WHERE SUB.subscriptionId = ?";
		
		List<Product> products =  (List<Product>) jdbcTemplate.query(sql,new Object[] { subscriptionId}, new ProductRowMapper());
		
		System.out.println("products  select size: " + products.size());
		return products;
	}
	
	@Override
	public Subscription getSubscription(String subscriptionId, String custId, String vin) {
		
		Subscription subscription = new Subscription();
		Customer customer = null;
		
		customer = getCustomer(custId);
		
		Vehicle vehicle = getVehicle(vin);
		
		List<Product>  products = getProductList(subscriptionId);
		
		System.out.println(" DAOImpl -  Customer : " + customer.getFirstName());
		
		System.out.println("vehicle : " + vehicle.getVin());
		
		System.out.println("products : " + products.size());
		subscription.setSubscriptionId(subscriptionId);
		subscription.setListProducts(products);
		subscription.setCustomer(customer);
		subscription.setVehicle(vehicle);
		
		return subscription;
		
	}
	
	public class VehicleRowMapper implements RowMapper
	{
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			Vehicle vehicle = new Vehicle();
			vehicle.setInternalVehicleId(rs.getString("internalVehicleId"));
			vehicle.setVin(rs.getString("VIN"));
			vehicle.setRegion(rs.getString("REGION"));
			return vehicle;
		}
	}

	public class ProductRowMapper implements RowMapper
	{
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			Product product = new Product();
			product.setInternalProductId(rs.getString("internalProductId"));
			
			product.setName(rs.getString("productName"));
			product.setRegion(rs.getString("region"));
			product.setAutoRenew(rs.getString("autoRenew"));
			product.setPrice(rs.getString("price"));
			return product;
		}
	}
	
	public class CustomerRowMapper implements RowMapper
	{
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			Customer customer = new Customer();
			customer.setInternalCustomerId(rs.getString("internalCustomerId"));
			
			customer.setFirstName(rs.getString("firstName"));
			customer.setLastName(rs.getString("lastName"));
			customer.setUserName(rs.getString("userName"));
			customer.setEmail(rs.getString("email"));
			customer.setPhoneNumber(rs.getString("phoneNumber"));
			return customer;
		}
	}

    
}
