package com.oupp.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oupp.hibernate.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>{

}
