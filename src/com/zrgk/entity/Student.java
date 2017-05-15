package com.zrgk.entity;

import java.io.Serializable;

//学生类
public class Student implements Serializable {
	// sid主键属性
	private int sid;
	private String sname;
	private String sex;
	// 添加关系属性 当前的这个学生拥有这个学生证
	private Paper paper;
	//添加关系属性  表达多个学生在一个班级
	private Grade grade;
	// 外键gid这里就不写了，只是用来维护关系用
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Student(int sid, String sname, String sex) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.sex = sex;
	}

	public Paper getPaper() {
		return paper;
	}

	public void setPaper(Paper paper) {
		this.paper = paper;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

}
