package cn.jiuling.distributedapi.test.controller;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.util.AssertionErrors;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import cn.jiuling.distributedapi.test.BaseTest;
import cn.jiuling.distributedapi.web.SysmngController;

public class SysmngControllerTest extends BaseTest {
	@Resource
	private SysmngController sysmngController;
	@Autowired
	public RequestMappingHandlerAdapter handlerAdapter;

	@Test
	public void serverinfo() {
		request.setRequestURI("/serverinfo.php");
		try {
			handlerAdapter
					.handle(request, response, new HandlerMethod(sysmngController, "serverinfo"));
			String res = response.getContentAsString();

			log.info("\n" + res);
		} catch (Exception e) {
			String message = e.getMessage();
			log.error(message, e);
			AssertionErrors.fail(message);
		}
	}
}
