package cn.jiuling.distributedapi.dao;

import cn.jiuling.distributedapi.model.Exttaskstatus;

public interface ExttaskstatusDao extends BaseDao<Exttaskstatus> {

	public Exttaskstatus getExttaskstatus(String flowNumber);
}
