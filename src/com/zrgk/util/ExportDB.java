package com.zrgk.util;


import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 * 
    alter table paper 
        drop 
        foreign key FK658118CF9ADE203

    alter table sc 
        drop 
        foreign key FKE50F9ADE203

    alter table sc 
        drop 
        foreign key FKE50E439769F

    alter table student 
        drop 
        foreign key FK8FFE823B6AB06913

    alter table test.emp 
        drop 
        foreign key FK188C861435C51

    drop table if exists LOGIN

    drop table if exists Lsx1

    drop table if exists course

    drop table if exists grade

    drop table if exists paper

    drop table if exists sc

    drop table if exists student

    drop table if exists test.dept

    drop table if exists test.emp

    drop table if exists test.user

    create table LOGIN (
        USERNAME varchar(255) not null,
        PASSWORD varchar(255),
        AGE integer,
        primary key (USERNAME)
    )

    create table Lsx1 (
        id integer not null auto_increment,
        name varchar(255),
        age integer,
        primary key (id)
    )

    create table course (
        cid integer not null auto_increment,
        cname varchar(255),
        cdesc varchar(255),
        primary key (cid)
    )

    create table grade (
        gid integer not null auto_increment,
        gname varchar(255),
        gdesc varchar(255),
        primary key (gid)
    )

    create table paper (
        pid integer not null auto_increment,
        sid integer unique,
        pdesc varchar(255),
        primary key (pid)
    )

    create table sc (
        cid integer not null,
        sid integer not null,
        primary key (cid, sid)
    )

    create table student (
        sid integer not null auto_increment,
        gid integer,
        sname varchar(255),
        sex varchar(255),
        primary key (sid)
    )

    create table test.dept (
        DEPTNO integer not null,
        DNAME varchar(255),
        LOC varchar(50),
        primary key (DEPTNO)
    )

    create table test.emp (
        EMPNO integer not null,
        ENAME varchar(10),
        JOB varchar(10),
        SALARY double precision,
        BONUS double precision,
        HIREDATE datetime,
        MANAGER integer,
        DEPTNO integer,
        primary key (EMPNO)
    )

    create table test.user (
        ID integer not null,
        NAME varchar(20),
        EMAIL varchar(30),
        AGE integer,
        BIRTHDAY date,
        SALARY double precision,
        primary key (ID)
    )

    alter table paper 
        add index FK658118CF9ADE203 (sid), 
        add constraint FK658118CF9ADE203 
        foreign key (sid) 
        references student (sid)

    alter table sc 
        add index FKE50F9ADE203 (sid), 
        add constraint FKE50F9ADE203 
        foreign key (sid) 
        references student (sid)

    alter table sc 
        add index FKE50E439769F (cid), 
        add constraint FKE50E439769F 
        foreign key (cid) 
        references course (cid)

    alter table student 
        add index FK8FFE823B6AB06913 (gid), 
        add constraint FK8FFE823B6AB06913 
        foreign key (gid) 
        references grade (gid)

    alter table test.emp 
        add index FK188C861435C51 (DEPTNO), 
        add constraint FK188C861435C51 
        foreign key (DEPTNO) 
        references test.dept (DEPTNO)

通过项目中的配置文件，生成表结构
 * @author lsx
 * @Description 
 *
 */
public class ExportDB {
	public static void main(String[] args) {
		//读取hibernate.cfg.xml文件
		//注意：默认查找路径为/hibernate.cfg.xml
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		///hibernate.cfg.xml not found
		//cfg.configure("/config/hibernate/hibernate.cfg.xml");
		//cfg.addResource("/config/hibernate/hibernate.cfg.xml");
		//cfg.addFile("config/hibernate/hibernate.cfg.xml");
		//hbm2ddl
		SchemaExport export = new SchemaExport(cfg);
		//void org.hibernate.tool.
		//hbm2ddl.SchemaExport.create(boolean script, boolean export)
		export.create(true, true);
		}
}
