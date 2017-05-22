package com.zrgk.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.zrgk.entity.Paper;
import com.zrgk.entity.Student;
import com.zrgk.util.HibernateUtil1;
//学生---学生证  一对一
public class TestOneToOne {
	@Test
	public void testAdd() {
		Session session = HibernateUtil1.getSession();
		Student s = new Student();
		s.setSex("m");
		s.setSname("笑笑");
		Paper p = new Paper();
		p.setPdesc("小学生");
		// 添加关系 双向关系
		s.setPaper(p);
		p.setStudent(s);
		Transaction tx = session.beginTransaction();
		session.save(s);
		session.save(p);// 如果设置了级联，就可以不用在这里插入p了
		tx.commit();
		HibernateUtil1.closeSession();
	}

	@Test
	// 设置了级联
	public void testAdd2() {
		Session session = HibernateUtil1.getSession();
		Student s = new Student();
		s.setSex("m");
		s.setSname("青青");
		Paper p = new Paper();
		p.setPdesc("初中生证");
		// 添加关系 双向关系
		s.setPaper(p);
		p.setStudent(s);
		Transaction tx = session.beginTransaction();
		session.save(s);
		// session.save(p);//如果设置了级联，就可以不用在这里插入p了
		tx.commit();
		HibernateUtil1.closeSession();
	}
	@Test
	public void testFind() {
		Session session = HibernateUtil1.getSession();
		Student s = (Student) session.get(Student.class, 1);
		Paper p = s.getPaper();
		System.out.println(s.getSname() + "_________" + p.getPdesc());
		HibernateUtil1.closeSession();
	}
}
