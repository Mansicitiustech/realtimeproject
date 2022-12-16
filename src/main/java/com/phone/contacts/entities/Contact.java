package com.phone.contacts.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="CONTACT_DETAILS")
public class Contact {
	@Column(name="CONTACT_ID")
	@Id
	private long id;
	@Column(name="CONTACT_NAME")
	private String name;
	@Column(name="CONTACT_EMAIL")
	private String email;
	@Column(name="CONTACT_NUMBER")
	private long number;

}
