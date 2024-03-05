package com.example.bookStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.bookStore.entity.MyBookList;
import com.example.bookStore.service.MyBookService;

@Controller
public class MyBookController {
	@Autowired
	private MyBookService mybookservice;
	@RequestMapping("/deleteMyList/{id}")
	public String deleteMyList(@PathVariable("id") long id) {
		
		
		mybookservice.deleteById(id);
		return "redirect:/myBook";
		
	}

}
