package cn.jiuling.distributedapi.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.TypeMismatchException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.jiuling.distributedapi.Vo.ResStatus;
import cn.jiuling.distributedapi.Vo.Status;
import cn.jiuling.distributedapi.exception.ServiceException;
import cn.jiuling.distributedapi.utils.ResponseUtils;

public class BaseController {
	protected Logger log = Logger.getLogger(this.getClass());
	private final ResStatus PARAMETER_ERROR = new ResStatus(Status.PARAMETER_ERROR);
	private final ResStatus SERVER_ERROR = new ResStatus(Status.SERVER_ERROR);

	protected Integer getUserId(HttpSession session) {
		return (Integer) session.getAttribute("userId");
	}

	@ExceptionHandler(ServiceException.class)
	@ResponseBody
	public String serviceException(HttpServletRequest req, Exception e) {
		log(req, e);
		ServiceException ex = (ServiceException) e;
		ResStatus rs = new ResStatus(ex.getStatus());
		return ResponseUtils.parse(rs);
	}

	private void log(HttpServletRequest req, Exception e) {
		log.error("Request: " + req.getRequestURL() + "," + parameter2String(req) + ", raised: " + e.getMessage(), e.getCause());
	}

	private String parameter2String(HttpServletRequest req) {
		return req.getQueryString();
	}

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public String handleError(HttpServletRequest req, Exception e) {
		log(req, e);
		return ResponseUtils.parse(SERVER_ERROR);
	}

	@ExceptionHandler(value = { TypeMismatchException.class, MissingServletRequestParameterException.class })
	@ResponseBody
	public String handleParameter(HttpServletRequest req, Exception e) {
		log(req, e);
		return ResponseUtils.parse(PARAMETER_ERROR);
	}
}
