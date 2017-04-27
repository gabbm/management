package tech.gab.web.management.project_management.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name="Project", indexes= {
		@Index(columnList = "pep", unique = true)
})
public class Project {

	public static enum Status {
		INITIALIZED, 
		STARTED, 
		ENDED, 
		BLOCKED, 
		CANCELLED
	}
	
	@Id
	@Column(nullable = false)
	private String pep;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String customer;
	
	@Column(nullable = false)
	private Date startDate;
	
	@Column(nullable = false)
	private Date endDate;
	
	@Column(nullable = false, precision=10, scale=2)
	private Double sellingMargin;
	
	@Column(nullable = false, precision=10, scale=2)
	private Double sellingPrice;
	
	@Column(nullable = false, precision=10, scale=2)
	private Double sellingPriceVAT;

	@Column(nullable = false)
	private Status status = Status.INITIALIZED;

	public String getPep() {
		return pep;
	}

	public void setPep(String pep) {
		this.pep = pep;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Double getSellingMargin() {
		return sellingMargin;
	}

	public void setSellingMargin(Double sellingMargin) {
		this.sellingMargin = sellingMargin;
	}

	public Double getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(Double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public Double getSellingPriceVAT() {
		return sellingPriceVAT;
	}

	public void setSellingPriceVAT(Double sellingPriceVAT) {
		this.sellingPriceVAT = sellingPriceVAT;
	}
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}
