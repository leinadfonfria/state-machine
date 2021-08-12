package com.imatia.statemachine.rest.model.conversor;

import java.util.NoSuchElementException;

import com.imatia.statemachine.rest.model.dto.OrderTrackingDTO;
import com.imatia.statemachine.rest.model.entity.OrderTracking;

public class OrderTrackingConversor {

	public static OrderTracking convert(OrderTrackingDTO orderTrackingDto) throws Exception {
		try {
			return new OrderTracking(orderTrackingDto.getOrderId(),
					OrderTracking.TrackingStatus.findTrackingStatusById(orderTrackingDto.getTrackingStatusId()),
					orderTrackingDto.getChangeStatusDate());
		} catch (NoSuchElementException ex) {
			throw new Exception("Error on Order conversion", ex);
		}
	}

	public static OrderTrackingDTO convert(OrderTracking orderTracking) {
		return new OrderTrackingDTO(orderTracking.getOrderId(), orderTracking.getTrackingStatusId(),
				orderTracking.getChangeStatusDate());
	}
}
