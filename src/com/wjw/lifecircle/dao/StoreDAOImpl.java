package com.wjw.lifecircle.dao;
// default package

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.wjw.lifecircle.model.Store;

/**
 	* A data access object (DAO) providing persistence and search support for Store entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .Store
  * @author MyEclipse Persistence Tools 
 */
public class StoreDAOImpl extends HibernateDaoSupport implements StoreDAO  {
		 private static final Log log = LogFactory.getLog(StoreDAOImpl.class);
		//property constants
	public static final String NAME = "name";
	public static final String PHONE = "phone";
	public static final String LOCATION_STR = "locationStr";
	public static final String LON = "lon";
	public static final String LAT = "lat";
	public static final String INFO = "info";



	protected void initDao() {
		//do nothing
	}
    
    /* (non-Javadoc)
	 * @see StoreDAO#save(com.wjw.lifecircle.model.Store)
	 */
    @Override
	public void save(Store transientInstance) {
        log.debug("saving Store instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	/* (non-Javadoc)
	 * @see StoreDAO#delete(com.wjw.lifecircle.model.Store)
	 */
	@Override
	public void delete(Store persistentInstance) {
        log.debug("deleting Store instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see StoreDAO#findById(java.lang.Integer)
	 */
    @Override
	public Store findById( java.lang.Integer id) {
        log.debug("getting Store instance with id: " + id);
        try {
            Store instance = (Store) getHibernateTemplate()
                    .get("com.wjw.lifecircle.model.Store", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    /* (non-Javadoc)
	 * @see StoreDAO#findByExample(com.wjw.lifecircle.model.Store)
	 */
    @Override
	public List findByExample(Store instance) {
        log.debug("finding Store instance by example");
        try {
            List results = getHibernateTemplate().findByExample(instance);
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    /* (non-Javadoc)
	 * @see StoreDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
    @Override
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding Store instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Store as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	/* (non-Javadoc)
	 * @see StoreDAO#findByName(java.lang.Object)
	 */
	@Override
	public List findByName(Object name
	) {
		return findByProperty(NAME, name
		);
	}
	
	/* (non-Javadoc)
	 * @see StoreDAO#findByPhone(java.lang.Object)
	 */
	@Override
	public List findByPhone(Object phone
	) {
		return findByProperty(PHONE, phone
		);
	}
	
	/* (non-Javadoc)
	 * @see StoreDAO#findByLocationStr(java.lang.Object)
	 */
	@Override
	public List findByLocationStr(Object locationStr
	) {
		return findByProperty(LOCATION_STR, locationStr
		);
	}
	
	/* (non-Javadoc)
	 * @see StoreDAO#findByLon(java.lang.Object)
	 */
	@Override
	public List findByLon(Object lon
	) {
		return findByProperty(LON, lon
		);
	}
	
	/* (non-Javadoc)
	 * @see StoreDAO#findByLat(java.lang.Object)
	 */
	@Override
	public List findByLat(Object lat
	) {
		return findByProperty(LAT, lat
		);
	}
	
	/* (non-Javadoc)
	 * @see StoreDAO#findByInfo(java.lang.Object)
	 */
	@Override
	public List findByInfo(Object info
	) {
		return findByProperty(INFO, info
		);
	}
	

	/* (non-Javadoc)
	 * @see StoreDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all Store instances");
		try {
			String queryString = "from Store";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    /* (non-Javadoc)
	 * @see StoreDAO#merge(com.wjw.lifecircle.model.Store)
	 */
    @Override
	public Store merge(Store detachedInstance) {
        log.debug("merging Store instance");
        try {
            Store result = (Store) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    /* (non-Javadoc)
	 * @see StoreDAO#attachDirty(com.wjw.lifecircle.model.Store)
	 */
    @Override
	public void attachDirty(Store instance) {
        log.debug("attaching dirty Store instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see StoreDAO#attachClean(com.wjw.lifecircle.model.Store)
	 */
    @Override
	public void attachClean(Store instance) {
        log.debug("attaching clean Store instance");
        try {
                      	getHibernateTemplate().lock(instance, LockMode.NONE);
                        log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static StoreDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (StoreDAO) ctx.getBean("StoreDAO");
	}
}