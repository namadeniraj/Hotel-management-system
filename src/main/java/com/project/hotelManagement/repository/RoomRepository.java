package com.project.hotelManagement.repository;

import org.springframework.data.repository.CrudRepository;

import com.project.hotelManagement.entity.RoomDetails;

public interface RoomRepository extends CrudRepository <RoomDetails, Integer> {

}
