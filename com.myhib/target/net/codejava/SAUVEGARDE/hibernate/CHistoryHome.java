package net.code.java.hibernate;
// Generated 13 nov. 2018 10:53:12 by Hibernate Tools 5.2.11.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class CHistory.
 * @see net.code.java.hibernate.CHistory
 * @author Hibernate Tools
 */
@Stateless
public class CHistoryHome {

	private static final Log log = LogFactory.getLog(CHistoryHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(CHistory transientInstance) {
		log.debug("persisting CHistory instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(CHistory persistentInstance) {
		log.debug("removing CHistory instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public CHistory merge(CHistory detachedInstance) {
		log.debug("merging CHistory instance");
		try {
			CHistory result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public CHistory findById(CHistoryId id) {
		log.debug("getting CHistory instance with id: " + id);
		try {
			CHistory instance = entityManager.find(CHistory.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
