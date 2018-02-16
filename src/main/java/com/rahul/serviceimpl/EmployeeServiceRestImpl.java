package com.rahul.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.rahul.model.Employee;
import com.rahul.service.EmployeeService;

@Path("/employee/")
public class EmployeeServiceRestImpl implements EmployeeService {
	
	private static List<Employee> list = new ArrayList<Employee>();
	static int counter = 0;
	
	@Override
	public int insert(Employee employee) {
		System.out.println("inside insert");
		if(employee.getId()==0){
			employee.setId(++counter);
			list.add(employee);
		}		
		return employee.getId();
	}

	@Override
	public boolean delete(int id) {
		System.out.println("inside delete");
		if(id!=0){
			Employee emp = new Employee();
			emp.setId(id);
			return list.remove(emp);
		}
		return false;
	}

	@Override
	@GET
	@Produces("application/json")
	@Path("/")
	public List<Employee> getAllEmployees() {
		System.out.println("inside getAllEmployees");
		if(list.isEmpty()){
			Employee emp = new Employee();
			emp.setId(-1);
			emp.setName("Dummy");
			emp.setEmail("abc@abc.com");
			List<Employee> list1 = new ArrayList<Employee>();
			list1.add(emp);
			return list1;
		}
		return list;
	}

	@Override
	public Employee findByName(String name) {
		System.out.println("inside findByName");
		for(Employee employee : list){
			if(employee.getName().equalsIgnoreCase(name)){
				return employee;
			}
		}
		return null;
	}

}
