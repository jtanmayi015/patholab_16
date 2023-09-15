package com.patholab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patholab.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
