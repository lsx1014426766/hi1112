package com.zrgk.test;

import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.junit.Test;
import com.zrgk.entity.Emp;
import com.zrgk.util.HibernateUtil1;
// ����sql
public class TestLocalSql{
	@Test
	public  void  test1(){
		Session session = HibernateUtil1.getSession();
		String sql= "select e.* from emp_myc e";
		// ִ�б���sql
		SQLQuery sqlQuery = 
			session.createSQLQuery(sql);
		// ָ���������ת��Ϊʲô���͵Ķ���
		sqlQuery = sqlQuery.addEntity(Emp.class);
		List<Emp> list = sqlQuery.list();
		for(Emp e:list){
			System.out.println(e.getEname());
		}
		session.close();
	}
}
