package com.zrgk.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.zrgk.entity.Paper;
import com.zrgk.entity.Student;
import com.zrgk.util.HibernateUtil1;
//ѧ��---ѧ��֤  һ��һ
public class TestOneToOne {
	@Test
	public void testAdd() {
		Session session = HibernateUtil1.getSession();
		Student s = new Student();
		s.setSex("m");
		s.setSname("ЦЦ");
		Paper p = new Paper();
		p.setPdesc("Сѧ��");
		// ��ӹ�ϵ ˫���ϵ
		s.setPaper(p);
		p.setStudent(s);
		Transaction tx = session.beginTransaction();
		session.save(s);
		session.save(p);// ��������˼������Ϳ��Բ������������p��
		tx.commit();
		HibernateUtil1.closeSession();
	}

	@Test
	// �����˼���
	public void testAdd2() {
		Session session = HibernateUtil1.getSession();
		Student s = new Student();
		s.setSex("m");
		s.setSname("����");
		Paper p = new Paper();
		p.setPdesc("������֤");
		// ��ӹ�ϵ ˫���ϵ
		s.setPaper(p);
		p.setStudent(s);
		Transaction tx = session.beginTransaction();
		session.save(s);
		// session.save(p);//��������˼������Ϳ��Բ������������p��
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
