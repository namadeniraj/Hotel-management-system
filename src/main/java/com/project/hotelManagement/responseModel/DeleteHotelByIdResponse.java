package com.project.hotelManagement.responseModel;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DeleteHotelByIdResponse {
	
	@JsonProperty("message")
	private String message;
	
	@JsonProperty("hotet_deleted")
	private Boolean hotelDeleted;
	
}
