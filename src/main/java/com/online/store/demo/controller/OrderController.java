package com.online.store.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.online.store.demo.model.PurchaseOrder;
import com.online.store.demo.repository.OrderRepository;

/**
 * @author rasrivastava
 * @apiNote Order Micro-Service
 */
@Controller
public class OrderController {
	
	@Autowired
	private OrderRepository orderRepository;

    @RequestMapping ("/ordersdisplay")
    public String fetchCustomers (Model model)
    {
        List<PurchaseOrder> orderRecords = orderRepository.findAll();

        model.addAttribute("orders", orderRecords);

        return "orders";
    }
    
    @GetMapping("/orders")
    @ResponseBody
    public Object fetchOrders ()
    {
        List<PurchaseOrder> orders = orderRepository.findAll();
        return orders;
    }

}
