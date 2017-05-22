package com.zrgk.cache;

import org.hibernate.Session;

import com.zrgk.entity.Emp;
import com.zrgk.util.HibernateUtil1;

//一级缓存(默认是开启的)
public class TestOneLevelCache {
	public static void main(String[] args) {
		Session session =
			HibernateUtil1.getSession();
		Emp e = (Emp)session.get(Emp.class, 1001);
		System.out.println(e.getEname());
		// 从一级缓存中  不会访问数据库
		Emp e2= (Emp)session.get(Emp.class, 1001);
		System.out.println(e2.getEname());
		
		Emp e3= (Emp)session.get(Emp.class, 1012);
		System.out.println(e3.getEname());
		session.close();// session关闭就将session缓存中的数据清空
//		session.clear(); 清空session一级缓存中的数据
		System.out.println("------------------");
		session= HibernateUtil1.getSession();
		Emp e4 = (Emp)session.get(Emp.class, 1001);
	}
}
