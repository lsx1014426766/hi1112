package com.pb.hibernate.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pb.hibernate.dao.LoginDao;
import com.pb.hibernate.po.Login;
import com.pb.hibernate.util.HibernateUtil;

public class LoginDaoImpl implements LoginDao{
	//使用命名SQL调用增、删、改用户的存储过程
	public void doUpdateProc
		(String sqlQueryName,List<Object> params){
		Session session = null;
		session =  HibernateUtil.getSessionFactory().openSession();
		Transaction transaction=session.beginTransaction();
		Query query = 
			session.getNamedQuery(sqlQueryName);
		if(params!=null && params.size()!=0){
			for(int i=0;i<params.size();i++){
				query.setParameter(i, params.get(i));
			}
		}
		
		query.executeUpdate();
		transaction.commit();
		session.close();
	}
		
	//使用命名SQL调用查询用户的存储过程
	public void doSelectProc(String sqlQueryName){
		Session session = null;
		session =  HibernateUtil.getSessionFactory().openSession();
		Query query = 
			session.getNamedQuery(sqlQueryName);
		SQLQuery query2=session.createSQLQuery("login_getlist").addEntity(Login.class);
		List<Login> list = query2.list();
		System.out.println("用户信息如下：");
	    for(Login login:list){
	    	System.out.println(login.getUsername()+"---"+login.getPassword()+"---"+login.getAge());
	    }
		session.close();
	}
}
