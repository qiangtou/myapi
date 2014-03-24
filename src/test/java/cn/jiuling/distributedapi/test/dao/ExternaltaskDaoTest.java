package cn.jiuling.distributedapi.test.dao;

import java.io.Serializable;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Test;

import cn.jiuling.distributedapi.dao.ExternaltaskDao;
import cn.jiuling.distributedapi.model.Externaltask;
import cn.jiuling.distributedapi.test.BaseTest;

public class ExternaltaskDaoTest extends BaseTest {
	@Resource
	private ExternaltaskDao externaltaskDao;

	@Test
	public void findByTaskNameAndUserUploadVideoId() {
		Serializable id = 0;
		String taskName = "浓缩任务";
		long count = externaltaskDao.findByTaskNameAndUserUploadVideoId(id, taskName);
		Assert.assertEquals(3, count);
	}

	@Test
	public void getLastTask() {
		Externaltask e = externaltaskDao.getLastTask(1);
		if (null != e) {
			Assert.assertEquals(10, e.getExtTaskId().intValue());
		}
	}
}
