package com.neu.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.exception.OrderException;
import com.neu.exception.RestaurantException;
import com.neu.pojo.OrderDetails;
import com.neu.pojo.Orders;
import com.neu.pojo.Restaurant;

public class OrdersDAO extends DAO{
public OrdersDAO() {}
public Orders addOrders(Orders o)throws OrderException{
	try {
		begin();
		System.out.println("inside DAO");
		getSession().save(o);
		commit();
		return o;	
	}catch(Exception e) {
		rollback();
		throw new OrderException("Could not add order", e);
	}
}
public List<OrderDetails> viewList(long customerId) throws OrderException{
	
	try {
        begin();
        Query q = getSession().createQuery("from OrderDetails where customerId = :customerId");
        q.setLong("customerId", customerId);
        List<OrderDetails> odetails = q.list();
        commit();
        return odetails;
    } catch (HibernateException e) {
        rollback();
        throw new OrderException("Could not fetch order details", e);
    }
	
}
}
