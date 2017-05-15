package com.zrgk.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zrgk.entity.User;
/**
 * 原始方式
 * 一个完整的利用hibernate进行db操作的流程
 * @author lsx
 *
 */
public class TestHibernate1 {
	public static void main(String[] args) {
		//1.加载主配置文件
		Configuration conf = 
			new Configuration().configure("hibernate.cfg.xml");
		//2.获取session工厂
		SessionFactory sf = conf.buildSessionFactory();
		//3.根据session工厂对象 获取一个session对象   
		// session对象是对原始Connection对象的封装
		Session session = sf.openSession();
		// 4.开启事务  对于增删改 需要打开事务
		Transaction tx = session.beginTransaction();
		User u = new User();
		u.setId(7);
		u.setAge(30);
		u.setEmail("guojing@163.com");
		u.setName("低调低调");
		u.setBirthday(new Date());
		u.setSalary(4000.75);
		//5.对User对象进行操作
		session.save(u);
	
		tx.commit();// 事务提交
		// 查询   
//		User u  = (User)session.get(User.class,3);
//		System.out.println(u.getName());
		// 删除
		//User u2 = (User)session.get(User.class,3);
//		User u2 = new User();
//		u2.setId(3);
//		session.delete(u2);
		// 修改 事务要重新开始
		tx.begin();
		User u3  = (User)session.get(User.class, 7);
		System.out.println("修改前："+u3.getName());
		u3.setName("小龙女");
		u3.setAge(120);
		session.update(u3);
		System.out.println("修改后："+u3.getName());
		tx.commit();//本例分别提交
		session.close();
		sf.close();
	}

}
