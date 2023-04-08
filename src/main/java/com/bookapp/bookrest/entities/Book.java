package com.bookapp.bookrest.entities;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    private String title;

    @OneToOne( cascade= {CascadeType.ALL})

    private Author author;
     
    public int getId() {
        return Id;
    }
    
    public String getTitle() {
    	
        return title;
    }
    
    public Author getAuthor() {
        return author;
    }
    
    public void setId(int id) {
        Id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(Author author) {
        this.author = author;
    }
    public Book(int id, String title, Author author) {
        Id = id;
        this.title = title;
        this.author = author;
    }
    public Book() {
    }
    @Override
    public String toString() {
        return "Book [Id=" + Id + ", title=" + title + ", author=" + author + "]";
    }
    
    
}
