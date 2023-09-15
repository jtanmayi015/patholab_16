package com.patholab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patholab.entity.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

}
