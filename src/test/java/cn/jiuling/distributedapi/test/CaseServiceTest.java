package cn.jiuling.distributedapi.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.util.Assert;

import cn.jiuling.distributedapi.Vo.CaseVideoVo;
import cn.jiuling.distributedapi.service.CaseService;

public class CaseServiceTest extends BaseTest {
	@Resource
	private CaseService caseService;

	@Test
	public void queryCaseGroup() {
		List list = caseService.queryCaseGroup();
		Assert.notEmpty(list);
	}

	@Test
	public void queryCase() {
		List list = caseService.queryCase(0, 10, 0, 1);
		Assert.notEmpty(list);
	}

	@Test
	public void queryCaseVideo() {
		CaseVideoVo c = caseService.queryCaseVideo(1L);
	}

}
