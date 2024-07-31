package com.project.hotelManagement.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "payment")
@Data
@Entity
public class Payment {
	
	@Id
	@Column(name = "payment_id")
	@JsonProperty("payment_id")
	private int paymentId;
	
	@Column(name = "amount")
	private int amount;
	
	@Column(name = "payment_method")
	@JsonProperty("payment_method")
	private String paymentMethod;
	
	@Column(name = "date")
	private String date;
	
	@Column(name = "reservation_id")
	@JsonProperty("reservation_id")
	private int reservationId;
	
}
