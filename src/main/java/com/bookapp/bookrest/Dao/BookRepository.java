package com.bookapp.bookrest.Dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bookapp.bookrest.entities.Book;

public interface BookRepository extends CrudRepository<Book,Integer> {
    public Book findById(int id);
  
    
}
