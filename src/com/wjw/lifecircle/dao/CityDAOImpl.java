package com.wjw.lifecircle.dao;
// default package

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.wjw.lifecircle.model.City;

/**
 	* A data access object (DAO) providing persistence and search support for City entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .City
  * @author MyEclipse Persistence Tools 
 */
public class CityDAOImpl extends HibernateDaoSupport implements CityDAO  {
		 private static final Log log = LogFactory.getLog(CityDAOImpl.class);
		//property constants
	public static final String NAME = "name";
	public static final String INFO = "info";



	protected void initDao() {
		//do nothing
	}
    
    /* (non-Javadoc)
	 * @see CityDAO#save(com.wjw.lifecircle.model.City)
	 */
    @Override
	public void save(City transientInstance) {
        log.debug("saving City instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	/* (non-Javadoc)
	 * @see CityDAO#delete(com.wjw.lifecircle.model.City)
	 */
	@Override
	public void delete(City persistentInstance) {
        log.debug("deleting City instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see CityDAO#findById(java.lang.Integer)
	 */
    @Override
	public City findById( java.lang.Integer id) {
        log.debug("getting City instance with id: " + id);
        try {
            City instance = (City) getHibernateTemplate()
                    .get("com.wjw.lifecircle.model.City", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    /* (non-Javadoc)
	 * @see CityDAO#findByExample(com.wjw.lifecircle.model.City)
	 */
    @Override
	public List findByExample(City instance) {
        log.debug("finding City instance by example");
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
	 * @see CityDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
    @Override
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding City instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from City as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	/* (non-Javadoc)
	 * @see CityDAO#findByName(java.lang.Object)
	 */
	@Override
	public List findByName(Object name
	) {
		return findByProperty(NAME, name
		);
	}
	
	/* (non-Javadoc)
	 * @see CityDAO#findByInfo(java.lang.Object)
	 */
	@Override
	public List findByInfo(Object info
	) {
		return findByProperty(INFO, info
		);
	}
	

	/* (non-Javadoc)
	 * @see CityDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all City instances");
		try {
			String queryString = "from City";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    /* (non-Javadoc)
	 * @see CityDAO#merge(com.wjw.lifecircle.model.City)
	 */
    @Override
	public City merge(City detachedInstance) {
        log.debug("merging City instance");
        try {
            City result = (City) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    /* (non-Javadoc)
	 * @see CityDAO#attachDirty(com.wjw.lifecircle.model.City)
	 */
    @Override
	public void attachDirty(City instance) {
        log.debug("attaching dirty City instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see CityDAO#attachClean(com.wjw.lifecircle.model.City)
	 */
    @Override
	public void attachClean(City instance) {
        log.debug("attaching clean City instance");
        try {
                      	getHibernateTemplate().lock(instance, LockMode.NONE);
                        log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static CityDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (CityDAO) ctx.getBean("CityDAO");
	}
}