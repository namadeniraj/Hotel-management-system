package com.project.hotelManagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.hotelManagement.entity.RoomDetails;
import com.project.hotelManagement.repository.RoomDetailsDAO;
import com.project.hotelManagement.repository.RoomRepository;
import com.project.hotelManagement.responseModel.AddUpdateRoomResponse;
import com.project.hotelManagement.responseModel.CheckAvailablityResponse;
import com.project.hotelManagement.responseModel.DeleteRoomByIdResponse;
import com.project.hotelManagement.responseModel.RoomAtHotelResponse;
import com.project.hotelManagement.responseModel.RoomDetailsResponse;

@Service
public class RoomService {
	
@Autowired RoomRepository roomRepository;

@Autowired RoomDetailsDAO roomDetailsDAO;
	
	public ArrayList<RoomDetails> getAllRoomDetails() {
		ArrayList<RoomDetails> room = new ArrayList<>();
		
		room = (ArrayList<RoomDetails>) roomRepository.findAll();
		
		return room;
	}
	
	public RoomDetailsResponse getRoomById(int id) {
		RoomDetailsResponse response = new RoomDetailsResponse();
		
		try {
			RoomDetails r = new RoomDetails();
			r = roomRepository.findById(id).get();
			response.setRoom(r);
			response.setMessage("Room Details Found!");
		}catch(Exception ex) {
			response.setRoom(null);
			response.setMessage("Unable to find Room Details, please check Id");
		}
		return response;
	}
	
	public AddUpdateRoomResponse addUpdateRoomDetails(RoomDetails room) {
		AddUpdateRoomResponse response = new AddUpdateRoomResponse();
		
		try {
			
				int id = roomRepository.save(room).getRoomId();
				if(id > 0) {
					response.setMessage("Room details are Added Succesfully");
					response.setRoomDetailsAdded(true);
				}
				else {
					response.setMessage("Unable to add Room details, please try again");
					response.setRoomDetailsAdded(false);
				}
				
		}catch(Exception ex) {
			response.setMessage("Unable to add Room details, please try again");
			response.setRoomDetailsAdded(false);
		}
		
		return response;
	}

	public DeleteRoomByIdResponse deleteByRoomId(int id) {
		DeleteRoomByIdResponse response = new DeleteRoomByIdResponse();
		String message;
		try {
			roomRepository.deleteById(id);
			message = "Room Details Deleted Successfully";
			response.setRoomDetailsDeleted(true);
		}catch(Exception ex) {
			message = "Unable to Deleted Room Details";
			response.setRoomDetailsDeleted(false);
		}
		response.setMessage(message);
		return response;
	}
	
	public List<CheckAvailablityResponse> checkAvailablity() {
		List<Object[]> checkavailabilties = roomDetailsDAO.checkAvailablity();
		List<CheckAvailablityResponse> response = new ArrayList<CheckAvailablityResponse>();
		
		for(Object[] checkavailabilty : checkavailabilties) {
			CheckAvailablityResponse ca = new CheckAvailablityResponse();
			ca.setRoomId((int) checkavailabilty[0]);
			ca.setType(checkavailabilty[1].toString());
			ca.setIsAvailable(checkavailabilty[2].toString());
			ca.setHotelId((int) checkavailabilty[3]);
			response.add(ca);
		}
		return response;
	}
	
	public List<RoomAtHotelResponse> roomAtHotel(int id) {
		List<Object[]> roomAtHotels = roomDetailsDAO.roomAtHotel(id);
		List<RoomAtHotelResponse> response = new ArrayList<RoomAtHotelResponse>();
		
		for(Object[] roomAtHotel : roomAtHotels) {
			RoomAtHotelResponse rh = new RoomAtHotelResponse();
			rh.setHotelId((int)roomAtHotel[0]);
			rh.setName(roomAtHotel[1].toString());
			rh.setAddress(roomAtHotel[2].toString());
			rh.setRoomId((int)roomAtHotel[3]);
			response.add(rh);
		}
		return response;
	}
	
}
