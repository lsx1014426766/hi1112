package com.zrgk.entity;

import java.io.Serializable;

//ѧ����
public class Student implements Serializable {
	// sid��������
	private int sid;
	private String sname;
	private String sex;
	// ��ӹ�ϵ���� ��ǰ�����ѧ��ӵ�����ѧ��֤
	private Paper paper;
	//��ӹ�ϵ����  �����ѧ����һ���༶
	private Grade grade;
	// ���gid����Ͳ�д�ˣ�ֻ������ά����ϵ��
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
