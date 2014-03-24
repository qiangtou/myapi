package cn.jiuling.distributedapi.test.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.util.AssertionErrors;

import cn.jiuling.distributedapi.service.CaseService;
import cn.jiuling.distributedapi.test.BaseTest;

public class CaseServiceTest extends BaseTest {
	@Resource
	private CaseService caseService;

	@Test
	public void queryCaseGroup() {
		try {
			List list = caseService.queryCaseGroup();
		} catch (Exception e) {
			AssertionErrors.fail("fail");
		}
	}

	@Test
	public void queryCase() {
		try {
			List list = caseService.queryCase(0, 10, 0, 1);
		} catch (Exception e) {
			AssertionErrors.fail("fail");
		}
	}

}
