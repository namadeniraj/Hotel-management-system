package com.project.hotelManagement.responseModel;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class RoomAvailablity {
		
	@JsonProperty("hotel_id")
	private int hotelId;
	
	@JsonProperty("type")
	private String type;
	
	@JsonProperty("is_available")
	private String isAvailable;
}
