package com.bookapp.web.controller;

import java.util.List;

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
	public ResponseEntity<List<Book>> getAllBooks() {
		List<Book> allBooks = bookService.getAllBooks();
		return ResponseEntity.status(200).body(allBooks);
	}

	@PostMapping("/book")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		bookService.addBook(book);
		return ResponseEntity.status(201).body(book);
	}

	@GetMapping("/book/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable(name = "id") int id) {
		return ResponseEntity.status(200).body(bookService.getBookById(id));
	}

	@DeleteMapping("book/{id}")
	public ResponseEntity<String> deleteBookById(@PathVariable(name = "id") int id) {
		bookService.deleteBook(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("book deleted with id ; "+id);
	}

	@PutMapping("book/{id}")
	public ResponseEntity<Book> updateBookById(@PathVariable(name = "id") int id, @RequestBody Book book) {
		Book updateBook = bookService.updateBook(id, book);
		System.out.println(updateBook);
		return ResponseEntity.status(HttpStatus.OK).body(updateBook);
	}
}
