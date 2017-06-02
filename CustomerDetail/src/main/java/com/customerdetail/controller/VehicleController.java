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

import com.customerdetail.model.Subscription;
import com.customerdetail.model.Vehicle;
import com.customerdetail.service.CustomerDAO;


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


}
