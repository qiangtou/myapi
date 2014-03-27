package cn.jiuling.distributedapi.test.controller;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.util.AssertionErrors;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import cn.jiuling.distributedapi.test.BaseTest;
import cn.jiuling.distributedapi.web.VideoAnalyzeController;

public class VideoAnalyzeControllerTest extends BaseTest {
	@Resource
	private VideoAnalyzeController videoAnalyzeController;
	@Autowired
	public RequestMappingHandlerAdapter handlerAdapter;

	@Test
	public void queryVideo() {
		request.setRequestURI("/server.php");
		request.setParameter("command", "queryunhandledtask");
		request.setParameter("userid", "1");
		try {
			handlerAdapter
					.handle(request, response, new HandlerMethod(videoAnalyzeController, "queryunhandledtask", new Class[] { Long.class }));
			String res = response.getContentAsString();

			log.info("\n" + res);
		} catch (Exception e) {
			AssertionErrors.fail(e.getMessage());
		}
	}

	@Test
	public void queryassignedtasklist() {
		request.setRequestURI("/server.php");
		request.setParameter("command", "queryassignedtasklist");
		request.setParameter("caseid", "1");
		try {
			handlerAdapter
					.handle(request, response, new HandlerMethod(videoAnalyzeController, "queryassignedtasklist", new Class[] { Long.class }));
			String res = response.getContentAsString();

			log.info("\n" + res);
		} catch (Exception e) {
			AssertionErrors.fail(e.getMessage());
		}
	}
}
