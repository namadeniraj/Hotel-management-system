package com.project.hotelManagement.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.hotelManagement.entity.Hotels;
import com.project.hotelManagement.responseModel.AddUpdateHotelResponse;
import com.project.hotelManagement.responseModel.AllRoomAvailabilityResponse;
import com.project.hotelManagement.responseModel.DeleteHotelByIdResponse;
import com.project.hotelManagement.responseModel.RoomAvailablity;
import com.project.hotelManagement.responseModel.SingleHotelResponse;
import com.project.hotelManagement.service.HotelService;

@RestController
public class HotelController {
	
	@Autowired HotelService hotelService;
	
	@GetMapping("/hotel/getAllHotels")
	ArrayList<Hotels> getAllHotels() {
		return hotelService.getAllHotels();
	}
	
	@GetMapping("/hotel/getHotelById/{id}")
	SingleHotelResponse getHotelById(@PathVariable("id") int id) {
		return hotelService.getHotelById(id);
	}
	
	@PostMapping("/hotel/addUpdateHotel")
	AddUpdateHotelResponse addUpdateHotel(@RequestBody Hotels hotel) {
		return hotelService.addUpdateHotel(hotel);
	}
	
	@DeleteMapping("/hotel/deleteHotelById/{id}")
	DeleteHotelByIdResponse deleteById(@PathVariable("id") int id) {
		return hotelService.deleteByHotelId(id);
	}
	
	@GetMapping("/hotel/getRoomAvailablitybyID/{id}")
	List<RoomAvailablity> getRoomAvailablitybyID(@PathVariable("id") int id) {
		return hotelService.getRoomAvailablitybyID(id);
	}
	
	@GetMapping("/hotel/getRoomAvailabilty")
	List<AllRoomAvailabilityResponse> getRoomAvailabilty() {
		return hotelService.getRoomAvailabilty();
	}
	
}
