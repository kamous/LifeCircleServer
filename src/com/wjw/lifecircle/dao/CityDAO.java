package com.wjw.lifecircle.dao;
import java.util.List;

import com.wjw.lifecircle.model.City;

public interface CityDAO {

	public abstract void save(City transientInstance);

	public abstract void delete(City persistentInstance);

	public abstract City findById(java.lang.Integer id);

	public abstract List findByExample(City instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByName(Object name);

	public abstract List findByInfo(Object info);

	public abstract List findAll();

	public abstract City merge(City detachedInstance);

	public abstract void attachDirty(City instance);

	public abstract void attachClean(City instance);

}