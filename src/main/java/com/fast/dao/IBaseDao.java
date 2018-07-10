package com.fast.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;

public interface IBaseDao<T> {
	
	public Session getCurrentSession();
	
	public void save(T t);
	
	public void saveAll(Collection<T> elements);
	
	public void deleteById(Serializable id);
	
	public void delete(T t);
	
	public void deleteAll(Collection<T> elements);
	
	public void saveOrUpdate(T t);
	
	public T findById(Serializable id);

	public T findByHql(String hql, Object... param);
	
	public <T2> List<T2> findListBysql(final String sql,final Class<T2> tranformClass,final Object ... values);
	
	public <T2> List<T2> findListBysql(String sql, Class<T2> tranformClass, Map<String,Object> map);
}
