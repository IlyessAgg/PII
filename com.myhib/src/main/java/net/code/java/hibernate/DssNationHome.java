package net.code.java.hibernate;
// Generated 13 nov. 2018 11:01:07 by Hibernate Tools 5.2.11.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class DssNation.
 * @see net.code.java.hibernate.DssNation
 * @author Hibernate Tools
 */
@Stateless
public class DssNationHome {

	private static final Log log = LogFactory.getLog(DssNationHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(DssNation transientInstance) {
		log.debug("persisting DssNation instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(DssNation persistentInstance) {
		log.debug("removing DssNation instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public DssNation merge(DssNation detachedInstance) {
		log.debug("merging DssNation instance");
		try {
			DssNation result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public DssNation findById(int id) {
		log.debug("getting DssNation instance with id: " + id);
		try {
			DssNation instance = entityManager.find(DssNation.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
