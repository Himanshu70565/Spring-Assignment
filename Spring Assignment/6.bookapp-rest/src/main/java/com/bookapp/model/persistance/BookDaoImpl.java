package com.bookapp.model.persistance;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import com.bookapp.web.entities.Book;
import com.bookapp.web.exceptions.BookNotFoundException;

@Repository
@Primary
public class BookDaoImpl implements BookDao{

	private EntityManager em;
	
	@Autowired
	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<Book> getAllBooks() {
		List<Book> resultList = em.createQuery("select book from Book book", Book.class).getResultList();
		return resultList;
	}

	@Override
	public Book addBook(Book book) {
		em.persist(book);
		return book;
	}

	@Override
	public Book deleteBook(int id) {
		Book bookToBeDeleted = getBookById(id);
		em.remove(bookToBeDeleted);
		return bookToBeDeleted;
	}

	@Override
	public Book updateBook(int id, Book book) {
		Book bookToBeUpdated = getBookById(id);
		bookToBeUpdated.setPrice(book.getPrice());
		em.merge(bookToBeUpdated);
		return bookToBeUpdated;
	}

	@Override
	public Book getBookById(int id) {
	     Book book = em.find(Book.class, id);		
	     if(book==null) {
	    	 throw new BookNotFoundException("book with id  : "+id+" is not found");
	     }
	     return book;
	}

}
