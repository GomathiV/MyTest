package com.customerdetail.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.customerdetail.model.Customer;
import com.customerdetail.model.Product;
import com.customerdetail.model.Subscriptions;
import com.customerdetail.model.Vehicle;
import com.customerdetail.valueobject.CustomerVO;
import com.customerdetail.valueobject.ProductVO;
import com.customerdetail.valueobject.SubscriptionVO;
import com.customerdetail.valueobject.VehicleVO;
import com.websystique.springmvc.service.ApplicationConfig;
import com.websystique.springmvc.service.CustomerMongoService;

@RestController
@RequestMapping("/customermong")
public class CustomerMonController {

	@RequestMapping(value = "/all/", method = RequestMethod.GET)
	public ResponseEntity<List<Customer>> listAllCustomer() {
		List<Customer> customers = customerMongoService.findAll();
		if(customers.isEmpty()){
			return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}

	
	@RequestMapping(value = "/all/", method = RequestMethod.POST, consumes = {"text/plain", "application/*"}, produces = {"text/plain", "application/*"})
	@ResponseBody
	public ResponseEntity<Void> createCustomer(@RequestBody CustomerVO customerVO, 	UriComponentsBuilder ucBuilder) {
		
		customerMongoService.create(transferCustomerObj(customerVO));

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/customer/{id}").buildAndExpand(customerVO.getInternalCustomerId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	

	AbstractApplicationContext contextc = new AnnotationConfigApplicationContext(ApplicationConfig.class);
	CustomerMongoService customerMongoService = (CustomerMongoService) contextc.getBean("customerMongoService");


	public Customer transferCustomerObj (CustomerVO customerVO) {
		
		Customer customer = new Customer();
		
	//	customer.setInternalCustomerId(customerVO.getInternalCustomerId());
		customer.setFirstName(customerVO.getFirstName());
		customer.setLastName(customerVO.getFirstName());
		customer.setUserName(customerVO.getUserName());
		customer.setEmail(customerVO.getEmail());
		customer.setPhoneNumber(customerVO.getPhoneNumber());
		return customer;
	}
	
	public Product transferProductObj (ProductVO productVO) {
		
		Product product = new Product();
		
		product.setName(productVO.getName());
		product.setAutoRenew(productVO.getAutoRenew());
		product.setRegion(productVO.getRegion());
		product.setCurreny(productVO.getCurreny());
		product.setPrice(productVO.getPrice());
		return product;
	}
	
	public Vehicle transferVehicleObj (VehicleVO vehicleVO) {
		
		Vehicle vehicle = new Vehicle();
		
		vehicle.setVin(vehicleVO.getVin());
		vehicle.setRegion(vehicleVO.getRegion());
		vehicle.setCreatedDateTime(vehicleVO.getCreatedDateTime());
		return vehicle;
	}
	
	public Subscriptions transferSubscriptionObj (SubscriptionVO subscriptionVO) {
		
		Subscriptions subscription = new Subscriptions();
		
		subscription.setVin(subscriptionVO.getVin());
		subscription.setSubscriptionReferenceId(subscriptionVO.getSubscriptionReferenceId());
		subscription.setCreatedDateTime(subscriptionVO.getCreatedDateTime());
		
		subscription.setArchivedDateTime(subscriptionVO.getArchivedDateTime());
		subscription.setPrimarySubscriberId(subscriptionVO.getPrimarySubscriberId());
		subscription.setLastUpdatedDateTime(subscriptionVO.getLastUpdatedDateTime());
		
		List<Product> products = null; 
		for (int i = 0; i < subscriptionVO.getProducts().size(); i++) {
			products = new ArrayList<Product>();
			products.add(transferProductObj(subscriptionVO.getProducts().get(i)))    ;
		}
		subscription.setProducts(products);
		
		return subscription;
	}
	
	
	@ExceptionHandler(Exception.class)
	public String myError(Exception exception) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exc", exception);
		mav.setViewName("errormessage");
		return "errormessage";
	}

}
