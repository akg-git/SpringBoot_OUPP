package com.oupp.hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oupp.hibernate.model.Author;
import com.oupp.hibernate.repository.AuthorRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AuthorService {
	
	@Autowired
	private AuthorRepository authorRepository;
	
	//READ: get all user details
	public List<Author> getAllAuthors(){
		return authorRepository.findAll();
	}
	
	public Author getAuthorById(Long id) {
		return authorRepository.findById(id)
				.orElseThrow( ()-> new EntityNotFoundException("Author with id: "+id+" not found."));
	}
	
//	CREATE: create an author and save in DB
	public Author createAuthor(Author author) {
		return authorRepository.save(author);
	}


}
