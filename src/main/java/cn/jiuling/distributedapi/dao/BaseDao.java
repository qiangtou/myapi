package cn.jiuling.distributedapi.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {
	public Serializable save(T t);

	public void delete(T t);

	public T load(Serializable id);

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

	public List exeSql(final String sql);

	public List find(final String sql, final int index, final int count);

	public Long getCount(String sql);
}
