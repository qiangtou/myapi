package cn.jiuling.distributedapi.test.service;

import javax.annotation.Resource;

import org.junit.Test;

import cn.jiuling.distributedapi.service.VideoService;
import cn.jiuling.distributedapi.test.BaseTest;

public class VideoServiceTest extends BaseTest {
	@Resource
	private VideoService videoService;

	@Test
	public void statusinfo() {
		videoService.queryTask(0);
	}

}
