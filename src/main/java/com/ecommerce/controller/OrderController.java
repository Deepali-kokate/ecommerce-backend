package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.Orders;
import com.ecommerce.repository.OrderRepository;

@RestController
@RequestMapping("/orders")
@CrossOrigin
public class OrderController {
     
	@Autowired
    private OrderRepository orderRepository;

    // Place Order
    @PostMapping
    public Orders placeOrder(@RequestBody Orders order) {
        return orderRepository.save(order);
    }

    // Get Orders by User
    @GetMapping("/{userId}")
    public List<Orders> getOrders(@PathVariable Long userId) {
        return orderRepository.findByUserId(userId);
    }
    
    @PutMapping("/{id}")
    public Orders updateOrder(@PathVariable Long id, @RequestBody Orders newOrder) {
        Orders existing = orderRepository.findById(id).orElseThrow();
        existing.setUserId(newOrder.getUserId());
        existing.setTotalAmount(newOrder.getTotalAmount());
        return orderRepository.save(existing);
    }
}
