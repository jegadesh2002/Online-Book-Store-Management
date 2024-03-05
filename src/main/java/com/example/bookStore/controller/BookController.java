package com.example.bookStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.bookStore.entity.Book;
import com.example.bookStore.entity.MyBookList;
import com.example.bookStore.service.BookService;
import com.example.bookStore.service.MyBookService;

@Controller
public class BookController {
	@Autowired
	private BookService service;
	@Autowired
	private MyBookService mybookService;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	@GetMapping("availableBooks")
	public ModelAndView availableBooks() {
		List<Book> listBook=service.getAllBooks();	
		return new ModelAndView("availableBooks","listbook",listBook); 
		//or
//		ModelAndView mav=new ModelAndView();
//		mav.setViewName("availableBooks");
//		mav.addObject(null, mav);
//		return mav;
		
	}
	@GetMapping("newBook")
	public String addBooks() {
		return "newBook";
	}
	
	@PostMapping("/save")
	public String addBook(@ModelAttribute Book book) {
		service.save(book);
		return "redirect:/availableBooks";
	}
	
	@GetMapping("/myBook")
	public String myBooks(Model model)
	{
		List<MyBookList>list=mybookService.getAllMyBooks();
		model.addAttribute("book",list);
		return "myBooks";
	}	
	
	@RequestMapping("/myBook/{id}")
	public String getMybook(@PathVariable("id") long id) {
		Book b=service.getBookbyId(id);
		MyBookList mb=new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
		mybookService.saveMyBook(mb);
		return "redirect:/myBook";
	}
	
	@RequestMapping("/editBook/{id}")
	public String editBook(@PathVariable("id") long id,Model model)
	{
		Book b=service.getBookbyId(id);
		model.addAttribute("book",b);
		return "editBook";
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") long id)
	{
		service.deleteBookbyId(id);
		return"redirect:/availableBooks";
	}
}
