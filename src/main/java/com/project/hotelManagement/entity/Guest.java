package com.project.hotelManagement.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

//import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "guest")
@Entity
@Data
public class Guest {
	
	@Id
	@Column(name = "guest_id")
	@JsonProperty("guest_id")
	private int guestId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "phone_number")
	@JsonProperty("phone_number")
	private long phoneNumber;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "nationality")
	private String nationality;
	
}
