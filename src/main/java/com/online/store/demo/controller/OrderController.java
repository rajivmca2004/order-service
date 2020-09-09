package com.online.store.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online.store.demo.model.PurchaseOrder;
import com.online.store.demo.repository.OrderRepository;

/**
 * @author rasrivastava
 * @apiNote Order Micro-Service
 */
@RestController
public class OrderController {
	
	@Autowired
	private OrderRepository orderRepository;

    
    @GetMapping("/orders")
    public Object fetchOrders ()
    {
        List<PurchaseOrder> orders = orderRepository.findAll();
        return orders;
    }

}
