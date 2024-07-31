package com.project.hotelManagement.responseModel;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DeletePaymentResponse {
	
	@JsonProperty("message")
	private String message;
	
	@JsonProperty("details_deleted")
	private Boolean detailsDeleted;
	
}
