package com.zrgk.test;

import org.hibernate.Session;

import com.zrgk.entity.User;
import com.zrgk.util.HibernateUtil1;

//懒加载
public class TestLazy {
	public static void main(String[] args) {
		Session session = HibernateUtil1.getSession();
		// 立即加载get方法// 立即加载   注意这里的id是存在的才可以，否则调用时找不到会报空指针异常的！
		//User u1 = (User)session.get(User.class, 1);
		//延迟加载 (懒加载)load方法 此时得到的是代理对象，debug查看属性值皆为空
		//延迟加载 (懒加载)   调用时找不到会报org.hibernate.ObjectNotFoundException:

		User u = (User)session.load(User.class, 1);
		//System.out.println(u.getName());//需要时再去查
//		session.close();//  session不能提前关闭 
//		System.out.println(u.getId());//1
//		System.out.println(u.getName());
	}

}
