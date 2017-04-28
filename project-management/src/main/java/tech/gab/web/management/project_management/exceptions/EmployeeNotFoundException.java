package tech.gab.web.management.project_management.exceptions;

public class EmployeeNotFoundException extends Exception {

	private static final long serialVersionUID = 3223346278525403039L;

	public EmployeeNotFoundException(long id) {
		super("Employee " + id + " not found into the database");
	}
}
