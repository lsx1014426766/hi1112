hibernate֪ʶ��
����Ŀ���ڲ��ԣ�ͨ��Junit Test���������漰web����

1.�����ļ� hibernate.cfg.xml�ļ���Ĭ�Ϸ���src��Ŀ¼�£�����������ļ�ʱ����ָ����
	//�����ÿղ�д
Configuration conf = 
			new Configuration().configure("hibernate.cfg.xml");
		
2. ����hibernate����db�������̣�
    1�����������ļ�
    
    2.��ȡsession����
    
    3.����session�������� ��ȡһ��session����  ��session�����Ƕ�ԭʼConnection����ķ�װ
    
    4.��������  ������ɾ�� ��Ҫ������
    
    5.��User������в��� session.save(u)��;	
    
    6.�����ύ���ر�session,sessionFactory	
    
3.�����м�����ϵ�Ĳ�����cascade

   	ѧ��---�꼶�Ĺ�ϵ�Ƕ��һ�����ü�����ʽ��ֻ��ѹ�ϵ�����ã� ˫���ϵ����ִ��һ���꼶��������
   	
  	ѧ��---ѧ��֤ �Ĺ�ϵһ��һ���ü�����ʽ�������ù�ϵ��ִ������һ���Ĳ�������
  	
        ��������+�������
        
         <!-- ���ù�ϵ���� -->
		<set name="students"  cascade="all">
		<key column="gid"></key>
		<one-to-many class="Student"/>
		</set>
		<many-to-one name="grade" class="Grade" column="gid" cascade="none">
		</many-to-one>
		
4.ͨ��ʵ�������Զ����ɱ���Ҫ�ṩ hibernate.cfg.xml��mapper�ļ�

5.�������ɲ��ԣ�

	<!-- �������������ɲ���   assigned:�ɳ���Ա�Լ�ָ�� -->
	<generator class="sequence">
		<param name="sequence">my_seq3</param>
	</generator> �����ɣ�����oracle dbָ��Ϊsequence

6����dao�������ݵĴ�ţ�
   1֮ǰһ��Լ����Ixxxdao.javaΪ�ӿڣ�xxxdao.javaΪʵ�֣�������dao����
   
   2��һ�ַŷ���dao����xxxdao.java   dao.impl���·� xxxdaoImpl.javaʵ����
   
7.�Զ����ѯsql��ʽ

         String queryString = "from User as model where model." 
         						+ propertyName + "= ?";
         						
         Query queryObject = getSession().createQuery(queryString);
         
		 queryObject.setParameter(0, value);
		 
		 return queryObject.list();
		 
   session�ṩ�ķ�����
             User user = (User) getSession().get("User", id);
             
             List results = getSession().createCriteria("User").add(Example.create(user)).list();
             
             User result = (User) getSession().merge(user);
             
             getSession().saveOrUpdate(instance);
             
             getSession().delete(persistentInstance);
             
             getSession().save(transientInstance);
             
8.mapperӳ���ļ�xmlд����

  <mapping resource="com/zrgk/mapping/User.hbm.xml"/>
  
ע���������Դ·������������   ֮��һ���÷�б�ܣ�����ᱨ���Ҳ���mapping����
