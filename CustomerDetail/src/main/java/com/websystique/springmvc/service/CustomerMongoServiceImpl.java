package com.websystique.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customerdetail.model.Customer;
import com.customerdetail.model.Product;
import com.customerdetail.model.Subscriptions;
import com.customerdetail.model.Vehicle;

@Service("customerMongoService")
public class CustomerMongoServiceImpl implements CustomerMongoService {

	 @Autowired
	 CustomerMongoDao customerMongoDao;
	 
	    public void create(Customer customer) {
	        customerMongoDao.create(customer);
	    }
	 
	    public void update(Customer customer) {
	        customerMongoDao.update(customer);
	    }
	 
	    public void delete(Customer customer) {
	        customerMongoDao.delete(customer);
	    }
	 
	    public List < Customer > findAll() {
	        return customerMongoDao.findAll();
	    }
	 
	    public Customer find(Customer customer) {
	        return customerMongoDao.find(customer);
	    }
	 
	    public void deleteAll() {
	        customerMongoDao.deleteAll();
	    }

	    //Product
	    
		@Override
		public void create(Product product) {
			customerMongoDao.create(product);
		}

		@Override
		public void update(Product product) {
			customerMongoDao.update(product);
		}

		@Override
		public void delete(Product product) {
			 customerMongoDao.delete(product);
		}

		@Override
		public Product find(Product product) {
			 return customerMongoDao.find(product);
		}

		@Override
		public List<Product> findAllProduct() {
			return customerMongoDao.findAllProduct();
		}

		//Vehicle
		
		@Override
		public void create(Vehicle vehicle) {
			customerMongoDao.create(vehicle);
		}

		@Override
		public void update(Vehicle vehicle) {
			customerMongoDao.update(vehicle);
		}

		@Override
		public void delete(Vehicle vehicle) {
			customerMongoDao.delete(vehicle);
		}

		@Override
		public Vehicle find(Vehicle vehicle) {
			 return customerMongoDao.find(vehicle);
		}

		@Override
		public List<Vehicle> findAllVehicle() {
			return customerMongoDao.findAllVehicle();
		}

		//Subscription
		@Override
		public void create(Subscriptions subscription) {
			customerMongoDao.create(subscription);
			
		}

		@Override
		public void update(Subscriptions subscription) {
			customerMongoDao.update(subscription);
		}

		@Override
		public void delete(Subscriptions subscription) {
			customerMongoDao.delete(subscription);
		}

		@Override
		public Subscriptions find(Subscriptions subscription) {
			return customerMongoDao.find(subscription);
		}

		@Override
		public List<Subscriptions> findAllSubscription() {
			return customerMongoDao.findAllSubscription();
		}
	    
	  
}
