package cn.jiuling.distributedapi.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	public static final String LOGIN_FAIL_PATH = "/logfail.php";
	private final Logger logger = Logger.getLogger(LoginInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// log开头的就放行

		String uri = request.getRequestURI();
		// login logout
		if (uri.startsWith("/log")) {
			return true;
		}
		Object user = WebUtils.getSessionAttribute(request, "userId");
		logger.info("enter login interceptor,user is " + user + ",url is " + uri);
		if (StringUtils.isEmpty(user)) {
			request.getRequestDispatcher(LOGIN_FAIL_PATH).forward(request, response);
			return false;
		}
		return true;
	}

}
