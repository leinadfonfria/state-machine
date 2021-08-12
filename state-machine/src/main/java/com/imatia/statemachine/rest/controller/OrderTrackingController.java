package com.imatia.statemachine.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.imatia.statemachine.rest.model.conversor.OrderTrackingConversor;
import com.imatia.statemachine.rest.model.dto.OrderTrackingDTO;
import com.imatia.statemachine.rest.model.entity.OrderTracking;
import com.imatia.statemachine.rest.service.OrderTrackingService;

@RestController
public class OrderTrackingController {

	@Autowired
	private OrderTrackingService orderTrackingService;

	@PostMapping("/order/tracking")
	public ResponseEntity<OrderTrackingDTO> orderTracking(@RequestBody OrderTrackingDTO orderTrackingDTO) {

		HttpStatus httpStatus;

		try {

			OrderTracking orderTracking = OrderTrackingConversor.convert(orderTrackingDTO);
			
			if (orderTrackingService.validateOrderTrackingStatus(orderTracking)) {
				
				orderTrackingService.save(orderTracking);
				
				httpStatus = HttpStatus.OK;
				
			} else {
				
				httpStatus = HttpStatus.BAD_REQUEST;
			}

		} catch (Exception ex) {
			httpStatus = HttpStatus.BAD_REQUEST;
		}

		return new ResponseEntity<OrderTrackingDTO>(orderTrackingDTO, httpStatus);
	}

}
