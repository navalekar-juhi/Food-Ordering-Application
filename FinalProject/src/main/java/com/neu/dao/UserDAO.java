package com.neu.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.exception.UserException;
import com.neu.pojo.User;

public class UserDAO extends DAO {
	public UserDAO() {

	}
	public User getDetails(String userName, String userPassword) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("from User where userName = :userName and userPassword = :userPassword");
			q.setString("userName", userName);
			q.setString("userPassword", userPassword);
			User user = (User) q.uniqueResult();
			commit();
			return user;

		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get user ", e);
		}

	}
}
