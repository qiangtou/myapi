package cn.jiuling.distributedapi.web;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.jiuling.distributedapi.Vo.AddUserRes;
import cn.jiuling.distributedapi.Vo.GroupRes;
import cn.jiuling.distributedapi.Vo.ResStatus;
import cn.jiuling.distributedapi.Vo.Status;
import cn.jiuling.distributedapi.Vo.UserVo;
import cn.jiuling.distributedapi.model.User;
import cn.jiuling.distributedapi.model.UserGroup;
import cn.jiuling.distributedapi.service.UserService;
import cn.jiuling.distributedapi.utils.ResponseUtils;

@Controller
@RequestMapping(value = "/server.php", produces = { "text/html;charset=utf-8" })
public class UserController extends BaseController {
	@Resource
	private UserService userService;

	/**
	 * 新建用户组
	 * 
	 * @param name
	 * @param description
	 * @param session
	 * @return
	 */
	@RequestMapping(params = { "command=AddUserGroup" })
	@ResponseBody
	public String addUserGroup(@RequestParam String name, @RequestParam String description, HttpSession session) {
		GroupRes rs = new GroupRes();
		UserGroup ug = new UserGroup(name, description);
		ug.setCreateTime(new Timestamp(System.currentTimeMillis()));
		ug.setCreator(getUserId(session));
		userService.addUserGroup(ug);
		rs.setStatus(Status.ADD_SUCCESS);
		rs.setGroupId(ug.getId());
		return ResponseUtils.parse(rs);
	}

	/**
	 * 删除用户组
	 * 
	 * @param groupid
	 * @return
	 */
	@RequestMapping(params = { "command=DeleteUserGroup" })
	@ResponseBody
	public String deleteUserGroup(@RequestParam Integer groupid) {
		ResStatus rs = new ResStatus();
		userService.delUserGroup(groupid);
		rs.setStatus(Status.DEL_SUCCESS);
		return ResponseUtils.parse(rs);
	}

	/**
	 * 修改用户组
	 * 
	 * @param groupid
	 * @param newname
	 * @param newdesc
	 * @return
	 */
	@RequestMapping(params = { "command=ModifyUserGroup" })
	@ResponseBody
	public String modifyUserGroup(@RequestParam Integer groupid,
			String newname, String newdesc) {
		ResStatus rs = new ResStatus();
		userService.modifyUserGroup(groupid, newname, newdesc);
		rs.setStatus(Status.MODIFY_SUCCESS);
		return ResponseUtils.parse(rs);
	}

	/**
	 * 查询用户组列表
	 * 
	 * @return
	 */
	@RequestMapping(params = { "command=QueryUserGroup" })
	@ResponseBody
	public String queryUserGroup() {
		ResStatus rs = new ResStatus();
		List<UserGroup> userGroupList = null;
		try {
			userGroupList = userService.queryUserGroup();
			log.info(userGroupList);
			rs.setStatus(Status.QUERY_SUCCESS);
		} catch (Exception e) {
			rs.setStatus(Status.SERVER_ERROR);
			log.error(e.getMessage(), e);
		}
		return ResponseUtils.parse(rs, userGroupList);
	}

	/**
	 * 新建用户
	 * 
	 * @return
	 */
	@RequestMapping(params = { "command=AddUser" })
	@ResponseBody
	public String addUser(@RequestParam String username, @RequestParam String fullname, @RequestParam String password, @RequestParam Integer groupid) {
		AddUserRes rs = new AddUserRes();
		User u = new User(username, password, fullname, groupid);
		userService.addUser(u);
		rs.setUserid(u.getUserId());
		rs.setStatus(Status.ADD_SUCCESS);
		return ResponseUtils.parse(rs);
	}

	/**
	 * 删除用户
	 * 
	 * @return
	 */
	@RequestMapping(params = { "command=DeleteUser" })
	@ResponseBody
	public String deleteUser(@RequestParam Integer userid) {
		userService.delUser(userid);
		ResStatus rs = new ResStatus();
		rs.setStatus(Status.DEL_SUCCESS);
		return ResponseUtils.parse(rs);
	}

	/**
	 * 修改用户信息
	 * 
	 * @param userid
	 * @param username
	 * @param fullname
	 * @param blocked
	 * @param groupid
	 * @param update_time_regular
	 * @param password
	 * @return
	 */
	@RequestMapping(params = { "command=ModifyUser" })
	@ResponseBody
	public Object modifyUser(@RequestParam Integer userid, String username, String fullname, Byte blocked,
			@RequestParam Integer groupid, Byte update_time_regular,
			String password) {
		User user = new User(userid, username, fullname, blocked, groupid, update_time_regular, password);
		userService.modifyUser(user);
		ResStatus rs = new ResStatus();
		rs.setStatus(Status.MODIFY_SUCCESS);
		return ResponseUtils.parse(rs);
	}

	/**
	 * 查询用户列表
	 * 
	 * @return
	 */
	@RequestMapping(params = { "command=QueryUser" })
	@ResponseBody
	public Object queryUser() {
		ResStatus rs = new ResStatus();
		List<UserVo> userList = null;
		try {
			userList = userService.queryUser();
			rs.setStatus(Status.QUERY_SUCCESS);
		} catch (Exception e) {
			rs.setStatus(Status.SERVER_ERROR);
			log.error(e.getMessage(), e);
		}
		return ResponseUtils.parse(rs, userList);
	}
}
