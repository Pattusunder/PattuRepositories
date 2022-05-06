package com.example.crud.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.Entity.Employee;
import com.example.crud.Service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@PostMapping("/addEmployee")
	public Employee addEmployee(@RequestBody Employee employee) {
		return service.saveEmployee(employee);
	}
	
    @PostMapping("/addEmployees")
	public List<Employee> addEmployees(@RequestBody List<Employee> employees) {
		return service.saveEmployees(employees);
	}
    @GetMapping("/employees")
    public List<Employee> findAllEmployees() {
		return service.getEmployees();
	}
    @GetMapping("/employee/{id}")
    public Employee findEmployeeById(@PathVariable int id) {
    	return service.getEmployeeById(id);
    }
    @GetMapping("/employee/{name}")
    public Employee findEmployeeByName(@PathVariable String name) {
    	return service.getEmployeeByName(name);
    }
    @PutMapping("/update")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return service.saveEmployee(employee);
	}
    @DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable int id) {
		return service.deleteEmployee(id);
	}
    
    
	

}
