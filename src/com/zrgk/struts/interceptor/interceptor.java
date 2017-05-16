package com.zrgk.struts.interceptor;

import org.hibernate.Session;
import org.hibernate.Transaction;



import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.zrgk.util.HibernateUtil1;


public class interceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation arg0) throws Exception {
		String resultCode="";
		Session session = HibernateUtil1.getSession();
		Transaction tx=session.beginTransaction();
		try{
			resultCode = arg0.invoke();
			tx.commit();
		}catch(Exception e){
		  e.printStackTrace();
		  tx.rollback();
		}finally{
			HibernateUtil1.closeSession();
		}
		return resultCode;
	}

}
