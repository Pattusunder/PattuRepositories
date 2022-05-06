package com.example.crud.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crud.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

	Optional<Employee> findByName(String name);
	

}
