package com.wjw.lifecircle.dao;
import java.util.List;

import com.wjw.lifecircle.model.Type;

public interface TypeDAO {

	public abstract void save(Type transientInstance);

	public abstract void delete(Type persistentInstance);

	public abstract Type findById(java.lang.Integer id);

	public abstract List findByExample(Type instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByName(Object name);

	public abstract List findAll();

	public abstract Type merge(Type detachedInstance);

	public abstract void attachDirty(Type instance);

	public abstract void attachClean(Type instance);

}