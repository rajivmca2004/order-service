package com.online.store.demo.controller;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online.store.demo.model.PurchaseOrder;
import com.online.store.demo.service.OrderService;

/**
 * @author rasrivastava
 * @apiNote Order Micro-Service
 */
@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderService;

    
    @GetMapping("/orders")
    public List<PurchaseOrder> fetchOrders () throws URISyntaxException
    {
        List<PurchaseOrder> orders = orderService.fetchOrdereDetails();
        return orders;
    }
}