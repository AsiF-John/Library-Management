package com.starter.Book.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starter.Book.Entity.MyBookList;
import com.starter.Book.Repository.MyBookRepository;

@Service
public class MyBookService {
	@Autowired
	private MyBookRepository mybook;
	
	public void SaveMyBooks(MyBookList book) {
		mybook.save(book);
		
	}
	public List<MyBookList> getAllMyBooks(){
		return mybook.findAll();
	}
	public void DeleteById(int id) {
		mybook.deleteById(id);
	}

}
