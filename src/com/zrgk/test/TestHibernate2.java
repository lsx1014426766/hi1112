package com.zrgk.test;

import org.hibernate.Session;

import com.zrgk.entity.User;
import com.zrgk.util.HibernateUtil1;


public class TestHibernate2 {

	/**采用工具类抽离封装的方式
	 * @param args
	 */
	public static void main(String[] args) {
		Session session = HibernateUtil1.getSession();
		User u = (User)session.get(User.class, 1);
		System.out.println(u.getName());
	}

}
