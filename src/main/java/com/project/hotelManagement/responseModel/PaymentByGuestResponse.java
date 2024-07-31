package com.project.hotelManagement.responseModel;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PaymentByGuestResponse {
	
	@JsonProperty("guest_id")
	private int guestId;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("roomId")
	private int roomId;
	
	@JsonProperty("amount")
	private int amount;
	
	@JsonProperty("payment_id")
	private int paymentId;
	
}
