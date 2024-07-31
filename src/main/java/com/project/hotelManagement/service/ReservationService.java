package com.project.hotelManagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.project.hotelManagement.entity.ReservationDetails;
import com.project.hotelManagement.repository.ReservationDAO;
import com.project.hotelManagement.repository.ReservationRepository;
import com.project.hotelManagement.responseModel.AddUpdateReservationResponse;
import com.project.hotelManagement.responseModel.DeleteReservationResponse;
import com.project.hotelManagement.responseModel.GuestInfoByReservationResponse;
import com.project.hotelManagement.responseModel.ReservationResponse;
import com.project.hotelManagement.responseModel.RoomCreds;
import com.project.hotelManagement.responseModel.RoomCredsResponse;
import com.project.hotelManagement.responseModel.RoomTypeResponse;

@Service
public class ReservationService {
	
@Autowired ReservationRepository reservationRepository;

@Autowired ReservationDAO reservationDAO;
	
	public ArrayList<ReservationDetails> getAllReservation() {
		ArrayList<ReservationDetails> reservation = new ArrayList<>();
		
		reservation = (ArrayList<ReservationDetails>) reservationRepository.findAll();
		
		return reservation;
	}
	
	public ReservationResponse getReservationById(int id) {
		ReservationResponse response = new ReservationResponse();

		try {
			ReservationDetails r = new ReservationDetails();
			r = reservationRepository.findById(id).get();
			response.setMessage("Reservation Found");
			response.setReservation(r);
		}catch(Exception e) {
			response.setReservation(null);
			response.setMessage("Reservation Not Found");
		}
		
		return response;
		
	}
	
	public DeleteReservationResponse deleteReservation(int id) {
		DeleteReservationResponse response = new DeleteReservationResponse();
		String message;
		try {
			reservationRepository.deleteById(id);
			message = "Reservation by Id: " + id + " Deleted Successfully!";
			response.setReservationDeleted(true);
		}catch(Exception ex) {
			message = "Unable to delete Reservation details, please check and try again";
			response.setReservationDeleted(false);
		}
		response.setMessage(message);
		return response;
	}
	
	public AddUpdateReservationResponse addUpdateReservation(ReservationDetails reservation) {
		AddUpdateReservationResponse response = new AddUpdateReservationResponse();
		try{
			int id = reservationRepository.save(reservation).getReservationId();
			if(id > 0) {
				response.setMessage("Reservation Details are Added Sucessfully");
				response.setReservationDetailsAdded(true);
			}
			else {
				response.setMessage("Unable to add Reservation Details, please try again");
				response.setReservationDetailsAdded(false);
			}
		}catch(Exception ex) {
			response.setMessage("Unable to add Reservation Details, please try again");
			response.setReservationDetailsAdded(false);
		}
		return response;
	}
	
	public RoomCredsResponse getRoomCreds(int id) {
		RoomCredsResponse response = new RoomCredsResponse();
		
		try {
			ReservationDetails rd = new ReservationDetails();
			rd = reservationRepository.findById(id).get();
			RoomCreds data = new RoomCreds();
			
			data.setRoomId(rd.getRoomId());
			data.setCheckIn(rd.getCheckIn());
			data.setCheckOut(rd.getCheckOut());
			
			response.setData(data);
			response.setMessage("Check in and Check out data found");
		}catch(Exception ex) {
			response.setData(null);
			response.setMessage("Unable to fetch data!");
		}
		return response;
	}
	
	public List<GuestInfoByReservationResponse> getGuestInfoByReservtionId(int id) {
		List<Object[]> guests = reservationDAO.getGuestInfoByReservtionId(id);
		List<GuestInfoByReservationResponse> response = new ArrayList<GuestInfoByReservationResponse>();
		
		for (Object[] guest : guests) {
			GuestInfoByReservationResponse g = new GuestInfoByReservationResponse();
			g.setReservationId((int)guest[0]);
			g.setGuestId((int)guest[1]);
			g.setName(guest[2].toString());
			g.setEmail(guest[3].toString());
			g.setAddress(guest[4].toString());
			response.add(g);
		}
		return response;
	}
	
	public List<RoomTypeResponse> getRoomTypeById(int id) {
		List<Object[]> types = reservationDAO.getRoomTypeById(id);
		List<RoomTypeResponse> response = new ArrayList<RoomTypeResponse>();
		
		for(Object[]type : types) {
			RoomTypeResponse rt = new RoomTypeResponse();
			rt.setReservationId((int) type[0]);
			rt.setType(type[1].toString());
			response.add(rt);
		}
		return response;
	}
	
}
