package com.patholab.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patholab.entity.Test;

@Repository
public interface TestRepository extends JpaRepository<Test, Integer> {
	List<Test> findByEmpId(int empId,Sort sort);
	List<Test> findByCategoryId(int catid,Sort sort);
}
