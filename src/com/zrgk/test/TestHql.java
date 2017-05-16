package com.zrgk.test;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;
import com.zrgk.entity.Student;
import com.zrgk.util.HibernateUtil1;
// hql语句
public class TestHql {
	// 查询所有的属性的值
	@Test
	public void test1(){
		Session session = HibernateUtil1.getSession();
//		String  hql ="from  Student";
		String  hql ="select s from  Student s";
		Query query = session.createQuery(hql);
		List<Student> list = query.list();
//		Iterator it = query.iterate();
		System.out.println(list.size());
		for(Student s:list){
			System.out.println(s.getSname());
		}
	}
	
	// 查询部分属性的值   返回的值Object数组类型
	@Test
	public void test2(){
		Session session = HibernateUtil1.getSession();
		String hql ="select sname,sex from Student";
		Query query = session.createQuery(hql);
		List<Object[]> list = query.list();
		for(Object [] obj:list){
			System.out.println("姓名："+obj[0]+"性别："+obj[1]);
			
		}
	}
	// 查询部分属性的值   返回的Student类型
	@Test
	public void test3(){
		Session session = HibernateUtil1.getSession();
		String hql ="select new Student(sname,sex) from Student";
		Query query = session.createQuery(hql);
		List<Student> list = query.list();
		for(Student s: list){
			System.out.println(s.getSname());
		}
	}
	
	@Test
	public void test4(){
//		String hql ="from Student where sname=? and sex=?";
		String hql ="from Student where sname=:name and sex=:s";
		Session session = HibernateUtil1.getSession();
		Query query = session.createQuery(hql);
		// hibernate问号是从0开始 给问号设置值
//		query.setString(0,"李莫愁");
//		query.setString(1,"m ");
		query.setString("name", "李莫愁");
		query.setString("s", "m ");
		List<Student>  list = query.list();
		System.out.println(list.size());
		for(Student s:list){
			System.out.println(s.getSex());
		}
	}
	@Test
	public void test5(){
		String hql ="select count(*)  from Student";
		Session session = HibernateUtil1.getSession();
		Query query = session.createQuery(hql);
		Long obj = (Long)query.uniqueResult();
	}
}
