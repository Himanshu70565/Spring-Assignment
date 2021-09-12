package com.bookapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.bookapp.model.service.BookService;
import com.bookapp.web.entities.Book;

@SpringBootApplication
//@EnableAspectJAutoProxy
public class Application implements CommandLineRunner {

	

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Book book1 = new Book("AAA", "Life Part1", "Himanshu", 120);
		Book book2 = new Book("BBB", "Life Part2", "Priyanka", 130);
		Book book3 = new Book("CCC", "Life Part3", "Pallavi", 140);

//		bookService.addBook(book1);
//		bookService.addBook(book2);
//		bookService.addBook(book3);		
	}

}
