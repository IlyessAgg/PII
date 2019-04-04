package net.code.java.hibernate;
// Generated 13 nov. 2018 11:01:07 by Hibernate Tools 5.2.11.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class DssPart.
 * @see net.code.java.hibernate.DssPart
 * @author Hibernate Tools
 */
@Stateless
public class DssPartHome {

	private static final Log log = LogFactory.getLog(DssPartHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(DssPart transientInstance) {
		log.debug("persisting DssPart instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(DssPart persistentInstance) {
		log.debug("removing DssPart instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public DssPart merge(DssPart detachedInstance) {
		log.debug("merging DssPart instance");
		try {
			DssPart result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public DssPart findById(int id) {
		log.debug("getting DssPart instance with id: " + id);
		try {
			DssPart instance = entityManager.find(DssPart.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
