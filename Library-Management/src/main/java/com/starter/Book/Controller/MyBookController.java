package com.starter.Book.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.starter.Book.Service.MyBookService;

@Controller
public class MyBookController {
	@Autowired
	private MyBookService service;
	
	@RequestMapping("/deleteMyList/{id}")
	public String deleteMyList(@PathVariable("id") int id) {
		service.DeleteById(id);
		return"redirect:/my_books";
	}

}
