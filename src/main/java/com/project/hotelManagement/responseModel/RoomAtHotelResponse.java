package com.project.hotelManagement.responseModel;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class RoomAtHotelResponse {
	
	@JsonProperty("hotel_id")
	private int hotelId;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("address")
	private String address;
	
	@JsonProperty("room_id")
	private int roomId;
	
}
