package com.project.hotelManagement.repository;

import org.springframework.data.repository.CrudRepository;

import com.project.hotelManagement.entity.Payment;

public interface PaymentRepository extends CrudRepository <Payment, Integer> {

}