package com.test.project.demo;

import com.test.project.demo.book.Book;
import com.test.project.demo.book.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    @Bean
    public CommandLineRunner bookInstall(BookRepository bookRepository){
        return args -> {
            bookRepository.save(new Book("Java 8 ","Venkat Subramaniam",25.45));
            bookRepository.save(new Book("Groovy ","Venkat Subramaniam",26.45));
            bookRepository.save(new Book("Spring Boot ","Josh Long",20.45));
            bookRepository.save(new Book("Head First Java","David Amalraj",35.45));
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
