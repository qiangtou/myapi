package cn.jiuling.distributedapi.test.dao;

import java.sql.Timestamp;

import javax.annotation.Resource;

import org.junit.Test;

import cn.jiuling.distributedapi.dao.DownloadtasksDao;
import cn.jiuling.distributedapi.test.BaseTest;

public class DownloadtasksDaoTest extends BaseTest {
	@Resource
	private DownloadtasksDao downloadtasksDao;

	@Test
	public void findByTaskNameAndUserUploadVideoId() {
		downloadtasksDao.queryHistoryTaskListList("", 1, new Timestamp(0), new Timestamp(System.currentTimeMillis()));
	}
}
