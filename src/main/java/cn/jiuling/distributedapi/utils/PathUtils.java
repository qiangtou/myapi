package cn.jiuling.distributedapi.utils;

import org.springframework.web.context.ContextLoader;

public class PathUtils {
	public static String getWebRoot() {
		return ContextLoader.getCurrentWebApplicationContext().getServletContext().getRealPath("/");
	}

}
