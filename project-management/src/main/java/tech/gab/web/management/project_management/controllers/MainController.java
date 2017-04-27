package tech.gab.web.management.project_management.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import tech.gab.web.management.project_management.services.ProjectService;

@Controller
public class MainController {

	private static final Log log = LogFactory.getLog(MainController.class);
	
	private ProjectService projectService;
	
	@Autowired
	public MainController(ProjectService projectService) {
		this.projectService = projectService;
	}
	
	@RequestMapping("/")
	public String home(){
		return "home";
	}
	
	@RequestMapping("/projects")
	public String projectList(Model model){
		
		model.addAttribute("projects", projectService.listProjects());
		
		return "project/list";
	}
	
	
}
