package net.codejava.hibernate;
// Generated 8 nov. 2018 14:18:53 by Hibernate Tools 5.3.6.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class COrder.
 * @see net.codejava.hibernate.COrder
 * @author Hibernate Tools
 */
public class COrderHome {

	private static final Log log = LogFactory.getLog(COrderHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(COrder transientInstance) {
		log.debug("persisting COrder instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(COrder instance) {
		log.debug("attaching dirty COrder instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(COrder instance) {
		log.debug("attaching clean COrder instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(COrder persistentInstance) {
		log.debug("deleting COrder instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public COrder merge(COrder detachedInstance) {
		log.debug("merging COrder instance");
		try {
			COrder result = (COrder) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public COrder findById(net.codejava.hibernate.COrderId id) {
		log.debug("getting COrder instance with id: " + id);
		try {
			COrder instance = (COrder) sessionFactory.getCurrentSession().get("net.codejava.hibernate.COrder", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(COrder instance) {
		log.debug("finding COrder instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("net.codejava.hibernate.COrder")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
