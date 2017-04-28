package tech.gab.web.management.project_management.services;

import tech.gab.web.management.project_management.exceptions.PropertyNotFoundException;

public interface PropertyService {
	
	public abstract String getValue(String name, Object defaultValue) throws PropertyNotFoundException;
}
