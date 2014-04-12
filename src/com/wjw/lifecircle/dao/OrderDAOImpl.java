package com.wjw.lifecircle.dao;
// default package

import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.wjw.lifecircle.model.Order;

/**
 	* A data access object (DAO) providing persistence and search support for Order entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .Order
  * @author MyEclipse Persistence Tools 
 */
public class OrderDAOImpl extends HibernateDaoSupport implements OrderDAO  {
		 private static final Log log = LogFactory.getLog(OrderDAOImpl.class);
		//property constants
	public static final String COUNT = "count";
	public static final String TOTAL_PRICE = "totalPrice";



	protected void initDao() {
		//do nothing
	}
    
    /* (non-Javadoc)
	 * @see OrderDAO#save(com.wjw.lifecircle.model.Order)
	 */
    @Override
	public void save(Order transientInstance) {
        log.debug("saving Order instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	/* (non-Javadoc)
	 * @see OrderDAO#delete(com.wjw.lifecircle.model.Order)
	 */
	@Override
	public void delete(Order persistentInstance) {
        log.debug("deleting Order instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see OrderDAO#findById(java.lang.Integer)
	 */
    @Override
	public Order findById( java.lang.Integer id) {
        log.debug("getting Order instance with id: " + id);
        try {
            Order instance = (Order) getHibernateTemplate()
                    .get("com.wjw.lifecircle.model.Order", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    /* (non-Javadoc)
	 * @see OrderDAO#findByExample(com.wjw.lifecircle.model.Order)
	 */
    @Override
	public List findByExample(Order instance) {
        log.debug("finding Order instance by example");
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
	 * @see OrderDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
    @Override
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding Order instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Order as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	/* (non-Javadoc)
	 * @see OrderDAO#findByCount(java.lang.Object)
	 */
	@Override
	public List findByCount(Object count
	) {
		return findByProperty(COUNT, count
		);
	}
	
	/* (non-Javadoc)
	 * @see OrderDAO#findByTotalPrice(java.lang.Object)
	 */
	@Override
	public List findByTotalPrice(Object totalPrice
	) {
		return findByProperty(TOTAL_PRICE, totalPrice
		);
	}
	

	/* (non-Javadoc)
	 * @see OrderDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all Order instances");
		try {
			String queryString = "from Order";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    /* (non-Javadoc)
	 * @see OrderDAO#merge(com.wjw.lifecircle.model.Order)
	 */
    @Override
	public Order merge(Order detachedInstance) {
        log.debug("merging Order instance");
        try {
            Order result = (Order) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    /* (non-Javadoc)
	 * @see OrderDAO#attachDirty(com.wjw.lifecircle.model.Order)
	 */
    @Override
	public void attachDirty(Order instance) {
        log.debug("attaching dirty Order instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see OrderDAO#attachClean(com.wjw.lifecircle.model.Order)
	 */
    @Override
	public void attachClean(Order instance) {
        log.debug("attaching clean Order instance");
        try {
                      	getHibernateTemplate().lock(instance, LockMode.NONE);
                        log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static OrderDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (OrderDAO) ctx.getBean("OrderDAO");
	}
}