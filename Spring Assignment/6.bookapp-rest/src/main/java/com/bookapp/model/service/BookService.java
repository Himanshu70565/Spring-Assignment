package com.bookapp.model.service;

import java.util.List;

import com.bookapp.web.entities.Book;

public interface BookService {
	public List<Book> getAllBooks();
	public Book addBook(Book book);
	public Book deleteBook(int id);
	public Book updateBook(int id, Book book);
	public Book getBookById(int id);
}
