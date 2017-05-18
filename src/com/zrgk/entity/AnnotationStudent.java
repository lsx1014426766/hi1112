package com.zrgk.entity;

import java.util.Set;

import javax.persistence.CascadeType;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;

import javax.persistence.Id;

import javax.persistence.JoinColumn;

import javax.persistence.JoinTable;

import javax.persistence.ManyToMany;

import javax.persistence.Table;

@Entity
@Table(name = "t_student")
public class AnnotationStudent {
	@Id
	@GeneratedValue
	private Integer id;
	private String name;

	@ManyToMany(targetEntity = com.zrgk.entity.AnnotationCourse.class, cascade = {
			CascadeType.MERGE, CascadeType.PERSIST })
	@JoinTable(name = "student_course", joinColumns = { @JoinColumn(name = "student_id") }, inverseJoinColumns = { @JoinColumn(name = "course_id") })
	private Set course;

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

	public Set getCourse() {
		return course;
	}

	public void setCourse(Set course) {
		this.course = course;
	}

}