package com.bookapp.model.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookapp.model.persistance.BookDao;
import com.bookapp.web.entities.Book;

@Service(value = "bookService")
@Transactional
public class BookServiceImpl implements BookService {

	private BookDao bookDao;
	
	@Autowired
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	public List<Book> getAllBooks() {
		return bookDao.getAllBooks();
	}

	public Book addBook(Book book) {
		return bookDao.addBook(book);
	}

	@Loggable
	public Book deleteBook(int id) {
		return bookDao.deleteBook(id);
	}	
	
	public Book updateBook(int id, Book book) {
		return bookDao.updateBook(id, book);
	}

	public Book getBookById(int id) {
		return bookDao.getBookById(id);
	}

}
