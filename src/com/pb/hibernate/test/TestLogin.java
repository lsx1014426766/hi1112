package com.pb.hibernate.test;

import java.util.ArrayList;
import java.util.List;

import com.pb.hibernate.dao.impl.LoginDaoImpl;
/**
 * pb包用来测试存储过程的调用
 * @author lsx
 *
 */
public class TestLogin {
	public static void main(String[] args) {
		//示例4：编写存储过程实现用户的增、删、改、查功能，使用命名SQL调用各存储过程
		LoginDaoImpl loginDaoImpl=new LoginDaoImpl();
		//增加用户信息
		/*List<Object> params=new ArrayList<Object>();
		params.add("newPerson");
		params.add("526897");
		params.add("30");
		loginDaoImpl.doUpdateProc("loginInsert", params);*/
		//修改用户信息
		/*List<Object> params2=new ArrayList<Object>();
		params2.add(25);
		loginDaoImpl.doUpdateProc("loginUpdate", params2);*/
		//删除特定用户信息
		/*List<Object> params3=new ArrayList<Object>();
		params3.add("newPerson");
		loginDaoImpl.doUpdateProc("loginDelete", params3);*/
		//查询用户信息
		loginDaoImpl.doSelectProc("loginGetList");
	}
}
