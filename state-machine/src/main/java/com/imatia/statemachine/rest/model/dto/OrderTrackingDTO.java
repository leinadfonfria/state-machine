package com.imatia.statemachine.rest.model.dto;

import java.util.Date;

public class OrderTrackingDTO {

	private Long orderId;
	private int trackingStatusId;
	private Date changeStatusDate;
	
	public OrderTrackingDTO(Long orderId, int trackingStatusId, Date changeStatusDate) {
		super();
		this.orderId = orderId;
		this.trackingStatusId = trackingStatusId;
		this.changeStatusDate = changeStatusDate;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public int getTrackingStatusId() {
		return trackingStatusId;
	}
	public void setTrackingStatusId(int trackingStatusId) {
		this.trackingStatusId = trackingStatusId;
	}
	public Date getChangeStatusDate() {
		return changeStatusDate;
	}
	public void setChangeStatusDate(Date changeStatusDate) {
		this.changeStatusDate = changeStatusDate;
	}
}
