package org.jsp.emp_app.controller;

import java.util.List;

import org.jsp.emp_app.entity.Employee;
import org.jsp.emp_app.responseStructure.ResponseStructure;
import org.jsp.emp_app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService service;

	@PostMapping
	public ResponseEntity<?> saveEmp(@RequestBody Employee emp) {
		return service.saveEmp(emp);
	}

	@GetMapping
	public ResponseEntity<?> findAllEmployee() {
		return service.findAllEmployee();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findEmpById(@PathVariable int id) {
		return service.findEmpById(id);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteEmpById(@PathVariable int id) {
		return service.deleteEmpById(id);
	}

	@PutMapping
	public ResponseEntity<?> updateEmp(@RequestBody Employee emp) {
		return service.updateEmp(emp);
	}

	@GetMapping("/{email}/{password}")
	public ResponseEntity<?> findEmpByEmailAndPassword(@PathVariable String email,
			@PathVariable String password) {
		return service.findEmpByEmailAndPassword(email, password);
	}

	@GetMapping("/name/{name}")
	public ResponseEntity<?> findEmpByName(@PathVariable String name) {
		return service.findEmpByName(name);
	}

	@PatchMapping("/active/{id}")
	public ResponseEntity<?> setEmployeeStatusToActive(@PathVariable int id) {
		return service.setEmployeeStatusToActive(id);
	}

	@PatchMapping("/inactive/{id}")
	public ResponseEntity<?> setEmployeeStatusToInActive(@PathVariable int id) {
		return service.setEmployeeStatusToInActive(id);
	}
}
