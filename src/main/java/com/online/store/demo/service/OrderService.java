package com.online.store.demo.service;

import java.net.URISyntaxException;
import java.util.List;

import com.online.store.demo.model.Catalogue;
import com.online.store.demo.model.Customer;
import com.online.store.demo.model.PurchaseOrder;

public interface OrderService {

	public List<Catalogue> fetchCatalogueService() throws URISyntaxException;

	public List<Customer> fetchCustomerService() throws URISyntaxException;
	
	public List<PurchaseOrder> fetchOrdereDetails() throws URISyntaxException;


}
