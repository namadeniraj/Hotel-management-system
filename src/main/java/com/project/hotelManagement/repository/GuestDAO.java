package com.project.hotelManagement.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class GuestDAO {
	
	@PersistenceContext
	EntityManager em;
	
	public List<Object[]> getReservationDetailsByGuest() {
		String query = "select g.guestId, g.name, r.reservationId, r.checkIn, r.checkOut, r.roomId "
				+ "from Guest g inner join ReservationDetails r on g.guestId = r.guestId";
		
		@SuppressWarnings("unchecked")
		List<Object[]> result = em.createQuery(query).getResultList();
		return result;
		
	}
	
	public List<Object[]> getPaymentDetails() {
		String query = "select g.guestId, g.name, r.roomId, p.amount, p.paymentId from Guest g "
				+ "inner join ReservationDetails r on g.guestId = r.guestId "
				+ "inner join Payment p on r.reservationId = p.reservationId";
		
		@SuppressWarnings("unchecked")
		List<Object[]> result = em.createQuery(query).getResultList();
		return result;
	}
	
    public List<Object[]> getPaymentDetailsById(int id) {
    	String query = "select g.guestId, g.name, r.roomId, p.amount, p.paymentId from Guest g "
				+ "inner join ReservationDetails r on g.guestId = r.guestId "
				+ "inner join Payment p on r.reservationId = p.reservationId where g.guestId = " + id;
		
    	@SuppressWarnings("unchecked")
		List<Object[]> result = em.createQuery(query).getResultList();
		return result;
	}
	
    public List<Object[]> getGuestDetails() {
    	String query = "select g.guestId, g.name, r.reservationId, ro.roomId, ro.type, h.hotelId, h.hotelName "
    			+ "from Guest g inner join ReservationDetails r on g.guestId = r.reservationId "
    			+ "inner join RoomDetails ro on r.roomId = ro.roomId "
    			+ "inner join Hotels h on ro.hotelId = h.hotelId";
    	
    	@SuppressWarnings("unchecked")
		List<Object[]> result = em.createQuery(query).getResultList();
		return result;
    }
    
    public List<Object[]> getGuestDetailsById(int id ) {
    	String query = "select g.guestId, g.name, r.reservationId, ro.roomId, ro.type, h.hotelId, h.hotelName "
    			+ "from Guest g inner join ReservationDetails r on g.guestId = r.reservationId "
    			+ "inner join RoomDetails ro on r.roomId = ro.roomId "
    			+ "inner join Hotels h on ro.hotelId = h.hotelId where g.guestId = " + id;
    	
    	@SuppressWarnings("unchecked")
		List<Object[]> result = em.createQuery(query).getResultList();
		return result;
    }
    
    public List<Object[]> getReservationByGuestId(int id) {
		String query = "select g.guestId, g.name, r.reservationId, r.checkIn, r.checkOut, r.roomId "
				+ "from Guest g inner join ReservationDetails r on g.guestId = r.guestId where g.guestId = " + id;
		
		@SuppressWarnings("unchecked")
		List<Object[]> result = em.createQuery(query).getResultList();
		return result;
		
	}
    
}
