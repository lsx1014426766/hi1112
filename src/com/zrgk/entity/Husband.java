package com.zrgk.entity;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
/**
 * hibernate的注解实现方式
 * 需要引入persistence-api.jar
 * 
 * @author lsx
 *
 */
@Entity
public class Husband {
 private int id;
 private String name;
 private Wife wife;
 @Id
 @GeneratedValue //主键生成器
 public int getId() {
  return id;
 }
 public String getName() {
  return name;
 }
 @OneToOne(cascade=CascadeType.ALL)
 @PrimaryKeyJoinColumn//这个注解只能写在主(生成ID)的一端
 public Wife getWife() {
  return wife;
 }
 public void setId(int id) {
  this.id = id;
 }
 public void setName(String name) {
  this.name = name;
 }
 public void setWife(Wife wife) {
  this.wife = wife;
 }
}