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
import cn.jiuling.distributedapi.utils.XmlUtil;

public class BaseController {
	protected Logger log = Logger.getLogger(this.getClass());

	protected Integer getUserId(HttpSession session) {
		return (Integer) session.getAttribute("userId");
	}

	@ExceptionHandler(ServiceException.class)
	@ResponseBody
	public String serviceException(HttpServletRequest req, Exception e) {
		log.error("Request: " + req.getRequestURL() + "," + parameter2String(req) + ", raised " + e.getMessage(), e.getCause());
		ResStatus rs = new ResStatus();
		ServiceException ex = (ServiceException) e;
		rs.setStatus(ex.getStatus());
		return XmlUtil.parse(rs);
	}

	private String parameter2String(HttpServletRequest req) {
		return req.getQueryString();
	}

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public String handleError(HttpServletRequest req, Exception e) {
		log.error("Request: " + req.getRequestURL() + "," + parameter2String(req) + ", raised " + e.getMessage(), e.getCause());
		ResStatus rs = new ResStatus();
		rs.setStatus(Status.SERVER_ERROR);
		return XmlUtil.parse(rs);
	}

	@ExceptionHandler(value = { TypeMismatchException.class, MissingServletRequestParameterException.class })
	@ResponseBody
	public String handleParameter(HttpServletRequest req, Exception e) {
		log.error("Request: " + req.getRequestURL() + "," + parameter2String(req) + ", raised " + e.getMessage(), e.getCause());
		ResStatus rs = new ResStatus();
		rs.setStatus(Status.PARAMETER_ERROR);
		return XmlUtil.parse(rs);
	}
}
