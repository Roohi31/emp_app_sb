package org.jsp.emp_app.exceptionClasses;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NoActiveEmployeeFoundException extends RuntimeException
{
	private String message;

	public NoActiveEmployeeFoundException(String message) 
	{
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return this.message;
	}
	
}
