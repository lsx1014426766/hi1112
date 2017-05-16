package com.zrgk.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import com.zrgk.entity.Emp;
import com.zrgk.util.HibernateUtil1;


public class TestHql1 {
	
	//hql实现 分组+排序
	@Test
	public void test1(){
		Session session = HibernateUtil1.getSession();
		String hql ="select job,count(empno) from Emp   group by job  having  count(empno)>1 order by 2 desc";
		Query query = session.createQuery(hql);
		Iterator<Object []> it = query.iterate();
		while(it.hasNext()){
			Object[] obj = it.next();
			System.out.println("职位："+obj[0]+"人数："+obj[1]);
		}
		session.close();
	}
	
	//hql 实现多个类连接（内连接）   每个员工来自哪个部门（员工名称,部门名称）lsx!!!
	@Test
	public void test2(){
		Session session = HibernateUtil1.getSession();
		//String hql ="select e.ename,d.dname from Emp  e join e.dept d";
		String hql ="select e.ename,d.dname from Dept d join d.emps e";
		Query query = session.createQuery(hql);
		Iterator<Object []> it = query.iterate();
		while(it.hasNext()){
			Object[] obj = it.next();
			System.out.println("姓名："+obj[0]+"部门名称："+obj[1]);
		}
		session.close();
	}
	
	//hql 实现多个类连接（外连接）   每个员工来自哪个部门（员工名称,部门名称）做了外鍵关联
	@Test
	public void test3(){
		Session session = HibernateUtil1.getSession();
		String hql ="select e.ename,nvl(d.dname,'没有部门') from Emp  e left join e.dept d";
		Query query = session.createQuery(hql);
		Iterator<Object []> it = query.iterate();
		while(it.hasNext()){
			Object[] obj = it.next();
			System.out.println("姓名："+obj[0]+"部门名称："+obj[1]);
		}
		session.close();
	}
	//按照部门分组 （部门名称， 部门人数）部门人数超过2人的   再按照部门人数降序
	@Test
	public void test4(){
		Session session = HibernateUtil1.getSession();
		String hql ="select d.dname,count(e.empno) from Emp e right join e.dept d  group by d.dname having count(e.empno)>=2 order by count(e.empno) desc";
		Query query = session.createQuery(hql);
		Iterator<Object []> it = query.iterate();
		while(it.hasNext()){
			Object[] obj = it.next();
			System.out.println("部门名称："+obj[0]+"部门人数："+obj[1]);
		}
		session.close();
	}
	//按照部门分组（部门名称，平均薪水）   平均薪水>=5000    按照平均薪水降序排序
	@Test
	public void test5(){
		Session session = HibernateUtil1.getSession();
		String hql ="select d.dname,round(avg(e.salary),0) from Emp e right join e.dept d  group by d.dname having avg(e.salary)>=5000 order by 2 desc";
		Query query = session.createQuery(hql);
		Iterator<Object []> it = query.iterate();
		while(it.hasNext()){
			Object[] obj = it.next();
			System.out.println("部门名称："+obj[0]+":部门平均薪水："+obj[1]);
		}
		session.close();
	}
	
	//hql分页
	@Test
	public  void test6(){
		Session session = HibernateUtil1.getSession();
		String hql ="from Emp";
		Query query = session.createQuery(hql);
		// 当前页开始的序号
		query.setFirstResult(5);
		//每页显示多少条
		query.setMaxResults(5);
		List<Emp> list = query.list();
		for(Emp e:list){
			System.out.println(e.getEname());
		}
		session.close();
	}
}
