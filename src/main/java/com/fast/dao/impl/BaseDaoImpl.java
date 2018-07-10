package com.fast.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;

import com.fast.dao.IBaseDao;

@SuppressWarnings("unchecked")
public class BaseDaoImpl<T> implements IBaseDao<T>{

	@Autowired
	private SessionFactory sessionFactory;
	
	private Class<T> clazz;
	
	/**
	 * 获取SessionFactory
	 * @return
	 */
	public SessionFactory getCurrentSessionFactory(){
		return this.sessionFactory;
	}
	
	/**
	 * 获取session
	 * @return
	 */
	@Override
	public Session getCurrentSession(){
		return getCurrentSessionFactory().getCurrentSession();
	}
	
	public BaseDaoImpl(){
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();  
        this.clazz = (Class<T>) type.getActualTypeArguments()[0];  
    }
	
	
	@Override
	public void save(T t) {
		this.getCurrentSession().save(t);
	}
	
	@Override
	public void saveAll(Collection<T> elements) {
		
		for (T element : elements){
			this.getCurrentSession().save(element);
		}
	}
	
	@Override
	public void deleteById(Serializable id) {
		this.getCurrentSession().delete(this.findById(id));
	}
	
	@Override
	public void delete(T t) {
		this.getCurrentSession().delete(t);
	}
	
	@Override
	public void deleteAll(Collection<T> elements) {
		for (T element : elements){
			this.getCurrentSession().delete(element);
		}
	}

	@Override
	public void saveOrUpdate(T t) {
		this.getCurrentSession().saveOrUpdate(t);
	}

	@Override
	public T findById(Serializable id) {
		return (T) this.getCurrentSession().get(clazz, id);
	}

	@Override
	public T findByHql(String hql, Object... param) {
		Query query = this.getCurrentSession().createQuery(hql);
		for(int i = 0;i<param.length;i++){
			query.setParameter(i, param[i]);
		}
		T t = (T) query.setMaxResults(1).uniqueResult();
		return t;
	}

	@Override
	public <T2> List<T2> findListBysql(String sql, Class<T2> tranformClass, Object... values) {
		Query query = this.getCurrentSession().createSQLQuery(sql);
		for(int i=0;i<values.length;i++){
			query.setParameter(i, values[i]);
		}
		query.setResultTransformer(new AliasToBeanResultTransformer(tranformClass));
		return query.list();
	}
	
	@Override
	public <T2> List<T2> findListBysql(String sql, Class<T2> tranformClass, Map<String,Object> map) {
		
		Query query = this.getCurrentSession().createSQLQuery(sql);
		for (Entry<String, Object> entry :map.entrySet()){
			query.setParameter(entry.getKey(), entry.getValue());
		}
		query.setResultTransformer(new AliasToBeanResultTransformer(tranformClass));
		return query.list();
	}

}
