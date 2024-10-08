package org.jsp.emp_app.responseStructure;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseStructure<T> 
{
	private int status;   // httpStatus
	private String message;
	private T body;
}
