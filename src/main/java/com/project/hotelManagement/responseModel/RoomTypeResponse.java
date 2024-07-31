package com.project.hotelManagement.responseModel;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class RoomTypeResponse {

	@JsonProperty("reservation_id")
	private int reservationId;
	
	@JsonProperty("type")
	private String type;
	
}
