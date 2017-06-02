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

import com.customerdetail.model.Product;
import com.customerdetail.service.CustomerDAO;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	CustomerDAO customerDAO;

	@RequestMapping(method = RequestMethod.GET)
	public String productRegistrationForm(ModelMap model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "product";
	}

	/*
	 * This method will be called on form submission, handling POST request It
	 * also validates the user input
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String saveProductRegistration(@Valid Product product, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "product";
		}

		customerDAO.createProduct(product);
		model.addAttribute("product" + product);
		return "successproduct";
	}

	@ExceptionHandler(Exception.class)
	public String myError(Exception exception) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exc", exception);
		mav.setViewName("errormessage");
		return "errormessage";
	}

}
