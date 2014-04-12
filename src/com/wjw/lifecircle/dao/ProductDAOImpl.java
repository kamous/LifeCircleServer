package com.wjw.lifecircle.dao;
// default package

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.wjw.lifecircle.model.Product;

/**
 	* A data access object (DAO) providing persistence and search support for Product entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .Product
  * @author MyEclipse Persistence Tools 
 */
public class ProductDAOImpl extends HibernateDaoSupport implements ProductDAO  {
		 private static final Log log = LogFactory.getLog(ProductDAOImpl.class);
		//property constants
	public static final String NAME = "name";
	public static final String PRICE = "price";
	public static final String INFO = "info";
	public static final String DESCRIPTION = "description";
	public static final String PICS = "pics";



	protected void initDao() {
		//do nothing
	}
    
    /* (non-Javadoc)
	 * @see ProductDAO#save(com.wjw.lifecircle.model.Product)
	 */
    @Override
	public void save(Product transientInstance) {
        log.debug("saving Product instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	/* (non-Javadoc)
	 * @see ProductDAO#delete(com.wjw.lifecircle.model.Product)
	 */
	@Override
	public void delete(Product persistentInstance) {
        log.debug("deleting Product instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see ProductDAO#findById(java.lang.Integer)
	 */
    @Override
	public Product findById( java.lang.Integer id) {
        log.debug("getting Product instance with id: " + id);
        try {
            Product instance = (Product) getHibernateTemplate()
                    .get("com.wjw.lifecircle.model.Product", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    /* (non-Javadoc)
	 * @see ProductDAO#findByExample(com.wjw.lifecircle.model.Product)
	 */
    @Override
	public List findByExample(Product instance) {
        log.debug("finding Product instance by example");
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
	 * @see ProductDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
    @Override
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding Product instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Product as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	/* (non-Javadoc)
	 * @see ProductDAO#findByName(java.lang.Object)
	 */
	@Override
	public List findByName(Object name
	) {
		return findByProperty(NAME, name
		);
	}
	
	/* (non-Javadoc)
	 * @see ProductDAO#findByPrice(java.lang.Object)
	 */
	@Override
	public List findByPrice(Object price
	) {
		return findByProperty(PRICE, price
		);
	}
	
	/* (non-Javadoc)
	 * @see ProductDAO#findByInfo(java.lang.Object)
	 */
	@Override
	public List findByInfo(Object info
	) {
		return findByProperty(INFO, info
		);
	}
	
	/* (non-Javadoc)
	 * @see ProductDAO#findByDescription(java.lang.Object)
	 */
	@Override
	public List findByDescription(Object description
	) {
		return findByProperty(DESCRIPTION, description
		);
	}
	
	/* (non-Javadoc)
	 * @see ProductDAO#findByPics(java.lang.Object)
	 */
	@Override
	public List findByPics(Object pics
	) {
		return findByProperty(PICS, pics
		);
	}
	

	/* (non-Javadoc)
	 * @see ProductDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all Product instances");
		try {
			String queryString = "from Product";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    /* (non-Javadoc)
	 * @see ProductDAO#merge(com.wjw.lifecircle.model.Product)
	 */
    @Override
	public Product merge(Product detachedInstance) {
        log.debug("merging Product instance");
        try {
            Product result = (Product) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    /* (non-Javadoc)
	 * @see ProductDAO#attachDirty(com.wjw.lifecircle.model.Product)
	 */
    @Override
	public void attachDirty(Product instance) {
        log.debug("attaching dirty Product instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see ProductDAO#attachClean(com.wjw.lifecircle.model.Product)
	 */
    @Override
	public void attachClean(Product instance) {
        log.debug("attaching clean Product instance");
        try {
                      	getHibernateTemplate().lock(instance, LockMode.NONE);
                        log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static ProductDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (ProductDAO) ctx.getBean("ProductDAO");
	}
	
	

	public List findProductsInPage(int page,int rows,int typeId,String orderBy,String order) {
		log.debug("finding all Product instances");
		try {
			StringBuffer queryString = new StringBuffer(" from Product p ");
			if(typeId > 0 )
			{
				queryString.append(" where p.store.type.typeId =");
				queryString.append(typeId);
			}
			if(orderBy!=null && !orderBy.trim().equals(""))
			{
				queryString.append(" order by ");
				queryString.append(orderBy);
				if(order!=null && (order.equals("desc") || order.equals("asc")))
				{
					queryString.append(" ");
					queryString.append(order);
				}
			}
			
			Session session  = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(queryString.toString()).setFirstResult((page-1)*rows).setMaxResults(rows);
			
		 	return query.list();
		} catch (Exception re) {
			log.error("find all failed", re);
			return null;
			//throw re;
		}
	}
}