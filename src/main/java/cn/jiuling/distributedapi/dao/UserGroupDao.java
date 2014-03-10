package cn.jiuling.distributedapi.dao;

import java.util.List;

import cn.jiuling.distributedapi.model.UserGroup;

public interface UserGroupDao extends BaseDao<UserGroup> {

	public List<UserGroup> queryUserGroup();

}
