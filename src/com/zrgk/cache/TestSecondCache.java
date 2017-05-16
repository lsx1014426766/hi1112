package com.zrgk.cache;

import org.hibernate.Session;
import com.zrgk.entity.Emp;
import com.zrgk.util.HibernateUtil1;


//��������(��ʵ����SessionFactory����Ļ��棬Ĭ���ǹرյ�)
//�����session���� 
public class TestSecondCache {
	public static void main(String[] args) {
		Session session = HibernateUtil1.getSession();
		Emp e = (Emp)session.get(Emp.class, 1001);
		System.out.println(e.getEname());
		session.close();
		session = HibernateUtil1.getSession();
		e =(Emp)session.get(Emp.class, 1001);
		System.out.println(e.getEname());
	}
}
