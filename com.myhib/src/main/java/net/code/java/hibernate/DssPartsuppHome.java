package net.code.java.hibernate;
// Generated 13 nov. 2018 11:01:07 by Hibernate Tools 5.2.11.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class DssPartsupp.
 * @see net.code.java.hibernate.DssPartsupp
 * @author Hibernate Tools
 */
@Stateless
public class DssPartsuppHome {

	private static final Log log = LogFactory.getLog(DssPartsuppHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(DssPartsupp transientInstance) {
		log.debug("persisting DssPartsupp instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(DssPartsupp persistentInstance) {
		log.debug("removing DssPartsupp instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public DssPartsupp merge(DssPartsupp detachedInstance) {
		log.debug("merging DssPartsupp instance");
		try {
			DssPartsupp result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public DssPartsupp findById(DssPartsuppId id) {
		log.debug("getting DssPartsupp instance with id: " + id);
		try {
			DssPartsupp instance = entityManager.find(DssPartsupp.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
