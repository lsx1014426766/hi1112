--这里的很多语法都只是oracle的，mysql不能用
写法上注意点：
  varchar(23)  必须带参数指定大小，且varchar2是Oracle 特有的，mysql并没有
  存储过程的起始和结尾要加上Delimiter改变分隔符
  as没有这个关键字   但oracle是有的
  getlist(in a  int)  输入输出类型和变量名的位置固定
  
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
  VALUES('马达','5268794',20);
  INSERT INTO LOGIN 
  VALUES('Kate','7485697',19);
  
  
  SELECT * FROM LOGIN;
  
--创建增、删、改、查用户信息的存储过程
--增加用户信息--

 DELIMITER $$
USE `test`$$
DROP PROCEDURE IF EXISTS login_insert$$
CREATE  PROCEDURE 
login_insert( IN username VARCHAR(23) ,IN password VARCHAR(23) ,IN age INT) 
BEGIN
  INSERT INTO login (username,PASSWORD ,age) VALUES(username,password,age);
END$$
DELIMITER ; 

--修改特定用户信息--
DELIMITER $$
USE `test`$$
DROP PROCEDURE IF EXISTS login_update$$
CREATE  PROCEDURE 
login_update(IN a  INT) 
BEGIN
  UPDATE login SET age=a WHERE username='Tom';
END$$
DELIMITER ;



--删除特定用户信息--
DELIMITER $$
USE `test`$$
DROP PROCEDURE IF EXISTS login_delete$$
CREATE  PROCEDURE 
login_delete(IN uname  VARCHAR(23))
BEGIN
 DELETE FROM login WHERE USERNAME = uname;
END$$
DELIMITER ;


--查询用户信息--
DELIMITER $$
USE `test`$$
DROP PROCEDURE IF EXISTS login_getlist$$
CREATE  PROCEDURE 
login_getlist(OUT logins  SYS_REFCURSOR) --有问题
BEGIN
 open logins for
    select * from login;
END$$
DELIMITER ;


--查询特定用户信息--

DELIMITER $$
USE `test`$$
DROP PROCEDURE IF EXISTS login_getsome$$
CREATE  PROCEDURE 
login_getsome(in name  varchar(23),v_age out int)
BEGIN
	select age into v_age from login where username=name;
END$$
DELIMITER ;
