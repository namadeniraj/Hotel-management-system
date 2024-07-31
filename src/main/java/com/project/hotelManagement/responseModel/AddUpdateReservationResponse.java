package com.project.hotelManagement.responseModel;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AddUpdateReservationResponse {
	
	@JsonProperty("message")
	private String message;
	
	@JsonProperty("reservation_details_added")
	private Boolean reservationDetailsAdded;
	
}
