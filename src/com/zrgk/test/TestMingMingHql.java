package com.zrgk.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import com.zrgk.entity.Emp;
import com.zrgk.util.HibernateUtil1;
//命名化hql
public class TestMingMingHql {
	@Test
	public void test1(){
		Session session = HibernateUtil1.getSession();
		Query query = session.getNamedQuery("findEmpByHql");
		query.setString(0,"张三丰");
		query.setDouble(1, 15000.0);
		List<Emp> list = query.list();
		for(Emp e:list){
			System.out.println(e.getEname());
		}
	}
}
