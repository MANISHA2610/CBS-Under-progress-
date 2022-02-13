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
@Table(name="Dept")
public class Dept {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable=false)
	private Integer DId;
	@Column
	private String mName;
	@Column
	private String dName;
	
	@OneToMany(mappedBy = "dept")
	private List<Employee> emp = new ArrayList();
	
	public Dept() {
		
	}
	
	public Integer getDId() {
		return DId;
	}
	public String getmName() {
		return mName;
	}
	public String getdName() {
		return dName;
	}
	public void setDId(Integer dId) {
		DId = dId;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public void setdName(String dName) {
		this.dName = dName;
	}
	
}
