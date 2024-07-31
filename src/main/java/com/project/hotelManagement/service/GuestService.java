package com.project.hotelManagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.hotelManagement.entity.Guest;
import com.project.hotelManagement.repository.GuestDAO;
import com.project.hotelManagement.repository.GuestRepository;
import com.project.hotelManagement.responseModel.SingleGuestResponse;
import com.project.hotelManagement.responseModel.AddUpdateGuestResponse;
import com.project.hotelManagement.responseModel.DeleteGuestResponse;
import com.project.hotelManagement.responseModel.GuestDetailsResponse;
import com.project.hotelManagement.responseModel.PaymentByGuestResponse;
import com.project.hotelManagement.responseModel.ReservationDetailsResponse;


@Service
public class GuestService {
	
	@Autowired GuestRepository guestRepository;
	
	@Autowired GuestDAO guestDAO;
	
	public ArrayList<Guest> getAllGuest() {
		ArrayList<Guest> guest = new ArrayList<>();
		
		guest = (ArrayList<Guest>) guestRepository.findAll();
		
		return guest;
	}
	
	public SingleGuestResponse getGuestById(int id) {
		SingleGuestResponse response = new SingleGuestResponse();

		try {
			Guest g = new Guest();
			g = guestRepository.findById(id).get();
			response.setMessage("User Found");
			response.setGuest(g);
		}catch(Exception e) {
			response.setGuest(null);
			response.setMessage("User Not Found");
		}
		
		return response;
		
	}
	
	public DeleteGuestResponse deleteUser(int id) {
		DeleteGuestResponse response = new DeleteGuestResponse();
		String message;
		try {
			Guest g = new Guest();
			g = guestRepository.findById(id).get();
			int i = g.getGuestId();
			
			if(i != id) {
				message = "Guest Does not Exsits, please check and try again";
				response.setIsUserDeleted(false);
			}
			else {
			guestRepository.deleteById(id);
			message = "Guest by Id: " + id + " Deleted Successfully!";
			response.setIsUserDeleted(true);
			}
		}catch(Exception ex) {
			message = "Guest Does not Exsits, please check and try again";
			response.setIsUserDeleted(false);
		}
		response.setMessage(message);
		return response;
	}
	
	public AddUpdateGuestResponse addUpdateGuest(Guest guest) {
		AddUpdateGuestResponse response = new AddUpdateGuestResponse();
		try{
			int id = guestRepository.save(guest).getGuestId();
			if(id > 0) {
				response.setMessage("User Added Sucessfully");
				response.setGuestAdded(true);
			}
			else {
				response.setMessage("Unable to add user, please try again");
				response.setGuestAdded(false);
			}
		}catch(Exception ex) {
			response.setMessage("Unable to add user, please try again");
			response.setGuestAdded(false);
		}
		return response;
	}
	
	public List<ReservationDetailsResponse> getReservationDetailsByGuest() {
		List<Object[]> reservationDetails = guestDAO.getReservationDetailsByGuest();
		List<ReservationDetailsResponse> response = new ArrayList<ReservationDetailsResponse>();
		
		for(Object[] reservationDetail : reservationDetails) {
			ReservationDetailsResponse rd = new ReservationDetailsResponse();
			rd.setGuestId((int) reservationDetail[0]);
			rd.setName(reservationDetail[1].toString());
			rd.setReservation_id((int) reservationDetail[2]);
			rd.setCheckIn(reservationDetail[3].toString());
			rd.setCheckOut(reservationDetail[4].toString());
			rd.setRoomId((int) reservationDetail[5]);
			response.add(rd);
		}
		return response;
	}
	
	public List<PaymentByGuestResponse> getPaymentDetails() {
		List<Object[]> paymentDetails = guestDAO.getPaymentDetails();
		List<PaymentByGuestResponse> response = new ArrayList<PaymentByGuestResponse>();
		
		for(Object[] paymentDetail : paymentDetails) {
			PaymentByGuestResponse pd = new PaymentByGuestResponse();
			pd.setGuestId((int) paymentDetail[0]);
			pd.setName(paymentDetail[1].toString());
			pd.setRoomId((int) paymentDetail[2]);
			pd.setAmount((int) paymentDetail[3]);
			pd.setPaymentId((int) paymentDetail[4]);
			response.add(pd);
		}
		return response;
	}
	
	public List<PaymentByGuestResponse> getPaymentDetailsById(int id) {
		List<Object[]> paymentDetails = guestDAO.getPaymentDetailsById(id);
		List<PaymentByGuestResponse> response = new ArrayList<PaymentByGuestResponse>();
		
		for(Object[] paymentDetail : paymentDetails) {
			PaymentByGuestResponse pd = new PaymentByGuestResponse();
			pd.setGuestId((int) paymentDetail[0]);
			pd.setName(paymentDetail[1].toString());
			pd.setRoomId((int) paymentDetail[2]);
			pd.setAmount((int) paymentDetail[3]);
			pd.setPaymentId((int) paymentDetail[4]);
			response.add(pd);
		}
		return response;
	}
	
	public List<GuestDetailsResponse> getGuestDetails() {
		List<Object[]>guestDetails = guestDAO.getGuestDetails();
		List<GuestDetailsResponse> response = new ArrayList<GuestDetailsResponse>();
		
		for(Object[] guestDetail : guestDetails) {
			GuestDetailsResponse gd = new GuestDetailsResponse();
			gd.setGuestId((int) guestDetail[0]);
			gd.setName(guestDetail[1].toString());
			gd.setReservationId((int) guestDetail[2]);
			gd.setRoomId((int) guestDetail[3]);
			gd.setType(guestDetail[4].toString());
			gd.setHotelId((int) guestDetail[5]);
			gd.setHotelName(guestDetail[6].toString());
			response.add(gd);
		}
		
		return response;
	}
	
	public List<GuestDetailsResponse> getGuestDetailsById(int id) {
		List<Object[]>guestDetails = guestDAO.getGuestDetailsById(id);
		List<GuestDetailsResponse> response = new ArrayList<GuestDetailsResponse>();
		
		for(Object[] guestDetail : guestDetails) {
			GuestDetailsResponse gd = new GuestDetailsResponse();
			gd.setGuestId((int) guestDetail[0]);
			gd.setName(guestDetail[1].toString());
			gd.setReservationId((int) guestDetail[2]);
			gd.setRoomId((int) guestDetail[3]);
			gd.setType(guestDetail[4].toString());
			gd.setHotelId((int) guestDetail[5]);
			gd.setHotelName(guestDetail[6].toString());
			response.add(gd);
		}
		
		return response;
	}
	
	public List<ReservationDetailsResponse> getReservationByGuestId(int id) {
		List<Object[]> reservationDetails = guestDAO.getReservationByGuestId(id);
		List<ReservationDetailsResponse> response = new ArrayList<ReservationDetailsResponse>();
		
		for(Object[] reservationDetail : reservationDetails) {
			ReservationDetailsResponse rd = new ReservationDetailsResponse();
			rd.setGuestId((int) reservationDetail[0]);
			rd.setName(reservationDetail[1].toString());
			rd.setReservation_id((int) reservationDetail[2]);
			rd.setCheckIn(reservationDetail[3].toString());
			rd.setCheckOut(reservationDetail[4].toString());
			rd.setRoomId((int) reservationDetail[5]);
			response.add(rd);
		}
		return response;
	}
	
}
