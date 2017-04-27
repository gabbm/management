package tech.gab.web.management.project_management.services;

import java.util.List;

import tech.gab.web.management.project_management.entities.Project;
import tech.gab.web.management.project_management.exceptions.ProjectNotFoundException;

public interface ProjectService {
	
	public abstract List<Project> listProjects();

	public abstract Project findByPep(String pep) throws ProjectNotFoundException;
}
