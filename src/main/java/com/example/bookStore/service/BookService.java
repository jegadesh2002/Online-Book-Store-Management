package com.example.bookStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.bookStore.entity.Book;
import com.example.bookStore.repository.BookRepository;

@Service
@Transactional
public class BookService {
	@Autowired
	private BookRepository repo;
	
	public void save(Book book) {
		repo.save(book);
	}
	
	public List<Book> getAllBooks(){
		return repo.findAll();
	}
	
	public Book getBookbyId(long id)
	{
		return repo.findById(id).get();
	}

	public void deleteBookbyId(long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		
	}
}
