--����ĺܶ��﷨��ֻ��oracle�ģ�mysql������

drop table if exists login; 
create table LOGIN
(
  USERNAME    VARCHAR2(50) not null,   --�û���
  PASSWORD    VARCHAR2(50),         --����
  AGE  int(3)       --�û�����
)

alter table LOGIN
  add constraint PK_LOGIN primary key (USERNAME);
  
  INSERT INTO LOGIN 
  VALUES('Tom','123456',21);
  INSERT INTO LOGIN 
  VALUES('���','5268794',20);
  INSERT INTO LOGIN 
  VALUES('Kate','7485697',19);
  
  
  SELECT * FROM LOGIN;
  
--��������ɾ���ġ����û���Ϣ�Ĵ洢����
--�����û���Ϣ--
create or replace procedure 
login_insert(username in varchar,password in varchar,age in number) as

begin
  insert into login (username,password,age) values(username,password,age);
end;
--�޸��ض��û���Ϣ--
create or replace procedure login_update(a in number) as
begin
  update login set age=a where username='Tom';
end;
--ɾ���ض��û���Ϣ--
create or replace procedure login_delete(uname in varchar) as
begin
  delete from login where USERNAME = uname;
end;
--��ѯ�û���Ϣ--
create or replace procedure login_getlist
(logins OUT SYS_REFCURSOR) as
begin
  open logins for
    select * from login;
end;

--��ѯ�ض��û���Ϣ--
create or replace procedure login_getlist
(name number,v_age out number) as
begin
	select age into v_age from login where username=name;
end;