package com.project.hotelManagement.responseModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.hotelManagement.entity.Hotels;

import lombok.Data;

@Data
public class SingleHotelResponse {
	
	@JsonProperty("hotel")
	private Hotels hotel;
	
	@JsonProperty("message")
	private String message;
		
}
