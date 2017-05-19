--����ĺܶ��﷨��ֻ��oracle�ģ�mysql������
д����ע��㣺
  varchar(23)  ���������ָ����С����varchar2��Oracle ���еģ�mysql��û��
  �洢���̵���ʼ�ͽ�βҪ����Delimiter�ı�ָ���
  asû������ؼ���   ��oracle���е�
  getlist(in a  int)  ����������ͺͱ�������λ�ù̶�
  
drop table if exists login; 
create table LOGIN
(
  USERNAME    VARCHAR(50) not null,  
  PASSWORD    VARCHAR(50),       
  AGE  int(3)    
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

 DELIMITER $$
USE `test`$$
DROP PROCEDURE IF EXISTS login_insert$$
CREATE  PROCEDURE 
login_insert( IN username VARCHAR(23) ,IN password VARCHAR(23) ,IN age INT) 
BEGIN
  INSERT INTO login (username,PASSWORD ,age) VALUES(username,password,age);
END$$
DELIMITER ; 

--�޸��ض��û���Ϣ--
DELIMITER $$
USE `test`$$
DROP PROCEDURE IF EXISTS login_update$$
CREATE  PROCEDURE 
login_update(IN a  INT) 
BEGIN
  UPDATE login SET age=a WHERE username='Tom';
END$$
DELIMITER ;



--ɾ���ض��û���Ϣ--
DELIMITER $$
USE `test`$$
DROP PROCEDURE IF EXISTS login_delete$$
CREATE  PROCEDURE 
login_delete(IN uname  VARCHAR(23))
BEGIN
 DELETE FROM login WHERE USERNAME = uname;
END$$
DELIMITER ;


--��ѯ�û���Ϣ--
DELIMITER $$
USE `test`$$
DROP PROCEDURE IF EXISTS login_getlist$$
CREATE  PROCEDURE 
login_getlist(OUT logins  SYS_REFCURSOR) --������
BEGIN
 open logins for
    select * from login;
END$$
DELIMITER ;


--��ѯ�ض��û���Ϣ--

DELIMITER $$
USE `test`$$
DROP PROCEDURE IF EXISTS login_getsome$$
CREATE  PROCEDURE 
login_getsome(in name  varchar(23),v_age out int)
BEGIN
	select age into v_age from login where username=name;
END$$
DELIMITER ;
