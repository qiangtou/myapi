package cn.jiuling.distributedapi.test.dao;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Test;

import cn.jiuling.distributedapi.dao.ExttaskstatusDao;
import cn.jiuling.distributedapi.model.Exttaskstatus;
import cn.jiuling.distributedapi.test.BaseTest;

public class ExttaskstatusDaoTest extends BaseTest {
	@Resource
	private ExttaskstatusDao exttaskstatusDao;

	@Test
	public void findByTaskNameAndUserUploadVideoId() {
		Exttaskstatus e = exttaskstatusDao.getExttaskstatus(null);
		Assert.assertNotNull(e);
	}
}
