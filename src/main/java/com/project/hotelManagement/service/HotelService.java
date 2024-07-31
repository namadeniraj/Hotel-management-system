package com.project.hotelManagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.hotelManagement.responseModel.AddUpdateHotelResponse;
import com.project.hotelManagement.responseModel.AllRoomAvailabilityResponse;
import com.project.hotelManagement.responseModel.DeleteHotelByIdResponse;
import com.project.hotelManagement.responseModel.RoomAvailablity;
import com.project.hotelManagement.entity.Hotels;
import com.project.hotelManagement.repository.HotelDAO;
import com.project.hotelManagement.repository.HotelRepository;
import com.project.hotelManagement.responseModel.SingleHotelResponse;

@Service
public class HotelService {
	
	@Autowired HotelRepository hotelRepository;
	
	@Autowired HotelDAO hotelDAO;
	
	public ArrayList<Hotels> getAllHotels() {
		ArrayList<Hotels> guest = new ArrayList<>();
		
		guest = (ArrayList<Hotels>) hotelRepository.findAll();
		
		return guest;
	}
	
	public SingleHotelResponse getHotelById(int id) {
		SingleHotelResponse response = new SingleHotelResponse();
		
		try {
			Hotels h = new Hotels();
			h = hotelRepository.findById(id).get();
			response.setHotel(h);
			response.setMessage("Hotel Found!");
		}catch(Exception ex) {
			response.setHotel(null);
			response.setMessage("Hotel not Found, Please check id");
		}
		return response;
	}
	
	public AddUpdateHotelResponse addUpdateHotel(Hotels hotel) {
		AddUpdateHotelResponse response = new AddUpdateHotelResponse();
		
		try {
			
				int id = hotelRepository.save(hotel).getHotelId();
				if(id > 0) {
					response.setMessage("Hotel Added Succesfully");
					response.setHotelAdded(true);
				}
				else {
					response.setMessage("Unable to add Hotel, please try again");
					response.setHotelAdded(false);
				}
				
		}catch(Exception ex) {
			response.setMessage("Unable to add Hotel, please try again");
			response.setHotelAdded(false);
		}
		
		return response;
	}

	public DeleteHotelByIdResponse deleteByHotelId(int id) {
		DeleteHotelByIdResponse response = new DeleteHotelByIdResponse();
		String message;
		try {
			hotelRepository.deleteById(id);
			message = "Hotel Deleted Successfully";
			response.setHotelDeleted(true);
		}catch(Exception ex) {
			message = "Unable to Deleted Hotel";
			response.setHotelDeleted(false);
		}
		response.setMessage(message);
		return response;
	}
	
	public List<RoomAvailablity> getRoomAvailablitybyID(int id) {
		List<Object[]> rooms = hotelDAO.getRoomAvailablitybyID(id);
		List<RoomAvailablity> response = new ArrayList<RoomAvailablity>();
		
		for(Object[] room : rooms) {
			RoomAvailablity ra = new RoomAvailablity();
			ra.setHotelId((int) room[0]);
			ra.setType(room[1].toString());
			ra.setIsAvailable(room[2].toString());
			response.add(ra);
		}
		return response;
	}
	
	public List<AllRoomAvailabilityResponse> getRoomAvailabilty() {
		List<Object[]> rooms = hotelDAO.getRoomAvailabilty();
		List<AllRoomAvailabilityResponse> response = new ArrayList<AllRoomAvailabilityResponse>();
		
		for(Object[] room : rooms) {
			AllRoomAvailabilityResponse ra = new AllRoomAvailabilityResponse();
			ra.setHotelId((int) room[0]);
			ra.setHotelName(room[1].toString());
			ra.setType(room[2].toString());
			ra.setIsAvailable(room[3].toString());
			response.add(ra);
		}
		return response;
	}
	
}
