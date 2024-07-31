package com.project.hotelManagement.responseModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.hotelManagement.entity.Guest;

import lombok.Data;

@Data
public class SingleGuestResponse {
	
	@JsonProperty
	private Guest guest;
	
	@JsonProperty
	private String message;
	
}
