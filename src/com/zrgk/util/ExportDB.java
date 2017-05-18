package com.zrgk.util;


import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 * alter table paper 
        drop 
        foreign key FK658118CF9ADE203

    alter table student 
        drop 
        foreign key FK8FFE823B6AB06913

    drop table if exists grade

    drop table if exists paper

    drop table if exists student

    drop table if exists test.user

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

    create table student (
        sid integer not null auto_increment,
        gid integer,
        sname varchar(255),
        sex varchar(255),
        primary key (sid)
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

    alter table student 
        add index FK8FFE823B6AB06913 (gid), 
        add constraint FK8FFE823B6AB06913 
        foreign key (gid) 
        references grade (gid)

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
