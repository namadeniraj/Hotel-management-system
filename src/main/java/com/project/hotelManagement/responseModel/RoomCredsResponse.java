package com.project.hotelManagement.responseModel;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class RoomCredsResponse {
	
	@JsonProperty("data")
	private RoomCreds data;
	
	@JsonProperty("message")
	private String message;
	
}
