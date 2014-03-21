package cn.jiuling.distributedapi.web;

import java.sql.Timestamp;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.jiuling.distributedapi.Vo.ExternaltaskVo;
import cn.jiuling.distributedapi.Vo.ExttaskstatusVo;
import cn.jiuling.distributedapi.Vo.QueryTaskListResultVo;
import cn.jiuling.distributedapi.Vo.ResStatus;
import cn.jiuling.distributedapi.Vo.Status;
import cn.jiuling.distributedapi.Vo.TaskListRes;
import cn.jiuling.distributedapi.model.Externaltask;
import cn.jiuling.distributedapi.service.VideoService;
import cn.jiuling.distributedapi.utils.ResponseUtils;

/**
 * 6. 视频分析任务管理
 * 
 * @author jiuling
 * 
 */
@Controller
@RequestMapping(produces = "text/html;charset=utf-8")
public class VideoAnalyzeController extends BaseController {
	@Resource
	private VideoService videoService;

	/**
	 * 6.1视频摘要/检索提交任务
	 * 
	 * @param UserUploadVideoId
	 * @param type
	 * @param run_time_speed
	 * @param filename
	 * @param fileSize
	 * @param sourceUrl
	 * @param thickness
	 * @param sensitivity
	 * @param framerate_nu
	 * @param obj_enable
	 * @param obj_type
	 * @param obj_subtype
	 * @param color_tolerance
	 * @param retrieve_avgcolor
	 * @param retrieve_uppercolor
	 * @param retrieve_lowercolor
	 * @param retrieve_carnum
	 * @param objHeight
	 * @param objWidth
	 * @param objDepth
	 * @param startFrame
	 * @param endFrame
	 * @param tripwire_x1
	 * @param tripwire_x2
	 * @param tripwire_y1
	 * @param tripwire_y2
	 * @param tripwire_crossdir
	 * @param summary_height
	 * @param summary_width
	 * @param isSetTripArea
	 * @param trip_area
	 * @param isocx
	 * @param UDR_exist
	 * @param UDR_setting
	 * @param task_priority
	 * @param snap_type
	 * @param taskName
	 * @param enable_search_by_image
	 * @param request_image_url
	 * @param request_mask_url
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("submitTask.php")
	@ResponseBody
	public String submitTask(
			Integer userid,
			@RequestParam(required = false, defaultValue = "0") Integer UserUploadVideoId,
			@RequestParam(required = false, defaultValue = "2") Short type,
			@RequestParam(required = false, defaultValue = "3") Short run_time_speed,
			@RequestParam(required = false, defaultValue = "") String filename,
			@RequestParam(required = false, defaultValue = "0") Integer fileSize,
			@RequestParam(required = false, defaultValue = "") String sourceUrl,
			@RequestParam(required = false, defaultValue = "0") Short thickness,
			@RequestParam(required = false, defaultValue = "2") Float sensitivity,
			@RequestParam(required = false, defaultValue = "25") Short framerate_nu,
			@RequestParam(required = false, defaultValue = "0") Short obj_enable,
			@RequestParam(required = false, defaultValue = "0") Short obj_type,
			@RequestParam(required = false, defaultValue = "0") Short obj_subtype,
			@RequestParam(required = false, defaultValue = "0") Float color_tolerance,
			@RequestParam(required = false, defaultValue = "1") Short isContain,
			@RequestParam(required = false, defaultValue = "1") Short isRegSet,
			@RequestParam(required = false, defaultValue = "0") Integer retrieve_avgcolor,
			@RequestParam(required = false, defaultValue = "0") Integer retrieve_uppercolor,
			@RequestParam(required = false, defaultValue = "0") Integer retrieve_lowercolor,
			@RequestParam(required = false, defaultValue = "0") Integer retrieve_carnum,
			@RequestParam(required = false, defaultValue = "0") Short objHeight,
			@RequestParam(required = false, defaultValue = "0") Short objWidth,
			@RequestParam(required = false, defaultValue = "0") Short objDepth,
			@RequestParam(required = false, defaultValue = "-1") Short clockwise_point1_x,
			@RequestParam(required = false, defaultValue = "-1") Short clockwise_point1_y,
			@RequestParam(required = false, defaultValue = "-1") Short clockwise_point2_x,
			@RequestParam(required = false, defaultValue = "-1") Short clockwise_point2_y,
			@RequestParam(required = false, defaultValue = "-1") Short clockwise_point3_x,
			@RequestParam(required = false, defaultValue = "-1") Short clockwise_point3_y,
			@RequestParam(required = false, defaultValue = "-1") Short clockwise_point4_x,
			@RequestParam(required = false, defaultValue = "-1") Short clockwise_point4_y,
			@RequestParam(required = false, defaultValue = "0") Integer startFrame,
			@RequestParam(required = false, defaultValue = "5400000") Integer endFrame,
			@RequestParam(required = false, defaultValue = "0") Short tripwire_x1,
			@RequestParam(required = false, defaultValue = "0") Short tripwire_y1,
			@RequestParam(required = false, defaultValue = "0") Short tripwire_x2,
			@RequestParam(required = false, defaultValue = "0") Short tripwire_y2,
			@RequestParam(required = false, defaultValue = "0") Short tripwire_crossdir,
			@RequestParam(required = false, defaultValue = "-1") Short summary_height,
			@RequestParam(required = false, defaultValue = "-1") Short summary_width,
			@RequestParam(required = false, defaultValue = "0") Short isSetTripArea,
			@RequestParam(required = false, defaultValue = "") String trip_area,
			@RequestParam(required = false, defaultValue = "0") Short UDR_exist,
			@RequestParam(required = false, defaultValue = "") String UDR_setting,
			@RequestParam(required = false, defaultValue = "0") Short task_priority,
			@RequestParam(required = false, defaultValue = "0") Long record_time,
			@RequestParam(required = false, defaultValue = "0") Short snap_type,
			String taskName,
			@RequestParam(required = false, defaultValue = "0") Short enable_search_by_image,
			@RequestParam(required = false, defaultValue = "0") Short IsAutoAnalyse,
			String request_image_url,
			String request_mask_url,
			@RequestParam(required = false, defaultValue = "") String flowNumber,
			HttpSession session) throws MissingServletRequestParameterException {
		// session 找不到userid,使用客户传递过来的
		userid = super.getUserId(session);
		if (null == userid) {
			userid = 0;
		}

		Externaltask e = videoService.submitTask(UserUploadVideoId,
					type,
					run_time_speed,
					filename,
					fileSize,
					sourceUrl,
					thickness,
					sensitivity.shortValue(),
					framerate_nu,
					obj_enable,
					obj_type,
					obj_subtype,
					color_tolerance.shortValue(),
					retrieve_avgcolor,
					retrieve_uppercolor,
					retrieve_lowercolor,
					retrieve_carnum,
					objHeight,
					objWidth,
					objDepth,
					startFrame,
					endFrame,
					tripwire_x1,
					tripwire_y1,
					tripwire_x2,
					tripwire_y2,
					tripwire_crossdir,
					summary_height,
					summary_width,
					isSetTripArea,
					trip_area,
					UDR_exist,
					UDR_setting,
					task_priority,
					snap_type,
					taskName,
					enable_search_by_image,
					request_image_url,
					request_mask_url, userid, IsAutoAnalyse,
					clockwise_point1_x,
					clockwise_point1_y,
					clockwise_point2_x,
					clockwise_point2_y,
					clockwise_point3_x,
					clockwise_point3_y,
					clockwise_point4_x,
					clockwise_point4_y, isRegSet, flowNumber, isContain
				);
		ExternaltaskVo v = new ExternaltaskVo(Status.ADD_SUCCESS, e.getFlowNumber());
		return ResponseUtils.parse(null, v, false);
	}

	/**
	 * 6.2视频处理任务状态查询
	 * 
	 * @param flowNumber
	 * @return
	 */
	@RequestMapping("query.php")
	@ResponseBody
	public String query(@RequestParam String flowNumber) {
		ExttaskstatusVo v = videoService.queryExttaskstatus(flowNumber);
		return ResponseUtils.parse(new ResStatus(Status.QUERY_SUCCESS), v, false);

	}

