package com.neu.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.exception.ItemException;
import com.neu.exception.RestaurantException;
import com.neu.pojo.Item;
import com.neu.pojo.Restaurant;

public class ItemDAO extends DAO{
public ItemDAO() {
	
}
public List<Item> getById(long rId) throws ItemException{
	
	try {
		begin();
		Query q = getSession().createQuery("from Item where rId = :rId");
		q.setLong("rId", rId);
		List<Item> item = q.list();
		commit();
		return item;
    } catch (HibernateException e) {
        rollback();
        throw new ItemException("Could not fetch item details", e);
    }	
}
public Set<Item> viewItemList(long rId) throws ItemException{
	
	try {
        begin();
        Query q = getSession().createQuery("from Restaurant where rId = :rId");
        q.setLong("rId", rId);
        Restaurant restaurant = (Restaurant)q.uniqueResult();
        Set<Item> items= restaurant.getMenuList();
        commit();
        return items;
    } catch (HibernateException e) {
        rollback();
        throw new ItemException("Could not fetch restaurant details", e);
    }
	
}

}
