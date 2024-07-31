package com.project.hotelManagement.responseModel;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AddUpdatePaymentResponse {
	
	@JsonProperty("message")
	private String message;
	
	@JsonProperty("payment_details_added")
	private Boolean paymentDetailsAdded;
	
}
