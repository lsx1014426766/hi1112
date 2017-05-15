package com.zrgk.util;



import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
/**
 *�ӣ����ַ�������ÿ�β���ʱ��Ҫ���´�session
 * @author lsx
 *
 */
public class SessionUtils {
 public static Session getSession(){
	 Configuration configure = new Configuration().configure();
	 SessionFactory sf = configure.buildSessionFactory();
	 Session session = (Session) sf.openSession();
	 return session;
 }
 //��ȡ����
 public static Transaction getTransaction(){
	Transaction ts = SessionUtils.getSession().beginTransaction();
	 return ts;
 }

}
