package com.zrgk.entity;

import java.util.Set;

import javax.persistence.CascadeType;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;

import javax.persistence.Id;

import javax.persistence.ManyToMany;

import javax.persistence.Table;

@Entity
@Table(name = "t_course")
public class AnnotationCourse {

	@Id
	@GeneratedValue
	private Integer id;
	private String name;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE },

	mappedBy = "course",
	targetEntity = com.zrgk.entity.AnnotationStudent.class

	)
	private Set student;

	public Integer getId() {

		return id;

	}

	public void setId(Integer id) {

		this.id = id;

	}

	public String getName() {

		return name;

	}

	public void setName(String name) {

		this.name = name;

	}

	public Set getStudent() {

		return student;

	}

	public void setStudent(Set student) {
		this.student = student;
	}

}