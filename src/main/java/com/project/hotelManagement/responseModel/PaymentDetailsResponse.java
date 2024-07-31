package com.project.hotelManagement.responseModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.hotelManagement.entity.Payment;

import lombok.Data;

@Data
public class PaymentDetailsResponse {
	
	@JsonProperty("payement_info")
	private Payment payment;
	
	@JsonProperty("message")
	private String message;
	
}
