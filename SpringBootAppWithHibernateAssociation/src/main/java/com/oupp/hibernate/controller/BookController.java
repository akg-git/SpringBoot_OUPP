package com.oupp.hibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oupp.hibernate.model.Book;
import com.oupp.hibernate.service.BookService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/books")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping
	public ResponseEntity<List<Book>> getAllBooks(){
		List<Book> books = bookService.getAllBooks();
		return ResponseEntity.ok(books);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable Long id){
		Book book = bookService.getBookById(id);
		return ResponseEntity.ok(book);
	}
	
	@PostMapping
	public ResponseEntity<Book> createBook(@RequestBody Book book){
		Book createdBook = bookService.createBook(book);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
	}
	

}
