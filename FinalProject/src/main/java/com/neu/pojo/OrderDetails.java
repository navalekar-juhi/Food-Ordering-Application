package com.neu.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OrderDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long orderDetailsId;
	
	@Column
	private long itemId;
	@Column
	private String itemName;
	@Column
	private float price;
	@Column
	private long customerId;
public OrderDetails() {}
public long getOrderDetailsId() {
	return orderDetailsId;
}
public void setOrderDetailsId(long orderDetailsId) {
	this.orderDetailsId = orderDetailsId;
}
public long getItemId() {
	return itemId;
}
public void setItemId(long itemId) {
	this.itemId = itemId;
}
public String getItemName() {
	return itemName;
}
public void setItemName(String itemName) {
	this.itemName = itemName;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
public long getCustomerId() {
	return customerId;
}
public void setCustomerId(long customerId) {
	this.customerId = customerId;
}

}
