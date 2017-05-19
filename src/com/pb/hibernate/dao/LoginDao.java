package com.pb.hibernate.dao;

import java.util.List;

public interface LoginDao {
	//...省略其他方法...
	//使用命名SQL调用增、删、改用户的存储过程
	public void doUpdateProc(String sqlQueryName,List<Object> params);
	//使用命名SQL调用查询用户的存储过程
	public void doSelectProc(String sqlQueryName);
}