	/**
	 * 6.3视频处理任务列表查询
	 * 
	 * @param userid
	 * @param startTime
	 * @param endTime
	 * @param index
	 * @param count
	 * @param status
	 *            (可选，默认返回所有状态)要查询的状态 (101=2|5|7|8 查询正在分析、等待分析等状态)
	 * @return
	 */
	@RequestMapping("taskList.php")
	@ResponseBody
	public String taskList(
			@RequestParam(required = false, defaultValue = "super") String userid,
			Timestamp startTime,
			Timestamp endTime,
			@RequestParam(required = false, defaultValue = "0") Integer index,
			@RequestParam(required = false, defaultValue = "-1") Integer count,
			@RequestParam(required = false, defaultValue = "0") Integer status) {
		QueryTaskListResultVo result = videoService.queryTaskList(userid, status, startTime, endTime, index, count);

		TaskListRes rs = new TaskListRes(Status.QUERY_SUCCESS, result);

		return ResponseUtils.parse(rs, result.getList());

	}

	/**
	 * 6.3视频处理任务详细信息查询
	 * 
	 * @param flowNumber
	 * @return
	 */
	@RequestMapping("taskDetail.php")
	@ResponseBody
	public String taskDetail(@RequestParam String flowNumber) {

		// TODO 视频处理任务详细信息查询,表mst_analysistask找不到
		// TaskListRes rs = new TaskListRes(Status.QUERY_SUCCESS);
		videoService.queryTaskDetail(flowNumber);
		return ResponseUtils.parse(null, null, false);

	}

