package com.wjw.lifecircle.dao;
import java.util.List;

import com.wjw.lifecircle.model.Product;

public interface ProductDAO {

	public abstract void save(Product transientInstance);

	public abstract void delete(Product persistentInstance);

	public abstract Product findById(java.lang.Integer id);

	public abstract List findByExample(Product instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByName(Object name);

	public abstract List findByPrice(Object price);

	public abstract List findByInfo(Object info);

	public abstract List findByDescription(Object description);

	public abstract List findByPics(Object pics);

	public abstract List findAll();

	public abstract Product merge(Product detachedInstance);

	public abstract void attachDirty(Product instance);

	public abstract void attachClean(Product instance);
	
	public List findProductsInPage(int page,int rows,int typeId,String orderBy,String order) ;

}