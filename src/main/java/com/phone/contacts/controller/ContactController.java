package com.phone.contacts.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.phone.contacts.entities.Contact;
import com.phone.contacts.exception.ContactIsAlreadyExists;
import com.phone.contacts.exception.ContactNotFoundException;
import com.phone.contacts.service.ContactService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="CONTACT_APP")
public class ContactController {
@Autowired
	private ContactService contactService;
@ApiOperation("add contact details")
@PostMapping("/addContacts")	
public Contact createContact(@RequestBody Contact contact) throws ContactIsAlreadyExists {
	//Contact createContacts = contactService.createContacts(contact);
	List<Contact> displayAllContacts = contactService.displayAllContacts();
	
for(int i=0;i<displayAllContacts.size();i++) {
	Contact contacts = displayAllContacts.get(i);
long id = contacts.getId();
Optional<Contact> findByContactId = contactService.findByContactId(id);
System.out.println(findByContactId.get().getId()==contact.getId());
	if(findByContactId.get().getId()==contact.getId()) {
		throw new ContactIsAlreadyExists("contact already exists so you cannot add this id  contact again");
	}}
	return contactService.createContacts(contact);
}
@ApiOperation("find all contact details")
@GetMapping("/getAllContacts")
public ResponseEntity<List<Contact>> displayAllContacts() {
	// TODO Auto-generated method stub
	List<Contact> contactList = contactService.displayAllContacts();
	if(!contactList.isEmpty()) {
	return new ResponseEntity<List<Contact>>(contactList,HttpStatus.FOUND);}
	else {
		return new ResponseEntity<List<Contact>>(contactList,HttpStatus.NO_CONTENT);
	}
}
@ApiOperation("update contact details if contact_is is present")
@PutMapping("update/{id}")
public Contact updateContact(@RequestBody Contact contact,@PathVariable ("id") long id) throws ContactNotFoundException {
	 Optional<Contact> findByContactId = contactService.findByContactId(id);
	 if(!findByContactId.isPresent()) {
		 throw new ContactNotFoundException("contact is not present ,so you cannot update ");
		}
	return contactService.updateContact(contact,id);
}
@ApiOperation("Find contact by contact_id")
@GetMapping("/findById/{id}")
public Optional<Contact> findByConatctId(@PathVariable ("id") long id) throws ContactNotFoundException {
	 Optional<Contact> findByContactId = contactService.findByContactId(id);
	 if(!findByContactId.isPresent()) {
		 throw new ContactNotFoundException("contact is not present");
		}
	 return findByContactId;
	
}
@ApiOperation("Delete contact by contact_id")
@DeleteMapping("delete/{id}")
public String deleteContact(@PathVariable ("id") long id) throws ContactNotFoundException {
	Optional<Contact> findByContactId = contactService.findByContactId(id);
	if(findByContactId.isPresent()) {
	return  contactService.deleteContact(id);}
	else {
		throw new ContactNotFoundException("contact is not present");
	}
}
}
