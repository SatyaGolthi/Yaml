package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Inputs;
import com.example.demo.service.DemoService;




@RestController
public class DemoController {
	
	@Autowired(required=false)
	private DemoService demoservice;
	
	
	@RequestMapping(value = "/userdetails", method = RequestMethod.GET)
	public String getDetails(@RequestBody Inputs input) throws Exception {
		return demoservice.getDetails(input);
	}
	
	
	}

