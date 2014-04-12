package com.wjw.lifecircle.dao;
import java.util.List;

import com.wjw.lifecircle.model.User;

public interface UserDAO {

	public abstract void save(User transientInstance);

	public abstract void delete(User persistentInstance);

	public abstract User findById(java.lang.Integer id);

	public abstract List findByExample(User instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByName(Object name);

	public abstract List findByEmail(Object email);

	public abstract List findByPassword(Object password);

	public abstract List findByPic(Object pic);

	public abstract List findAll();

	public abstract User merge(User detachedInstance);

	public abstract void attachDirty(User instance);

	public abstract void attachClean(User instance);

}