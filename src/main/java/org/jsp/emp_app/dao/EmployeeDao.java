package org.jsp.emp_app.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.emp_app.entity.Employee;
import org.jsp.emp_app.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDao {
	@Autowired
	private EmployeeRepository repository;

	public Employee saveEmp(Employee emp) 
	{
		return repository.save(emp);
	}

	public List<Employee> findAllEmployee() 
	{
		return repository.findAll();
	}
	
	public List<Employee> findAllActiveEmployee() 
	{
		return repository.findAllActiveEmployee();
	}
	
	public Optional<Employee> findEmpById(int id)
	{
		return repository.findById(id);
	}

	public void deleteEmpById(int id) 
	{
		repository.deleteById(id);
	}

	public Optional<Employee> findEmpByEmailAndPassword(String email, String password) 
	{	
		return repository.findEmpByEmailAndPassword(email,password);
	}

	public Employee updateEmp(Employee emp) 
	{
		return repository.save(emp);
	}

	public List<Employee> findEmpByName(String name) 
	{
		return repository.findEmpByName(name);
	}
}
