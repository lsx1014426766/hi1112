package com.zrgk.entity;
// default package


import java.util.Date;


/**
 * Emp entity. @author MyEclipse Persistence Tools
 */

public class Emp  implements java.io.Serializable {
    // Fields    
     private int empno;
     private String ename;
     private String job;
     private Double salary;
     private Double bonus;
     private Date hiredate;
     private Integer manager;
     //πÿœµ Ù–‘
     private Dept dept;

    // Constructors

    /** default constructor */
    public Emp() {
    }

	/** minimal constructor */
    public Emp(int empno) {
        this.empno = empno;
    }
    
    /** full constructor */
    public Emp(int empno, Dept dept, String ename, String job, Double salary, Double bonus, Date hiredate, int manager) {
        this.empno = empno;
        this.dept = dept;
        this.ename = ename;
        this.job = job;
        this.salary = salary;
        this.bonus = bonus;
        this.hiredate = hiredate;
        this.manager = manager;
    }

   
    // Property accessors


    public Dept getDept() {
        return this.dept;
    }
    
    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public String getEname() {
        return this.ename;
    }
    
    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return this.job;
    }
    
    public void setJob(String job) {
        this.job = job;
    }

    public Double getSalary() {
        return this.salary;
    }
    
    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getBonus() {
        return this.bonus;
    }
    
    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    public Date getHiredate() {
        return this.hiredate;
    }
    
    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public Integer getManager() {
		return manager;
	}

	public void setManager(Integer manager) {
		this.manager = manager;
	}

}