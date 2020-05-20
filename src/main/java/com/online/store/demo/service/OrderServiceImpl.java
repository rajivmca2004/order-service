package com.online.store.demo.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.online.store.demo.model.Catalogue;
import com.online.store.demo.model.Customer;

/**
 * @author rasrivastava
 *
 */

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private RestTemplate restTemplate;


	@Value("${catalogue.resource.host}")
	private String catalogueResourceHost;
	
	@Value("${catalogue.resource.port}")
	private String catalogueResourcePort;

	@Value("${customer.resource.host}")
	private String customerResourceHost;
	
	@Value("${customer.resource.port}")
	private String customerResourcePort;

	/*
	 * Fetch from Catalogue Micro-Service
	 */
	

	@Override
	public List<Catalogue> fetchCatalogueService() throws URISyntaxException {
		List<Catalogue> catalogueList= null;
		
		URI catalogueUri = new URI(catalogueResourceHost+":"+catalogueResourcePort+"/catalogue");

		ResponseEntity<Catalogue[]> catalogueResponse = restTemplate.getForEntity(catalogueUri, Catalogue[].class);
		Catalogue[] catalogue = catalogueResponse.getBody();

		if (catalogueResponse.getStatusCode().is2xxSuccessful()) {
			catalogueList=Arrays.asList(catalogue);
		}
		return catalogueList;
	}
	
	/*
	 * Fetch from Customer-Service
	 */

	
	@Override
	public List<Customer> fetchCustomerService() throws URISyntaxException {
		List<Customer> customerList= null;
		
		URI customerUri = new URI(customerResourceHost+":"+customerResourcePort+"/customers");


		ResponseEntity<Customer[]> customerResponse = restTemplate.getForEntity(customerUri, Customer[].class);
		Customer[] customer = customerResponse.getBody();
		if (customerResponse.getStatusCode().is2xxSuccessful()) {
			customerList=Arrays.asList(customer);
		}
		return customerList;
	}
}
