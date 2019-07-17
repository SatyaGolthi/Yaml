package com.example.demo.entity;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.xml.Book;

public class Example {
	@Autowired
 private Inputs input;
	@Autowired
 private  Book book;
 
public Inputs getInput() {
	return input;
}
public void setInput(Inputs input) {
	this.input = input;
}
public Book getBook() {
	return book;
}
public void setBook(Book book) {
	this.book = book;
}
@Override
public String toString() {
	return "Example [input=" + input + ", book=" + book + "]";
}
 
 
}