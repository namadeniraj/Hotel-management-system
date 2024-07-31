package com.project.hotelManagement.repository;

import org.springframework.data.repository.CrudRepository;

import com.project.hotelManagement.entity.Guest;

public interface GuestRepository extends CrudRepository <Guest, Integer> {

}
