package com.customerdetail.configuration;

import javax.sql.DataSource;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.customerdetail.service.CustomerDAO;
import com.customerdetail.service.CustomerDAOImpl;
import com.mongodb.MongoClient;
import com.websystique.springmvc.service.CustomerMongoDao;
import com.websystique.springmvc.service.CustomerMongoDaoImpl;
import com.websystique.springmvc.service.CustomerMongoService;
import com.websystique.springmvc.service.CustomerMongoServiceImpl;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.customerdetail")
public class CustomerDetailConfiguration extends WebMvcConfigurerAdapter {
	
	/*
	 * Configure View Resolver 
	 */
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	/*
	 * Configure MessageSource to provide internationalized messages
	 * 
	 */
	
	@Bean
	public MessageSource messageSource() {
	    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
	    messageSource.setBasename("messages");
	    return messageSource;
	}

	/*
	 * Configure ResourceHandlers to serve static resources like CSS/ Javascript etc...
	 * 
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("/static/**").addResourceLocations("/static/");
	}
	
	@Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/mysql");
        dataSource.setUsername("admin");	
        dataSource.setPassword("admin");
         
        return dataSource;
    }
     
    @Bean
    public CustomerDAO getCustomerDAO() {
        return new CustomerDAOImpl(getDataSource());
    }
    
    @Bean
    public MongoDbFactory mongoDbFactory() throws Exception {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        UserCredentials userCredentials = new UserCredentials("", "");
        return new SimpleMongoDbFactory(mongoClient, "customerdetail", userCredentials);
    }
 
    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
        return mongoTemplate;
    }
       
    @Bean
    public CustomerMongoService getCustomerMongoService() {
    	return new CustomerMongoServiceImpl();
    }
    
    @Bean
    public CustomerMongoDao getCustomerMongoDao() {
    	return new CustomerMongoDaoImpl();
    }
    
    
    
   /* public CarService getCarServiceContext() {

    	AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
    	CarService carService = (CarService) context.getBean("carService");
    	return carService;
    }*/

}