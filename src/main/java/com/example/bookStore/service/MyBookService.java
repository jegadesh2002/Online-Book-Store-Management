package com.example.bookStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookStore.entity.MyBookList;
import com.example.bookStore.repository.MybookRepository;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class MyBookService {
	
	@Autowired
	private MybookRepository myRepo;
	
	public void saveMyBook(MyBookList mb) {
		myRepo.save(mb);
	}
	
	public List<MyBookList> getAllMyBooks(){
		return myRepo.findAll();
	}
	
	
	public MyBookList getBookById(long id) {
		return myRepo.findById(id).get();
	}
	
	public void deleteById(long id) {
		myRepo.deleteById(id);
	}
}
