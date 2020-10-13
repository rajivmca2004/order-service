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

	public List<Object> createOrdereDetails(String id, PurchaseOrder purchaseOrder);

	public List<Object> deleteOrdereDetails(String id);

	public List<Object> updateOrdereDetails(String id, PurchaseOrder purchaseOrder);

	public List<PurchaseOrder> fetchOrdereDetails(String id);
}
