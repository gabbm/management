package tech.gab.web.management.project_management.dto;

import tech.gab.web.management.project_management.entities.Employee;

public class EmployeeModel {
	
	private Employee employee;
	
	private double baseCost;
	private double companyCost;
	private double objectiveRate;
	
	public Employee getEmployee() {
		return employee;
	}
	
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public double getBaseCost() {
		return baseCost;
	}
	
	public void setBaseCost(double baseCost) {
		this.baseCost = baseCost;
	}
	
	public double getCompanyCost() {
		return companyCost;
	}
	
	public void setCompanyCost(double companyCost) {
		this.companyCost = companyCost;
	}
	
	public double getObjectiveRate() {
		return objectiveRate;
	}
	
	public void setObjectiveRate(double objectiveRate) {
		this.objectiveRate = objectiveRate;
	}
	
}
