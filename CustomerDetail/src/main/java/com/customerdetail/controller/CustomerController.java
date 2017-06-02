package com.customerdetail.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.customerdetail.model.Customer;
import com.customerdetail.model.Product;
import com.customerdetail.model.Subscription;
import com.customerdetail.model.Vehicle;
import com.customerdetail.service.CustomerDAO;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerDAO customerDAO;

	/*
	 * This method will serve as default GET handler.
	 */
	@RequestMapping(value = { "user" }, method = RequestMethod.GET)
	public String customerRegistrationForm(ModelMap model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "enroll";
	}

	/*
	 * This method will be called on form submission, handling POST request It
	 * also validates the user input
	 */
	@RequestMapping(value = { "user" }, method = RequestMethod.POST)
	public String saveCustomerRegistration(@Valid Customer customer,
			BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "enroll";
		}
		System.out.println("Creating User " + customer.getFirstName());
		customerDAO.saveOrUpdate(customer);
		model.addAttribute("test","testvalue");
		//model.addAttribute("customer" + customer);
		return "successcustomer";
	}

	/*public String createUser(Customer customer) {
		customerDAO.saveOrUpdate(customer);
		return "success";
	}*/

	@RequestMapping(value = { "product" }, method = RequestMethod.GET)
	public String productRegistrationForm(ModelMap model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "product";
	}

	/*
	 * This method will be called on form submission, handling POST request It
	 * also validates the user input
	 */
	@RequestMapping(value = { "product" }, method = RequestMethod.POST)
	public String saveProductRegistration(@Valid Product product, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "product";
		}

		customerDAO.createProduct(product);
		model.addAttribute("product" + product);
		return "successproduct";
	}

	/*public String createProduct(Product product) {
		System.out.println("Creating User " + product.getName());

		customerDAO.createProduct(product);
		return "success";
	}*/

	@RequestMapping(value = { "vehicle" }, method = RequestMethod.GET)
	public String vehicleRegistrationForm(ModelMap model) {
		Vehicle vehicle = new Vehicle();
		model.addAttribute("vehicle", vehicle);
		return "vehicle";
	}

	/*
	 * This method will be called on form submission, handling POST request It
	 * also validates the user input
	 */
	@RequestMapping(value = { "vehicle" }, method = RequestMethod.POST)
	public String saveVehicleRegistration(@Valid Vehicle vehicle, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "vehicle";
		}

		customerDAO.createVehicle(vehicle);
		model.addAttribute("vehicle" + vehicle);
		return "successvehicle";
	}

	/*public String createVehicle(Vehicle vehicle) {
		System.out.println("Vehicle " + vehicle.getVin());

		customerDAO.createVehicle(vehicle);
		return "success";
	}*/

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

	
	/*
	
	
	
	 * Method used to populate the Section list in view. Note that here you can
	 * call external systems to provide real data.
	 
	@ModelAttribute("sections")
	public List<String> initializeSections() {

		List<String> sections = new ArrayList<String>();
		sections.add("Graduate");
		sections.add("Post Graduate");
		sections.add("Research");
		return sections;
	}

	
	 * Method used to populate the country list in view. Note that here you can
	 * call external systems to provide real data.
	 
	@ModelAttribute("countries")
	public List<String> initializeCountries() {

		List<String> countries = new ArrayList<String>();
		
		 * countries.add("USA"); countries.add("CANADA");
		 * countries.add("FRANCE"); countries.add("GERMANY");
		 * countries.add("ITALY"); countries.add("OTHER");
		 
		return countries;
	}

	
	 * Method used to populate the subjects list in view. Note that here you can
	 * call external systems to provide real data.
	 
	@ModelAttribute("subjects")
	public List<String> initializeSubjects() {

		List<String> subjects = new ArrayList<String>();
		
		 * subjects.add("Physics"); subjects.add("Chemistry");
		 * subjects.add("Life Science"); subjects.add("Political Science");
		 * subjects.add("Computer Science"); subjects.add("Mathmatics");
		 
		return subjects;
	}
*/
}