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

import com.project.hotelManagement.entity.ReservationDetails;
import com.project.hotelManagement.responseModel.AddUpdateReservationResponse;
import com.project.hotelManagement.responseModel.DeleteReservationResponse;
import com.project.hotelManagement.responseModel.GuestInfoByReservationResponse;
import com.project.hotelManagement.responseModel.ReservationResponse;
import com.project.hotelManagement.responseModel.RoomCredsResponse;
import com.project.hotelManagement.responseModel.RoomTypeResponse;
import com.project.hotelManagement.service.ReservationService;

@RestController
public class ReservationController {
	
@Autowired ReservationService reservationService;
	
	@GetMapping("/reservation/getAllReservation")
	ArrayList<ReservationDetails> getAllReservation() {
		return reservationService.getAllReservation();
	}
	
	@GetMapping("/reservation/getReservationtById/{id}")
	ReservationResponse getGuestById(@PathVariable("id") int id) {
		return reservationService.getReservationById(id);
	}
	
	@DeleteMapping("/reservation/deleteReservation/{id}")
	DeleteReservationResponse deleteReservation(@PathVariable("id") int id) {
		return reservationService.deleteReservation(id);
	}
	
	@PostMapping("/reservation/addUpdateReservation")
	AddUpdateReservationResponse addUpdateReservation(@RequestBody ReservationDetails reservation) {
		return reservationService.addUpdateReservation(reservation);
	}
	
	@GetMapping("/reservation/getRoomCreds/{id}")
	RoomCredsResponse getRoomCreds(@PathVariable("id") int id) {
		return reservationService.getRoomCreds(id);
	}
	
	@GetMapping("/reservation/getGuestInfoByReservtionId/{id}")
	List<GuestInfoByReservationResponse> getGuestInfoByReservtionId(@PathVariable("id") int id) {
		return reservationService.getGuestInfoByReservtionId(id);
	}
	
	@GetMapping("/reservation/getRoomTypeById/{id}")
	List<RoomTypeResponse> getRoomTypeById(@PathVariable("id") int id) {
		return reservationService.getRoomTypeById(id);
	}
	
}
