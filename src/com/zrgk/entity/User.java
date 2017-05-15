package com.zrgk.entity;


// default package

import java.util.Date;


/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String name;
     private String email;
     private Integer age;
     private Date birthday;
     private Double salary;


    // Constructors

    /** default constructor */
    public User() {
    }

	/** minimal constructor */
    public User(Integer id) {
        this.id = id;
    }
    
    /** full constructor */
    public User(Integer id, String name, String email, Integer age, Date birthday, double salary) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.birthday = birthday;
        this.salary = salary;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return this.age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return this.birthday;
    }
    
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public double getSalary() {
        return this.salary;
    }
    
    public void setSalary(Double salary) {
        this.salary = salary;
    }
   








}