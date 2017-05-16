package com.zrgk.test;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;
import com.zrgk.entity.Student;
import com.zrgk.util.HibernateUtil1;
// hql���
public class TestHql {
	// ��ѯ���е����Ե�ֵ
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
	
	// ��ѯ�������Ե�ֵ   ���ص�ֵObject��������
	@Test
	public void test2(){
		Session session = HibernateUtil1.getSession();
		String hql ="select sname,sex from Student";
		Query query = session.createQuery(hql);
		List<Object[]> list = query.list();
		for(Object [] obj:list){
			System.out.println("������"+obj[0]+"�Ա�"+obj[1]);
			
		}
	}
	// ��ѯ�������Ե�ֵ   ���ص�Student����
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
		// hibernate�ʺ��Ǵ�0��ʼ ���ʺ�����ֵ
//		query.setString(0,"��Ī��");
//		query.setString(1,"m ");
		query.setString("name", "��Ī��");
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
