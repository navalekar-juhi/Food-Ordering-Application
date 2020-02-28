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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long orderId;
	
	@ManyToOne()
	@JoinColumn(name="userId")
	private Customer customer;

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY) 
	@JoinColumn(name="orderId")
	private Set<OrderDetails> orderDetails;
	
public Orders() {
	
}

public long getOrderId() {
	return orderId;
}

public void setOrderId(long orderId) {
	this.orderId = orderId;
}

public Customer getCustomer() {
	return customer;
}

public void setCustomer(Customer customer) {
	this.customer = customer;
}

public Set<OrderDetails> getOrderDetails() {
	return orderDetails;
}

public void setOrderDetails(Set<OrderDetails> orderDetails) {
	this.orderDetails = orderDetails;
}



}
