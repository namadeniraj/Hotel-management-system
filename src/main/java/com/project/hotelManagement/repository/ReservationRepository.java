package com.project.hotelManagement.repository;

import org.springframework.data.repository.CrudRepository;

import com.project.hotelManagement.entity.ReservationDetails;

public interface ReservationRepository extends CrudRepository <ReservationDetails, Integer> {

}
