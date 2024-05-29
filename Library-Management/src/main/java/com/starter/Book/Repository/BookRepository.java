package com.starter.Book.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.starter.Book.Entity.Book;
@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

}
