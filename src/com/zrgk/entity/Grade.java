package com.zrgk.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

//ѧ����
public class Grade implements Serializable {
	// gid�������ԣ�
	private int gid;
	private String gname;
	private String gdesc;
	//��ӹ�ϵ����  ���һ���༶���ѧ��
	private Set<Student> students=new HashSet<Student>();
	public Grade() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Grade(int gid, String gname, String gdesc) {
		super();
		this.gid = gid;
		this.gname = gname;
		this.gdesc = gdesc;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public String getGdesc() {
		return gdesc;
	}
	public void setGdesc(String gdesc) {
		this.gdesc = gdesc;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	

}
