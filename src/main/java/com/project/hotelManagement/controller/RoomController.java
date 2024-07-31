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

import com.project.hotelManagement.entity.RoomDetails;
import com.project.hotelManagement.responseModel.AddUpdateRoomResponse;
import com.project.hotelManagement.responseModel.CheckAvailablityResponse;
import com.project.hotelManagement.responseModel.DeleteRoomByIdResponse;
import com.project.hotelManagement.responseModel.RoomAtHotelResponse;
import com.project.hotelManagement.responseModel.RoomDetailsResponse;
import com.project.hotelManagement.service.RoomService;

@RestController
public class RoomController {
	
@Autowired RoomService roomService;
	
	@GetMapping("/room/getAllRoom")
	ArrayList<RoomDetails> getAllRoomDetails() {
		return roomService.getAllRoomDetails();
	}
	
	@GetMapping("/room/getRoomById/{id}")
	RoomDetailsResponse getRoomById(@PathVariable("id") int id) {
		return roomService.getRoomById(id);
	}
	
	@PostMapping("/room/addUpdateRoomDetails")
	AddUpdateRoomResponse addUpdateRoomDetails(@RequestBody RoomDetails room) {
		return roomService.addUpdateRoomDetails(room);
	}
	
	@DeleteMapping("/room/deleteRoom/{id}")
	DeleteRoomByIdResponse deleteByRoomId(@PathVariable("id") int id) {
		return roomService.deleteByRoomId(id);
	}
	
	@GetMapping("/room/checkAvailablity")
	List<CheckAvailablityResponse> checkAvailablity() {
		return roomService.checkAvailablity();
	}
	
	@GetMapping("/room/roomAtHotel/{id}")
	List<RoomAtHotelResponse> roomAtHotel(@PathVariable("id") int id) {
		return roomService.roomAtHotel(id);
	}
	
}
