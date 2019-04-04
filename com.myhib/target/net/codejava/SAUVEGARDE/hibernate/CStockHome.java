package net.code.java.hibernate;
// Generated 13 nov. 2018 10:53:12 by Hibernate Tools 5.2.11.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class CStock.
 * @see net.code.java.hibernate.CStock
 * @author Hibernate Tools
 */
@Stateless
public class CStockHome {

	private static final Log log = LogFactory.getLog(CStockHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(CStock transientInstance) {
		log.debug("persisting CStock instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(CStock persistentInstance) {
		log.debug("removing CStock instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public CStock merge(CStock detachedInstance) {
		log.debug("merging CStock instance");
		try {
			CStock result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public CStock findById(CStockId id) {
		log.debug("getting CStock instance with id: " + id);
		try {
			CStock instance = entityManager.find(CStock.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