	/**
	 * 添加视频转码
	 * 
	 * @param userid
	 * @param srcName
	 * @param isAutoSubmit
	 * @return
	 */
	@RequestMapping("addtranscodetask.php")
	@ResponseBody
	public String addTranscodeTask(@RequestParam Long userid, @RequestParam String srcName,
			@RequestParam(required = false, defaultValue = "0") Short isAutoSubmit) {
		srcName = srcName.trim();
		videoService.addTranscodeTask(userid, srcName, isAutoSubmit);
		return ResponseUtils.parse(null);

	}

	/**
	 * 查询已上传视频列表
	 * 
	 * TODO php中userid是必填的,但是api文档中没有这个参数
	 * 
	 * @param startTime
	 * @param endTime
	 * @param index
	 * @param count
	 * @param status
	 * @return
	 */
	@RequestMapping("getuploadtasklist.php")
	@ResponseBody
	public String getuploadtasklist(
			@RequestParam(required = false, defaultValue = "0") Long startTime,
			Long endTime,
			@RequestParam(required = false, defaultValue = "0") Integer index,
			@RequestParam(required = false, defaultValue = "-1") Integer count,
			@RequestParam(required = false, defaultValue = "-1") Integer status) {

		// TODO 添加视频转码,表mst_analysistask找不到
		// TaskListRes rs = new TaskListRes(Status.QUERY_SUCCESS);
		return ResponseUtils.parse(null);

	}

	/**
	 * 查询转码视频状态
	 * 
	 * TODO 没有表mst_masterconfig
	 * 
	 * @param UserUploadVideoId
	 * @return
	 */
	@RequestMapping("querytranscodestatus.php")
	@ResponseBody
	public String querytranscodestatus(@RequestParam Long UserUploadVideoId) {
		// SELECT t.status,t.srcURL,t.destURL,t.progress,CONCAT(c.VirtualDAT,
		// right(t.destURL,char_length(t.destURL)-char_length(c.PhysicalDATPath)))
		// as downloadURI FROM mst_videotranscode t ,mst_masterconfig c WHERE
		// t.VideoId = " . $VideoId;
		// TaskListRes rs = new TaskListRes(Status.QUERY_SUCCESS);
		return ResponseUtils.parse(null);

	}

	/**
	 * 获取单快照打包文件名
	 * 
	 * @param flownumber
	 * @param SnapshotType
	 * @param sortType
	 * @param sortOrder
	 * @param objType
	 * @param objSize
	 * @param rgbInfo
	 * @param obj_type
	 * @return
	 */
	@RequestMapping("getsnapshotzipurl.php")
	@ResponseBody
	public String getsnapshotzipurl(@RequestParam Long flownumber, Short SnapshotType,
			Short sortType,
			Short sortOrder,
			Short objType,
			Short objSize,
			Short rgbInfo,
			Short obj_type) {

		// TODO添加视频转码,表mst_analysistask找不到
		// TaskListRes rs = new TaskListRes(Status.QUERY_SUCCESS);
		return ResponseUtils.parse(null);

	}
}
