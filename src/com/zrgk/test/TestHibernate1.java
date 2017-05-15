package com.zrgk.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zrgk.entity.User;
/**
 * ԭʼ��ʽ
 * һ������������hibernate����db����������
 * @author lsx
 *
 */
public class TestHibernate1 {
	public static void main(String[] args) {
		//1.�����������ļ�
		Configuration conf = 
			new Configuration().configure("hibernate.cfg.xml");
		//2.��ȡsession����
		SessionFactory sf = conf.buildSessionFactory();
		//3.����session�������� ��ȡһ��session����   
		// session�����Ƕ�ԭʼConnection����ķ�װ
		Session session = sf.openSession();
		// 4.��������  ������ɾ�� ��Ҫ������
		Transaction tx = session.beginTransaction();
		User u = new User();
		u.setId(7);
		u.setAge(30);
		u.setEmail("guojing@163.com");
		u.setName("�͵��͵�");
		u.setBirthday(new Date());
		u.setSalary(4000.75);
		//5.��User������в���
		session.save(u);
	
		tx.commit();// �����ύ
		// ��ѯ   
//		User u  = (User)session.get(User.class,3);
//		System.out.println(u.getName());
		// ɾ��
		//User u2 = (User)session.get(User.class,3);
//		User u2 = new User();
//		u2.setId(3);
//		session.delete(u2);
		// �޸� ����Ҫ���¿�ʼ
		tx.begin();
		User u3  = (User)session.get(User.class, 7);
		System.out.println("�޸�ǰ��"+u3.getName());
		u3.setName("С��Ů");
		u3.setAge(120);
		session.update(u3);
		System.out.println("�޸ĺ�"+u3.getName());
		tx.commit();//�����ֱ��ύ
		session.close();
		sf.close();
	}

}
