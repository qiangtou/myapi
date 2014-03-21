package cn.jiuling.distributedapi.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.jiuling.distributedapi.Vo.UserVo;
import cn.jiuling.distributedapi.dao.UserDao;
import cn.jiuling.distributedapi.model.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	public User findByUserName(String userName) {
		User user = null;
		List<User> userList = getHibernateTemplate().find("select new User(u.userName, u.passWord, u.fullName, u.groupId) from User u where u.userName=?",
				userName);
		if (userList.size() > 0) {
			user = userList.get(0);
		}
		return user;
	};

	public List<UserVo> queryUser() {

		String query = "select new cn.jiuling.distributedapi.Vo.UserVo(u.userId,u.userName,u.fullName,u.groupId) from User u";
		return getHibernateTemplate().find(query);
	}

}
