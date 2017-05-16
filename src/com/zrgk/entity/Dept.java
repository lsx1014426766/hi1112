package com.zrgk.entity;
// default package

import java.util.HashSet;
import java.util.Set;



/**
 * Dept entity. @author MyEclipse Persistence Tools
 */

public class Dept  implements java.io.Serializable {


    // Fields    

     private int deptno;
     private String dname;
     private String loc;
     private Set<Emp> emps = new HashSet<Emp>();


    // Constructors

    /** default constructor */
    public Dept() {
    }

	/** minimal constructor */
    public Dept(int deptno) {
        this.deptno = deptno;
    }
    
    /** full constructor */
    public Dept(int deptno, String dname, String loc, Set<Emp> emps) {
        this.deptno = deptno;
        this.dname = dname;
        this.loc = loc;
        this.emps = emps;
    }

   
    // Property accessors
    

    public String getDname() {
        return this.dname;
    }
    
    public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}


	public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return this.loc;
    }
    
    public void setLoc(String loc) {
        this.loc = loc;
    }

	public Set<Emp> getEmps() {
		return emps;
	}

	public void setEmps(Set<Emp> emps) {
		this.emps = emps;
	}
}