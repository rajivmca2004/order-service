package com.online.store.demo.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
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
		
		URI catalogueUri = new URI("http://"+catalogueResourceHost+":"+catalogueResourcePort+"/catalogue");
		System.out.println("*******catalogueUri=>"+catalogueUri.toString());


		//ResponseEntity<Catalogue[]> catalogueResponse = restTemplate.getForEntity(catalogueUri, Catalogue[].class);
		try {
			ResponseEntity<Catalogue[]> catalogueResponse = restTemplate.getForEntity("http://catalogue-service:8010/catalogue", Catalogue[].class);

			Catalogue[] catalogue = catalogueResponse.getBody();

			if (catalogueResponse.getStatusCode().is2xxSuccessful()) {
				catalogueList=Arrays.asList(catalogue);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return catalogueList;
	}
	
	/*
	 * Fetch from Customer-Service
	 */

	
	@Override
	public List<Customer> fetchCustomerService() throws URISyntaxException {
		List<Customer> customerList= null;
		
		URI customerUri = new URI("http://"+customerResourceHost+":"+customerResourcePort+"/customers");
		System.out.println("*****customerUri=>"+customerUri.toString());

		//ResponseEntity<Customer[]> customerResponse = restTemplate.getForEntity(customerUri, Customer[].class);
		try {
			ResponseEntity<Customer[]> customerResponse = restTemplate.getForEntity("http://customer-management-service:8011/customers", Customer[].class);

			Customer[] customer = customerResponse.getBody();
			if (customerResponse.getStatusCode().is2xxSuccessful()) {
				customerList=Arrays.asList(customer);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customerList;
	}
}
