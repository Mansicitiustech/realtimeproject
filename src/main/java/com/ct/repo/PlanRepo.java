package com.ct.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ct.model.Plan;


@Repository
public interface PlanRepo extends JpaRepository<Plan,Long> {
public Optional<Plan> findByPalnName(String pName);
public Optional<Plan> findByPalnStatus(String pStatus);
}
