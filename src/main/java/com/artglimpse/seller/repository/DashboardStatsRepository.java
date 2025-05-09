package com.artglimpse.seller.repository;

import com.artglimpse.seller.model.DashboardStats;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DashboardStatsRepository extends MongoRepository<DashboardStats, String> {
}
