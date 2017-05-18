package com.zrgk.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
		//��һ�ֻ�ȡsession�ķ���   
				//ֻ�ǻ�ȡsession�ķ�����ͬ�����̣߳�һ���û�ֻʹ��һ��sesion����
				//�ñ����߳̿���session�Ĵ�������session������threadLocal��

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
