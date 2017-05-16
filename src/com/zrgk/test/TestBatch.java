package com.zrgk.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.zrgk.entity.Dept;

//�����������
public class TestBatch {
	public static void main(String[] args) {
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Transaction tran = session.beginTransaction();
		for ( int i=1; i<=5; i++ ) {
			Dept dept = new Dept();
			dept.setDeptno(40+i);
			dept.setDname("��֯"+i+"��");
			dept.setLoc("����"+i);
			session.save(dept);
			if ( i % 5 == 0 ) { //����������������ĿΪ5,��hibenate.cfg.xml�е�JDBC������������ͬ
				session.flush();//�����棬ִ����������5����¼��SQL���
				session.clear();//��ջ����е�Dept����
			}
		}  
		tran.commit();
		session.close();
	}

}
