package com.zrgk.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.zrgk.entity.Dept;

//批量插入操作
public class TestBatch {
	public static void main(String[] args) {
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Transaction tran = session.beginTransaction();
		for ( int i=1; i<=5; i++ ) {
			Dept dept = new Dept();
			dept.setDeptno(40+i);
			dept.setDname("组织"+i+"部");
			dept.setLoc("西安"+i);
			session.save(dept);
			if ( i % 5 == 0 ) { //单次批量操作的数目为5,与hibenate.cfg.xml中的JDBC批量数设置相同
				session.flush();//清理缓存，执行批量插入5条记录的SQL语句
				session.clear();//清空缓存中的Dept对象
			}
		}  
		tran.commit();
		session.close();
	}

}
