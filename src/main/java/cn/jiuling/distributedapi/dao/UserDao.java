package cn.jiuling.distributedapi.dao;

import java.util.List;

import cn.jiuling.distributedapi.Vo.UserVo;
import cn.jiuling.distributedapi.model.User;

public interface UserDao extends BaseDao<User> {

	public User findByUserName(String userName);

	public List<UserVo> queryUser();

}
