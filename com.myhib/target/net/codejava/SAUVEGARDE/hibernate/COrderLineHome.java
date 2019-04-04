package net.code.java.hibernate;
// Generated 13 nov. 2018 10:53:12 by Hibernate Tools 5.2.11.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class COrderLine.
 * @see net.code.java.hibernate.COrderLine
 * @author Hibernate Tools
 */
@Stateless
public class COrderLineHome {

	private static final Log log = LogFactory.getLog(COrderLineHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(COrderLine transientInstance) {
		log.debug("persisting COrderLine instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(COrderLine persistentInstance) {
		log.debug("removing COrderLine instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public COrderLine merge(COrderLine detachedInstance) {
		log.debug("merging COrderLine instance");
		try {
			COrderLine result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public COrderLine findById(COrderLineId id) {
		log.debug("getting COrderLine instance with id: " + id);
		try {
			COrderLine instance = entityManager.find(COrderLine.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
