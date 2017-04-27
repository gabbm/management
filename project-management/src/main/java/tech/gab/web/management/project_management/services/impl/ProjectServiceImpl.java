package tech.gab.web.management.project_management.services.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import tech.gab.web.management.project_management.entities.Project;
import tech.gab.web.management.project_management.exceptions.ProjectNotFoundException;
import tech.gab.web.management.project_management.repositories.ProjectRepository;
import tech.gab.web.management.project_management.services.ProjectService;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ProjectServiceImpl implements ProjectService{

	private static final Log log = LogFactory.getLog(ProjectServiceImpl.class);
	
	private ProjectRepository projectRepository;
	
	@Autowired
	public ProjectServiceImpl(ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}
	
	@Override
	public List<Project> listProjects() {
		return projectRepository.findAll();
	}

	@Override
	public Project findByPep(String pep) throws ProjectNotFoundException {
		Project project = projectRepository.findByPep(pep);
		
		if(project == null){
			throw new ProjectNotFoundException(pep);
		}
		
		return project;
	}

}
