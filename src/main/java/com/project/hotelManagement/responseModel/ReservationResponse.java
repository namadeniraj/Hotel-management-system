package com.project.hotelManagement.responseModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.hotelManagement.entity.ReservationDetails;

import lombok.Data;

@Data
public class ReservationResponse {
	
	@JsonProperty("reservation_details")
	private ReservationDetails reservation;
	
	@JsonProperty("message")
	private String message;
	
}
