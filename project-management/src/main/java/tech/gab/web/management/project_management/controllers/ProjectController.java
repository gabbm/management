package tech.gab.web.management.project_management.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tech.gab.web.management.project_management.entities.Project;
import tech.gab.web.management.project_management.services.ProjectService;
import tech.gab.web.management.project_management.utils.Utilities;

@Controller
@RequestMapping("/project")
public class ProjectController {

	private static final Log log = LogFactory.getLog(ProjectController.class);

	private ProjectService projectService;
	
	@Autowired
	public ProjectController(ProjectService projectService) {
		this.projectService = projectService;
	}
	
	@RequestMapping(value = "/profile", params = "pep", produces={"text/html; charset=UTF-8"})
	public String detail(@RequestParam("pep") String pep,
			Model model){
		Project project;

		try{
			project = projectService.findByPep(pep);
		}catch(Exception e){
			log.error(e.getMessage());
			
			ObjectError objectError = new ObjectError("project", "project-not-found");
			
			return "redirect:/projects";
		}
		
		model.addAttribute(project);
		return "project/profile";
	}
}
