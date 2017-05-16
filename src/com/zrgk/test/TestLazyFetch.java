package com.zrgk.test;


import org.hibernate.Session;
import com.zrgk.entity.Dept;
import com.zrgk.util.HibernateUtil1;

//在配置文件中设置表Dept lazy属性值，true or false 看运行情况
public class TestLazyFetch {
	public static void main(String[] args) {
		Session session = HibernateUtil1.getSession();
		Dept dept = (Dept)session.get(Dept.class, 10);
		System.out.println(dept.getDname());
//		Set<Emp> emps = dept.getEmps();
//		for(Emp e:emps){
//			System.out.println(e.getEname());
//		}
	}
}
