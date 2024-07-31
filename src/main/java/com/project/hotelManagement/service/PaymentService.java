package com.project.hotelManagement.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.hotelManagement.entity.Payment;
import com.project.hotelManagement.repository.PaymentDAO;
import com.project.hotelManagement.repository.PaymentRepository;
import com.project.hotelManagement.responseModel.AddUpdatePaymentResponse;
import com.project.hotelManagement.responseModel.DeletePaymentResponse;
import com.project.hotelManagement.responseModel.PaymentDetailsByMethodResponse;
import com.project.hotelManagement.responseModel.PaymentDetailsResponse;
import com.project.hotelManagement.responseModel.TotalAmountResponse;

@Service
public class PaymentService {
	
	@Autowired PaymentRepository paymentRepository;
	
	@Autowired PaymentDAO paymentDAO;
	
	public ArrayList<Payment> getAllPaymentDetails() {
		ArrayList<Payment> paymentDetails = new ArrayList<>();
		
		paymentDetails = (ArrayList<Payment>) paymentRepository.findAll();
		
		return paymentDetails;
	}
	
	public PaymentDetailsResponse getPaymentDetailsById(int id) {
		PaymentDetailsResponse response = new PaymentDetailsResponse();
		try {
			Payment p = new Payment();
			p = paymentRepository.findById(id).get();
			response.setPayment(p);
			response.setMessage("Payment Detail by Id: " + id +" Found Succesfully");
		}catch(Exception ex) {
			response.setPayment(null);
			response.setMessage("Unable to find Payment Details");
		}
		return response;
	}
	
	public DeletePaymentResponse deletePaymentDetails(int id) {
		DeletePaymentResponse response = new DeletePaymentResponse();
		try {
			paymentRepository.deleteById(id);
			response.setDetailsDeleted(true);
			response.setMessage("Payment details deleted successfully!");
		}catch(Exception ex) {
			response.setDetailsDeleted(false);
			response.setMessage("Unable to delete payment details, please try again");
		}
		return response;
	}
	
	public AddUpdatePaymentResponse addUpdatePaymentDetails(Payment payment) {
		AddUpdatePaymentResponse response = new AddUpdatePaymentResponse();
		try {
			int id = paymentRepository.save(payment).getPaymentId();
			if(id > 0) {
				response.setMessage("Payment Details Added Successfully");
				response.setPaymentDetailsAdded(true);
			}
			else {
				response.setMessage("Unable to add Payment Details, please try again");
				response.setPaymentDetailsAdded(false);
			}
		}catch(Exception ex) {
			response.setMessage("Unable to add Payment Details, please try again");
			response.setPaymentDetailsAdded(false);
		}
		return response;
	}
	
	public Long getTotalAmount() {
		 return paymentDAO.getTotalAmount();
	}
	
	public List<PaymentDetailsByMethodResponse> paymentDetailsByMethod(String method) {
		List<Object[]> details = paymentDAO.paymentDetailsByMethod(method);
		List<PaymentDetailsByMethodResponse> response = new ArrayList<PaymentDetailsByMethodResponse>();
		
		for(Object[] detail : details) {
			PaymentDetailsByMethodResponse pd = new PaymentDetailsByMethodResponse();
			pd.setPaymentId((int) detail[0]);
			pd.setAmount((int) detail[1]);
			pd.setPaymentMethod(detail[2].toString());
			pd.setDate(detail[3].toString());
			
			response.add(pd);
		}
		return response;
	}
	
}
