package org.jsp.emp_app.service;

import java.util.List;
import java.util.Optional;

import org.jsp.emp_app.dao.EmployeeDao;
import org.jsp.emp_app.entity.Employee;
import org.jsp.emp_app.exceptionClasses.InvalidCredentials;
import org.jsp.emp_app.exceptionClasses.InvalidEmployeeIdException;
import org.jsp.emp_app.exceptionClasses.NoActiveEmployeeFoundException;
import org.jsp.emp_app.exceptionClasses.NoEmployeeFoundException;
import org.jsp.emp_app.responseStructure.ResponseStructure;
import org.jsp.emp_app.util.EmployeeStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class EmployeeService
{
	@Autowired
	private EmployeeDao dao;

	public ResponseEntity<?> saveEmp(Employee emp) 
	{
		emp.setStatus(EmployeeStatus.IN_ACTIVE);
//		emp = dao.saveEmp(emp);
		
		
//		ResponseStructure<Employee> structure = new ResponseStructure<>();
//		structure.setStatus(HttpStatus.CREATED.value());  // HttpStatus is an enum
//		structure.setMessage("employee created successfully");
//		structure.setBody(emp);
		
//      Builder method will allow us to create object without new keyword
		
		return ResponseEntity.status(HttpStatus.CREATED).body( ResponseStructure.builder().status(HttpStatus.CREATED.value()).message("Employee saved Sucessfully....").body(dao.saveEmp(emp)).build()) ;
		
	}
	
	public ResponseEntity<?> updateEmp(Employee emp) 
	{
//		Employee e = dao.updateEmp(emp);
//		
//		ResponseStructure<Employee> structure = new ResponseStructure<>();
//		structure.setStatus(HttpStatus.OK.value());  // HttpStatus is an enum
//		structure.setMessage("employee updated successfully");
//		structure.setBody(e);
		
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("employee updated successfully").body(dao.updateEmp(emp)).build());
	}
	
	public ResponseEntity<?> findEmpById(int id)
	{
		Optional<Employee> optional = dao.findEmpById(id);
//		ResponseEntity<?> structure = new ResponseStructure<>();
		if(optional.isEmpty())
		{
			throw InvalidEmployeeIdException.builder().message("Invalid employee id").build();
			
			// all argument constructor should be after the @builder annotation  
		}
//		Employee emp = optional.get();
//		structure.setStatus(HttpStatus.OK.value());  // HttpStatus is an enum
//		structure.setMessage("Employee found successfully");
//		structure.setBody(emp);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Employee found successfully").body(optional.get()).build());
		
	}

	public ResponseEntity<?> findAllEmployee() 
	{
		List<Employee> emp = dao.findAllActiveEmployee();
		ResponseStructure<List<Employee>> structure = new ResponseStructure<>();
		if(emp.isEmpty())
		{
			throw new NoActiveEmployeeFoundException("No Active Employee Found, Invalid Id...");
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Employees found successfully").body(emp).build());
	}

	public ResponseEntity<?> deleteEmpById(int id) 
	{
		Optional<Employee> optional = dao.findEmpById(id);
		ResponseStructure<String> structure = new ResponseStructure<>();
		if(optional.isEmpty())
		{
			throw new InvalidEmployeeIdException("Invalid id, Unable to delete...");
		}
		dao.deleteEmpById(id);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Employees deleted successfully").body("Employee Deleted").build());
	}

	public ResponseEntity<?> findEmpByEmailAndPassword(String email, String password) 
	{
		Optional<Employee> optional = dao.findEmpByEmailAndPassword(email,password);
//		ResponseStructure<Employee> structure = new ResponseStructure<>();
		if(optional.isEmpty())
		{
			throw new InvalidCredentials("Invalid email and password");
		}
//		Employee emp = optional.get();
//		structure.setStatus(HttpStatus.OK.value());
//		structure.setMessage("Verification successfull");
//		structure.setBody(emp);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Verification successfull").body(optional.get()).build());
	}
	
	public ResponseEntity<?> findEmpByName(String name)
	{
		List<Employee> emp = dao.findEmpByName(name);
//		ResponseStructure<List<Employee>> structure = new ResponseStructure<>();
		if(emp.isEmpty())
		{
			throw new NoEmployeeFoundException("No Matching Employee found, for respective Name");
		}
//			structure.setStatus(HttpStatus.OK.value());
//			structure.setMessage("Employee Found");
//			structure.setBody(emp);
			return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Employee Found").body(emp).build());
		
	}

	public ResponseEntity<?> setEmployeeStatusToActive(int id) 
	{
		Optional<Employee> optional = dao.findEmpById(id);
		ResponseStructure<Employee> structure = new ResponseStructure<>();
		if(optional.isEmpty())
		{
			throw new InvalidEmployeeIdException("Unable to set employee Status to Active");
		}
		Employee emp = optional.get();
		emp.setStatus(EmployeeStatus.ACTIVE);
		emp = dao.updateEmp(emp);
//		structure.setStatus(HttpStatus.OK.value());
//		structure.setMessage("Employee Status Updated To Active...");
//		structure.setBody(emp);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Employee Status Updated To Active...").body(emp).build());
	}

	public ResponseEntity<?> setEmployeeStatusToInActive(int id) 
	{
		Optional<Employee> optional = dao.findEmpById(id);
		ResponseStructure<Employee> structure = new ResponseStructure<>();
		if(optional.isEmpty())
		{
			throw new InvalidEmployeeIdException("Unable to set employee Status to In_Active");
		}
		Employee emp = optional.get();
		emp.setStatus(EmployeeStatus.IN_ACTIVE);
		emp = dao.updateEmp(emp);
//		structure.setStatus(HttpStatus.OK.value());
//		structure.setMessage("Employee Status Updated To Active...");
//		structure.setBody(emp);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Employee Status Updated To Active...").body(emp).build());
	}

}
