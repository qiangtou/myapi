package cn.jiuling.distributedapi.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.jiuling.distributedapi.Vo.LoginUserVo;
import cn.jiuling.distributedapi.Vo.ResStatus;
import cn.jiuling.distributedapi.Vo.Status;
import cn.jiuling.distributedapi.model.User;
import cn.jiuling.distributedapi.service.UserService;
import cn.jiuling.distributedapi.utils.ResponseUtils;

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
		ResStatus rs = new ResStatus();
		try {
			User user = new User(username, password);
			logger.info(user);
			LoginUserVo loginUser = userService.getLoginUser(user);
			if (null != loginUser) {
				session.setAttribute("userName", user.getUserName());
				session.setAttribute("userId", loginUser.getUserid());
				rs.setStatus(Status.LOGIN_SUCCESS);
				res = ResponseUtils.parse(rs, loginUser, false);
			} else {
				rs.setStatus(Status.LOGIN_FAIL);
				res = ResponseUtils.parse(rs);
			}
		} catch (Exception e) {
			rs.setStatus(Status.LOGIN_FAIL);
			res = ResponseUtils.parse(rs);
		}
		return res;
	}

	@RequestMapping(value = "logout.php")
	@ResponseBody
	public String logout(HttpSession session) {
		ResStatus rs = new ResStatus(Status.LOGOUT_SUCCESS);
		session.invalidate();
		return ResponseUtils.parse(rs);
	}

	@RequestMapping(value = "logfail.php")
	@ResponseBody
	public String logfail(HttpSession session) {
		ResStatus rs = new ResStatus(Status.LOGIN_FAIL);
		return ResponseUtils.parse(rs);
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

	@RequestMapping(value = "/login/valid.php", params = "oldpw", produces = "application/json;charset=utf-8")
	@ResponseBody
	public boolean validOldPw(String oldpw, HttpSession session) {
		log.info(oldpw);
		Integer userid = super.getUserId(session);
		return userService.validOldPw(userid, oldpw);
	}

	@RequestMapping(value = "modifypassword.php")
	public void modifypassword() {
	}

	@RequestMapping(value = "modifypassword.php", params = "newpw", produces = "application/json;charset=utf-8")
	@ResponseBody
	public boolean modifypassword(@RequestParam String oldpw, @RequestParam String newpw, HttpSession session) {
		boolean flag = false;
		try {
			Integer userid = super.getUserId(session);
			User user = userService.modifyPw(userid, oldpw, newpw);
			flag = true;
		} catch (Exception e) {

		}
		return flag;
	}
}
