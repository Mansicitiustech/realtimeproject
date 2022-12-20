package com.ct.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
@Data
@Entity
public class Plan {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private long pid;
	private String pName;
	private String pStatus;
	private Date startDate;
	private Date endDate;
	
	

}
