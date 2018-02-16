package com.rahul.service;

import java.util.List;

import javax.jws.WebService;

import com.rahul.model.Employee;

@WebService
public interface EmployeeService {
	int insert(Employee employee);
	boolean delete(int id);
	List<Employee> getAllEmployees();
	Employee findByName(String name);
}
