package org.jsp.emp_app.repository;

import java.util.List;
import java.util.Optional;

import org.jsp.emp_app.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	Optional<Employee> findEmpByEmailAndPassword(String email, String password);

	List<Employee> findEmpByName(String name);

	@Query("select e from Employee e where e.status='ACTIVE'")
	List<Employee> findAllActiveEmployee();

}
