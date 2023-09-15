package com.patholab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patholab.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String> {

}
