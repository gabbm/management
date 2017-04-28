package tech.gab.web.management.project_management.services.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import tech.gab.web.management.project_management.dto.EmployeeModel;
import tech.gab.web.management.project_management.entities.Employee;
import tech.gab.web.management.project_management.exceptions.EmployeeNotFoundException;
import tech.gab.web.management.project_management.exceptions.PropertyNotFoundException;
import tech.gab.web.management.project_management.repositories.EmployeeRepository;
import tech.gab.web.management.project_management.services.EmployeeService;
import tech.gab.web.management.project_management.services.PropertyService;
import tech.gab.web.management.project_management.utils.Constants;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class EmployeeServiceImpl implements EmployeeService{

	private static final Log log = LogFactory.getLog(EmployeeServiceImpl.class);
	
	private EmployeeRepository employeeRepository;
	private PropertyService propertyService;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository,
			PropertyService propertyService) {
		this.employeeRepository = employeeRepository;
		this.propertyService = propertyService;
	}
	
	@Override
	public List<Employee> listEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(long id) throws EmployeeNotFoundException {
		Employee employee = employeeRepository.findById(id);
		
		if(employee == null){
			throw new EmployeeNotFoundException(id);
		}
		
		return employee;
	}

	@Override
	public EmployeeModel calculateEmployeeData(long id) throws EmployeeNotFoundException, PropertyNotFoundException {
		return calculateEmployeeData(findById(id));
	}

	@Override
	public EmployeeModel calculateEmployeeData(Employee employee) throws PropertyNotFoundException{
		String baiPercent = propertyService.getValue(Constants.BPE.BAI_PERCENT_NAME,
				Constants.BPE.BAI_PERCENT);
		String bpePercent = propertyService.getValue(Constants.BPE.BPE_PERCENT_NAME,
				Constants.BPE.BPE_PERCENT);
		String bpeCompanyGroupPercent = propertyService.getValue(Constants.BPE.BPE_COMPANY_GROUP_PERCENT_NAME,
				Constants.BPE.BPE_COMPANY_GROUP_PERCENT);
		String bpeExternalPercent = propertyService.getValue(Constants.BPE.BPE_EXTERNAL_PERCENT_NAME,
				Constants.BPE.BPE_EXTERNAL_PERCENT);
		String ssPercent = propertyService.getValue(Constants.BPE.SS_PERCENT_NAME,
				Constants.BPE.SS_PERCENT);
		String workDays = propertyService.getValue(Constants.BPE.WORK_DAYS_NAME,
				Constants.BPE.WORK_DAYS);
		
		EmployeeModel employeeModel = new EmployeeModel();
		
		employeeModel.setEmployee(employee);
		
		employeeModel.setCompanyCost(employee.getSalary() != 0.00 ? 
					calculateCompanyCost(employee.getSalary(), Double.valueOf(ssPercent), Integer.valueOf(workDays)) : 
					0.0);
		
		if(employee.isIntern()){
			if(employee.getSalary() == 0.0){
				employee.setSalary(calculateSalary(employee.getRate(), Double.valueOf(ssPercent), Double.valueOf(bpePercent), Integer.valueOf(workDays)));
			}
			
			employeeModel.setCompanyCost(calculateCompanyCost(employee.getSalary(), Double.valueOf(ssPercent), Integer.valueOf(workDays)));
			
			employeeModel.setBaseCost(employee.getRate() != 0.0 ? employee.getRate() : 
				calculateBaseCost(employeeModel.getCompanyCost(), Double.valueOf(bpePercent)));
		}else{
			employeeModel.setCompanyCost(employee.getRate());
			
			if(employee.isCompanyGroup()){
				employeeModel.setBaseCost(calculateBaseCost(employeeModel.getCompanyCost(), Double.valueOf(bpeCompanyGroupPercent)));
			}else{
				employeeModel.setBaseCost(calculateBaseCost(employeeModel.getCompanyCost(), Double.valueOf(bpeExternalPercent)));
			}
		}
		
		employeeModel.setObjectiveRate(calculateObjectiveRate(employeeModel.getBaseCost(), Double.valueOf(baiPercent)));
		
		return employeeModel;
	}
	
	private double calculateSalary(double baseCost, double ssPercent, double bpePercent, int workDays){
		double companyCost = baseCost / (1 + (bpePercent/100));
		double companyCostYear = companyCost * workDays;
		return companyCostYear / (1 + (ssPercent/100));
	}
	
	private double calculateCompanyCost(double salary, double ssPercent, int workDays){
		double companyCostYear = salary * (1 + (ssPercent/100));
		return companyCostYear / workDays;
	}
	
	private double calculateBaseCost(double companyCost, double bpePercent){
		return companyCost * (1 + (bpePercent/100));
	}
	
	private double calculateObjectiveRate(double baseCost, double baiPercent){
		return baseCost / (1 - (baiPercent/100));
	}
}
