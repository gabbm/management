package tech.gab.web.management.project_management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.gab.web.management.project_management.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	Employee findById(long id);
}
