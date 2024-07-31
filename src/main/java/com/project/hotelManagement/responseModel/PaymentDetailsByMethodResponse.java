package com.project.hotelManagement.responseModel;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PaymentDetailsByMethodResponse {

	@JsonProperty("payment_id")
	private int paymentId;
	
	@JsonProperty("amount")
	private int amount;
	
	@JsonProperty("payment_method")
	private String paymentMethod;
	
	@JsonProperty("date")
	private String date;
	
}
