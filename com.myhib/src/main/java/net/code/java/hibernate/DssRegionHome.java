package net.code.java.hibernate;
// Generated 13 nov. 2018 11:01:07 by Hibernate Tools 5.2.11.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class DssRegion.
 * @see net.code.java.hibernate.DssRegion
 * @author Hibernate Tools
 */
@Stateless
public class DssRegionHome {

	private static final Log log = LogFactory.getLog(DssRegionHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(DssRegion transientInstance) {
		log.debug("persisting DssRegion instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(DssRegion persistentInstance) {
		log.debug("removing DssRegion instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public DssRegion merge(DssRegion detachedInstance) {
		log.debug("merging DssRegion instance");
		try {
			DssRegion result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public DssRegion findById(int id) {
		log.debug("getting DssRegion instance with id: " + id);
		try {
			DssRegion instance = entityManager.find(DssRegion.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
