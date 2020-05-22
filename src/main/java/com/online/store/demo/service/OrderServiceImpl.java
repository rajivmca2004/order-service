package com.online.store.demo.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private static Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

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
	 * Fetch from Catalogue Service
	 */

	@Override
	public List<Catalogue> fetchCatalogueService() throws URISyntaxException {
		List<Catalogue> catalogueList = null;

		URI catalogueUri = new URI("http://" + catalogueResourceHost + ":" + catalogueResourcePort + "/catalogue");

		try {
			logger.info("******* Calling CATALOGUE SERVICE**********catalogueUri=> "+catalogueUri);
			ResponseEntity<Catalogue[]> catalogueResponse = restTemplate.getForEntity(catalogueUri, Catalogue[].class);
			// ResponseEntity<Catalogue[]> catalogueResponse =restTemplate.getForEntity("http://catalogue-service:8010/catalogue",Catalogue[].class);

			Catalogue[] catalogue = catalogueResponse.getBody();

			if (catalogueResponse.getStatusCode().is2xxSuccessful()) {
				catalogueList = Arrays.asList(catalogue);
			}else {
				logger.info("No response or Error from [CATALOGUE SERVICE]");
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return catalogueList;
	}

	/*
	 * Fetch from Customer-Service
	 */

	@Override
	public List<Customer> fetchCustomerService() throws URISyntaxException {
		List<Customer> customerList = null;

		URI customerUri = new URI("http://" + customerResourceHost + ":" + customerResourcePort + "/customers");

		try {
			logger.info("******* Calling CUSTOMER SERVICE**********customerUri=> "+customerUri.toString());
			ResponseEntity<Customer[]> customerResponse = restTemplate.getForEntity(customerUri, Customer[].class);
			// ResponseEntity<Customer[]> customerResponse = restTemplate.getForEntity("http://customer-management-service:8011/customers",Customer[].class);

			Customer[] customer = customerResponse.getBody();
			if (customerResponse.getStatusCode().is2xxSuccessful()) {
				customerList = Arrays.asList(customer);
			}else {
				logger.info("No response or Error from [CUSTOMER SERVICE]");
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return customerList;
	}
}
