package com.Emp_crud_react.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Emp_crud_react.Model.Employee;
import com.Emp_crud_react.Repository.EmployeeRepository;

@Service
public class EmployeeService {
	 @Autowired
	    private EmployeeRepository repository;

	    // CREATE
	    public Employee saveEmployee(Employee employee) {
	        return repository.save(employee);
	    }

	    // READ
	    public List<Employee> getAllEmployees() {
	        return repository.findAll();
	    }

	    // READ BY ID
	    public Employee getEmployeeById(Long id) {
	        return repository.findById(id).orElse(null);
	    }

	    // UPDATE
	    public Employee updateEmployee(Long id, Employee employee) {

	        Employee existingEmployee = repository.findById(id).orElse(null);

	        if(existingEmployee != null) {

	            existingEmployee.setName(employee.getName());
	            existingEmployee.setEmail(employee.getEmail());
	            existingEmployee.setOrganization(employee.getOrganization());
	            existingEmployee.setSalary(employee.getSalary());

	            return repository.save(existingEmployee);
	        }

	        return null;
	    }

	    // DELETE
	    public String deleteEmployee(Long id) {

	        repository.deleteById(id);

	        return "Employee Deleted Successfully";
	    }
}
