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
 * Home object for domain model class COrderLine.
 * @see net.codejava.hibernate.COrderLine
 * @author Hibernate Tools
 */
public class COrderLineHome {

	private static final Log log = LogFactory.getLog(COrderLineHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(COrderLine transientInstance) {
		log.debug("persisting COrderLine instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(COrderLine instance) {
		log.debug("attaching dirty COrderLine instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(COrderLine instance) {
		log.debug("attaching clean COrderLine instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(COrderLine persistentInstance) {
		log.debug("deleting COrderLine instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public COrderLine merge(COrderLine detachedInstance) {
		log.debug("merging COrderLine instance");
		try {
			COrderLine result = (COrderLine) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public COrderLine findById(net.codejava.hibernate.COrderLineId id) {
		log.debug("getting COrderLine instance with id: " + id);
		try {
			COrderLine instance = (COrderLine) sessionFactory.getCurrentSession()
					.get("net.codejava.hibernate.COrderLine", id);
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

	public List findByExample(COrderLine instance) {
		log.debug("finding COrderLine instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("net.codejava.hibernate.COrderLine")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
