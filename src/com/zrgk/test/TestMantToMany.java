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
		s.setSname("���2");
		s.setSex("m");
		
		Student s2 = new Student();
		s2.setSname("С��Ů2");
		s2.setSex("f");
		
		Course c1 = new Course();
		c1.setCdesc("����һ��web��Mvc���");
		c1.setCname("struts22");
		
		Course c2 = new Course();
		c2.setCdesc("����һ���־ò���");
		c2.setCname("hibernate2");
		
		
		//��ӹ�ϵ
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
	
	
	//��������  cascade="all"
	@Test
	public  void testAdd2(){
		Transaction tx = session.beginTransaction();
		Student s = new Student();
		s.setSname("���3");
		s.setSex("m");
		
		Student s2 = new Student();
		s2.setSname("С��Ů3");
		s2.setSex("f");
		
		Course c1 = new Course();
		c1.setCdesc("����һ��web��Mvc���");
		c1.setCname("struts222");
		
		Course c2 = new Course();
		c2.setCdesc("����һ���־ò���");
		c2.setCname("hibernate22");
		
		
		//��ӹ�ϵ
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
