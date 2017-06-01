package com.customerdetail.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.customerdetail.model.Customer;
import com.customerdetail.model.Product;
import com.customerdetail.service.CustomerDAO;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerDAO customerDAO;
	/*
	 * This method will serve as default GET handler.
	 */
	@RequestMapping(value={"user"},method = RequestMethod.GET)
	public String newRegistration(ModelMap model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "enroll";
	}

	/*
	 * This method will be called on form submission, handling POST request It
	 * also validates the user input
	 */
	@RequestMapping(value={"user"}, method = RequestMethod.POST)
	public String saveRegistration(@Valid Customer customer,
			BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "enroll";
		}

		createUser(customer);
		model.addAttribute("customer" + customer);
		return "success";
	}
	
	 public String createUser(Customer customer) {
	        System.out.println("Creating User " + customer.getFirstName());
	 
	        customerDAO.saveOrUpdate(customer);
	        return "success";
	    }


	
	 @RequestMapping(value={"product"},method = RequestMethod.GET)
		public String getProduct(ModelMap model) {
			Product product = new Product();
			model.addAttribute("product", product);
			return "product";
		}

		/*
		 * This method will be called on form submission, handling POST request It
		 * also validates the user input
		 */
		@RequestMapping(value={"product"}, method = RequestMethod.POST)
		public String createProduct(@Valid Product product,
				BindingResult result, ModelMap model) {

			if (result.hasErrors()) {
				return "product";
			}

			createProduct(product);
			model.addAttribute("product" + product);
			return "success";
		}
		
		 public String createProduct(Product product) {
		        System.out.println("Creating User " + product.getName());
		 
		        customerDAO.createProduct(product);
		        return "success";
		    }


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		/*
		 * Method used to populate the Section list in view. Note that here you can
		 * call external systems to provide real data.
		 */
		@ModelAttribute("sections")
		public List<String> initializeSections() {

			List<String> sections = new ArrayList<String>();
			sections.add("Graduate");
			sections.add("Post Graduate");
			sections.add("Research");
			return sections;
		}

	
	
	/*
	 * Method used to populate the country list in view. Note that here you can
	 * call external systems to provide real data.
	 */
	@ModelAttribute("countries")
	public List<String> initializeCountries() {

		List<String> countries = new ArrayList<String>();
	/*	countries.add("USA");
		countries.add("CANADA");
		countries.add("FRANCE");
		countries.add("GERMANY");
		countries.add("ITALY");
		countries.add("OTHER");*/
		return countries;
	}

	/*
	 * Method used to populate the subjects list in view. Note that here you can
	 * call external systems to provide real data.
	 */
	@ModelAttribute("subjects")
	public List<String> initializeSubjects() {

		List<String> subjects = new ArrayList<String>();
		/*subjects.add("Physics");
		subjects.add("Chemistry");
		subjects.add("Life Science");
		subjects.add("Political Science");
		subjects.add("Computer Science");
		subjects.add("Mathmatics");*/
		return subjects;
	}

}