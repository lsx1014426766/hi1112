package com.zrgk.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.ThreadLocalSessionContext;

// 获取session对象的工具类
public class HibernateUtil2 {
	//将当前用户的session对象绑定到threadLocal上
	private static ThreadLocal<Session> threadLocal = 
				  new ThreadLocal<Session>();
	private static SessionFactory sf;
	static{
		sf = new Configuration().configure().buildSessionFactory();
	}
	
	public static Session  getSession(){
		Session session = threadLocal.get();
		if(session==null || !session.isOpen()){
			// 第一次连接数据库
			session = sf.openSession();
			//将session存放到threadLocal中  方便下次操作获取
			threadLocal.set(session);
		}
		return session;
	}
	
	public static  void  closeSession(){
		Session session = threadLocal.get();
		if(session!=null){
			threadLocal.set(null);
			session.close();
		}
	}
}
