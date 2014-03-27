package cn.jiuling.distributedapi.test.dao;

import javax.annotation.Resource;

import org.junit.Test;

import cn.jiuling.distributedapi.dao.VideoDao;
import cn.jiuling.distributedapi.test.BaseTest;

public class videoDaoTest extends BaseTest {
	@Resource
	private VideoDao videoDao;

	@Test
	public void getVideos() {
		videoDao.getVideosByCamera(1, 1);
	}

	@Test
	public void queryUnAssignVideo() {
		videoDao.queryUnAssignVideo(1l);
	}

	@Test
	public void queryunhandledtask() {
		videoDao.queryunhandledtask(1l);
	}

	@Test
	public void queryassignedtasklist() {
		videoDao.queryassignedtasklist(1l);
	}
}
