package cn.jiuling.distributedapi.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.jiuling.distributedapi.dao.BaseDao;

@Repository
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {
	protected Logger logger = Logger.getLogger(this.getClass());
	private Class clazz;

	@Autowired
	public void setSessionFactoryOverride(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	public Class getClazz() {
		if (null == this.clazz) {
			Class clazz = (Class<T>) getClass();
			ParameterizedType pt = (ParameterizedType) clazz.getGenericSuperclass();
			this.clazz = (Class) pt.getActualTypeArguments()[0];
		}
		return this.clazz;
	}

	public void delete(T t) {
		getHibernateTemplate().delete(t);
		getHibernateTemplate().flush();
	}

	public T find(Serializable id) {
		return (T) getHibernateTemplate().get(getClazz(), id);
	}

	public Serializable save(T t) {
		Serializable id = getHibernateTemplate().save(t);
		getHibernateTemplate().flush();
		return id;
	}

	public void update(T t) {
		getHibernateTemplate().clear();
		getHibernateTemplate().update(t);
		getHibernateTemplate().flush();
	}

	public void saveOrUpdate(T t) {
		getHibernateTemplate().saveOrUpdate(t);
		getHibernateTemplate().flush();
	}

	public List<T> getAll() {
		return getHibernateTemplate().find("from " + getClazz().getName());
	}
}
