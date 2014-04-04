package cn.jiuling.distributedapi.test.dao;

import javax.annotation.Resource;

import org.junit.Test;

import cn.jiuling.distributedapi.dao.EnhanceTaskDao;
import cn.jiuling.distributedapi.test.BaseTest;

public class EnhanceTaskDaoTest extends BaseTest {
	@Resource
	private EnhanceTaskDao enhanceTaskDao;

	@Test
	public void getLastTask() {
		// enhanceTaskDao.findByEnhanceType("hhh", 2, 10);
		enhanceTaskDao.deleteAll();
	}
}
