package com.cbsp1.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cab")
public class Cab {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Integer cabId;
	@Column
	private String cabNo;
	@Column
	private String dName;
	@Column
	private String dMobile;
	@Column
	private Integer AvailableTime;
	@Column
	private Integer active;
	
	@OneToMany(mappedBy = "cab")
	private List<BookingHistory> cabbookings = new ArrayList();
	
	public Cab() {
		
	}
	
	public Cab(String cabNo, String dName, String dMobile, Integer AvailableTime, Integer active) {
	
		this.cabNo=cabNo;
		this.dName=dName;
		this.dMobile=dMobile;
		this.AvailableTime=AvailableTime;
		this.active=active;
		
	}
	public Integer getCabId() {
		return cabId;
	}
	public String getCabNo() {
		return cabNo;
	}
	public String getdName() {
		return dName;
	}
	public String getdMobile() {
		return dMobile;
	}
	public Integer getAvailableTime() {
		return AvailableTime;
	}
	public void setCabId(Integer cabId) {
		this.cabId = cabId;
	}
	public void setCabNo(String cabNo) {
		this.cabNo = cabNo;
	}
	public void setdName(String dName) {
		this.dName = dName;
	}
	public void setdMobile(String dMobile) {
		this.dMobile = dMobile;
	}
	public void setAvailableTime(Integer availableTime) {
		AvailableTime = availableTime;
	}
	public Integer getActive() {
		return active;
	}
	public void setActive(Integer active) {
		this.active = active;
	}
	public List<BookingHistory> getCabbookings() {
		return cabbookings;
	}
	public void setCabbookings(List<BookingHistory> cabbookings) {
		this.cabbookings = cabbookings;
	}
	
}
