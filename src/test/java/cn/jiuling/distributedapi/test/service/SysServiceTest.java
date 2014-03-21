package cn.jiuling.distributedapi.test.service;

import javax.annotation.Resource;

import org.junit.Test;

import cn.jiuling.distributedapi.service.SysService;
import cn.jiuling.distributedapi.test.BaseTest;

public class SysServiceTest extends BaseTest {
	@Resource
	private SysService sysService;

	@Test
	public void statusinfo() {
		sysService.statusinfo();
	}

}
