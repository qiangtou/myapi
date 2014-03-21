package cn.jiuling.distributedapi.web;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.jiuling.distributedapi.Vo.DownloadTasksVo;
import cn.jiuling.distributedapi.Vo.IdRes;
import cn.jiuling.distributedapi.Vo.QueryTaskVo;
import cn.jiuling.distributedapi.Vo.ResStatus;
import cn.jiuling.distributedapi.Vo.Status;
import cn.jiuling.distributedapi.Vo.TotalRes;
import cn.jiuling.distributedapi.service.VideoService;
import cn.jiuling.distributedapi.utils.ResponseUtils;

@Controller
@RequestMapping(value = "server.php", produces = "text/html;charset=utf-8")
public class VideoController extends BaseController {
	@Resource
	private VideoService videoService;

	/**
	 * 查询监控点的视频列表
	 * 
	 * @param cameraid
	 * @param userid
	 * @return
	 */
	@RequestMapping(params = "command=QueryVideo")
	@ResponseBody
	public String queryVideo(@RequestParam Long cameraid, Long userid) {

		List list = videoService.queryVideo(cameraid, userid);
		TotalRes rs = new TotalRes(Status.QUERY_SUCCESS, list.size());
		return ResponseUtils.parse(rs, list);
	}

	/**
	 * 查询视频分析列表
	 * 
	 * @param uploadvideoid
	 * @return
	 */
	@RequestMapping(params = "command=QueryTask")
	@ResponseBody
	public String queryTask(@RequestParam Integer uploadvideoid) {
		List<QueryTaskVo> list = videoService.queryTask(uploadvideoid);
		return ResponseUtils.parse(new ResStatus(Status.QUERY_SUCCESS), list);
	}

	/**
	 * 修改视频
	 * 
	 * @param videoid
	 * @param record_time
	 * @param userid
	 * @return
	 */
	@RequestMapping(params = "command=ModifyVideo")
	@ResponseBody
	public String modifyVideo(@RequestParam Long videoid, Timestamp record_time, Long userid) {
		videoService.modifyVideo(videoid, record_time, userid);
		ResStatus rs = new ResStatus(Status.MODIFY_SUCCESS);
		return ResponseUtils.parse(rs);
	}

	/**
	 * 添加第三方平台视频
	 * 
	 * @param cameraid
	 * @param srcurl
	 * @param platformname
	 * @param isautosubmit
	 * @return
	 */
	@RequestMapping(params = "command=Add3rdVideo")
	@ResponseBody
	public String add3rdVideo(@RequestParam Long cameraid, @RequestParam String srcurl, String platformname,
			@RequestParam(required = false, defaultValue = "0") Short isautosubmit) {
		long id = videoService.add3rdVideo(cameraid, srcurl, platformname, isautosubmit);
		IdRes rs = new IdRes(Status.ADD_SUCCESS, id);
		return ResponseUtils.parse(rs);
	}

	/**
	 * 查询监控点下第三方平台视频状态和进度
	 * 
	 * @param cameraid
	 * @param srcurl
	 * @param platformname
	 * @param isautosubmit
	 * @return
	 */
	@RequestMapping(params = "command=Query3rdVideoStatus")
	@ResponseBody
	public String query3rdVideoStatus(@RequestParam Long id) {
		DownloadTasksVo d = videoService.query3rdVideoStatus(id);
		ResStatus rs = new ResStatus(Status.QUERY_SUCCESS);
		return ResponseUtils.parse(rs, d, false);
	}

	/**
	 * 查询监控点下第三方平台视频列表
	 * 
	 * @param cameraid
	 *            挂接到的摄像头id
	 * @param startTime
	 *            （可选，默认0，全部时间段）开始时间戳
	 * @param endTime
	 *            （可选，默认-1，全部时间段）结束时间戳（1970 00:00:00 GMT 起的秒数）
	 * @param index
	 *            （可选，默认0，第一个任务开始返回）开始任务位置
	 * @param count
	 *            （可选，默认-1，返回所有任务）要查询的数量
	 * @param status
	 *            可选，默认-1，返回所有状态的任务
	 * @return
	 */
	@RequestMapping(params = "command=Query3rdVideoList")
	@ResponseBody
	public String query3rdVideoList(@RequestParam Long cameraid,
			@RequestParam(required = false, defaultValue = "0") long startTime,
			@RequestParam(required = false, defaultValue = "-1") long endTime,
			@RequestParam(required = false, defaultValue = "0") Integer index,
			@RequestParam(required = false, defaultValue = "-1") Integer count,
			@RequestParam(required = false, defaultValue = "-1") Short status) {
		Timestamp end = new Timestamp(endTime == -1 ? System.currentTimeMillis() : endTime);
		Timestamp start = new Timestamp(startTime);
		List list = videoService.query3rdVideoList(cameraid, status, start, end, index, count);
		ResStatus rs = new ResStatus(Status.QUERY_SUCCESS);
		return ResponseUtils.parse(rs, list);
	}
}
