package com.test.project.demo.book;

import lombok.val;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookResource {

    private final BookService bookService;

    public BookResource(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> books(){
        List<Book> books = new ArrayList<>();
        this.bookService.getAllBooks().forEach(books::add);
        return books;
    }

    @PostMapping(value = "/save" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> save(@RequestBody  Book book){
        val saveBook = this.bookService.save(book);
        return ResponseEntity.ok(saveBook);
    }
}