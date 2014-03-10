package cn.jiuling.distributedapi.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.jiuling.distributedapi.Vo.LoginUserVo;
import cn.jiuling.distributedapi.Vo.ResStatus;
import cn.jiuling.distributedapi.Vo.Status;
import cn.jiuling.distributedapi.model.User;
import cn.jiuling.distributedapi.service.UserService;
import cn.jiuling.distributedapi.utils.XmlUtil;

@Controller
@RequestMapping(produces = "text/html;charset=utf-8")
public class LoginController extends BaseController {
	private Logger logger = Logger.getLogger(LoginController.class);

	@Resource
	private UserService userService;

	@RequestMapping(value = "/")
	public String index(HttpSession session) {
		logger.info("进入登录页面");
		return "login";

	}

	@RequestMapping(value = "login.php")
	@ResponseBody
	public String login(String username, String password, HttpSession session) {
		String res;
		User user = new User(username, password);
		logger.info(user);
		user = valideUser(user);
		ResStatus rs = new ResStatus();
		if (null != user) {
			LoginUserVo loginUser = new LoginUserVo();
			loginUser.setUserid(user.getUserId());
			loginUser.setGroupId(user.getGroupId());
			loginUser.setTaskPriority(user.getTaskPriority());
			// TODO 是否允许外部登陆
			loginUser.setSingleormulti("");

			session.setAttribute("userName", user.getUserName());
			session.setAttribute("userId", user.getUserId());
			rs.setStatus(Status.LOGIN_SUCCESS);
			res = XmlUtil.parse(rs, loginUser, false);
		} else {
			rs.setStatus(Status.LOGIN_FAIL);
			res = XmlUtil.parse(rs);
		}
		return res;
	}

	@RequestMapping(value = "logout.php")
	@ResponseBody
	public String logout(HttpSession session) {
		ResStatus rs = new ResStatus(Status.LOGOUT_SUCCESS);
		session.invalidate();
		return XmlUtil.parse(rs);
	}

	@RequestMapping(value = "logfail.php")
	@ResponseBody
	public String logfail(HttpSession session) {
		ResStatus rs = new ResStatus(Status.LOGIN_FAIL);
		return XmlUtil.parse(rs);
	}

	private User valideUser(User user) {
		logger.info("login user is " + user);
		return userService.valideUser(user);
	}

	@RequestMapping(value = "/login/valid.php", produces = "application/json;charset=utf-8")
	@ResponseBody
	public boolean valid(@ModelAttribute("user") User user) {
		boolean isValid = null != valideUser(user);
		return isValid;
	}

}
