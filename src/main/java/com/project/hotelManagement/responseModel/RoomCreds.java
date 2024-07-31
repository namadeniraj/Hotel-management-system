package com.project.hotelManagement.responseModel;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class RoomCreds {
	
	@JsonProperty("room_id")
	int roomId;
	
	@JsonProperty("check_in")
	String checkIn;
	
	@JsonProperty("check_out")
	String checkOut;
	
}
