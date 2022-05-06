package com.example.crud.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.Entity.Employee;
import com.example.crud.Repository.EmployeeRepository;

@Service
public class EmployeeService {
	 
	@Autowired
	private  EmployeeRepository repository;
	
	public Employee saveEmployee(Employee employee) {
		return repository.save(employee);
		
	}
	public List<Employee> saveEmployees(List<Employee> employees) {
		return repository.saveAll(employees);
		
	}
	public List<Employee> getEmployees() {
		return repository.findAll();
		
	}
	
	public Employee getEmployeeById(int id) {
		return repository.findById(id).orElse(null);
		
	}
	public Employee getEmployeeByName(String name) {
		return repository.findByName(name).orElse(null);
		
	}
public String deleteEmployee(int id) {
	repository.deleteById(id);
	return "Employee removed || "+id;
	
}

public Employee updateEmployee(Employee employee) {
	Employee existingEmployee=repository.findById(employee.getId()).orElse(null);
	existingEmployee.setName(employee.getName());
	existingEmployee.setAge(employee.getAge());
	existingEmployee.setSalaryl(employee.getSalaryl());
	return repository.save(existingEmployee);


}

}
