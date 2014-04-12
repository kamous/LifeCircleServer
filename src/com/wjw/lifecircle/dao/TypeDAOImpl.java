package com.wjw.lifecircle.dao;
// default package

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.wjw.lifecircle.model.Type;

/**
 	* A data access object (DAO) providing persistence and search support for Type entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .Type
  * @author MyEclipse Persistence Tools 
 */
public class TypeDAOImpl extends HibernateDaoSupport implements TypeDAO  {
		 private static final Log log = LogFactory.getLog(TypeDAOImpl.class);
		//property constants
	public static final String NAME = "name";



	protected void initDao() {
		//do nothing
	}
    
    /* (non-Javadoc)
	 * @see TypeDAO#save(com.wjw.lifecircle.model.Type)
	 */
    @Override
	public void save(Type transientInstance) {
        log.debug("saving Type instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	/* (non-Javadoc)
	 * @see TypeDAO#delete(com.wjw.lifecircle.model.Type)
	 */
	@Override
	public void delete(Type persistentInstance) {
        log.debug("deleting Type instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see TypeDAO#findById(java.lang.Integer)
	 */
    @Override
	public Type findById( java.lang.Integer id) {
        log.debug("getting Type instance with id: " + id);
        try {
            Type instance = (Type) getHibernateTemplate()
                    .get("com.wjw.lifecircle.model.Type", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    /* (non-Javadoc)
	 * @see TypeDAO#findByExample(com.wjw.lifecircle.model.Type)
	 */
    @Override
	public List findByExample(Type instance) {
        log.debug("finding Type instance by example");
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
	 * @see TypeDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
    @Override
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding Type instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Type as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	/* (non-Javadoc)
	 * @see TypeDAO#findByName(java.lang.Object)
	 */
	@Override
	public List findByName(Object name
	) {
		return findByProperty(NAME, name
		);
	}
	

	/* (non-Javadoc)
	 * @see TypeDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all Type instances");
		try {
			String queryString = "from Type";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    /* (non-Javadoc)
	 * @see TypeDAO#merge(com.wjw.lifecircle.model.Type)
	 */
    @Override
	public Type merge(Type detachedInstance) {
        log.debug("merging Type instance");
        try {
            Type result = (Type) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    /* (non-Javadoc)
	 * @see TypeDAO#attachDirty(com.wjw.lifecircle.model.Type)
	 */
    @Override
	public void attachDirty(Type instance) {
        log.debug("attaching dirty Type instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see TypeDAO#attachClean(com.wjw.lifecircle.model.Type)
	 */
    @Override
	public void attachClean(Type instance) {
        log.debug("attaching clean Type instance");
        try {
                      	getHibernateTemplate().lock(instance, LockMode.NONE);
                        log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static TypeDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (TypeDAO) ctx.getBean("TypeDAO");
	}
}