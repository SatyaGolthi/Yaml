package com.example.demo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Inputs;
import com.example.demo.service.DemoService;
import com.example.demo.service.YAMLUtil;
import com.example.xml.Book;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;




@RestController
public class DemoController {
	
	@Autowired(required=false)
	private DemoService demoservice;
	
	@Autowired(required=false)
	private YAMLUtil yaml;
	

	
	@RequestMapping(value = "/inputs", method = RequestMethod.POST)
	public Inputs addInputs(@RequestBody Inputs input){
		
           return demoservice.addInputs(input);
	}
	
	@RequestMapping(value = "/input2", method = RequestMethod.POST)
	public Book printYAML(@RequestBody Inputs input,Book obj) throws JsonGenerationException, JsonMappingException, IOException{
		
           return yaml.printYAML(obj);
	}
	}


