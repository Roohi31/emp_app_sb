package org.jsp.emp_app.exceptionClasses;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InvalidCredentials extends RuntimeException
{
	private String message;

	public InvalidCredentials(String message) 
	{
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return this.message;
	}
}
