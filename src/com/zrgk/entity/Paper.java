package com.zrgk.entity;

import java.io.Serializable;

//学生证类
public class Paper implements Serializable {
	private int pid;
	private String pdesc;
	// hibernate面向对象，配置关系属性，说明当前学生证对象属于这个学生
	private Student student;

	public Paper() {
		super();
	}

	public Paper(int pid, String pdesc) {
		super();
		this.pid = pid;
		this.pdesc = pdesc;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPdesc() {
		return pdesc;
	}

	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
