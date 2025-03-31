package com.artglimpse.order.repository;

import com.artglimpse.order.model.Order;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface OrderRepository extends MongoRepository<Order, ObjectId> {
    List<Order> findByUserId(ObjectId userId);
    Page<Order> findBySellerIdOrderByCreatedAtDesc(ObjectId sellerId, Pageable pageable);
    // Page<Order> findBySellerIdOrderByCreatedAtDesc(String sellerId, Pageable pageable);
}
