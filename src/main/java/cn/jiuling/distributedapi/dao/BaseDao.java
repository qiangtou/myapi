package cn.jiuling.distributedapi.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {
	public Serializable save(T t);

	public void delete(T t);

	public T load(Serializable id);

	public T get(Serializable id);

	public void update(T t);

	public void saveOrUpdate(T t);

	public List<T> getAll();

	/**
	 * 通过属性名查找实体
	 * 
	 * @param name
	 *            属性名
	 * @param value
	 *            值
	 * @return
	 */
	public T findBy(String name, Object value);

	public List listBy(String name, Object value);

	public List exeSql(final String sql);

	public List find(final String sql, final int index, final int count);

	public Long getCount(String sql);

	public Long getCount(String sql, Object[] o);

	/**
	 * 清空表数据,谨慎操作
	 */
	public void deleteAll();

	/**
	 * 清空表数据,谨慎操作
	 */
	public void deleteAllByEntity(String entityName);

	public List exeSql(String sql, int firstResult, int maxResults);

}
