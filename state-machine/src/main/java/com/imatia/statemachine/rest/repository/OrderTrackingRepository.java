package com.imatia.statemachine.rest.repository;

import org.springframework.data.repository.CrudRepository;

import com.imatia.statemachine.rest.model.entity.OrderTracking;

public interface OrderTrackingRepository extends CrudRepository<OrderTracking, Long> {
	
}
