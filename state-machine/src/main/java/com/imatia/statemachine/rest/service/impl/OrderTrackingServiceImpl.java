package com.imatia.statemachine.rest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imatia.statemachine.rest.model.entity.OrderTracking;
import com.imatia.statemachine.rest.repository.OrderTrackingRepository;
import com.imatia.statemachine.rest.service.OrderTrackingService;

@Service
public class OrderTrackingServiceImpl implements OrderTrackingService {
	
	@Autowired
	OrderTrackingRepository orderTrackingRepository;
	
	@Override
	public OrderTracking save(OrderTracking orderTracking) {
		return orderTrackingRepository.save(orderTracking);
	}
	
	@Override
	public OrderTracking findById(Long id) {
		return orderTrackingRepository.findById(id).orElse(null);
	}
	
	@Override
	public Iterable<OrderTracking> findAll() {
		return orderTrackingRepository.findAll();
	}
	
	@Override
	public boolean validateOrderTrackingStatus(OrderTracking orderTracking) {
		
		boolean isValid = true;
		
		if(!validateOrderTrackingStatusId(orderTracking.getTrackingStatusId())) {
			isValid = false;
		}
		
		return isValid;
	}
	
	private boolean validateOrderTrackingStatusId(int id) {

		boolean isValid = true;

		if (OrderTracking.TrackingStatus.findTrackingStatusById(id) == null) {
			isValid = false;
		}

		return isValid;
	}
}
