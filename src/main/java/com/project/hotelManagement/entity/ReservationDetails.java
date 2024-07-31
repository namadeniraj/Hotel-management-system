package com.project.hotelManagement.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "reservation_details")
@Data
@Entity

public class ReservationDetails {

	@Id
	@Column(name = "reservation_id")
	@JsonProperty("reservation_id")
	private int reservationId;
	
	@Column(name = "check_in")
	@JsonProperty("check_in")
	private String checkIn;
	
	@Column(name = "check_out")
	@JsonProperty("check_out")
	private String checkOut;
	
	@Column(name = "number_of_guest")
	@JsonProperty("number_of_guest")
	private int numberOfGuest;
	
	@Column(name = "guest_id")
	@JsonProperty("guest_id")
	private int guestId;
	
	@Column(name = "room_id")
	@JsonProperty("room_id")
	private int roomId;
	
}
