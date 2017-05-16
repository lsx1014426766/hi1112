package com.zrgk.dao.impl;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.zrgk.dao.IUserDao;
import com.zrgk.entity.User;
import com.zrgk.util.HibernateUtil2;


public class UserDaoHibernateImpl3 implements IUserDao {
	public void UpdateUser(User u) throws Exception {
		Session session = HibernateUtil2.getSession();
		session.update(u);
	}

	public void deteleUserById(int id) throws Exception {
		Session session = HibernateUtil2.getSession();
		User u = (User) session.get(User.class, id);
		session.delete(u);
	}

	public List<User> findAll() throws Exception {
		Session session = HibernateUtil2.getSession();
		String hql = "select u from User u";
		// ÷¥––hql”Ôæ‰
		Query query = session.createQuery(hql);
		List<User> list = query.list();
		return list;
	}

	public User findUserById(int id) throws Exception {
		Session session = HibernateUtil2.getSession();
		User u = (User) session.get(User.class, id);
		return u;
	}

	public void saveUser(User u) throws Exception {
		Session session = HibernateUtil2.getSession();
			session.save(u);
	}
}
