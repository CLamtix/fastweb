package com.fast.service;

import java.io.Serializable;
import java.util.Collection;

public interface IBaseService<T> {
	
	public void save(T t);
	
	public void saveAll(Collection<T> elements);
	
	public void deleteById(Serializable id);
	
	public void delete(T t);
	
	public void deleteAll(Collection<T> elements);
	
	public void saveOrUpdate(T t);
	
	public T findById(Serializable id);
	
	public T findByHql(String hql,Object...param);
	
	
}
