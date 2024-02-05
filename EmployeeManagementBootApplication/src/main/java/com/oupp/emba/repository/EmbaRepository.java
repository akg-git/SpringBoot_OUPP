package com.oupp.emba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oupp.emba.entity.EmployeeEntity;

public interface EmbaRepository extends JpaRepository<EmployeeEntity, Integer>{

}
