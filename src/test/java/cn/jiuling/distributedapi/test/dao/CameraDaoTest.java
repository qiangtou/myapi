package cn.jiuling.distributedapi.test.dao;

import javax.annotation.Resource;

import org.junit.Test;

import cn.jiuling.distributedapi.dao.CameraDao;
import cn.jiuling.distributedapi.model.Camera;
import cn.jiuling.distributedapi.test.BaseTest;

public class CameraDaoTest extends BaseTest {
	@Resource
	private CameraDao cameraDao;

	@Test
	public void deleteByCaseId() {
		// cameraDao.deleteByCaseId(6L);

		Camera c = cameraDao.load(1L);
		c.setDescription("hehe");
		cameraDao.update(c);
	}
}
