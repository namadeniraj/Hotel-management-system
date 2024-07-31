package com.project.hotelManagement.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "room_details")
@Data
@Entity

public class RoomDetails {
	
	@Id
	@Column(name = "room_id")
	@JsonProperty("room_id")
	private int roomId;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "is_available")
	@JsonProperty("is_available")
	private String isAvailable;
	
	@Column(name = "hotel_id")
	@JsonProperty("hotel_id")
	private int hotelId;
	
}
