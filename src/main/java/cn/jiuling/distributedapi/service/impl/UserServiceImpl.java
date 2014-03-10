package cn.jiuling.distributedapi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import cn.jiuling.distributedapi.Vo.Status;
import cn.jiuling.distributedapi.Vo.UserVo;
import cn.jiuling.distributedapi.dao.UserDao;
import cn.jiuling.distributedapi.dao.UserGroupDao;
import cn.jiuling.distributedapi.exception.ServiceException;
import cn.jiuling.distributedapi.model.User;
import cn.jiuling.distributedapi.model.UserGroup;
import cn.jiuling.distributedapi.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	private final Logger log = Logger.getLogger(UserServiceImpl.class);
	@Resource
	private UserDao userDao;
	@Resource
	private UserGroupDao userGroupDao;

	public User findUserById(Integer userId) {
		return userDao.find(userId);
	}

	@Override
	public User valideUser(User user) {
		User u = userDao.findByUserName(user.getUserName());
		if (null != u && user.getPassWord().equals(u.getPassWord())) {
			return u;
		}
		return null;
	}

	@Override
	public void addUserGroup(UserGroup ug) {
		userGroupDao.save(ug);
	}

	@Override
	public void delUserGroup(Integer groupid) {
		try {
			UserGroup ug = userGroupDao.find(groupid);
			userGroupDao.delete(ug);
		} catch (Exception e) {
			throw new ServiceException(Status.USERGROUP_DEL_ERROR, e);
		}
	}

	@Override
	public void modifyUserGroup(Integer groupid, String newname, String newdesc) {
		try {
			UserGroup ug = new UserGroup(newname, newdesc);
			ug.setId(groupid);
			userGroupDao.update(ug);
		} catch (Exception e) {
			throw new ServiceException(Status.USERGROUP_MODIFY_ERROR, e);
		}
	}

	@Override
	public List<UserGroup> queryUserGroup() {
		return userGroupDao.queryUserGroup();
	}

	@Override
	public void addUser(User u) {
		userDao.save(u);
	}

	@Override
	public void delUser(Integer userid) {
		User u = userDao.find(userid);
		userDao.delete(u);
	}

	@Override
	public void modifyUser(User user) {
		User u = userDao.find(user.getUserId());
		// User(userid, username, fullname, blocked, groupid,
		// update_time_regular, password);
		u.setUserName(user.getUserName());
		u.setFullName(user.getFullName());
		u.setBlocked(user.getBlocked());
		u.setGroupId(user.getGroupId());
		u.setUpdateTimeRegular(user.getUpdateTimeRegular());
		u.setPassWord(user.getPassWord());
		userDao.update(u);
	}

	@Override
	public List<UserVo> queryUser() {
		return userDao.queryUser();
	}

}
