package net.code.java.hibernate;
// Generated 13 nov. 2018 11:01:07 by Hibernate Tools 5.2.11.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class DssSupplier.
 * @see net.code.java.hibernate.DssSupplier
 * @author Hibernate Tools
 */
@Stateless
public class DssSupplierHome {

	private static final Log log = LogFactory.getLog(DssSupplierHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(DssSupplier transientInstance) {
		log.debug("persisting DssSupplier instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(DssSupplier persistentInstance) {
		log.debug("removing DssSupplier instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public DssSupplier merge(DssSupplier detachedInstance) {
		log.debug("merging DssSupplier instance");
		try {
			DssSupplier result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public DssSupplier findById(int id) {
		log.debug("getting DssSupplier instance with id: " + id);
		try {
			DssSupplier instance = entityManager.find(DssSupplier.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
