package com.zrgk.test;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.zrgk.entity.Husband;
import com.zrgk.entity.Wife;

/**
 * 通过注解方式pojo-->table Hasband ，Wife表
 * 引入jar:
 *   persistence.jar
 *   hibernate-annotation-xx.jar
 *   
 * @author lsx
 *
 */

public class OneToOnePKTest {
 private static SessionFactory sessionFactory;
 
 @BeforeClass
 public static void beforeClass() {
   sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
 }
 @AfterClass
 public static void afterClass() {
  sessionFactory.close();
 }
 
 @Test
 public void testSave(){
  Session s = sessionFactory.getCurrentSession();
  s.beginTransaction();
  
  Husband h = new Husband();
  Wife w = new Wife();
  w.setName("w");
  h.setName("h");


  h.setWife(w);
  w.setHusband(h);
  s.save(w);
  s.getTransaction().commit();
 }

@Test
 public void testSchemaExport() {
	//注解配置方式，非script xml脚本
	AnnotationConfiguration configure = new AnnotationConfiguration().configure();
	SchemaExport schemaExport = new SchemaExport(configure);
	schemaExport.create(false, true);
/**
 * java.lang.NoClassDefFoundError: org/hibernate/annotations/common/AssertionFailure
 * 需要引入jar: hibernate-commons-annotations-xxx.Final.jar
 * java.lang.IncompatibleClassChangeError: Implementing class 包冲突  还没找到原因
	

 */
}
 public static void main(String[] args) {
	 AnnotationConfiguration configure = new AnnotationConfiguration();
  beforeClass();
  new OneToOnePKTest().testSave();
  afterClass();
 }
}