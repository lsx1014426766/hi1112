package com.zrgk.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.zrgk.dao.IUserDao;
import com.zrgk.entity.User;
import com.zrgk.util.HibernateUtil1;



public class UserDaoHibernateImpl implements IUserDao {
	public void UpdateUser(User u) throws Exception {
		Session session = null;
		Transaction tx = null;
		try{
			session = HibernateUtil1.getSession();
//			Transaction tx = session.beginTransaction();
			tx = session.getTransaction();
			tx.begin();
			session.update(u);
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}finally{
			HibernateUtil1.closeSession();
		}
	}

	public void deteleUserById(int id) throws Exception {
		Session session = null;
		Transaction tx = null;
		try{
			session = HibernateUtil1.getSession();
			tx = session.beginTransaction();
			User u = (User)session.get(User.class,id);
//			User u = new User();
//			u.setId(id);
			session.delete(u);
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}finally{
			HibernateUtil1.closeSession();
		}
	}

	public List<User> findAll() throws Exception {
		Session session = null;
		List<User> list = null;
		try{
			session = HibernateUtil1.getSession();
			// hql”Ôæ‰
			String  hql ="select u from User u";
			//÷¥––hql”Ôæ‰
			Query query = session.createQuery(hql);
			list = query.list();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			HibernateUtil1.closeSession();
		}
		return list;
	}

	public User findUserById(int id) throws Exception {
		Session session = null;
		User u = null;
		try{
			session = HibernateUtil1.getSession();
			u = (User)session.get(User.class, id);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			HibernateUtil1.closeSession();
		}
		return u;
	}

	public void saveUser(User u) throws Exception {
		Session session = null;
		Transaction tx = null;
		try{
			session = HibernateUtil1.getSession();
			tx = session.beginTransaction();
			session.save(u);
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}finally{
			HibernateUtil1.closeSession();
		}
	}
}
