package com.zrgk.cache;

import org.hibernate.Session;

import com.zrgk.entity.Emp;
import com.zrgk.util.HibernateUtil1;

//һ������(Ĭ���ǿ�����)
public class TestOneLevelCache {
	public static void main(String[] args) {
		Session session =
			HibernateUtil1.getSession();
		Emp e = (Emp)session.get(Emp.class, 1001);
		System.out.println(e.getEname());
		// ��һ��������  ����������ݿ�
		Emp e2= (Emp)session.get(Emp.class, 1001);
		System.out.println(e2.getEname());
		
		Emp e3= (Emp)session.get(Emp.class, 1012);
		System.out.println(e3.getEname());
		session.close();// session�رվͽ�session�����е��������
//		session.clear(); ���sessionһ�������е�����
		System.out.println("------------------");
		session= HibernateUtil1.getSession();
		Emp e4 = (Emp)session.get(Emp.class, 1001);
	}
}
