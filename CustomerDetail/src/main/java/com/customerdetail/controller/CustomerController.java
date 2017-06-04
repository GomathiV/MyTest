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
import com.customerdetail.service.CustomerDAO;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerDAO customerDAO;
	
	/*
	 * This method will serve as default GET handler.
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String customerRegistrationForm(ModelMap model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "enroll";
	}

	/*
	 * This method will be called on form submission, handling POST request It
	 * also validates the user input
	 */
	@RequestMapping(method = RequestMethod.POST)
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

	 @ExceptionHandler(Exception.class)
	 public String myError(Exception exception) {
	    ModelAndView mav = new ModelAndView();
	    mav.addObject("exc", exception);
	    mav.setViewName("errormessage");
	    return "errormessage";
	 }
	 
}