select * from USER_TABLES
--班级表
CREATE TABLE GRADE(
 GID NUMBER NOT NULL,
 GNAME VARCHAR2(10) NOT NULL,
 GDESC VARCHAR2(50)
)
COMMIT;
ALTER TABLE GRADE ADD PRIMARY KEY(GID);

SELECT * FROM STUDENT;
DROP TABLE STUDENT;
--学生表
create table STUDENT
(
  SID   NUMBER not null,
  SNAME VARCHAR2(10) not null,
  SEX   CHAR(2),
  GID   NUMBER
);

alter table student
  add primary key (SID);

alter table STUDENT
  add constraint STU_FOREIGN_GID foreign key (GID)
  references GRADE (GID);

 -- Create table  课程表
create table COURSE
(
  CID   NUMBER not null,
  CNAME VARCHAR2(20) not null,
  CDESC VARCHAR2(50)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64
    minextents 1
    maxextents unlimited
  );
-- Create/Recreate primary, unique and foreign key constraints 
alter table COURSE
  add primary key (CID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

  -- Create table   学生和课程的中间表
create table SC
(
  SID NUMBER,
  CID NUMBER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64
    minextents 1
    maxextents unlimited
  );
-- Create/Recreate primary, unique and foreign key constraints 
alter table SC
  add constraint CID_FK foreign key (CID)
  references COURSE (CID);
alter table SC
  add constraint SID_FK foreign key (SID)
  references STUDENT (SID);


-- Create table   学生证表
create table PAPER
(
  PID   NUMBER not null,
  SID   NUMBER not null,
  PDESC VARCHAR2(50)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64
    minextents 1
    maxextents unlimited
  );
-- Create/Recreate primary, unique and foreign key constraints 
--学生证
alter table PAPER
  add primary key (PID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PAPER
  add constraint PAPER_FK_SID foreign key (SID)
  references STUDENT (SID);
COMMIT;
drop table paper
drop table student  --不能删除主键表，有外键关联

--学生表  学生证表   一对一的关系
--
create sequence my_seq3
--创建序列
drop sequence my_seq;
create  sequence my_seq start with 1 increment by 1;
commit;


select * from student;
select * from grade;
select * from paper;
