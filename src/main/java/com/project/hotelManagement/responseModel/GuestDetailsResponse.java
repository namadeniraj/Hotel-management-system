package com.project.hotelManagement.responseModel;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class GuestDetailsResponse {
	
	@JsonProperty("guest_id")
	private int guestId;
	 
	@JsonProperty("name")
	private String name;
	 
	@JsonProperty("reservation_id")
	private int reservationId;
	 
	@JsonProperty("room_id")
	private int roomId;
	 
	@JsonProperty("type")
	private String type;
	 
	@JsonProperty("hotel_id")
	private int hotelId;
	 
	@JsonProperty("hotel_name")
	private String hotelName;
	
}
