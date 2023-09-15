package com.patholab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patholab.entity.Test;

@Repository
public interface BookRepository extends JpaRepository<Test, Integer> {
	
	List<Test> findByCategoryId(int catid);
}
