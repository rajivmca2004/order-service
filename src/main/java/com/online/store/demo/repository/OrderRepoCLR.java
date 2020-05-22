package com.online.store.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.online.store.demo.model.Catalogue;
import com.online.store.demo.model.Customer;
import com.online.store.demo.model.PurchaseOrder;
import com.online.store.demo.service.OrderService;

/**
 * @author rasrivastava
 *
 */

@Component
public class OrderRepoCLR implements CommandLineRunner {

	private OrderRepository orderRepository;

	@Autowired
	private OrderService orderService;

	@Autowired
	public OrderRepoCLR(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		List<Catalogue> catalogueList = orderService.fetchCatalogueService();
		List<Customer> customerList = orderService.fetchCustomerService();
		
		if (null!=catalogueList && null!=customerList && catalogueList.size() == customerList.size()) {

			for (int i = 0; i < catalogueList.size(); i++) {
				orderRepository.save(new PurchaseOrder(customerList.get(i).getName(), customerList.get(i).getEmail(),
						catalogueList.get(i).getName(), catalogueList.get(i).getPrice()));
			}
		}

		orderRepository.findAll().forEach(System.out::println);
	}
}
