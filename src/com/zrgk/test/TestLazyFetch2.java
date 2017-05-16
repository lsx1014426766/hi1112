package com.zrgk.test;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import com.zrgk.entity.Dept;
import com.zrgk.util.HibernateUtil1;

public class TestLazyFetch2 {
	public static void main(String[] args) {
		Session session = HibernateUtil1.getSession();
		String hql ="from Dept";
		Query query = session.createQuery(hql);
		List<Dept> list = query.list();
		for(Dept dept:list){
			System.out.println(dept.getDname());
		}
		
	}
}
