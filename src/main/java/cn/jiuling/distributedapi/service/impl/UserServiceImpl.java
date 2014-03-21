package cn.jiuling.distributedapi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import cn.jiuling.distributedapi.Vo.LoginUserVo;
import cn.jiuling.distributedapi.Vo.Status;
import cn.jiuling.distributedapi.Vo.UserVo;
import cn.jiuling.distributedapi.dao.SystemconfigDao;
import cn.jiuling.distributedapi.dao.UserDao;
import cn.jiuling.distributedapi.dao.UserGroupDao;
import cn.jiuling.distributedapi.exception.ServiceException;
import cn.jiuling.distributedapi.model.Systemconfig;
import cn.jiuling.distributedapi.model.User;
import cn.jiuling.distributedapi.model.UserGroup;
import cn.jiuling.distributedapi.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;
	@Resource
	private UserGroupDao userGroupDao;
	@Resource
	private SystemconfigDao systemconfigDao;

	public User findUserById(Integer userId) {
		return userDao.load(userId);
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
		try {
			userGroupDao.save(ug);
		} catch (Exception e) {
			throw new ServiceException(Status.ADD_ERROR, e);
		}
	}

	@Override
	public void delUserGroup(Integer groupid) {
		try {
			UserGroup ug = userGroupDao.load(groupid);
			userGroupDao.delete(ug);
		} catch (Exception e) {
			throw new ServiceException(Status.DEL_ERROR, e);
		}
	}

	@Override
	public void modifyUserGroup(Integer groupid, String newname, String newdesc) {
		try {
			UserGroup ug = userGroupDao.load(groupid);
			if (!StringUtils.isEmpty(newname)) {
				ug.setTitle(newname);
			}
			if (!StringUtils.isEmpty(newdesc)) {
				ug.setDescription(newdesc);
			}
			userGroupDao.update(ug);
		} catch (Exception e) {
			throw new ServiceException(Status.MODIFY_ERROR, e);
		}
	}

	@Override
	public List<UserGroup> queryUserGroup() {
		try {
			return userGroupDao.queryUserGroup();
		} catch (Exception e) {
			throw new ServiceException(Status.QUERY_ERROR, e);
		}
	}

	@Override
	public void addUser(User u) {
		try {
			userDao.save(u);
		} catch (Exception e) {
			throw new ServiceException(Status.ADD_ERROR, e);
		}
	}

	@Override
	public void delUser(Integer userid) {
		try {
			User u = userDao.load(userid);
			userDao.delete(u);
		} catch (Exception e) {
			throw new ServiceException(Status.DEL_ERROR, e);
		}
	}

	@Override
	public void modifyUser(User user) {
		try {
			User u = userDao.load(user.getUserId());
			// User(userid, username, fullname, blocked, groupid,
			// update_time_regular, password);
			u.setUserName(user.getUserName());
			u.setFullName(user.getFullName());
			u.setBlocked(user.getBlocked());
			u.setGroupId(user.getGroupId());
			u.setUpdateTimeRegular(user.getUpdateTimeRegular());
			u.setPassWord(user.getPassWord());
			userDao.update(u);
		} catch (Exception e) {
			throw new ServiceException(Status.MODIFY_ERROR, e);
		}
	}

	@Override
	public List<UserVo> queryUser() {
		try {
			return userDao.queryUser();
		} catch (Exception e) {
			throw new ServiceException(Status.QUERY_ERROR, e);
		}
	}

	@Override
	public LoginUserVo getLoginUser(User u) {
		try {
			LoginUserVo loginUser = null;
			User user = valideUser(u);
			if (user != null) {
				loginUser = new LoginUserVo();
				loginUser.setUserid(user.getUserId());
				loginUser.setGroupId(user.getGroupId());
				loginUser.setTaskPriority(user.getTaskPriority());
				Systemconfig s = systemconfigDao.getSystemconfig();
				loginUser.setSingleormulti(s.getId().getIsExternalAccessAllow());
			}
			return loginUser;
		} catch (Exception e) {
			throw new ServiceException(Status.QUERY_ERROR, e);
		}
	}
}
