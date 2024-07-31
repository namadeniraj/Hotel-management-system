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

import com.project.hotelManagement.entity.Payment;
import com.project.hotelManagement.responseModel.AddUpdatePaymentResponse;
import com.project.hotelManagement.responseModel.DeletePaymentResponse;
import com.project.hotelManagement.responseModel.PaymentDetailsByMethodResponse;
import com.project.hotelManagement.responseModel.PaymentDetailsResponse;
import com.project.hotelManagement.responseModel.TotalAmountResponse;
import com.project.hotelManagement.service.PaymentService;

@RestController
public class PaymentController {
	
	@Autowired PaymentService paymentService;
	
	@GetMapping("/payment/getAllPaymentDetails")
	ArrayList<Payment> getAllPaymentDetails() {
		return paymentService.getAllPaymentDetails();
	}
	
	@GetMapping("/payment/getPaymentDetailsById/{id}")
	PaymentDetailsResponse getPaymentDetailsById(@PathVariable("id") int id) {
		return paymentService.getPaymentDetailsById(id);
	}
	
	@DeleteMapping("/payment/deletePaymentDetails/{id}")
	DeletePaymentResponse deletePaymentDetails(@PathVariable("id") int id) {
		return paymentService.deletePaymentDetails(id);
	}
	
	@PostMapping("/payment/addUpdatePaymentDetails")
	AddUpdatePaymentResponse addUpdatePaymentDetails(@RequestBody Payment payment) {
		return paymentService.addUpdatePaymentDetails(payment);
	}
	
	@GetMapping("/payment/getTotalAmount")
	Long getTotalAmount() {
		return paymentService.getTotalAmount();
	}
	
	@GetMapping("/payment/paymentDetailsByMethod/{method}")
	List<PaymentDetailsByMethodResponse> paymentDetailsByMethod(@PathVariable("method") String method) {
		return paymentService.paymentDetailsByMethod(method);
	}
	
}
