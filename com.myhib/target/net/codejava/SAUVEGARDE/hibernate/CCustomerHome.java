package net.code.java.hibernate;
// Generated 13 nov. 2018 10:53:12 by Hibernate Tools 5.2.11.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class CCustomer.
 * @see net.code.java.hibernate.CCustomer
 * @author Hibernate Tools
 */
@Stateless
public class CCustomerHome {

	private static final Log log = LogFactory.getLog(CCustomerHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(CCustomer transientInstance) {
		log.debug("persisting CCustomer instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(CCustomer persistentInstance) {
		log.debug("removing CCustomer instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public CCustomer merge(CCustomer detachedInstance) {
		log.debug("merging CCustomer instance");
		try {
			CCustomer result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public CCustomer findById(CCustomerId id) {
		log.debug("getting CCustomer instance with id: " + id);
		try {
			CCustomer instance = entityManager.find(CCustomer.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
