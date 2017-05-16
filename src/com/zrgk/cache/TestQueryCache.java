package com.zrgk.cache;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;

import com.zrgk.entity.Emp;
import com.zrgk.util.HibernateUtil1;

//��ѯ���� ���Ի��� hql��ѯ�����Ķ���
public class TestQueryCache {
	public static void main(String[] args) {
		Session session = HibernateUtil1.getSession();
		String hql ="from Emp where ename=?";
		Query query = session.createQuery(hql);
		//ȷ��  ʹ�ò�ѯ���� 
		query.setCacheable(true);
		query.setString(0, "���޼�");
		Emp e= (Emp)query.uniqueResult();
		System.out.println(e.getEname());
		
		String  hql2 ="from Emp where ename=?";
		Query query2 = session.createQuery(hql2);
		
		
		query2.setCacheable(true);
		query2.setString(0, "���޼�");
		Emp e2 = (Emp)query2.uniqueResult();
		System.out.println(e2.getEname());
		
		//���� ����
		//session.evict(e);
		//sf.evict(e);
		
		// ������  ������
		//session.get(Emp.class, 1001,LockMode.UPGRADE);
		
	}

}
