package com.itc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Patient")
public class Patient {
	@Id
	@Column(name = "pId")
	private int pId;
	@Column(name = "pName")
	private String pName;
	@Column(name = "dept")
	private String dept;
	@Column(name = "doctor")
	private String doctor;

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public Patient(int pId, String pName, String dept, String doctor) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.dept = dept;
		this.doctor = doctor;
	}

	public Patient() {
		super();
	}

}
