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
 * Home object for domain model class CWarehouse.
 * @see net.codejava.hibernate.CWarehouse
 * @author Hibernate Tools
 */
public class CWarehouseHome {

	private static final Log log = LogFactory.getLog(CWarehouseHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(CWarehouse transientInstance) {
		log.debug("persisting CWarehouse instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(CWarehouse instance) {
		log.debug("attaching dirty CWarehouse instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CWarehouse instance) {
		log.debug("attaching clean CWarehouse instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(CWarehouse persistentInstance) {
		log.debug("deleting CWarehouse instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CWarehouse merge(CWarehouse detachedInstance) {
		log.debug("merging CWarehouse instance");
		try {
			CWarehouse result = (CWarehouse) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public CWarehouse findById(int id) {
		log.debug("getting CWarehouse instance with id: " + id);
		try {
			CWarehouse instance = (CWarehouse) sessionFactory.getCurrentSession()
					.get("net.codejava.hibernate.CWarehouse", id);
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

	public List findByExample(CWarehouse instance) {
		log.debug("finding CWarehouse instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("net.codejava.hibernate.CWarehouse")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
