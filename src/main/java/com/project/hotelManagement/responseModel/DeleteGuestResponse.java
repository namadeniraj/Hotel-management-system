package com.project.hotelManagement.responseModel;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DeleteGuestResponse {
	
	@JsonProperty("message")
	private String message ;
	
	@JsonProperty("is_user_deleted")
	private Boolean isUserDeleted;
	
}
