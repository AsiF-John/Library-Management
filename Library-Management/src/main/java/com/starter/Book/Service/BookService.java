package com.starter.Book.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starter.Book.Entity.Book;
import com.starter.Book.Repository.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bRepo;
	public void save(Book b) {
		bRepo.save(b);
	}
	public List<Book> getbook(){
		return bRepo.findAll();
	}
	public Book getBookById(int id) {
		return bRepo.findById(id).get();
	}
	public void deletebyId(int id) {
		bRepo.deleteById(id);
	}

}
