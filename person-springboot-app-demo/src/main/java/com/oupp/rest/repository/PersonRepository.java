package com.oupp.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.oupp.rest.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

	List<Person> findByNameContainingIgnoreCase(String name);

	List<Person> findByNameContainingIgnoreCaseAndAge(String name, int age);

	// JPQL query to find persons by age between a specified range
	@Query("SELECT p FROM Person p WHERE p.age BETWEEN :minAge AND :maxAge")
	List<Person> findPersonsAgeBetween(@Param("minAge") int minAge, @Param("maxAge") int maxAge);

}
