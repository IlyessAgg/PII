package net.code.java.hibernate;
// Generated 13 nov. 2018 11:01:07 by Hibernate Tools 5.2.11.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class DssOrder.
 * @see net.code.java.hibernate.DssOrder
 * @author Hibernate Tools
 */
@Stateless
public class DssOrderHome {

	private static final Log log = LogFactory.getLog(DssOrderHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(DssOrder transientInstance) {
		log.debug("persisting DssOrder instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(DssOrder persistentInstance) {
		log.debug("removing DssOrder instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public DssOrder merge(DssOrder detachedInstance) {
		log.debug("merging DssOrder instance");
		try {
			DssOrder result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public DssOrder findById(long id) {
		log.debug("getting DssOrder instance with id: " + id);
		try {
			DssOrder instance = entityManager.find(DssOrder.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
