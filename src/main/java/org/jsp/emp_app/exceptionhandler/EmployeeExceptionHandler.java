package org.jsp.emp_app.exceptionhandler;

import java.sql.SQLIntegrityConstraintViolationException;

import org.jsp.emp_app.exceptionClasses.InvalidCredentials;
import org.jsp.emp_app.exceptionClasses.InvalidEmployeeIdException;
import org.jsp.emp_app.exceptionClasses.NoActiveEmployeeFoundException;
import org.jsp.emp_app.exceptionClasses.NoEmployeeFoundException;
import org.jsp.emp_app.responseStructure.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice  // to redirect the exception to this class 
public class EmployeeExceptionHandler 
{
	@ExceptionHandler(NoActiveEmployeeFoundException.class)
	public ResponseStructure<String> noActiveEmployeeFoundExceptionHandler(NoActiveEmployeeFoundException e)
	{
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage("No Active Employee");
		structure.setBody(e.getMessage());
		return structure;
	}
	
	@ExceptionHandler(InvalidEmployeeIdException.class)
	public ResponseStructure<String> invalidEmployeeIdExceptionHandler(InvalidEmployeeIdException e)
	{
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage("Invalid Id...");
		structure.setBody(e.getMessage());
		return structure;
	}
	
	@ExceptionHandler(InvalidCredentials.class)
	public ResponseStructure<String> invalidCredentialsHandler(InvalidCredentials e)
	{
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage("Invalid credentials...");
		structure.setBody(e.getMessage());
		return structure;
	} 
	
// to make responseStatus [status] and responseEntity in the header Http_status same.
	@ExceptionHandler(NoEmployeeFoundException.class)
	public ResponseEntity<ResponseStructure<String>> noEmployeeFoundException(NoEmployeeFoundException e)
	{
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage("No Employee Found");
		structure.setBody(e.getMessage());
		return new ResponseEntity(structure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<ResponseStructure<String>> sQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException e)
	{
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		structure.setMessage("Already Employee Exist");
		structure.setBody(e.getMessage());
		return new ResponseEntity(structure, HttpStatus.BAD_REQUEST);
	}
}
