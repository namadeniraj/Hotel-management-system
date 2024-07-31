package com.project.hotelManagement.responseModel;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DeleteReservationResponse {
	
	@JsonProperty("message")
	private String message;
	
	@JsonProperty("reservation_deleted")
	private Boolean reservationDeleted;
	
}
