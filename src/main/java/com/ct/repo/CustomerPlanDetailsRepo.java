package com.ct.repo;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ct.model.CustomerPlanDetails;

@Repository
public interface CustomerPlanDetailsRepo extends JpaRepository<CustomerPlanDetails,Serializable> {
@Query(value="select distinct(c.plan_name) from customer_plan_details c",nativeQuery=true)
	public List<String> getPlanNames();
@Query(value="select distinct(c.p_status) from customer_plan_details c",nativeQuery=true)
public List<String> getPlanStatus();
//@Query(value="select c from customer_plan_details c where c.plan_name=:planName and c.p_status=:pStatus",nativeQuery=true)
//@Query(value="select c from  customer_plan_details c where c.p_status = :pStatus And c.plan_name =planName",nativeQuery=true)
//public List<CustomerPlanDetails> getByStatusAndName(String pStatus,String planName);
}
