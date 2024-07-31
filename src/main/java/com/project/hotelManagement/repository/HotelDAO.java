package com.project.hotelManagement.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class HotelDAO {
	
	@PersistenceContext
	EntityManager em;
	
	public List<Object[]> getRoomAvailablitybyID(int id) {
		String query = "select h.hotelId, r.type, r.isAvailable from Hotels h "
				+ "inner join RoomDetails r on h.hotelId = r.hotelId "
				+ "where h.hotelId = " + id +" and isAvailable = \"yes\"";
		
		@SuppressWarnings("unchecked")
		List<Object[]> result = em.createQuery(query).getResultList();
		
		return result;
	}
	
	public List<Object[]> getRoomAvailabilty() {
		String query = "select h.hotelId, h.hotelName,  r.type, r.isAvailable from Hotels h "
				+ "inner join RoomDetails r on h.hotelId = r.hotelId "
				+ "where isAvailable = \"yes\"";
		
		@SuppressWarnings("unchecked")
		List<Object[]> result = em.createQuery(query).getResultList();
		
		return result;
	}
	
}
