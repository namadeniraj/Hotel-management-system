package com.project.hotelManagement.responseModel;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class GuestInfoByReservationResponse {
	
	@JsonProperty("reservation_id")
	private int reservationId;
	
	@JsonProperty("guest_id")
	private int guestId;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("email")
	private String email;
	
	@JsonProperty("address")
	private String address;
	
}
