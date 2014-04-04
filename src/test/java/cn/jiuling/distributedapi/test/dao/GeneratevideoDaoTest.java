package cn.jiuling.distributedapi.test.dao;

import javax.annotation.Resource;

import org.junit.Test;

import cn.jiuling.distributedapi.dao.GeneratevideoDao;
import cn.jiuling.distributedapi.test.BaseTest;

public class GeneratevideoDaoTest extends BaseTest {
	@Resource
	private GeneratevideoDao generatevideoDao;

	@Test
	public void updateStatus() {
		generatevideoDao.updateStatus(6);
	}
}
