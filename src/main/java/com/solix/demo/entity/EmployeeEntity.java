package com.solix.demo.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Employee")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeEntity {
    @Id
	private int empid;
	private String name;
	private double salary;
	private Date hireDate;
	private int age;
	private String City;
	

}
