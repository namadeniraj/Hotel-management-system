package com.project.hotelManagement.repository;

import java.util.List;

import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class PaymentDAO {
	
	@PersistenceContext
	EntityManager em;
	
	public Long getTotalAmount () {
		Query query = em.createQuery("SELECT SUM(p.amount) AS totalAmount FROM Payment p");
		 return (Long) query.getSingleResult();
		}
	
	public List<Object[]> paymentDetailsByMethod(String method) {
		String query = "select p.paymentId, p.amount, p.paymentMethod, p.date from Payment p "
				+ "where p.paymentMethod = ?1";
		@SuppressWarnings("unchecked")
	    List<Object[]> result = em.createQuery(query).setParameter(1, method).getResultList();
		
		return result;
	}
	
}
