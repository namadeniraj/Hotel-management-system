package com.project.hotelManagement.repository;

import org.springframework.data.repository.CrudRepository;

import com.project.hotelManagement.entity.Hotels;

public interface HotelRepository extends CrudRepository <Hotels, Integer> {

}
