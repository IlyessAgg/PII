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
 * Home object for domain model class CNewOrder.
 * @see net.codejava.hibernate.CNewOrder
 * @author Hibernate Tools
 */
public class CNewOrderHome {

	private static final Log log = LogFactory.getLog(CNewOrderHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(CNewOrder transientInstance) {
		log.debug("persisting CNewOrder instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(CNewOrder instance) {
		log.debug("attaching dirty CNewOrder instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CNewOrder instance) {
		log.debug("attaching clean CNewOrder instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(CNewOrder persistentInstance) {
		log.debug("deleting CNewOrder instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CNewOrder merge(CNewOrder detachedInstance) {
		log.debug("merging CNewOrder instance");
		try {
			CNewOrder result = (CNewOrder) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public CNewOrder findById(net.codejava.hibernate.CNewOrderId id) {
		log.debug("getting CNewOrder instance with id: " + id);
		try {
			CNewOrder instance = (CNewOrder) sessionFactory.getCurrentSession().get("net.codejava.hibernate.CNewOrder",
					id);
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

	public List findByExample(CNewOrder instance) {
		log.debug("finding CNewOrder instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("net.codejava.hibernate.CNewOrder")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
