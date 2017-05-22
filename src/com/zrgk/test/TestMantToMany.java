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
	/**
	 * hibernate插入操作Field "SID" do not have a default value
	 */
	
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
	/**
	 *  An association from the table sc refers to an unmapped class: com.zrgk.entity.Course
	 *  原因：在hibernate.cfg.xml中没有配置Course.xml的映射文件
	 *  
	 *  native
根据底层数据库的能力选择 identity、sequence 或者 hilo 中的一个;

也就是说，主键生成，由hibernate选择
对于内部支持标识字段的数据库（DB2、MySQL、Sybase 和 MS SQL），你可以使用 identity 关
键字生成。对于内部支持序列的数据库（DB2、Oracle、PostgreSQL、Interbase、McKoi 和 SAP
DB），你可以使用 sequence 风格的关键字生成。这两种方式对于插入一个新的对象都需要两次
SQL 查询。

问题：我的Cource在db层面没有生成自增标识 还是表创建有了问题
	 */
	
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
