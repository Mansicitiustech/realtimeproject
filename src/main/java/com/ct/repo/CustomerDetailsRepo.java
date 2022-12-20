package com.ct.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ct.model.CustomerDetails;
import com.ct.model.Plan;
@Repository
public interface CustomerDetailsRepo extends JpaRepository<CustomerDetails,Long> {
public Optional<CustomerDetails> findByPlan(long pid);
}
