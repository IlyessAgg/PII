package net.code.java.hibernate;
// Generated 13 nov. 2018 10:53:12 by Hibernate Tools 5.2.11.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class CItem.
 * @see net.code.java.hibernate.CItem
 * @author Hibernate Tools
 */
@Stateless
public class CItemHome {

	private static final Log log = LogFactory.getLog(CItemHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(CItem transientInstance) {
		log.debug("persisting CItem instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(CItem persistentInstance) {
		log.debug("removing CItem instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public CItem merge(CItem detachedInstance) {
		log.debug("merging CItem instance");
		try {
			CItem result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public CItem findById(int id) {
		log.debug("getting CItem instance with id: " + id);
		try {
			CItem instance = entityManager.find(CItem.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
