package com.websystique.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.customerdetail.model.Customer;
import com.customerdetail.model.Product;
import com.customerdetail.model.Subscription;
import com.customerdetail.model.Subscriptions;
import com.customerdetail.model.Vehicle;

@Repository
@Qualifier("customerMongoDao")
public class CustomerMongoDaoImpl implements CustomerMongoDao {
	
	 	@Autowired
	    MongoTemplate mongoTemplate;
	 
	    final String COLLECTION = "customers";
	    
	    public void create(Customer customer) {
	        mongoTemplate.insert(customer);
	    }
	 
	    public void update(Customer customer) {
	        mongoTemplate.save(customer);
	    }
	 
	    public void delete(Customer customer) {
	        mongoTemplate.remove(customer);
	    }
	 
	    public void deleteAll() {
	        mongoTemplate.remove(new Query(), COLLECTION);
	    }
	 
	    public Customer find(Customer customer) {
	        Query query = new Query(Criteria.where("_id").is(customer.getInternalCustomerId()));
	        return mongoTemplate.findOne(query, Customer.class, COLLECTION);
	    }
	 
	    public List < Customer > findAll() {
	        return (List < Customer > ) mongoTemplate.findAll(Customer.class);
	    }

	    //Product
	    
		@Override
		public void create(Product product) {
			mongoTemplate.insert(product);
			
		}

		@Override
		public void update(Product product) {
			mongoTemplate.save(product);
			
		}

		@Override
		public void delete(Product product) {
			mongoTemplate.remove(product);
			
		}

		@Override
		public Product find(Product product) {
			 Query query = new Query(Criteria.where("_id").is(product.getInternalProductId()));
		        return mongoTemplate.findOne(query, Product.class, COLLECTION);
		}

		@Override
		public List<Product> findAllProduct() {
			 return (List < Product > ) mongoTemplate.findAll(Product.class);
		}

		//Vehicle
		
		@Override
		public void create(Vehicle vehicle) {
			mongoTemplate.insert(vehicle);
			
		}
		
		@Override
		public void update(Vehicle vehicle) {
			mongoTemplate.save(vehicle);
			
		}

		@Override
		public void delete(Vehicle vehicle) {
			mongoTemplate.remove(vehicle);
			
		}

		@Override
		public Vehicle find(Vehicle vehicle) {
			Query query = new Query(Criteria.where("_id").is(vehicle.getInternalVehicleId()));
	        return mongoTemplate.findOne(query, Vehicle.class, COLLECTION);
		}

		@Override
		public List<Vehicle> findAllVehicle() {
			return (List < Vehicle > ) mongoTemplate.findAll(Vehicle.class);
		}

		//Subscription
		
		@Override
		public void create(Subscriptions subscription) {
			mongoTemplate.insert(subscription);
			
		}

		@Override
		public void update(Subscriptions subscription) {
			mongoTemplate.save(subscription);
			
		}

		@Override
		public void delete(Subscriptions subscription) {
			mongoTemplate.remove(subscription);
			
		}

		@Override
		public Subscriptions find(Subscriptions subscription) {
			Query query = new Query(Criteria.where("_id").is(subscription.getSubscriptionId()));
	        return mongoTemplate.findOne(query, Subscriptions.class, COLLECTION);
		}

		@Override
		public List<Subscriptions> findAllSubscription() {
			return (List < Subscriptions > ) mongoTemplate.findAll(Subscriptions.class);
		}
	 

}
