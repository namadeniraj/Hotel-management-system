package com.project.hotelManagement.responseModel;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AddUpdateHotelResponse {
	
	@JsonProperty("message")
	private String message;
	
	@JsonProperty("hotel_added")
	private Boolean hotelAdded;
	
}
