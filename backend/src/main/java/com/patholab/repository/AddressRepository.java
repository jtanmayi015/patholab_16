package com.patholab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patholab.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
