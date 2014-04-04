package cn.jiuling.distributedapi.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.jiuling.distributedapi.Vo.AutoTaskStatusRes;
import cn.jiuling.distributedapi.Vo.DeletedObjVo;
import cn.jiuling.distributedapi.Vo.ResStatus;
import cn.jiuling.distributedapi.Vo.ServerInfoVo;
import cn.jiuling.distributedapi.Vo.ServertimeVo;
import cn.jiuling.distributedapi.Vo.Status;
import cn.jiuling.distributedapi.Vo.StatusInfoVo;
import cn.jiuling.distributedapi.Vo.SummaryResolutionVo;
import cn.jiuling.distributedapi.Vo.TubeBasicInfoFilenameRes;
import cn.jiuling.distributedapi.service.SysService;
import cn.jiuling.distributedapi.utils.ConfigUtils;
import cn.jiuling.distributedapi.utils.ResponseUtils;

@Controller
@RequestMapping(produces = "text/html;charset=utf-8")
public class SysmngController extends BaseController {
	@Resource
	private SysService sysService;

	/**
	 * 7.1服务器版本及ukey到期日查询
	 * 
	 * @return
	 */
	@RequestMapping("serverinfo.php")
	@ResponseBody
	public String serverinfo() {

		ServerInfoVo s = new ServerInfoVo();
		String serveVersion = ConfigUtils.getValue("server_version");
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
	 * 7.3检查磁盘空间及服务器LOAD状态
	 * 
	 * @return
	 */
	@RequestMapping("statusinfo.php")
	@ResponseBody
	public String statusinfo() {
		StatusInfoVo s = sysService.queryStatusinfo();
		return ResponseUtils.parse(null, s, false);
	}

	/**
	 * 7.5清空服务器数据
	 * 
	 * 此接口会清空很多表的数据,磁盘中的文件,谨慎使用
	 * 
	 * @return
	 */
	@RequestMapping("emptyfiledata.php")
	@ResponseBody
	public String emptyfiledata() {
		sysService.emptyfiledata();
		return ResponseUtils.parse(new ResStatus(Status.EXECUTE_SUCCESS));
	}

	/**
	 * TODO 7.6删除(案件,监控点,视频,任务)
	 * 
	 * @param type
	 *            type : 0 任务 1 视频 2 监控点 3 案件
	 * @param id
	 * @return
	 */
	@RequestMapping("delete.php")
	@ResponseBody
	public String delete(HttpSession session, @RequestParam Short type, @RequestParam Long id) {

		// TODO 未登录的情况也可以删除 ,这里待处理
		sysService.delete(type, id);
		return ResponseUtils.parse(new ResStatus(Status.EXECUTE_SUCCESS));
	}

	/**
	 * 7.7恢复标记为删除状态的案件/监控点/视频
	 * 
	 * @param type
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "server.php", params = { "command=AddBackDeletedObj" })
	@ResponseBody
	public String addBackDeletedObj(@RequestParam Short type, @RequestParam Long id) {
		sysService.addBackDeletedObj(type, id);
		return ResponseUtils.parse(new ResStatus(Status.ADD_SUCCESS));
	}

	/**
	 * 7.8获取系统支持的浓缩视频分辨率列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "server.php", params = { "command=QuerySummaryResolution" })
	@ResponseBody
	public String querySummaryResolution() {
		List<SummaryResolutionVo> list = sysService.querySummaryResolution();
		return ResponseUtils.parse(new ResStatus(Status.QUERY_SUCCESS), list);
	}

	/**
	 * 7.9获取描述对象信息的tbi文件
	 * 
	 * @param FlowNumber
	 * @param TubeID
	 * @return
	 */
	@RequestMapping(value = "server.php", params = { "command=QueryTubeBasicInfoFilename" })
	@ResponseBody
	public String queryTubeBasicInfoFilename(@RequestParam String FlowNumber, Long TubeID) {
		String fileUrl = sysService.queryTubeBasicInfoFilename(FlowNumber, TubeID);
		return ResponseUtils.parse(new TubeBasicInfoFilenameRes(Status.QUERY_SUCCESS, fileUrl));
	}

	/**
	 * 7.10获取自动分析任务状态
	 * 
	 * @param caseid
	 * @param userid
	 * @return
	 */
	@RequestMapping(value = "server.php", params = { "command=QueryAutoTaskStatus" })
	@ResponseBody
	public String queryAutoTaskStatus(@RequestParam Long caseid, @RequestParam Long userid) {
		Short status = sysService.queryAutoTaskStatus(caseid, userid);
		return ResponseUtils.parse(new AutoTaskStatusRes(Status.QUERY_SUCCESS, status));
	}

	/**
	 * 7.11获取回收站资源信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "server.php", params = { "command=QueryDeletedObj" })
	@ResponseBody
	public String queryDeletedObj() {
		List<DeletedObjVo> list = sysService.queryDeletedObj();
		return ResponseUtils.parse(new ResStatus(Status.QUERY_SUCCESS), list);
	}

	/**
	 * 7.12查询未完成任务信息....没有的接口
	 * 
	 * @param userid
	 * @return
	 */
	/*@RequestMapping(value = "server.php", params = { "command=QueryUnHandledTask" })
	@ResponseBody
	public String queryNotCompleteTask(@RequestParam Long userid) {
		sysService.QueryUnHandledTask(userid);
		return ResponseUtils.parse(new ResStatus(Status.QUERY_SUCCESS), list);
	}*/
}
