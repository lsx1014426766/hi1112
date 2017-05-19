package com.pb.hibernate.po;

//用户信息
public class Login {
	private String username;
	private String password;
	private int age;
	public Login() {
	}
	public Login(String username, String password, int age) {
		super();
		this.username = username;
		this.password = password;
		this.age = age;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
}
