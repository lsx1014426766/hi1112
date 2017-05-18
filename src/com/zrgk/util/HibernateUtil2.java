package com.zrgk.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
		//另一种获取session的方法   
				//只是获取session的方法不同，用线程，一个用户只使用一个sesion对象
				//用本地线程控制session的创建，将session放在了threadLocal中

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
