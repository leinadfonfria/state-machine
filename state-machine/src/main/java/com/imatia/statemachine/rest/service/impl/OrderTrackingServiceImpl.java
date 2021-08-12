package com.imatia.statemachine.rest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imatia.statemachine.rest.model.entity.OrderTracking;
import com.imatia.statemachine.rest.repository.OrderTrackingRepository;
import com.imatia.statemachine.rest.service.OrderTrackingService;

@Service
public class OrderTrackingServiceImpl implements OrderTrackingService {
	
	@Autowired
	private OrderTrackingRepository orderTrackingRepository;
	
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
		
		OrderTracking orderTrackingRepo = orderTrackingRepository.findById(orderTracking.getOrderId()).orElse(null);
		
		if(orderTrackingRepo==null)
			return true;
		
		if(orderTrackingRepo.getTrackingStatus().equals(OrderTracking.TrackingStatus.ENTREGADO))
			return false;
		
		if(!validateOrderTrackingStatusId(orderTracking.getTrackingStatusId()))
			return false;
		
		if(!orderTrackingRepo.getTrackingStatus().equals(OrderTracking.TrackingStatus.RECOGIDO_EN_ALMACEN) &&
				orderTracking.getTrackingStatus().equals(OrderTracking.TrackingStatus.RECOGIDO_EN_ALMACEN))
			return false;

		return true;
	}
	
	private boolean validateOrderTrackingStatusId(int id) {

		boolean isValid = true;

		if (OrderTracking.TrackingStatus.findTrackingStatusById(id) == null) {
			isValid = false;
		}

		return isValid;
	}
}
