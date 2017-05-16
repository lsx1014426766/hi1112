package com.zrgk.test;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.junit.Test;

import com.zrgk.entity.Emp;
import com.zrgk.util.HibernateUtil1;
//������sql
public class TestMingMinSql {
	@Test
	public void test1(){
		Session session = HibernateUtil1.getSession();
		// ������sql���  ��QueryǿתΪSQLQuery
		SQLQuery query = (SQLQuery)session.getNamedQuery("findUserBySql");
		query.setString(0, "������");
		query.setDouble(1, 15000.0);
		List<Emp>list = query.list();
		for(Emp e:list){
			System.out.println(e.getEname());
		}
	}
}
