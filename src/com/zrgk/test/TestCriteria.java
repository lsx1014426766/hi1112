package com.zrgk.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.junit.Test;
import com.zrgk.entity.Dept;
import com.zrgk.entity.Emp;
import com.zrgk.util.HibernateUtil1;

public class TestCriteria {
	@Test
	public  void test1(){
		Session session = HibernateUtil1.getSession();
		Criteria c = 
			session.createCriteria(Dept.class);
		//c.add(Restrictions.eq("dname","�з���"));
		// �ȼ��ڣ�    String sql ="select * from dept_myc where dname lile %��%";
		c.add(Restrictions.like("dname", "%��%"));
		List<Dept> list = c.list();
		System.out.println(list.size());
		for(Dept d:list){
			System.out.println(d.getLoc());
		}
	}
	
	@Test
	public  void test2(){
		Session session = HibernateUtil1.getSession();
		Criteria c = session.createCriteria(Emp.class);
		// select * from emp_myc where salary>3000 order by salary desc; 
		c.add(Restrictions.gt("salary", 3000.0));
		//����salary����    ��������
		c.addOrder(Order.desc("salary"));
		List<Emp> list = c.list();
		for(Emp e:list){
			System.out.println(e.getEname());
		}
	}
	
	
	@Test
	public  void test3(){
		Session session = HibernateUtil1.getSession();
		Criteria c = 
			session.createCriteria(Emp.class);
//		c.setProjection(Projections.groupProperty("job"));
//		c.setProjection(Projections.count("bonus"));
//		c.setProjection(Projections.rowCount());
//		c.setProjection(Projections.avg("salary"));
//		c.setProjection(Projections.max("salary"));
//		c.setProjection(Projections.min("salary"));
//		c.setProjection(Projections.avg("salary"));
		c.setProjection(Projections.sum("salary"));
		List<Double> list = c.list();
		for(Double d:list){
			System.out.println(d);
		}
		// �鿴�����з�װ���� ʲô���͵Ķ���
		System.out.println(list.get(0).getClass().getName());
	}
	
	@Test
	public  void test4(){
		Session session = HibernateUtil1.getSession();
		Criteria c = 
			session.createCriteria(Emp.class);
		Emp e = new Emp();
		e.setSalary(3500.0);
//		Criterion cc = Restrictions.eq("salary", 3500);
//		c.add(cc);
		c.add(Example.create(e));
		List list = c.list();
//		Projection pro = Projections.rowCount();
	}
	
	
	@Test
	public  void test5(){
		Session session = HibernateUtil1.getSession();
		Criteria c = 
			session.createCriteria(Emp.class);
		//criteria  ��ҳ
		c.setFirstResult(6);
		c.setMaxResults(5);
		List<Emp> list = c.list();
		for(Emp e:list){
			System.out.println(e.getEname());
		}
	}
	
}
