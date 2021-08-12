package com.imatia.statemachine.rest.model.entity;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrderTracking {
	
	public enum TrackingStatus {
	
		RECOGIDO_EN_ALMACEN(1),
		EN_REPARTO(2),
		INCIDENCIA_EN_ENTREGA(3),
		ENTREGADO(4);
	
		private int trackingStatusId;

		private TrackingStatus(int trackingStatusId) {
			this.trackingStatusId = trackingStatusId;
		}

		public int getTrackingStatusId() {
			return trackingStatusId;
		}
		
		public static TrackingStatus findTrackingStatusById(int id) {
			return Arrays.stream(TrackingStatus.values()).filter(t -> t.getTrackingStatusId()==id).findFirst().orElseThrow();
		}
		
	};

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;
	private TrackingStatus trackingStatus;
	private Date changeStatusDate;
	
	public OrderTracking(Long orderId, TrackingStatus trackingStatus, Date changeStatusDate) {
		super();
		this.orderId = orderId;
		this.trackingStatus = trackingStatus;
		this.changeStatusDate = changeStatusDate;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public TrackingStatus getTrackingStatus() {
		return trackingStatus;
	}
	
	public int getTrackingStatusId() {
		return trackingStatus.trackingStatusId;
	}

	public void setTrackingStatus(TrackingStatus trackingStatus) {
		this.trackingStatus = trackingStatus;
	}

	public Date getChangeStatusDate() {
		return changeStatusDate;
	}

	public void setChangeStatusDate(Date changeStatusDate) {
		this.changeStatusDate = changeStatusDate;
	}
	
}
