package com.zrgk.dao;



import java.util.List;

import com.zrgk.entity.User;


public interface IUserDao {
	public User findUserById(int id) throws Exception;
	public List<User> findAll() throws Exception;
	public void deteleUserById(int id) throws Exception;
	public void UpdateUser(User u) throws Exception;
	public void saveUser(User u)throws Exception;
}
