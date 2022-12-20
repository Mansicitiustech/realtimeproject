package com.ct.service;

import java.util.List;
import java.util.Optional;

import com.ct.model.CustomerDetails;
import com.ct.model.Plan;

public interface CustomerDetailsService {
public List<CustomerDetails> findAllCustomers();
public Optional<Plan> findPlanByStatus(String pStatus);
public Optional<Plan> findPlanByName(String pName);
public Optional<CustomerDetails> findCustomerByPlan(long pid);
}
