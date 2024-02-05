package com.oupp.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oupp.hibernate.model.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
