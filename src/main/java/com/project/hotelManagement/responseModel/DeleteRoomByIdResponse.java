package com.project.hotelManagement.responseModel;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DeleteRoomByIdResponse {

	@JsonProperty("message")
	private String message;
	
	@JsonProperty("Room_details_deleted")
	private Boolean RoomDetailsDeleted;
}
