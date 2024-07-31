package com.project.hotelManagement.responseModel;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AddUpdateGuestResponse {
	
	@JsonProperty
	private String message;
	
	@JsonProperty("guest_added")
	private Boolean GuestAdded;
	
	
}
