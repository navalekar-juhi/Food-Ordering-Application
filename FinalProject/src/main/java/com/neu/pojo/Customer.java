package com.neu.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "userId")
public class Customer extends User{

	@Column
	private String fName;
	@Column
	private String lName;
	@Column
	private String address;
	@Column
	private String phNumber;
	
	public Customer() {
		
	}
	public Customer(String fName, String lName, String address,String phNumber) {
		this.fName=fName;
		this.lName= lName;
		this.address= address;
		this.phNumber=phNumber;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhNumber() {
		return phNumber;
	}

	public void setPhNumber(String phNumber) {
		this.phNumber = phNumber;
	}
	
}
