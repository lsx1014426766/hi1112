package com.zrgk.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.zrgk.entity.Course;
import com.zrgk.entity.Student;
import com.zrgk.util.HibernateUtil1;

public class TestMantToMany {
	Session session = null;
	
	
	@Before
	public void beforeMethod(){
		session= HibernateUtil1.getSession();
	}
	
	
	@Test
	public  void testAdd(){
		Transaction tx = session.beginTransaction();
		Student s = new Student();
		s.setSname("杨过2");
		s.setSex("m");
		
		Student s2 = new Student();
		s2.setSname("小龙女2");
		s2.setSex("f");
		
		Course c1 = new Course();
		c1.setCdesc("这是一个web的Mvc框架");
		c1.setCname("struts22");
		
		Course c2 = new Course();
		c2.setCdesc("这是一个持久层框架");
		c2.setCname("hibernate2");
		
		
		//添加关系
		s.getCourses().add(c1);
		s.getCourses().add(c2);
		s2.getCourses().add(c1);
		s2.getCourses().add(c2);
		
		c1.getStudents().add(s);
		c1.getStudents().add(s2);
		c2.getStudents().add(s);
		c2.getStudents().add(s2);
		session.save(s);
		session.save(s2);
		session.save(c1);
		session.save(c2);
		tx.commit();
	}
	
	
	//级联插入  cascade="all"
	@Test
	public  void testAdd2(){
		Transaction tx = session.beginTransaction();
		Student s = new Student();
		s.setSname("杨过3");
		s.setSex("m");
		
		Student s2 = new Student();
		s2.setSname("小龙女3");
		s2.setSex("f");
		
		Course c1 = new Course();
		c1.setCdesc("这是一个web的Mvc框架");
		c1.setCname("struts222");
		
		Course c2 = new Course();
		c2.setCdesc("这是一个持久层框架");
		c2.setCname("hibernate22");
		
		
		//添加关系
		s.getCourses().add(c1);
		s.getCourses().add(c2);
		s2.getCourses().add(c1);
		s2.getCourses().add(c2);
		
		c1.getStudents().add(s);
		c1.getStudents().add(s2);
		c2.getStudents().add(s);
		c2.getStudents().add(s2);
		session.save(s);
		session.save(s2);
		tx.commit();
	}
	
	
	
	
	
	@After
	public  void  afterMethod(){
		session.close();
	}
	

}
