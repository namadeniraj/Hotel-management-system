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

import com.project.hotelManagement.entity.Guest;
import com.project.hotelManagement.responseModel.AddUpdateGuestResponse;
import com.project.hotelManagement.responseModel.DeleteGuestResponse;
import com.project.hotelManagement.responseModel.GuestDetailsResponse;
import com.project.hotelManagement.responseModel.PaymentByGuestResponse;
import com.project.hotelManagement.responseModel.ReservationDetailsResponse;
import com.project.hotelManagement.responseModel.SingleGuestResponse;
import com.project.hotelManagement.service.GuestService;

@RestController
public class GuestController {
	
	@Autowired GuestService guestService;
	
	@GetMapping("/guest/getAllGuest")
	ArrayList<Guest> getAllGuest() {
		return guestService.getAllGuest();
	}
	
	@GetMapping("/guest/getGuestById/{id}")
	SingleGuestResponse getGuestById(@PathVariable("id") int id) {
		return guestService.getGuestById(id);
	}
	
	@DeleteMapping("/guest/deleteGuest/{id}")
	DeleteGuestResponse deleteUser(@PathVariable("id") int id) {
		return guestService.deleteUser(id);
	}
	
	@PostMapping("/guest/addUpdateGuest")
	AddUpdateGuestResponse addUpdateGuest(@RequestBody Guest guest) {
		return guestService.addUpdateGuest(guest);
	}
	
	@GetMapping("/guest/getReservationDetails")
	List<ReservationDetailsResponse> getReservationDetailsByGuest() {
		return guestService.getReservationDetailsByGuest();
	}
	
	@GetMapping("/guest/getPaymentDetails")
	List<PaymentByGuestResponse> getPaymentDetails() {
		return guestService.getPaymentDetails();
	}
	
	@GetMapping("/guest/getPaymentDetailsById/{id}")
	List<PaymentByGuestResponse> getPaymentDetailsById(@PathVariable("id") int id) {
		return guestService.getPaymentDetailsById(id);
	}
	
	@GetMapping("/guest/getGuestDetails")
	List<GuestDetailsResponse> getGuestDetails() {
		return guestService.getGuestDetails();
	}
	
	@GetMapping("/guest/getGuestDetailsById/{id}")
	List<GuestDetailsResponse> getGuestDetailsById(@PathVariable("id") int id) {
		return guestService.getGuestDetailsById(id);
	}
	
	@GetMapping("/guest/getReservationByGuestId/{id}")
	List<ReservationDetailsResponse> getReservationByGuestId(@PathVariable("id") int id) {
		return guestService.getReservationByGuestId(id);
	}
	
}
