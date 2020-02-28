package com.neu.pojo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.neu.pojo.Item;

@Entity
public class Restaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long rId;
	@Column
	private String rName;
	@Column
	private String rAddress;
	@Column
	private String rNumber;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY) 
	@JoinColumn(name="rId") //specify the column used for join- created in item table
	private Set<Item> menuList;
	
	public Restaurant() {
		
	}

	public long getrId() {
		return rId;
	}

	public void setrId(long rId) {
		this.rId = rId;
	}

	public String getrName() {
		return rName;
	}

	public void setrName(String rName) {
		this.rName = rName;
	}

	public String getrAddress() {
		return rAddress;
	}

	public void setrAddress(String rAddress) {
		this.rAddress = rAddress;
	}

	public String getrNumber() {
		return rNumber;
	}

	public void setrNumber(String rNumber) {
		this.rNumber = rNumber;
	}

	public Set<Item> getMenuList() {
		return menuList;
	}

	public void setMenuList(Set<Item> menuList) {
		this.menuList = menuList;
	}
	
	
}
