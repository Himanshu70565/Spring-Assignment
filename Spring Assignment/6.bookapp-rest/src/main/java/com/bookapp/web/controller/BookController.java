package com.bookapp.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.model.service.BookService;
import com.bookapp.web.entities.Book;

@RestController
public class BookController {
	
	private BookService bookService;

	@Autowired
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	
	@GetMapping("/book")
	public List<Book> getAllBooks(){
		List<Book> allBooks = bookService.getAllBooks();
		return allBooks;
	}
	
	@GetMapping("/book/{id}")
	public Book getBookById(@PathVariable(name="id")int id) {
		return bookService.getBookById(id);
	}
	
	@PostMapping("/book")
	public Book addBook(@RequestBody Book book) {
		return bookService.addBook(book);
	}
	
	@DeleteMapping("book/{id}")
	public Book deleteBookById(@PathVariable (name="id") int id) {
		return bookService.deleteBook(id);
	}
	
	@PutMapping("book/{id}")
	public Book updateBookById(@PathVariable (name="id")int id,@RequestBody Book book) {
		return bookService.updateBook(id, book);
	}
}
