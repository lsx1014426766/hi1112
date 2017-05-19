--这里的很多语法都只是oracle的，mysql不能用

drop table if exists login; 
create table LOGIN
(
  USERNAME    VARCHAR2(50) not null,   --用户名
  PASSWORD    VARCHAR2(50),         --密码
  AGE  int(3)       --用户年龄
)

alter table LOGIN
  add constraint PK_LOGIN primary key (USERNAME);
  
  INSERT INTO LOGIN 
  VALUES('Tom','123456',21);
  INSERT INTO LOGIN 
  VALUES('马达','5268794',20);
  INSERT INTO LOGIN 
  VALUES('Kate','7485697',19);
  
  
  SELECT * FROM LOGIN;
  
--创建增、删、改、查用户信息的存储过程
--增加用户信息--
create or replace procedure 
login_insert(username in varchar,password in varchar,age in number) as

begin
  insert into login (username,password,age) values(username,password,age);
end;
--修改特定用户信息--
create or replace procedure login_update(a in number) as
begin
  update login set age=a where username='Tom';
end;
--删除特定用户信息--
create or replace procedure login_delete(uname in varchar) as
begin
  delete from login where USERNAME = uname;
end;
--查询用户信息--
create or replace procedure login_getlist
(logins OUT SYS_REFCURSOR) as
begin
  open logins for
    select * from login;
end;

--查询特定用户信息--
create or replace procedure login_getlist
(name number,v_age out number) as
begin
	select age into v_age from login where username=name;
end;