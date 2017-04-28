package tech.gab.web.management.project_management.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import tech.gab.web.management.project_management.dto.EmployeeModel;
import tech.gab.web.management.project_management.services.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	private static final Log log = LogFactory.getLog(EmployeeController.class);

	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@RequestMapping(value = "/profile/{id}", produces={"text/html; charset=UTF-8"})
	public String detail(@PathVariable("id") long id,
			Model model){
		EmployeeModel employeeModel;

		try{
			employeeModel = employeeService.calculateEmployeeData(id);
		}catch(Exception e){
			log.error(e.getMessage(), e);
			
			ObjectError objectError = new ObjectError("employee", "employee-not-found");
			
			return "redirect:/employees";
		}
		
		model.addAttribute("employee", employeeModel);
		return "employee/profile";
	}
}
