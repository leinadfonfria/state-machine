package com.imatia.statemachine.rest.service;

import com.imatia.statemachine.rest.model.entity.OrderTracking;

public interface OrderTrackingService {

	OrderTracking save(OrderTracking orderTracking);

	OrderTracking findById(Long id);

	Iterable<OrderTracking> findAll();
	
	boolean validateOrderTrackingStatus(OrderTracking orderTracking);

}