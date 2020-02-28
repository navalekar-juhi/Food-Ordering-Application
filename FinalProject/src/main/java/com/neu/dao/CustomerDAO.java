package com.neu.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.exception.CustomerException;
import com.neu.exception.RestaurantException;
import com.neu.pojo.Customer;
import com.neu.pojo.Restaurant;

public class CustomerDAO extends DAO{
	public CustomerDAO() {
		
	}
	public Customer addCustomer(Customer c)throws CustomerException{
		try {
			begin();
			System.out.println("inside DAO");
			Customer cust= new Customer();
			cust.setfName(c.getfName());
			cust.setlName(c.getlName());
			cust.setPhNumber(c.getPhNumber());
			cust.setAddress(c.getAddress());
			cust.setRole("customer");
			cust.setEmailId(c.getEmailId());
			cust.setUserName(c.getUserName());
			cust.setUserPassword(c.getUserPassword());
			getSession().save(cust);
			commit();
			return c;	
		}catch(Exception e) {
			rollback();
			throw new CustomerException("Could not add customer", e);
		}
	}
	public Customer getById(long userId) throws CustomerException{
		
		try {
			begin();
			Query q = getSession().createQuery("from Customer where userId = :userId");
			q.setLong("userId", userId);
			Customer user = (Customer) q.uniqueResult();
			commit();
			return user;
	    } catch (HibernateException e) {
	        rollback();
	        throw new CustomerException("Could not get customer", e);
	    }	
	}
}
