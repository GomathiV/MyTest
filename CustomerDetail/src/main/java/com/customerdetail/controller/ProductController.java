package com.customerdetail.controller;

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
import com.customerdetail.service.CustomerDAO;
import com.customerdetail.valueobject.ProductVO;
import com.websystique.springmvc.service.ApplicationConfig;
import com.websystique.springmvc.service.CustomerMongoService;

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
	

	
	@RequestMapping(value = "/all/", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> listAllProducts() {
		List<Product> products = customerMongoService.findAllProduct();
		if(products.isEmpty()){
			return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}

	@RequestMapping(value = "/all/", method = RequestMethod.POST, consumes = {"text/plain", "application/*"}, produces = {"text/plain", "application/*"})
	@ResponseBody
	public ResponseEntity<Void> createProduct(@RequestBody ProductVO productVO, UriComponentsBuilder ucBuilder) {
		
		customerMongoService.create(transferProductObj(productVO));

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/all/{id}").buildAndExpand(productVO.getInternalProductId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	AbstractApplicationContext contextc = new AnnotationConfigApplicationContext(ApplicationConfig.class);
	CustomerMongoService customerMongoService = (CustomerMongoService) contextc.getBean("customerMongoService");

	public Product transferProductObj (ProductVO productVO) {
		
		Product product = new Product();
		
		product.setName(productVO.getName());
		product.setAutoRenew(productVO.getAutoRenew());
		product.setRegion(productVO.getRegion());
		product.setCurreny(productVO.getCurreny());
		product.setPrice(productVO.getPrice());
		return product;
	}


}
