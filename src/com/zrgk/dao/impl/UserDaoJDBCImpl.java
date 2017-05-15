package com.zrgk.dao.impl;

import java.io.Serializable;
import java.sql.Connection;
import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.zrgk.dao.IUserDao;
import com.zrgk.entity.User;
import com.zrgk.util.SessionUtils;

public class UserDaoJDBCImpl implements IUserDao {

	public void saveUser(User u) throws Exception{
		Session session = SessionUtils.getSession();
		session.save(u);
		Transaction ts = SessionUtils.getTransaction();
		ts.commit();
		session.close();
	}

	public User findUserById(int id) throws Exception{
		Session session = SessionUtils.getSession();
		User u = (User) session.get(User.class, id);
		session.close();
		return u;

	}

	public void deleteUserById(int id) throws Exception{
		Session session = SessionUtils.getSession();
		User u = (User) session.get(User.class, id);
		session.delete(u);
		session.beginTransaction().commit();
		session.close();

	}
	public void updateUser(User u) throws Exception{
		//这个传递过来的User是修改后的用户信息
		Session session = SessionUtils.getSession();
        session.update(u);
        session.beginTransaction().commit();
        session.close();
	}

	public List<User> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public void deteleUserById(int id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void UpdateUser(User u) throws Exception {
		// TODO Auto-generated method stub
		
	}


}
