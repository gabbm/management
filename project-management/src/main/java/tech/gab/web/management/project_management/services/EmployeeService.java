package tech.gab.web.management.project_management.services;

import java.util.List;

import tech.gab.web.management.project_management.dto.EmployeeModel;
import tech.gab.web.management.project_management.entities.Employee;
import tech.gab.web.management.project_management.exceptions.EmployeeNotFoundException;
import tech.gab.web.management.project_management.exceptions.PropertyNotFoundException;

public interface EmployeeService {
	
	public abstract List<Employee> listEmployees();

	public abstract Employee findById(long id) throws EmployeeNotFoundException;
	
	public abstract EmployeeModel calculateEmployeeData(long id) throws EmployeeNotFoundException, PropertyNotFoundException;

	public abstract EmployeeModel calculateEmployeeData(Employee employee) throws PropertyNotFoundException;

}
