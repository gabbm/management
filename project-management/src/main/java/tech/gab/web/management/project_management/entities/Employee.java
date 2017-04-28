package tech.gab.web.management.project_management.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Employee", indexes= {
		@Index(columnList = "id", unique = true)
})
public class Employee {

	public static enum Position{
		PROGRAMMER,
		PROGRAMMER_ANALYST,
		ANALYST,
		ARCHITECT,
		TEAM_MANAGER,
		PROJECT_MANAGER,
		EXECUTIVE
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false, precision=10, scale=2)
	private String name;
	
	@Column(nullable = false, precision=10, scale=2)
	private String surname;
	
	@Column(precision=10, scale=2)
	private Double salary = 0.00;

	@Column(precision=10, scale=2)
	private Double rate = 0.00;
	
	@Column(nullable = false)
	private Position position;
	
	@Column(nullable = false)
	private Boolean intern = Boolean.TRUE;
	
	@Column(nullable = false)
	private Boolean companyGroup = Boolean.TRUE;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="employee")
	private Set<Resource> resources = new HashSet<Resource>();
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Boolean isIntern() {
		return intern;
	}

	public void setIntern(Boolean intern) {
		this.intern = intern;
	}

	public Boolean isCompanyGroup() {
		return companyGroup;
	}

	public void setCompanyGroup(Boolean companyGroup) {
		this.companyGroup = companyGroup;
	}

	public Set<Resource> getResources() {
		return resources;
	}
	
}
