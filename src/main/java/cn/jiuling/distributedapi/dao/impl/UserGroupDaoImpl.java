package cn.jiuling.distributedapi.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.jiuling.distributedapi.dao.UserGroupDao;
import cn.jiuling.distributedapi.model.UserGroup;

@Repository("userGroupDao")
public class UserGroupDaoImpl extends BaseDaoImpl<UserGroup> implements UserGroupDao {
	public List<UserGroup> queryUserGroup() {
		String query = "select new cn.jiuling.distributedapi.Vo.UserGroupVo(u.Id,u.title,u.description) from UserGroup u";
		return getHibernateTemplate().find(query);
	}
}
