package cn.jiuling.distributedapi.dao;

import java.util.List;

import cn.jiuling.distributedapi.model.Server;

public interface ServerDao extends BaseDao<Server> {
	public List<Server> getServersByDeptId(Integer deptId);
}
