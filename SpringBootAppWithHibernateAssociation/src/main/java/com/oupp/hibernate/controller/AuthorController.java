package com.oupp.hibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oupp.hibernate.model.Author;
import com.oupp.hibernate.service.AuthorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/authors")
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;
	
	@GetMapping
	public ResponseEntity<List<Author>> getAllAuthors(){
		List<Author> authors = authorService.getAllAuthors();	
		return ResponseEntity.ok(authors);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Author> getAuthorById(@PathVariable Long id){
		Author author = authorService.getAuthorById(id);	
		return ResponseEntity.ok(author);
	}
	
	@PostMapping
	public ResponseEntity<Author> createAuthor(@RequestBody Author author){
		Author createdAuthor = authorService.createAuthor(author);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdAuthor);
	}
	

}
