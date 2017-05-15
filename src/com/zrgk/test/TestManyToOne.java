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
 * ѧ��---���꼶  ���һ
 * @author lsx
 *
 */
public class TestManyToOne {
	@Test
	public void testAdd() {////�������
		Session session = HibernateUtil1.getSession();
		Grade g = new Grade();
		g.setGdesc("java1412");
		g.setGname("һ�꼶");

		Student s2 = new Student();
		s2.setSex("m");
		s2.setSname("����");
		Student s3 = new Student();
		s3.setSex("m");
		s3.setSname("����");
		Student s4 = new Student();
		s4.setSex("m");
		s4.setSname("����");
		//�໥֮�䶼Ҫ��Ӻù�ϵ
		g.getStudents().add(s2);
		g.getStudents().add(s3);
		g.getStudents().add(s4);

		s2.setGrade(g);
		s3.setGrade(g);
		s4.setGrade(g);

		Transaction tx = session.beginTransaction();
		session.save(g);
		// ע������ֻ�����ü����Ļ���
		// �ſ���ֻͨ��һ��save(g)����ɹ�
		// ����ͱ����Ȳ���ѧ������ִ�в���༶�ɹ�
		tx.commit();
		HibernateUtil1.closeSession();
	}
	// ���ü������
		@Test
		public void testAdd2(){
			Session session = HibernateUtil1.getSession();
			Transaction tx = session.beginTransaction();
			Grade g = new Grade();
			g.setGdesc("java1414�Ǹ��ð༶");
			g.setGname("java1414");
			
			Student s1 = new Student();
			s1.setSex("m");
			s1.setSname("�Ƿ�");
			
			
			Student s2 = new Student();
			s2.setSex("m");
			s2.setSname("����");
			
			//��ӹ�ϵ
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
	// �����˼���
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
	// �����˼���
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
	    //����Ҫע�������ǲ��ܱ��޸ĵģ���Ϊ������Ϊ�����Ĳ�ѯ����ڵ�
	    //����������ڵ����壬�������в�����û������ģ���ֻ����Ϊ�ο��������
	    g.setGname("�߼���");
	    session.update(g);
	    Transaction tx = session.beginTransaction();
	    tx.commit();
	    HibernateUtil1.closeSession();
	}
}
