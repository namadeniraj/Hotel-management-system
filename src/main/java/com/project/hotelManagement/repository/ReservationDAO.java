package com.project.hotelManagement.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class ReservationDAO {
	
	@PersistenceContext
	EntityManager em;
	
	public List<Object[]> getGuestInfoByReservtionId(int id) {
		String query = "select r.reservationId, g.guestId, g.name, g.email, g.address from Guest g "
				+ "right join ReservationDetails r on g.guestId = r.guestId where r.reservationId = " + id;
		
		@SuppressWarnings("unchecked")
		List<Object[]> result = em.createQuery(query).getResultList();
		
		return result;
	}
	
	public List<Object[]> getRoomTypeById(int id) {
		String query = "select r.reservationId, ro.type from ReservationDetails r "
				+ "inner join RoomDetails ro on r.roomId = ro.roomId where r.reservationId = " + id;
		
		@SuppressWarnings("unchecked")
		List<Object[]> result = em.createQuery(query).getResultList();
		
		return result;
	}
	
}
