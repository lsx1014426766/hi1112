package com.zrgk.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.ThreadLocalSessionContext;

// ��ȡsession����Ĺ�����
public class HibernateUtil2 {
	//����ǰ�û���session����󶨵�threadLocal��
	private static ThreadLocal<Session> threadLocal = 
				  new ThreadLocal<Session>();
	private static SessionFactory sf;
	static{
		sf = new Configuration().configure().buildSessionFactory();
	}
	
	public static Session  getSession(){
		Session session = threadLocal.get();
		if(session==null || !session.isOpen()){
			// ��һ���������ݿ�
			session = sf.openSession();
			//��session��ŵ�threadLocal��  �����´β�����ȡ
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
