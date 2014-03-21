package cn.jiuling.distributedapi.service;

import java.util.List;

import cn.jiuling.distributedapi.Vo.LoginUserVo;
import cn.jiuling.distributedapi.Vo.UserVo;
import cn.jiuling.distributedapi.model.User;
import cn.jiuling.distributedapi.model.UserGroup;

public interface UserService {
	public User findUserById(Integer userId);

	public User valideUser(User user);

	public void addUserGroup(UserGroup ug);

	public void delUserGroup(Integer groupid);

	public void modifyUserGroup(Integer groupid, String newname, String newdesc);

	public List<UserGroup> queryUserGroup();

	public void addUser(User u);

	public void delUser(Integer userid);

	public void modifyUser(User user);

	public List<UserVo> queryUser();

	public LoginUserVo getLoginUser(User user);

}
