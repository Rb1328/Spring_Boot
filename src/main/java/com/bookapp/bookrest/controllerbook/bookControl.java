package com.bookapp.bookrest.controllerbook;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

import com.bookapp.bookrest.entities.Book;
import com.bookapp.bookrest.services.BookService;


@RestController
public class bookControl {
  
   

        @Autowired
        private BookService bookService;

        @GetMapping("/books")
        public ResponseEntity <List<Book>>  getBooks() {
            List<Book> list= this.bookService.getAllBooks();
            if(list.size()<=0){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            return ResponseEntity.status(HttpStatus.CREATED).body(list);
        }
        @GetMapping("/books/{id}")

        public ResponseEntity<Book> getBookByID( @PathVariable("id") int id) {
            Book book =  this.bookService.getBookByID(id);
            System.out.println(id);

            if(book == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            return ResponseEntity.status(HttpStatus.CREATED).body(book);
        }

        @PostMapping("/books")

        public ResponseEntity<Book> addBook(@RequestBody Book book){
           
            Book b2=null;
            try{
                 b2 =this.bookService.addBook(book);
                 System.out.println(book);
                 return ResponseEntity.status(HttpStatus.CREATED).build();
            }
            catch(Exception e){
                e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
           
           
        }
       @DeleteMapping("/books/{bookId}")

       public ResponseEntity<Void> deleteBook(@PathVariable("bookId") int bookId){
           
        try{
            this.bookService.deleteBook(bookId);
             return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        catch(Exception e){
            e.printStackTrace();
        return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
                }


                @PutMapping("/books/{bookId}")
                public Book updateBook(@RequestBody Book book,@PathVariable("bookId")int bookId){

                    
                    this.bookService.updateBook(book,bookId);
                    return book;




                }



    // @RequestMapping(value="/book" , method=RequestMethod.GET)
    // @ResponseBody
        // Book book=new Book();
        // book.setId(1);
        // book.setTitle("java");
        // book.setAuthor("rb");
        //     return book;
        // 
}
