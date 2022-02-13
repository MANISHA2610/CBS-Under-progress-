package com.cbsp1.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable=false)
	private Integer EId;
	@Column(nullable=false)
	private String name;
	@Column
	private String email;
	@Column
	private String mobile;
	@Column
	private Date doj;
	@Column
	private String manager;

	@Column(nullable=false, unique=true)
	private String password;
	
	@OneToMany(mappedBy = "emp")
	private List<Requests> request = new ArrayList();
	
	@OneToMany(mappedBy = "emp")
	private List<BookingHistory> bookings = new ArrayList();
	
	@ManyToOne
	private Dept dept;
	
	public Employee() {
		//default constructor
	}

	public Employee(String name, String email, String mobile, String manager, Date doj, String password) {
		// for adding employee
		this.name=name;
		this.email=email;
		this.mobile=mobile;
		this.manager=manager;
		this.doj=doj;
		this.password=password;
	}
	
	public Employee(Integer EId, String password) {
		// for login validation
		this.EId=EId;
		this.password=password;
	}
	public Employee(Employee eId) {
		// TODO Auto-generated constructor stub
		//to add to requests
	}

	public Integer getEId() {
		return EId;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getMobile() {
		return mobile;
	}
	public Date getDoj() {
		return doj;
	}
	public String getManager() {
		return manager;
	}
	public void setEId(Integer eId) {
		EId = eId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public List<Requests> getRequest() {
		return request;
	}

	public void setRequest(List<Requests> request) {
		this.request = request;
	}

	public List<BookingHistory> getBookings() {
		return bookings;
	}

	public void setBookings(List<BookingHistory> bookings) {
		this.bookings = bookings;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Employee [EId=" + EId + ", name=" + name + ", email=" + email + ", mobile=" + mobile + ", doj=" + doj
				+ ", manager=" + manager + ", password=" + password + ", request=" + request + ", bookings=" + bookings
				+ ", dept=" + dept + "]";
	}
	
}
