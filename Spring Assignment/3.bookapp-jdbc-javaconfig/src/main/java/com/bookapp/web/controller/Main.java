package com.bookapp.web.controller;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bookapp.model.config.AppConfig;
import com.bookapp.model.service.BookService;
import com.bookapp.web.entities.Book;

public class Main{
	public static void main(String[] args) {		
		
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		BookService bookService = ctx.getBean("bookService",BookService.class);
		List<Book> allBooks = bookService.getAllBooks();
		allBooks.forEach(b->System.out.println(b));
		
		bookService.deleteBook(2);
		allBooks = bookService.getAllBooks();
		allBooks.forEach(b->System.out.println(b));
		ctx.close();
	}
}

