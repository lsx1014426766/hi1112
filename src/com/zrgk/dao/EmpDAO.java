package com.zrgk.dao;

import java.util.Date;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zrgk.entity.Emp;

/**
 * A data access object (DAO) providing persistence and search support for
 * Emp entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.zrgk.entity.Emp
 * @author MyEclipse Persistence Tools
 */

public class EmpDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(EmpDAO.class);
	// property constants
	public static final String ENAME = "ename";
	public static final String JOB = "job";
	public static final String SALARY = "salary";
	public static final String BONUS = "bonus";
	public static final String MANAGER = "manager";

	public void save(Emp transientInstance) {
		log.debug("saving Emp instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Emp persistentInstance) {
		log.debug("deleting Emp instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Emp findById(java.lang.Integer id) {
		log.debug("getting Emp instance with id: " + id);
		try {
			Emp instance = (Emp) getSession().get(
					"com.zrgk.entity.Emp", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Emp instance) {
		log.debug("finding Emp instance by example");
		try {
			List results = getSession()
					.createCriteria("com.zrgk.entity.Emp")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Emp instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Emp as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByEname(Object ename) {
		return findByProperty(ENAME, ename);
	}

	public List findByJob(Object job) {
		return findByProperty(JOB, job);
	}

	public List findBySalary(Object salary) {
		return findByProperty(SALARY, salary);
	}

	public List findByBonus(Object bonus) {
		return findByProperty(BONUS, bonus);
	}

	public List findByManager(Object manager) {
		return findByProperty(MANAGER, manager);
	}

	public List findAll() {
		log.debug("finding all Emp instances");
		try {
			String queryString = "from Emp";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Emp merge(Emp detachedInstance) {
		log.debug("merging Emp instance");
		try {
			Emp result = (Emp) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Emp instance) {
		log.debug("attaching dirty Emp instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Emp instance) {
		log.debug("attaching clean Emp instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}