package com.artglimpse.buyer.controller.product;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.artglimpse.buyer.dto.product.CreateOrderRequest;
import com.artglimpse.buyer.model.product.Order;
import com.artglimpse.buyer.service.product.OrderService;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody CreateOrderRequest request) {
        Order order = orderService.createOrder(request.getUserId(), request.getCart(), request.getShippingAddress());
        return ResponseEntity.ok(order);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Order>> getOrders(@PathVariable String userId) {
        ObjectId userObjectId = new ObjectId(userId);
        List<Order> orders = orderService.getOrdersByUser(userObjectId);
        return ResponseEntity.ok(orders);
    }
}
