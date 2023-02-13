package com.ct.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.Data;
@Data
@Entity
public class CustomerPlanDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private long cid;
private String planName;
private String pStatus;
private String cemail;
private String cName;
private long phNo;
private String gender;
private long ssn;


}
