package com.ct.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;
@Data
@Entity
public class CustomerDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private long id;
private String name;
private String email;
private long number;
private String gender;
private long ssnNumber;
@OneToOne(cascade=CascadeType.ALL)
@JoinColumn(name="pid",referencedColumnName="pid")
private Plan plan;
}
