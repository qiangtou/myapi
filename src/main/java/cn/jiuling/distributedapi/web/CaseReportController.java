package cn.jiuling.distributedapi.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.jiuling.distributedapi.Vo.CaseReportVo;
import cn.jiuling.distributedapi.Vo.ResStatus;
import cn.jiuling.distributedapi.Vo.Status;
import cn.jiuling.distributedapi.service.CaseService;
import cn.jiuling.distributedapi.utils.ResponseUtils;

@Controller
@RequestMapping(produces = "text/html;charset=utf-8")
public class CaseReportController extends BaseController {

	@Resource
	private CaseService caseService;

	/**
	 * 案件报告
	 * 
	 * @param caseid
	 * @return
	 */
	@RequestMapping("case_report.php")
	@ResponseBody
	public String queryCaseReport(@RequestParam Long caseid) {
		CaseReportVo c = caseService.queryCaseReport(caseid);
		ResStatus rs = new ResStatus(Status.QUERY_SUCCESS);
		return ResponseUtils.parse(rs, c);
	}
}
