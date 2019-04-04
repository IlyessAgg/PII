package net.code.java.hibernate;
// Generated 13 nov. 2018 10:53:12 by Hibernate Tools 5.2.11.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class COrder.
 * @see net.code.java.hibernate.COrder
 * @author Hibernate Tools
 */
@Stateless
public class COrderHome {

	private static final Log log = LogFactory.getLog(COrderHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(COrder transientInstance) {
		log.debug("persisting COrder instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(COrder persistentInstance) {
		log.debug("removing COrder instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public COrder merge(COrder detachedInstance) {
		log.debug("merging COrder instance");
		try {
			COrder result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public COrder findById(COrderId id) {
		log.debug("getting COrder instance with id: " + id);
		try {
			COrder instance = entityManager.find(COrder.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
