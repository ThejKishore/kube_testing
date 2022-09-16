package com.test.project.demo.book;

import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public Iterable<Book> getAllBooks(){
        return this.bookRepository.findAll();
    }

    public Book save(Book book){
        return bookRepository.save(book);
    }
}