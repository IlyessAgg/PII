package net.code.java.hibernate;
// Generated 13 nov. 2018 11:01:07 by Hibernate Tools 5.2.11.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class DssCustomer.
 * @see net.code.java.hibernate.DssCustomer
 * @author Hibernate Tools
 */
@Stateless
public class DssCustomerHome {

	private static final Log log = LogFactory.getLog(DssCustomerHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(DssCustomer transientInstance) {
		log.debug("persisting DssCustomer instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(DssCustomer persistentInstance) {
		log.debug("removing DssCustomer instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public DssCustomer merge(DssCustomer detachedInstance) {
		log.debug("merging DssCustomer instance");
		try {
			DssCustomer result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public DssCustomer findById(int id) {
		log.debug("getting DssCustomer instance with id: " + id);
		try {
			DssCustomer instance = entityManager.find(DssCustomer.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
