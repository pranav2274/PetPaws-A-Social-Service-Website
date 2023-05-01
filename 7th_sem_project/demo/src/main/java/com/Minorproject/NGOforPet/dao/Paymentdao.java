package com.Minorproject.NGOforPet.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Minorproject.NGOforPet.entities.payment_details;

public interface Paymentdao extends JpaRepository<payment_details, Integer>{

}
