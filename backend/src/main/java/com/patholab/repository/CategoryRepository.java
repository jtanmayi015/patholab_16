package com.patholab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patholab.entity.TestCategory;

@Repository
public interface CategoryRepository extends JpaRepository<TestCategory, Integer> {

}
