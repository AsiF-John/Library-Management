package com.starter.Book.Controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.starter.Book.Entity.Book;
import com.starter.Book.Entity.MyBookList;
import com.starter.Book.Service.BookService;
import com.starter.Book.Service.MyBookService;

@Controller
public class BookController {
	@Autowired
	private BookService service;
	
	@Autowired 
	private MyBookService mybookservice;
	
	@GetMapping("/")
	public String home() {
		return "home.html";
	}
	
	
	@GetMapping("/book_register")
	public String bookRegister() {
		return "bookRegister";
	}
	
	
	@GetMapping("/available_books")
	public ModelAndView getbook() {
		List<Book>list=service.getbook();
//		ModelAndView m = new ModelAndView();
//		m.setViewName("booklist");
//		m.addObject("book", list);
		return new ModelAndView("booklist","book",list);
	}
	
	
	@PostMapping("/save")
	public String Addbook(@ModelAttribute Book b) {
		service.save(b);
		return "redirect:/available_books";
	}
	
	@GetMapping("/my_books")
	public String getMyBooks(Model model) {
		List<MyBookList>list=mybookservice.getAllMyBooks();
		model.addAttribute("book",list);
		return "myBooks";
	}
	
	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id) {
		Book b =service.getBookById(id);
		MyBookList mb = new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
		mybookservice.SaveMyBooks(mb);
		return"redirect:/my_books";
	}
	
	@RequestMapping("/editBook/{id}")
	public String editBook(@PathVariable("id") int id,Model model) {
		Book b = service.getBookById(id);
		model.addAttribute("book",b);
		return"BookEdit";
	}
	@RequestMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable("id") int id) {
		service.deletebyId(id);
		return "redirect:/available_books";
		
	}

}
