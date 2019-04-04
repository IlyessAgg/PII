package net.code.java.hibernate;
// Generated 13 nov. 2018 11:01:07 by Hibernate Tools 5.2.11.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class DssLineitem.
 * @see net.code.java.hibernate.DssLineitem
 * @author Hibernate Tools
 */
@Stateless
public class DssLineitemHome {

	private static final Log log = LogFactory.getLog(DssLineitemHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(DssLineitem transientInstance) {
		log.debug("persisting DssLineitem instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(DssLineitem persistentInstance) {
		log.debug("removing DssLineitem instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public DssLineitem merge(DssLineitem detachedInstance) {
		log.debug("merging DssLineitem instance");
		try {
			DssLineitem result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public DssLineitem findById(DssLineitemId id) {
		log.debug("getting DssLineitem instance with id: " + id);
		try {
			DssLineitem instance = entityManager.find(DssLineitem.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
