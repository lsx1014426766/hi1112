package com.zrgk.test;

import org.hibernate.Session;

import com.zrgk.entity.User;
import com.zrgk.util.HibernateUtil1;

//������
public class TestLazy {
	public static void main(String[] args) {
		Session session = HibernateUtil1.getSession();
		// ��������get����
		//User u1 = (User)session.get(User.class, 1);
		//�ӳټ��� (������)load���� ��ʱ�õ����Ǵ������debug�鿴����ֵ��Ϊ��
		User u = (User)session.load(User.class, 1);
		//System.out.println(u.getName());//��Ҫʱ��ȥ��
//		session.close();//  session������ǰ�ر� 
//		System.out.println(u.getId());//1
//		System.out.println(u.getName());
	}

}
