package com.zrgk.entity;

import java.io.Serializable;

//ѧ��֤��
public class Paper implements Serializable {
	private int pid;
	private String pdesc;
	// hibernate����������ù�ϵ���ԣ�˵����ǰѧ��֤�����������ѧ��
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
