package com.project.hotelManagement.responseModel;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class TotalAmountResponse {
	
	@JsonProperty("total_amount")
	private long totalAmount;
	
}
