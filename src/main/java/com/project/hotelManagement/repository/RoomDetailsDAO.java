package com.project.hotelManagement.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class RoomDetailsDAO {
	
	@PersistenceContext
	EntityManager em;
	
	public List<Object[]> checkAvailablity() {
		String query = "select roomId, type, isAvailable, hotelId from RoomDetails where isAvailable = \"yes\"";
		
		@SuppressWarnings("unchecked")
		List<Object[]> result = em.createQuery(query).getResultList();
		
		return result;
	}
	
	public List<Object[]> roomAtHotel(int id) {
        String query = "select h.hotelId, h.name, h.address, r.roomId, r.type from Hotels h "
        		+ "inner join RoomDetails r on h.hotelId = r.hotelId where h.hotelId = " + id;
		
        @SuppressWarnings("unchecked")
		List<Object[]> result = em.createQuery(query).getResultList();
		
		return result;
	}
	
}
