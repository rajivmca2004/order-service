package com.online.store.demo.service;

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
	RestTemplate restTemplate;


	@Value("${catalogue.resource.url}")
	String catalogueResourceUrl;

	@Value("${customer.resource.url}")
	String customerResourceUrl;

	/*
	 * Fetch from Catalogue Micro-Service
	 */
	

	@Override
	public List<Catalogue> fetchCatalogueService() {
		List<Catalogue> catalogueList= null;

		ResponseEntity<Catalogue[]> catalogueResponse = restTemplate.getForEntity(catalogueResourceUrl, Catalogue[].class);
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
	public List<Customer> fetchCustomerService() {
		List<Customer> customerList= null;

		ResponseEntity<Customer[]> customerResponse = restTemplate.getForEntity(customerResourceUrl, Customer[].class);
		Customer[] customer = customerResponse.getBody();
		if (customerResponse.getStatusCode().is2xxSuccessful()) {
			customerList=Arrays.asList(customer);
		}
		return customerList;
	}
}
