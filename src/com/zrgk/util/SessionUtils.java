package com.zrgk.util;



import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
/**
 *劣：这种方法，在每次操作时都要重新打开session
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
 //获取事务
 public static Transaction getTransaction(){
	Transaction ts = SessionUtils.getSession().beginTransaction();
	 return ts;
 }

}
