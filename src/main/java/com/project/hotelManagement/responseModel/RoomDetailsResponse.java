package com.project.hotelManagement.responseModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.hotelManagement.entity.RoomDetails;

import lombok.Data;

@Data
public class RoomDetailsResponse {
	
	@JsonProperty("room")
	private RoomDetails room;
	
	@JsonProperty("message")
	private String message;
	
}
