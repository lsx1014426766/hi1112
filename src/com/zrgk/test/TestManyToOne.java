package com.zrgk.test;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.zrgk.entity.Grade;
import com.zrgk.entity.Paper;
import com.zrgk.entity.Student;
import com.zrgk.util.HibernateUtil1;
/**
 * 学生---》年级  多对一
 * @author lsx
 *
 */
public class TestManyToOne {
	@Test
	public void testAdd() {////级联添加
		Session session = HibernateUtil1.getSession();
		Grade g = new Grade();
		g.setGdesc("java1412");
		g.setGname("一年级");

		Student s2 = new Student();
		s2.setSex("m");
		s2.setSname("丽云");
		Student s3 = new Student();
		s3.setSex("m");
		s3.setSname("金名");
		Student s4 = new Student();
		s4.setSex("m");
		s4.setSname("蓬蓬");
		//相互之间都要添加好关系
		g.getStudents().add(s2);
		g.getStudents().add(s3);
		g.getStudents().add(s4);

		s2.setGrade(g);
		s3.setGrade(g);
		s4.setGrade(g);

		Transaction tx = session.beginTransaction();
		session.save(g);
		// 注意这里只有设置级联的话，
		// 才可以只通过一次save(g)插入成功
		// 否则就必须先插入学生才能执行插入班级成功
		tx.commit();
		HibernateUtil1.closeSession();
	}
	// 不用级联添加
		@Test
		public void testAdd2(){
			Session session = HibernateUtil1.getSession();
			Transaction tx = session.beginTransaction();
			Grade g = new Grade();
			g.setGdesc("java1414是个好班级");
			g.setGname("java1414");
			
			Student s1 = new Student();
			s1.setSex("m");
			s1.setSname("乔峰");
			
			
			Student s2 = new Student();
			s2.setSex("m");
			s2.setSname("段誉");
			
			//添加关系
			g.getStudents().add(s1);
			g.getStudents().add(s2);
			s1.setGrade(g);
			s2.setGrade(g);
			
			session.save(g);
			session.save(s1);
			session.save(s2);
			tx.commit();
			session.close();
		}

	@Test
	// 设置了级联
	public void testFind() {
		Session session = HibernateUtil1.getSession();
		Grade g = (Grade) session.get(Grade.class, 20);
		Set<Student> ss = g.getStudents();
		for (Student s : ss) {
			System.out.println(s.getSname());
		}
		HibernateUtil1.closeSession();
	}

	@Test
	// 设置了级联
	public void testDelete() {
		Session session = HibernateUtil1.getSession();
		Grade g = (Grade) session.get(Grade.class, 20);
		Transaction tx = session.beginTransaction();
		session.delete(g);
		tx.commit();
		HibernateUtil1.closeSession();
	}
	@Test
	public void testUpdate(){
		Session session = HibernateUtil1.getSession();
	    Grade g =(Grade) session.get(Grade.class, 24);
	    System.out.println("dffdsfs"+g.getGname());
	    //这里要注意主键是不能被修改的，因为它是作为操作的查询项存在的
	    //这就是它存在的意义，对它进行操作是没有意义的，它只能作为参考项，关联项
	    g.setGname("高级班");
	    session.update(g);
	    Transaction tx = session.beginTransaction();
	    tx.commit();
	    HibernateUtil1.closeSession();
	}
}
