package com.zrgk.dao;
// default package


import org.hibernate.Session;

import com.zrgk.util.HibernateUtil1;


/**
 * Data access object (DAO) for domain model
 * @author MyEclipse Persistence Tools
 */
public class BaseHibernateDAO implements IBaseHibernateDAO {
	
	public Session getSession() {
		return HibernateUtil1.getSession();
	}
	
}