package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.Yaml;

import com.example.demo.entity.Inputs;
import com.example.demo.repositry.DemoRepositry;
@Service
public class DemoService {
@Autowired
private DemoRepositry demorepo;
       
Yaml yaml = new Yaml();

	public Inputs addInputs(Inputs input) {
		
		return demorepo.save(input);
	}

	
}
