package com.example.demo.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Set;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Inputs;

@Service
public class DemoService {

	public String getDetails(Inputs input) throws IOException {

		FileWriter filewriter=new FileWriter("example.yml");
		BufferedWriter bufferwriter= new BufferedWriter(filewriter);

		bufferwriter.write("version:"+ input.getVersion());
		bufferwriter.newLine();
		bufferwriter.write("host:"+ input.getHost());
		bufferwriter.newLine();
		bufferwriter.write("basepath:"+ input.getBasepath());
		bufferwriter.newLine();
		bufferwriter.write("title:"+ input.getTitle());
		bufferwriter.newLine();
		bufferwriter.write("path:"+ input.getPath());
		bufferwriter.newLine();
		bufferwriter.newLine();

		Set<Class<? extends Object>> object = getPojo();

		for(Class<? extends Object> cls : object) {
			bufferwriter.write("class:"+ cls.getName().split(cls.getPackage().toString().split(" ")[1]+".")[1]);
			bufferwriter.newLine();
			bufferwriter.write("\t \t \t Parameters:");
			bufferwriter.newLine();
			for(Field field:cls.getDeclaredFields()) {
				bufferwriter.write("\t \t \t \t name:"+ field.getName());
				bufferwriter.newLine();
				bufferwriter.write("\t \t \t \t type:"+ field.getType().getSimpleName());
				bufferwriter.newLine();
				bufferwriter.newLine();
			} 
			bufferwriter.write("paths:");
			bufferwriter.newLine();
			bufferwriter.write(cls.getName().split(cls.getPackage().toString().split(" ")[1]+".")[1]+":");
			bufferwriter.newLine();
			bufferwriter.write("\t \t \t post:");
			bufferwriter.newLine();
			bufferwriter.write("paths:");
			bufferwriter.newLine();
			bufferwriter.write( "summary: Add a new"+ cls.getName().split(cls.getPackage().toString().split(" ")[1]+".")[1] +" to the store");
			bufferwriter.newLine();
			bufferwriter.write("operationId: "+"add"+cls.getName().split(cls.getPackage().toString().split(" ")[1]+".")[1]);
			bufferwriter.newLine();
			bufferwriter.write("produces:\r\n" + "  - application/json");
			bufferwriter.newLine();
			bufferwriter.write("description: ");
			bufferwriter.newLine();
			bufferwriter.newLine();
			
			
		}

		bufferwriter.close();
		return "Details added Successfully";
	}
	
	

	public Set<Class<? extends Object>> getPojo() {
		Reflections reflections = new Reflections("com.example.xml",new SubTypesScanner(false));
		return reflections.getSubTypesOf(Object.class);
	}

}
