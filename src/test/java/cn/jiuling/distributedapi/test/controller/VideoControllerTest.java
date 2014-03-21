package cn.jiuling.distributedapi.test.controller;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.util.AssertionErrors;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import cn.jiuling.distributedapi.test.BaseTest;
import cn.jiuling.distributedapi.web.VideoController;

public class VideoControllerTest extends BaseTest {
	@Resource
	private VideoController videoController;
	@Autowired
	public RequestMappingHandlerAdapter handlerAdapter;

	@Test
	public void queryVideo() {
		request.setRequestURI("/server.php");
		request.setParameter("command", "QueryVideo");
		request.setParameter("cameraid", "1");
		request.setParameter("userid", "1");
		try {
			handlerAdapter
					.handle(request, response, new HandlerMethod(videoController, "queryVideo", new Class[] { Long.class, Long.class }));
			String res = response.getContentAsString();

			log.info("\n" + res);
		} catch (Exception e) {
			AssertionErrors.fail(e.getMessage());
		}
	}

	@Test
	public void add3rdVideo() {
		request.setRequestURI("/server.php");
		request.setParameter("command", "Add3rdVideo");
		request.setParameter("cameraid", "1");
		request.setParameter("srcurl", "1");
		request.setParameter("platformname", "");
		try {
			handlerAdapter
					.handle(request, response, new HandlerMethod(videoController, "add3rdVideo", new Class[] { Long.class, String.class, String.class,
							Short.class }));
			String res = response.getContentAsString();
			log.info("\n" + res);

			request.setParameter("srcurl", "http://ggg?schedule=1");
			handlerAdapter
					.handle(request, response, new HandlerMethod(videoController, "add3rdVideo", new Class[] { Long.class, String.class, String.class,
							Short.class }));
			res = response.getContentAsString();
			log.info("\n" + res);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			AssertionErrors.fail(e.getMessage());
		}
	}
}
