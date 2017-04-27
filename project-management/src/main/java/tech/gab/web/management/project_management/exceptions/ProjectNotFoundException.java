package tech.gab.web.management.project_management.exceptions;

public class ProjectNotFoundException extends Exception {

	private static final long serialVersionUID = 9146190875092314225L;

	public ProjectNotFoundException(String pep) {
		super("Project " + pep + " not found into the database");
	}
}
