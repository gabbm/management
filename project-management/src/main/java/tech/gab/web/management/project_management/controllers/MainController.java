package tech.gab.web.management.project_management.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import tech.gab.web.management.project_management.services.EmployeeService;
import tech.gab.web.management.project_management.services.ProjectService;

@Controller
public class MainController {

	private static final Log log = LogFactory.getLog(MainController.class);
	
	private EmployeeService employeeService;
	private ProjectService projectService;
	
	@Autowired
	public MainController(EmployeeService employeeService,
			ProjectService projectService) {
		this.employeeService = employeeService;
		this.projectService = projectService;
	}
	
	@RequestMapping("/")
	public String home(){
		return "home";
	}
	
	@RequestMapping("/projects")
	public String projects(Model model){
		
		model.addAttribute("projects", projectService.listProjects());
		
		return "project/list";
	}
	
	@RequestMapping("/employees")
	public String employees(Model model){
		
		model.addAttribute("employees", employeeService.listEmployees());
		
		return "employee/list";
	}
}
