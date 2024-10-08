package org.jsp.emp_app.exceptionClasses;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NoEmployeeFoundException extends RuntimeException
{
	private String message;

	public NoEmployeeFoundException(String message) 
	{
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return this.message;
	}
}
