package com.customerdetail.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.customerdetail.model.Product;
import com.customerdetail.model.Subscription;
import com.customerdetail.model.Subscriptions;
import com.customerdetail.model.Vehicle;
import com.customerdetail.service.CustomerDAO;
import com.customerdetail.valueobject.ProductVO;
import com.customerdetail.valueobject.SubscriptionVO;
import com.customerdetail.valueobject.VehicleVO;
import com.websystique.springmvc.service.ApplicationConfig;
import com.websystique.springmvc.service.CustomerMongoService;


@Controller
@RequestMapping("/vehicle")
public class VehicleController {

	@Autowired
	CustomerDAO customerDAO;

	@RequestMapping(method = RequestMethod.GET)
	public String vehicleRegistrationForm(ModelMap model) {
		Vehicle vehicle = new Vehicle();
		model.addAttribute("vehicle", vehicle);
		return "vehicle";
	}

	/*
	 * This method will be called on form submission, handling POST request It
	 * also validates the user input
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String saveVehicleRegistration(@Valid Vehicle vehicle, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "vehicle";
		}

		customerDAO.createVehicle(vehicle);
		model.addAttribute("vehicle" + vehicle);
		return "successvehicle";
	}

	@RequestMapping(value = { "subscription" }, method = RequestMethod.GET)
	public String getViewSubscription(ModelMap model) {
		Subscription subscription = new Subscription();
		model.addAttribute("subscription", subscription);
		return "subscription"; 
	}



	/*
	 * This method will be called on form submission, handling POST request It
	 * also validates the user input
	 */
	@RequestMapping(value = { "subscription" }, method = RequestMethod.POST)
	public String createSubscription(@Valid Subscription subscription,
			BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "subscription";
		}

		customerDAO.createSubscription(subscription);
		model.addAttribute("subscription" + subscription);
		return "successsubscription";
	}


	@RequestMapping(value = { "viewsubscriptiondetail" }, method = RequestMethod.GET)
	public String getViewSubscriptionDetail(ModelMap model) {
		Subscription subscription = new Subscription();
		model.addAttribute("subscription", subscription);
		return "viewsubscription";
	}

	@RequestMapping(value = { "viewsubscriptiondetail" }, method = RequestMethod.POST)
	public String getViewSubscriptionDetail(@Valid Subscription subscription,
			BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "viewsubscription";
		}
		subscription = customerDAO.getSubscription(subscription.getSubscriptionId(), subscription.getInternalCustomerId(), subscription.getVin());

		model.addAttribute("subscription", subscription);
		model.addAttribute("products", subscription.getListProducts());

		return "successviewsubscription";
	}

	@ExceptionHandler(Exception.class)
	public String myError(Exception exception) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exc", exception);
		mav.setViewName("errormessage");
		return "errormessage";
	}
	


	@RequestMapping(value = "/all/", method = RequestMethod.GET)
	public ResponseEntity<List<Vehicle>> listAllVehicle() {
		List<Vehicle> vehicles = customerMongoService.findAllVehicle();
		if(vehicles.isEmpty()){
			return new ResponseEntity<List<Vehicle>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Vehicle>>(vehicles, HttpStatus.OK);
	}

	@RequestMapping(value = "/all/", method = RequestMethod.POST, consumes = {"text/plain", "application/*"}, produces = {"text/plain", "application/*"})
	@ResponseBody
	public ResponseEntity<Void> createVehicle(@RequestBody VehicleVO vehicleVO, UriComponentsBuilder ucBuilder) {
		
		customerMongoService.create(transferVehicleObj(vehicleVO));

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/all/{id}").buildAndExpand(vehicleVO.getInternalVehicleId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/subscriptions/", method = RequestMethod.GET)
	public ResponseEntity<List<Subscriptions>> listAllSubscription() {
		List<Subscriptions> subscriptions = customerMongoService.findAllSubscription();
		if(subscriptions.isEmpty()){
			return new ResponseEntity<List<Subscriptions>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Subscriptions>>(subscriptions, HttpStatus.OK);
	}

	@RequestMapping(value = "/subscriptions/", method = RequestMethod.POST, consumes = {"text/plain", "application/*"}, produces = {"text/plain", "application/*"})
	@ResponseBody
	public ResponseEntity<Void> createVehicle(@RequestBody SubscriptionVO subscriptionVO, UriComponentsBuilder ucBuilder) {
		customerMongoService.create(transferSubscriptionObj(subscriptionVO));

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/subscriptions/{id}").buildAndExpand(subscriptionVO.getSubscriptionId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
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
	

	AbstractApplicationContext contextc = new AnnotationConfigApplicationContext(ApplicationConfig.class);
	CustomerMongoService customerMongoService = (CustomerMongoService) contextc.getBean("customerMongoService");

}
