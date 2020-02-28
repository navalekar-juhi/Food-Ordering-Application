package com.neu.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import com.neu.exception.RestaurantException;
import com.neu.exception.UserException;
import com.neu.pojo.Customer;
import com.neu.pojo.Restaurant;

public class RestaurantDAO extends DAO{
public RestaurantDAO() {}

public Restaurant addRestaurant(Restaurant rst) throws RestaurantException{
	try {
		begin();
		System.out.println("inside DAO");		
		getSession().save(rst);
		commit();
		return rst;	
	}catch(Exception e) {
		rollback();
		throw new RestaurantException("Could not add restaurant " + rst.getrName(), e);
	}
}
public void delete(Restaurant restaurant)
        throws RestaurantException {
    try {
        begin();
        getSession().delete(restaurant);
        commit();
    } catch (HibernateException e) {
        rollback();
        throw new RestaurantException("Could not delete restaurant", e);
    }
}

public List<Restaurant> viewList() throws RestaurantException{
	
	try {
        begin();
        Query q = getSession().createQuery("from Restaurant");
        List<Restaurant> restaurant = q.list();
        commit();
        return restaurant;
    } catch (HibernateException e) {
        rollback();
        throw new RestaurantException("Could not fetch restaurant details", e);
    }
	
}
public Restaurant getById(long rId) throws RestaurantException{
	
	try {
		begin();
		Query q = getSession().createQuery("from Restaurant where rId = :rId");
		q.setLong("rId", rId);
		Restaurant user = (Restaurant) q.uniqueResult();
		commit();
		return user;
    } catch (HibernateException e) {
        rollback();
        throw new RestaurantException("Could not fetch restaurant details", e);
    }	
}
public Restaurant updateItem(Restaurant r) throws RestaurantException{
	
	try {
		begin();
        getSession().saveOrUpdate(r);
        commit();
		return r;
    } catch (HibernateException e) {
        rollback();
        throw new RestaurantException("Could not fetch restaurant details", e);
    }	
}
}
