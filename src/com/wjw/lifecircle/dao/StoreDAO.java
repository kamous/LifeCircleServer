package com.wjw.lifecircle.dao;
import java.util.List;

import com.wjw.lifecircle.model.Store;

public interface StoreDAO {

	public abstract void save(Store transientInstance);

	public abstract void delete(Store persistentInstance);

	public abstract Store findById(java.lang.Integer id);

	public abstract List findByExample(Store instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByName(Object name);

	public abstract List findByPhone(Object phone);

	public abstract List findByLocationStr(Object locationStr);

	public abstract List findByLon(Object lon);

	public abstract List findByLat(Object lat);

	public abstract List findByInfo(Object info);

	public abstract List findAll();

	public abstract Store merge(Store detachedInstance);

	public abstract void attachDirty(Store instance);

	public abstract void attachClean(Store instance);

}