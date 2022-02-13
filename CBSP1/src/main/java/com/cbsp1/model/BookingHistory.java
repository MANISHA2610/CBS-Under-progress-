package com.cbsp1.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="bookingHistory")
public class BookingHistory {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(nullable=false)
	private Integer BId;
	@Column
	private Date bDate;
	
	@OneToOne
	private Requests request;
	
	@ManyToOne
	private Employee emp;
	
	@ManyToOne
	private Cab cab;
	
	public BookingHistory() {
		
	}
	
	public Integer getBId() {
		return BId;
	}
	public Date getbDate() {
		return bDate;
	}
	public void setBId(Integer bId) {
		BId = bId;
	}
	public void setbDate(Date bDate) {
		this.bDate = bDate;
	}
	public Requests getRequest() {
		return request;
	}
	public void setRequest(Requests request) {
		this.request = request;
	}
	public Employee getEmp() {
		return emp;
	}
	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	public Cab getCab() {
		return cab;
	}
	public void setCab(Cab cab) {
		this.cab = cab;
	}
	
}
