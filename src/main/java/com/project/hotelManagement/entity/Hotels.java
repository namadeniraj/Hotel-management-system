package com.project.hotelManagement.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

//import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "hotels")
@Data
@Entity
public class Hotels {
	
	@Id
	@Column(name = "hotel_id")
	@JsonProperty("hotel_id")
	private int hotelId;
	
	@Column(name = "hotel_name")
	private String hotelName;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "phone_number")
	@JsonProperty("phone_number")
	private long phoneNumber;
	
}
