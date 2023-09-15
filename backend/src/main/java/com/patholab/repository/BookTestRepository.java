package com.patholab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patholab.entity.BookTest;
import com.patholab.entity.Patient;

@Repository
public interface BookTestRepository extends JpaRepository<BookTest, Integer> {
	List<BookTest> findByPatient(Patient patient);
}
