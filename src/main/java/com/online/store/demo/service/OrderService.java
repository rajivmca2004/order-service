package com.online.store.demo.service;

import java.util.List;

import com.online.store.demo.model.Catalogue;
import com.online.store.demo.model.Customer;

public interface OrderService {

	public List<Catalogue> fetchCatalogueService();

	public List<Customer> fetchCustomerService();

}
