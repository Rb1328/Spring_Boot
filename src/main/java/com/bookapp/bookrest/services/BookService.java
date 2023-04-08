package com.bookapp.bookrest.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bookapp.bookrest.Dao.BookRepository;
import com.bookapp.bookrest.entities.Book;

@Component
public class BookService {
   
    private static List<Book> list=new ArrayList<>();

    @Autowired
    private BookRepository bookRepository;
    // static{
    //     list.add(new Book(2,"Spring","rahul"));
    //     list.add(new Book(3,"cpp","wabale"));
    //     list.add(new Book(4,"Boot","bhavar"));
    //     list.add(new Book(5,"oracle","ram"));
    // }
    
    // Get All Books
    public List<Book> getAllBooks(){
      List<Book> list=  (List) this.bookRepository.findAll();
    
      return list;


    }

    public Book getBookByID(int Id){
         Book book =null;
        try{
            // book =list.stream().filter(e->e.getId()==Id).findFirst().get();
           book= (Book) this.bookRepository.findById(Id);

        }
        catch(Exception e){
            e.printStackTrace();
        }
        return book;

    }
    public Book addBook(Book b){
        // list.add(b);
        Book result= (Book) this.bookRepository.save(b);
        System.out.println("service");
        
        return b;

    }

    public void deleteBook(int bid){

        this.bookRepository.deleteById(bid);
    //   list=list.stream().filter(book->book.getId()!=bid).collect(Collectors.toList());


    // list=list.stream().filter(
    //     book->{
    //         if(book.getId()!=bid){
    //             return true;
    //         }
    //         else{
    //             return false;

    //         }
    //     }).collect(Collectors.toList());

    }


    public void updateBook(Book book,int bookId){
    //     list=list.stream().map(b->
    //     {
    //         if(b.getId()==bookId){
    //             b.setId(book.getId());
    //             b.setAuthor(book.getAuthor());
    //             b.setTitle(book.getTitle());
    //         }
    //         return b;
    //     }).collect(Collectors.toList());

    book.setId(bookId);
    bookRepository.save(book);
     }


    
}
