package com.solix.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solix.demo.entity.EmployeeEntity;

public interface EmpRepository extends JpaRepository<EmployeeEntity, Integer>{

}
