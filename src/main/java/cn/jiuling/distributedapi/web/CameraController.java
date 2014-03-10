package cn.jiuling.distributedapi.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.jiuling.distributedapi.Vo.ResStatus;
import cn.jiuling.distributedapi.Vo.Status;
import cn.jiuling.distributedapi.service.CaseService;
import cn.jiuling.distributedapi.service.UserService;
import cn.jiuling.distributedapi.utils.XmlUtil;

@Controller
@RequestMapping(value = "server.php", produces = "text/html;charset=utf-8")
public class CameraController extends BaseController {

	@Resource
	private UserService userService;
	@Resource
	private CaseService caseService;

	@RequestMapping(params = { "command=AddCamera" })
	@ResponseBody
	public String addCamera(String username, String grouptitle, String description) {
		ResStatus rs = new ResStatus(Status.LOGOUT_SUCCESS);

		// CaseGroup cg = new CaseGroup(username, grouptitle, description);
		// caseService.addCaseGroup(cg);

		return XmlUtil.parse(rs);
	}

}
