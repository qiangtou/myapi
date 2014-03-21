package cn.jiuling.distributedapi.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.jiuling.distributedapi.Vo.ResStatus;
import cn.jiuling.distributedapi.Vo.ServerInfoVo;
import cn.jiuling.distributedapi.Vo.ServertimeVo;
import cn.jiuling.distributedapi.Vo.StatusInfoVo;
import cn.jiuling.distributedapi.service.SysService;
import cn.jiuling.distributedapi.utils.ConfigUtils;
import cn.jiuling.distributedapi.utils.ResponseUtils;

@Controller
@RequestMapping(produces = "text/html;charset=utf-8")
public class SysmngController extends BaseController {
	@Resource
	private SysService sysService;

	/**
	 * 服务器版本及ukey到期日查询
	 * 
	 * @return
	 */
	@RequestMapping("serverinfo.php")
	@ResponseBody
	public String serverinfo() {

		ServerInfoVo s = new ServerInfoVo();
		String serveVersion = ConfigUtils.getValue("server_version");
		// TODO 文档中写死了
		String ukeyDeadline = "2012-12-07";
		s.setUkeyDeadline(ukeyDeadline);
		s.setServeVersion(serveVersion);

		ResStatus r = new ResStatus();
		return ResponseUtils.parse(null, r, false);
	}

	/**
	 * 获取服务器当前系统时间
	 * 
	 * @return 现在距离1970年的秒数
	 */

	@RequestMapping("getservertime.php")
	@ResponseBody
	public String getservertime() {
		long currentTimeMillis = System.currentTimeMillis();
		ServertimeVo s = new ServertimeVo(currentTimeMillis / 1000);
		return ResponseUtils.parse(null, s, false);
	}

	/**
	 * 检查磁盘空间及服务器LOAD状态
	 * 
	 * @return
	 */
	@RequestMapping("statusinfo.php")
	@ResponseBody
	public String statusinfo() {
		StatusInfoVo s = sysService.statusinfo();
		return ResponseUtils.parse(null, s, false);
	}
}
