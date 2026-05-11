package com.Emp_crud_react.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Emp_crud_react.Model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
