package net.code.java.hibernate;
// Generated 13 nov. 2018 10:53:12 by Hibernate Tools 5.2.11.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class CWarehouse.
 * @see net.code.java.hibernate.CWarehouse
 * @author Hibernate Tools
 */
@Stateless
public class CWarehouseHome {

	private static final Log log = LogFactory.getLog(CWarehouseHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(CWarehouse transientInstance) {
		log.debug("persisting CWarehouse instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(CWarehouse persistentInstance) {
		log.debug("removing CWarehouse instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public CWarehouse merge(CWarehouse detachedInstance) {
		log.debug("merging CWarehouse instance");
		try {
			CWarehouse result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public CWarehouse findById(int id) {
		log.debug("getting CWarehouse instance with id: " + id);
		try {
			CWarehouse instance = entityManager.find(CWarehouse.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
