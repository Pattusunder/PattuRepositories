package com.example.springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.model.Employee;
import com.example.springboot.repository.EmployeeRepository;
import com.example.springboot.sevice.EmployeeService;

@Service

public class EmployeeServiceImpl implements EmployeeService {
	

	private EmployeeRepository employeeRepository;
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}
	public Employee saveEmployee(Employee  employee) {
		return employeeRepository.save(employee);

}
	
}
