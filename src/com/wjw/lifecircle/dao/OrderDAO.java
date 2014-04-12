package com.wjw.lifecircle.dao;
import java.util.List;

import com.wjw.lifecircle.model.Order;

public interface OrderDAO {

	public abstract void save(Order transientInstance);

	public abstract void delete(Order persistentInstance);

	public abstract Order findById(java.lang.Integer id);

	public abstract List findByExample(Order instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByCount(Object count);

	public abstract List findByTotalPrice(Object totalPrice);

	public abstract List findAll();

	public abstract Order merge(Order detachedInstance);

	public abstract void attachDirty(Order instance);

	public abstract void attachClean(Order instance);

}