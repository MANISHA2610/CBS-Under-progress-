package com.cbsp1.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="requests")
public class Requests {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable=false)
	private Integer reqId;
	@Column
	private String status;
	@Column
	private Timestamp rDate;
	
	@ManyToOne
	private Employee emp;
	
	public Requests() {
		
	}
	
	public Requests(String status, Integer emp, Timestamp rDate) {
		// to insert a new request
		
		}
	public Integer getReqId() {
		return reqId;
	}
	public String getStatus() {
		return status;
	}
	public Timestamp getrDate() {
		return rDate;
	}
	public void setReqId(Integer reqId) {
		this.reqId = reqId;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setrDate(Timestamp rDate) {
		this.rDate = rDate;
	}
	public Employee getEmp() {
		return emp;
	}
	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	
}
