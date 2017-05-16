package com.zrgk.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Course implements Serializable {
	private int cid;
	private String cname;
	private String cdesc;
	
	//关系属性   一个课程可以被多个学生选
	private Set<Student>  students = 
		new HashSet<Student>();
	
	public Course() {
	}


	public int getCid() {
		return cid;
	}


	public void setCid(int cid) {
		this.cid = cid;
	}


	public String getCname() {
		return cname;
	}


	public void setCname(String cname) {
		this.cname = cname;
	}


	public String getCdesc() {
		return cdesc;
	}


	public void setCdesc(String cdesc) {
		this.cdesc = cdesc;
	}


	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	
}
