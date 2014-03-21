package cn.jiuling.distributedapi.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
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

	public T load(Serializable id) {
		return (T) getHibernateTemplate().load(getClazz(), id);
	}

	public T findBy(String name, Object value) {
		String queryString = "from " + getClazz().getName() + " o where o." + name + "=?";
		List<T> list = getHibernateTemplate().find(queryString, value);
		T t = null;
		if (list.size() > 0) {
			t = list.get(0);
		}
		return t;
	}

	public T get(Serializable id) {
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

	public List exeSql(final String sql) {
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				SQLQuery query = session.createSQLQuery(sql);
				return query.list();
			}
		});
	}

	@Override
	public Long getCount(String sql) {
		sql = "select count(*) " + sql;
		List list = getHibernateTemplate().find(sql);
		return (Long) list.get(0);
	}

	@Override
	public List find(final String queryString, final int index, final int count) {
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(queryString);
				query.setFirstResult(index);
				query.setMaxResults(count);
				return query.list();
			}
		});
	}
}
