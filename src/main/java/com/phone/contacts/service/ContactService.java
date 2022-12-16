package com.phone.contacts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.phone.contacts.entities.Contact;
import com.phone.contacts.repo.ContactRepo;

@Service
public class ContactService {
	@Autowired
	private ContactRepo contactRepo;

	public Contact createContacts(Contact contact) {
		Contact contacts = contactRepo.save(contact);
		System.out.println("contact is created");
		return contacts;
		
	}

	

	public Contact updateContact(Contact contact,long id) {
		Optional<Contact> cId = contactRepo.findById(id);
		//Contact contact = cId.get();
		Contact updateContact=new Contact();
		if(cId.isPresent()) {
			updateContact.setId(contact.getId());
			updateContact.setEmail(contact.getEmail());
			updateContact.setName(contact.getName());
			updateContact.setNumber(contact.getNumber());
			contactRepo.save(updateContact);
		}
		// TODO Auto-generated method stub
		return updateContact;
	}

	public String  deleteContact(long id) {
		// TODO Auto-generated method stub
	//	Optional<Contact> findById = contactRepo.findById(id);
		//if(findById.isPresent()) {
		 contactRepo.deleteById(id);
		 return "record is deleted successfully for id     "+ id     +"  so now  this record is not present in db";
		 //}
		
	}



	public List<Contact> displayAllContacts() {
		// TODO Auto-generated method stub
		return contactRepo.findAll();
	}



	public Optional<Contact> findByContactId(long id) {
		// TODO Auto-generated method stub
		return contactRepo.findById(id);
	}

	

		
}
