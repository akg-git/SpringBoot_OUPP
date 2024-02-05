package com.oupp.hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oupp.hibernate.model.Book;
import com.oupp.hibernate.repository.BookRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	//READ: get all book details
	public List<Book> getAllBooks(){
		return bookRepository.findAll();
	}
	
	public Book getBookById(Long id) {
		return bookRepository.findById(id)
				.orElseThrow( ()-> new EntityNotFoundException("Book with id: "+id+" not found."));
	}
	
//	CREATE: create an author and save in DB
	public Book createBook(Book book) {
		return bookRepository.save(book);
	}

}
