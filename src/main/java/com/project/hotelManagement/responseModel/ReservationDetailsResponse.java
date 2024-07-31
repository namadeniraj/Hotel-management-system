package com.project.hotelManagement.responseModel;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ReservationDetailsResponse {
	
	@JsonProperty("guest_id")
	private int guestId;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("reservation_id")
	private int reservation_id;
	
	
	@JsonProperty("check_in")
	private String checkIn;
	
	@JsonProperty("check_out")
	private String checkOut;
	
	@JsonProperty("room_id")
	private int roomId;
	
}
