package com.project.hotelManagement.responseModel;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CheckAvailablityResponse {
	
	@JsonProperty("room_id")
	private int roomId;
	
	@JsonProperty("type")
	private String type;
	
	@JsonProperty("is_available")
	private String isAvailable;
	
	@JsonProperty("hotel_id")
	private int hotelId;
	
}
