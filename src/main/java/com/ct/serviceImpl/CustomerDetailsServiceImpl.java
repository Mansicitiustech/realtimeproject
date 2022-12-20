package com.ct.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ct.model.CustomerDetails;
import com.ct.model.Plan;
import com.ct.repo.CustomerDetailsRepo;
import com.ct.repo.PlanRepo;
import com.ct.service.CustomerDetailsService;
@Service
public class CustomerDetailsServiceImpl implements CustomerDetailsService {
	@Autowired
	private CustomerDetailsRepo customRepo;
	@Autowired
	private PlanRepo planRepo;

	@Override
	public List<CustomerDetails> findAllCustomers() {
		// TODO Auto-generated method stub
		return customRepo.findAll();
	}

	@Override
	public Optional<Plan> findPlanByStatus(String pStatus) {
		// TODO Auto-generated method stub
		return planRepo.findByPalnStatus(pStatus);
	}

	@Override
	public Optional<Plan> findPlanByName(String pName) {
		// TODO Auto-generated method stub
		return planRepo.findByPalnName(pName);
	}

	@Override
	public Optional<CustomerDetails> findCustomerByPlan(long pid) {
		// TODO Auto-generated method stub
		return customRepo.findByPlan(pid);
	}

}
