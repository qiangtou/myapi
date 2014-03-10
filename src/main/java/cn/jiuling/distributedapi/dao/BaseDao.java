package cn.jiuling.distributedapi.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {
	public Serializable save(T t);

	public void delete(T t);

	public T find(Serializable id);

	public void update(T t);

	public void saveOrUpdate(T t);

	public List<T> getAll();
}
