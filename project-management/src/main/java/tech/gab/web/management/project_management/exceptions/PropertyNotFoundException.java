package tech.gab.web.management.project_management.exceptions;

public class PropertyNotFoundException extends Exception {
	
	private static final long serialVersionUID = -4916175464486499426L;

	public PropertyNotFoundException(String name) {
		super("Property " + name + " not found into the database and it doesn't have a default value");
	}
}
