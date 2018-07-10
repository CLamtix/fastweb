package com.fast.service.impl;

import java.io.Serializable;
import java.util.Collection;

import com.fast.dao.IBaseDao;
import com.fast.service.IBaseService;

public abstract class BaseServiceImpl<T> implements IBaseService<T>{

	protected IBaseDao<T> baseDao;
	
	protected abstract void setBaseDao();
	
	@Override
	public void save(T t) {
		baseDao.save(t);
	}

	@Override
	public void saveAll(Collection<T> elements) {
		baseDao.saveAll(elements);
	}

	@Override
	public void deleteById(Serializable id) {
		baseDao.deleteById(id);
	}

	@Override
	public void delete(T t) {
		baseDao.delete(t);
	}

	@Override
	public void deleteAll(Collection<T> elements) {
		baseDao.deleteAll(elements);
	}

	@Override
	public void saveOrUpdate(T t) {
		baseDao.saveOrUpdate(t);
	}

	@Override
	public T findById(Serializable id) {
		return baseDao.findById(id);
	}

	@Override
	public T findByHql(String hql, Object... param) {
		return baseDao.findByHql(hql,param);
	}

}
