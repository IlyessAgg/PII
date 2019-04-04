package net.code.java.hibernate;
// Generated 13 nov. 2018 10:53:12 by Hibernate Tools 5.2.11.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class CNewOrder.
 * @see net.code.java.hibernate.CNewOrder
 * @author Hibernate Tools
 */
@Stateless
public class CNewOrderHome {

	private static final Log log = LogFactory.getLog(CNewOrderHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(CNewOrder transientInstance) {
		log.debug("persisting CNewOrder instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(CNewOrder persistentInstance) {
		log.debug("removing CNewOrder instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public CNewOrder merge(CNewOrder detachedInstance) {
		log.debug("merging CNewOrder instance");
		try {
			CNewOrder result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public CNewOrder findById(CNewOrderId id) {
		log.debug("getting CNewOrder instance with id: " + id);
		try {
			CNewOrder instance = entityManager.find(CNewOrder.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
