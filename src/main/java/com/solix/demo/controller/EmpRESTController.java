package com.solix.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.solix.demo.entity.EmployeeEntity;
import com.solix.demo.repository.EmpRepository;

@RestController
public class EmpRESTController {
    
	@Autowired
	EmpRepository repo;
	
	@GetMapping("/employees")
	
	public List<EmployeeEntity> getAllEmployees(){
		List<EmployeeEntity> emp =repo.findAll();
		return emp;
	}
	
	@PostMapping("/employee/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<String> addEmployee(@RequestBody EmployeeEntity emp) {
		repo.save(emp);
		return ResponseEntity.ok("Employee created");
	}
	
	@DeleteMapping("/employee/delete/{id}")
	public ResponseEntity<String> removeEmployee(@PathVariable int id) {
	    Optional<EmployeeEntity> optionalEmp = repo.findById(id);
	    if (optionalEmp.isPresent()) {
	        repo.delete(optionalEmp.get());
	        return ResponseEntity.ok("Employee deleted");
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not exist");
	    }
	}
	
}
