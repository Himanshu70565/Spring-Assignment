package com.bookapp.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bookapp.model.service.BookService;
import com.bookapp.web.entities.Book;

@Controller
public class BookController {
	
	private BookService bookService;

	@Autowired
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	
	
//	------Get all books----------
	@GetMapping("/books")
	public String getAllBooks(Model model) {
		List<Book> allBooks = bookService.getAllBooks();
		model.addAttribute("books", allBooks);
		return "showAllBooks";
	}

	
//	------Add a new book-----------
	@GetMapping("addBook")
	public String addBookGet(Model model) {
		model.addAttribute("book", new Book());
		return "addBook";
	}
	
	
	@PostMapping("addBook")
	public String addBookPost(@ModelAttribute Book book,Model model) {
		if(book.getId()==0) {
			bookService.addBook(book);
		}else {
			System.out.println(book);
			Book bookById = bookService.getBookById(book.getId());
			System.out.println("-------------");
			System.out.println(bookById);
			System.out.println("---------------------------------");
			System.out.println(book);
			bookService.updateBook(book.getId(), book);
		}
		return "redirect:books";
	}
	
	
//	------Delete a book by Id-------
	@GetMapping("deleteBook")
	public String deleteBookById(@RequestParam(name="id") int id) {
		bookService.deleteBook(id);
		return "redirect:/books";
	}
	
	
//	------Update a book by Id-------
	@GetMapping("updateBook")
	public String updateBookById(@RequestParam (name="id")int id,Model model) {
		Book bookToBeUpdated = bookService.getBookById(id);
		model.addAttribute("book", bookToBeUpdated);
		return "updateBook";
	}

}
