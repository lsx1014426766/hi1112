package com.zrgk.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import com.zrgk.entity.Emp;
import com.zrgk.util.HibernateUtil1;


public class TestHql1 {
	
	//hqlʵ�� ����+����
	@Test
	public void test1(){
		Session session = HibernateUtil1.getSession();
		String hql ="select job,count(empno) from Emp   group by job  having  count(empno)>1 order by 2 desc";
		Query query = session.createQuery(hql);
		Iterator<Object []> it = query.iterate();
		while(it.hasNext()){
			Object[] obj = it.next();
			System.out.println("ְλ��"+obj[0]+"������"+obj[1]);
		}
		session.close();
	}
	
	//hql ʵ�ֶ�������ӣ������ӣ�   ÿ��Ա�������ĸ����ţ�Ա������,�������ƣ�lsx!!!
	@Test
	public void test2(){
		Session session = HibernateUtil1.getSession();
		//String hql ="select e.ename,d.dname from Emp  e join e.dept d";
		String hql ="select e.ename,d.dname from Dept d join d.emps e";
		Query query = session.createQuery(hql);
		Iterator<Object []> it = query.iterate();
		while(it.hasNext()){
			Object[] obj = it.next();
			System.out.println("������"+obj[0]+"�������ƣ�"+obj[1]);
		}
		session.close();
	}
	
	//hql ʵ�ֶ�������ӣ������ӣ�   ÿ��Ա�������ĸ����ţ�Ա������,�������ƣ��������I����
	@Test
	public void test3(){
		Session session = HibernateUtil1.getSession();
		String hql ="select e.ename,nvl(d.dname,'û�в���') from Emp  e left join e.dept d";
		Query query = session.createQuery(hql);
		Iterator<Object []> it = query.iterate();
		while(it.hasNext()){
			Object[] obj = it.next();
			System.out.println("������"+obj[0]+"�������ƣ�"+obj[1]);
		}
		session.close();
	}
	//���ղ��ŷ��� ���������ƣ� ����������������������2�˵�   �ٰ��ղ�����������
	@Test
	public void test4(){
		Session session = HibernateUtil1.getSession();
		String hql ="select d.dname,count(e.empno) from Emp e right join e.dept d  group by d.dname having count(e.empno)>=2 order by count(e.empno) desc";
		Query query = session.createQuery(hql);
		Iterator<Object []> it = query.iterate();
		while(it.hasNext()){
			Object[] obj = it.next();
			System.out.println("�������ƣ�"+obj[0]+"����������"+obj[1]);
		}
		session.close();
	}
	//���ղ��ŷ��飨�������ƣ�ƽ��нˮ��   ƽ��нˮ>=5000    ����ƽ��нˮ��������
	@Test
	public void test5(){
		Session session = HibernateUtil1.getSession();
		String hql ="select d.dname,round(avg(e.salary),0) from Emp e right join e.dept d  group by d.dname having avg(e.salary)>=5000 order by 2 desc";
		Query query = session.createQuery(hql);
		Iterator<Object []> it = query.iterate();
		while(it.hasNext()){
			Object[] obj = it.next();
			System.out.println("�������ƣ�"+obj[0]+":����ƽ��нˮ��"+obj[1]);
		}
		session.close();
	}
	
	//hql��ҳ
	@Test
	public  void test6(){
		Session session = HibernateUtil1.getSession();
		String hql ="from Emp";
		Query query = session.createQuery(hql);
		// ��ǰҳ��ʼ�����
		query.setFirstResult(5);
		//ÿҳ��ʾ������
		query.setMaxResults(5);
		List<Emp> list = query.list();
		for(Emp e:list){
			System.out.println(e.getEname());
		}
		session.close();
	}
}
