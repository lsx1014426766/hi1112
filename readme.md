hibernate知识点
此项目重在测试，通过Junit Test方法

在页面上测试calendar日期插件，My97DatePicker

localhost:8080/hi1112/index.jsp

1.配置文件 hibernate.cfg.xml文件，默认放在src根目录下，当加载配合文件时无需指定：
	//可以置空不写
Configuration conf = 
			new Configuration().configure("hibernate.cfg.xml");
		
2. 利用hibernate进行db操作流程：
    1加载主配置文件
    
    2.获取session工厂
    
    3.根据session工厂对象 获取一个session对象  ，session对象是对原始Connection对象的封装
    
    4.开启事务  对于增删改 需要打开事务
    
    5.对User对象进行操作 session.save(u)等;	
    
    6.事务提交，关闭session,sessionFactory	
    
3.对于有级联关系的操作，cascade

   	学生---年级的关系是多对一，采用级联方式，只需把关系建立好（ 双向关系），执行一次年级操作即可
   	
  	学生---学会证 的关系一对一采用级联方式，建立好关系，执行任意一方的操作即可
  	
        级联设置+外键设置
        
         <!-- 配置关系属性 -->
		<set name="students"  cascade="all">
		<key column="gid"></key>
		<one-to-many class="Student"/>
		</set>
		<many-to-one name="grade" class="Grade" column="gid" cascade="none">
		</many-to-one>
		
4.通过实体类来自动生成表，需要提供 hibernate.cfg.xml，mapper文件

5.主键生成策略：

	<!-- 配置主键的生成策略   assigned:由程序员自己指定 -->
	<generator class="sequence">
		<param name="sequence">my_seq3</param>
	</generator> 自生成，对于oracle db指定为sequence

6关于dao包下内容的存放：
   1之前一种约定是Ixxxdao.java为接口，xxxdao.java为实现，都放在dao包下
   
   2另一种放法：dao包下xxxdao.java   dao.impl包下放 xxxdaoImpl.java实现类
   
7.自定义查询sql方式

         String queryString = "from User as model where model." 
         						+ propertyName + "= ?";
         						
         Query queryObject = getSession().createQuery(queryString);
         
		 queryObject.setParameter(0, value);
		 
		 return queryObject.list();
		 
   session提供的方法：
             User user = (User) getSession().get("User", id);
             
             List results = getSession().createCriteria("User").add(Example.create(user)).list();
             
             User result = (User) getSession().merge(user);
             
             getSession().saveOrUpdate(instance);
             
             getSession().delete(persistentInstance);
             
             getSession().save(transientInstance);
             
8.mapper映射文件xml写法：

  <mapping resource="com/zrgk/mapping/User.hbm.xml"/>
  
注意这里的资源路径包名，类名   之间一律用反斜杠！否则会报出找不到mapping错误

9Testhibernate1.java
  session.save(user); 在执行插入时遇到db 编码非utf-8导致插入失败问题
  
  解决方法：在db设置database的编码，重新执行ExportDB
        
        因为没有指定程序连接时的编码所以跟db的设置保持了一致
        
8eclipse部署问题：
   
   1使用eclipse，选择本地tomcat,部署项目位于eclipse>workspace>metadata下的某个目录，
          并不在tomcat下的webapp里！
         通过eclipse--server配置，不可选
         
  2要更改项目的名字，项目》右击》properties>在resouces,webroot下修改，再重新部署启动
  
9 ImageBrowsing.js 上传图片后，直接在下方显示，还未请求后台接口的时候
  
   browse('f1','d1',200,200);
   
10 My97DatePicker/WdatePicker.js的使用

   <input type="text" name="c" readonly="readonly" onclick="WdatePicker();"/>
