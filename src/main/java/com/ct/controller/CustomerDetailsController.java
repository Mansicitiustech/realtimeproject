package com.ct.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.ct.serviceImpl.CustomerDetailsServiceImpl;

@RestController
public class CustomerDetailsController {
	@Autowired
private CustomerDetailsServiceImpl customService;
}
