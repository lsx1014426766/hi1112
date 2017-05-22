package com.zrgk.cache;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;

import com.zrgk.entity.Emp;
import com.zrgk.util.HibernateUtil1;

//查询缓存 可以缓存 hql查询出来的对象
public class TestQueryCache {
	public static void main(String[] args) {
		Session session = HibernateUtil1.getSession();
		String hql ="from Emp where ename=?";
		Query query = session.createQuery(hql);
		//确认  使用查询缓存 
		query.setCacheable(true);
		query.setString(0, "张无忌");
		Emp e= (Emp)query.uniqueResult();
		System.out.println(e.getEname());
		
		String  hql2 ="from Emp where ename=?";
		Query query2 = session.createQuery(hql2);
		
		
		query2.setCacheable(true);
		query2.setString(0, "张无忌");
		Emp e2 = (Emp)query2.uniqueResult();
		System.out.println(e2.getEname());
		
		//管理 缓存
		//session.evict(e);
		//sf.evict(e);
		
		// 锁机制  悲观锁
		//session.get(Emp.class, 1001,LockMode.UPGRADE);
		
	}

}
