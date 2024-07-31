package com.project.hotelManagement.responseModel;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AddUpdateRoomResponse {
	
	@JsonProperty("message")
	private String message;
	
	@JsonProperty("room_details_added")
	private Boolean roomDetailsAdded;
	
}
