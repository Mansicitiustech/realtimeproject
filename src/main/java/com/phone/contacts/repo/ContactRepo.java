package com.phone.contacts.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phone.contacts.entities.Contact;

public interface ContactRepo extends JpaRepository<Contact,Long>{

}
