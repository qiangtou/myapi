package cn.jiuling.distributedapi.web;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.jiuling.distributedapi.Vo.AssignedtaskVo;
import cn.jiuling.distributedapi.Vo.AutoAnalyseParamVo;
import cn.jiuling.distributedapi.Vo.Autoanalyseparam4cameraVo;
import cn.jiuling.distributedapi.Vo.EnhanceTaskVo;
import cn.jiuling.distributedapi.Vo.ExternaltaskVo;
import cn.jiuling.distributedapi.Vo.ExttaskstatusVo;
import cn.jiuling.distributedapi.Vo.FsrtaskVo;
import cn.jiuling.distributedapi.Vo.IdRes;
import cn.jiuling.distributedapi.Vo.ListResultVo;
import cn.jiuling.distributedapi.Vo.OrgvideofragmenturlRes;
import cn.jiuling.distributedapi.Vo.PicEnhanceListVo;
import cn.jiuling.distributedapi.Vo.ResStatus;
import cn.jiuling.distributedapi.Vo.SnapshotzipurlRes;
import cn.jiuling.distributedapi.Vo.Status;
import cn.jiuling.distributedapi.Vo.TaskDetailVo;
import cn.jiuling.distributedapi.Vo.TaskListRes;
import cn.jiuling.distributedapi.Vo.TotalRes;
import cn.jiuling.distributedapi.Vo.TranscodeStatusVo;
import cn.jiuling.distributedapi.Vo.UnAssignVideoVo;
import cn.jiuling.distributedapi.Vo.UseruploadvideoVo;
import cn.jiuling.distributedapi.Vo.VideoEnhanceListVo;
import cn.jiuling.distributedapi.exception.ServiceException;
import cn.jiuling.distributedapi.model.EnhanceTask;
import cn.jiuling.distributedapi.model.Externaltask;
import cn.jiuling.distributedapi.model.Fsrtask;
import cn.jiuling.distributedapi.model.Useruploadvideo;
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
// @RequestMapping(produces = "application/xml;charset=utf-8")
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
		ListResultVo result = videoService.queryTaskList(userid, status, startTime, endTime, index, count);

		TaskListRes rs = new TaskListRes(Status.QUERY_SUCCESS, result);

		return ResponseUtils.parse(rs, result.getList());

	}

	/**
	 * 6.4视频处理任务详细信息查询
	 * 
	 * @param flowNumber
	 * @return
	 */
	@RequestMapping("taskDetail.php")
	@ResponseBody
	public String taskDetail(@RequestParam String flowNumber) {

		TaskDetailVo t = videoService.queryTaskDetail(flowNumber);
		return ResponseUtils.parse(null, t, false);

	}

	/**
	 * 6.5添加视频转码
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
		Useruploadvideo u = videoService.addTranscodeTask(userid, srcName, isAutoSubmit);
		UseruploadvideoVo v = new UseruploadvideoVo();
		v.setDestUrl(u.getDestUrl());
		v.setUserUploadVideoId(u.getUserUploadVideoId());
		return ResponseUtils.parse(new ResStatus(Status.ADD_SUCCESS), v, false);

	}

	/**
	 * 6.6查询已上传视频列表
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
			@RequestParam String userid,
			@RequestParam(required = false, defaultValue = "0") Long startTime,
			Long endTime,
			@RequestParam(required = false, defaultValue = "0") Integer index,
			@RequestParam(required = false, defaultValue = "-1") Integer count,
			@RequestParam(required = false, defaultValue = "-1") Integer status) {

		ListResultVo result = videoService.getuploadtasklist(userid, status, startTime, endTime, index, count);
		TaskListRes rs = new TaskListRes(Status.QUERY_SUCCESS, result);

		return ResponseUtils.parse(rs, result.getList());

	}

	/**
	 * 6.7查询转码视频状态
	 * 
	 * @param UserUploadVideoId
	 * @return
	 */
	@RequestMapping("querytranscodestatus.php")
	@ResponseBody
	public String querytranscodestatus(@RequestParam Long UserUploadVideoId) {
		TranscodeStatusVo tv = videoService.queryTranscodeStatus(UserUploadVideoId);
		return ResponseUtils.parse(new ResStatus(Status.QUERY_SUCCESS), tv, false);
	}

	/**
	 * TODO 6.8获取单快照打包文件名
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
	public String getsnapshotzipurl(@RequestParam String flownumber,
			@RequestParam(required = false, defaultValue = "tube") String SnapshotType,
				Short sortType,
				Short sortOrder,
				Short objType,
			@RequestParam(required = false, defaultValue = "0") Short objSize,
			@RequestParam(required = false, defaultValue = "null,null,null,null,null,null,null,null,null") String rgbInfo,
			@RequestParam(required = false, defaultValue = "0") Short obj_type) {

		String url = videoService.getsnapshotzipurl(flownumber, SnapshotType, sortType, sortOrder, objType, objSize, rgbInfo, obj_type);
		return ResponseUtils.parse(new SnapshotzipurlRes(Status.QUERY_SUCCESS, url));
	}

	/**
	 * 6.10获取原始视频片段文件名
	 * 
	 * @param filename
	 * @param ss
	 * @param endpos
	 * @return
	 */
	@RequestMapping("getorgvideofragmenturl.php")
	@ResponseBody
	public String getorgvideofragmenturl(
			@RequestParam String filename,
			@RequestParam Integer ss,
			@RequestParam Integer endpos) {
		String url = videoService.getOrgvideoFragmenturl(filename, ss, endpos);
		OrgvideofragmenturlRes rs = new OrgvideofragmenturlRes(Status.QUERY_SUCCESS);
		rs.setUrl(url);
		return ResponseUtils.parse(rs);
	}

	/**
	 * 6.11获取视频最近一次任务分析配置
	 * 
	 * @param videoid
	 * @return
	 */
	@RequestMapping(value = "server.php", params = { "command=QueryLastCfgInfo" })
	@ResponseBody
	public String queryLastCfgInfo(
			@RequestParam Integer videoid) {
		TaskDetailVo tv = videoService.queryLastCfgInfo(videoid);
		return ResponseUtils.parse(new ResStatus(Status.QUERY_SUCCESS), tv, false);
	}

	/**
	 * 6.12添加案件下所有视频自动分析
	 * 
	 * @param videoid
	 * @return
	 */
	@RequestMapping(value = "server.php", params = { "command=AddAutoAnalyse4Case" })
	@ResponseBody
	public String addAutoAnalyse4Case(
			@RequestParam Integer caseid,
			@RequestParam Integer userid) {
		videoService.addAutoAnalyse4Case(caseid, userid);
		return ResponseUtils.parse(new ResStatus(Status.QUERY_SUCCESS));
	}

	/**
	 * 6.13添加监控点下所有视频自动分析
	 * 
	 * @param cameraid
	 * @param userid
	 * @return
	 */
	@RequestMapping(value = "server.php", params = { "command=AddAutoAnalyse4Camera" })
	@ResponseBody
	public String addAutoAnalyse4Camera(
			@RequestParam Integer cameraid,
			@RequestParam Integer userid) {
		videoService.addAutoAnalyse4Camera(cameraid, userid);
		return ResponseUtils.parse(new ResStatus(Status.QUERY_SUCCESS));
	}

	/**
	 * 6.14获取案件自动分析参数
	 * 
	 * @param caseid
	 * @param userid
	 * @return
	 */
	@RequestMapping(value = "server.php", params = { "command=QueryAutoAnalyseParam" })
	@ResponseBody
	public String queryAutoAnalyseParam(
			@RequestParam Long caseid,
			@RequestParam Long userid) {
		AutoAnalyseParamVo av = videoService.queryAutoAnalyseParam(caseid, userid);
		return ResponseUtils.parse(new ResStatus(Status.QUERY_SUCCESS), av, false);
	}

	/**
	 * 6.15获取监控点自动分析参数
	 * 
	 * @param cameraid
	 * @param userid
	 * @return
	 */
	@RequestMapping(value = "server.php", params = { "command=QueryAutoAnalyseParam4Camera" })
	@ResponseBody
	public String queryAutoAnalyseParam4Camera(
			@RequestParam Long cameraid,
			@RequestParam Long userid) {
		Autoanalyseparam4cameraVo av = videoService.queryAutoAnalyseParam4Camera(cameraid, userid);
		return ResponseUtils.parse(new ResStatus(Status.QUERY_SUCCESS), av, false);
	}

	/**
	 * 6.16修改案件自动分析参数
	 * 
	 * @param caseid
	 * @param userid
	 * @param taskType
	 * @param thickness
	 * @param sensitivity
	 * @param obj_enable
	 * @param obj_type
	 * @param enable_avgcolor
	 * @param retrieve_avgcolor
	 * @param enable_uppercolor
	 * @param retrieve_uppercolor
	 * @param enable_lowercolor
	 * @param retrieve_lowercolor
	 * @param enable_carnum
	 * @param retrieve_carnum
	 * @param task_priority
	 * @param enable_search_by_image
	 * @param request_image_url
	 * @param request_image_data
	 * @param request_mask_url
	 * @param request_mask_data
	 * @param isPostPic
	 * @return
	 */
	@RequestMapping(value = "server.php", params = { "command=ModifyAutoAnalyseParam" })
	@ResponseBody
	public String ModifyAutoAnalyseParam(
			@RequestParam Long caseid,
			@RequestParam Long userid,
			@RequestParam(required = false, defaultValue = "2") Short taskType,
				Short thickness,
				Integer sensitivity,
				Short obj_enable,
				Short obj_type,
				Short enable_avgcolor,
				Integer retrieve_avgcolor,
				Short enable_uppercolor,
				Integer retrieve_uppercolor,
				Short enable_lowercolor,
				Integer retrieve_lowercolor,
				Short enable_carnum,
				String retrieve_carnum,
				Integer task_priority,
			@RequestParam(required = false, defaultValue = "0") Short enable_search_by_image,
			String request_image_url,
			String request_image_data,
			String request_mask_url,
			String request_mask_data,
			@RequestParam(required = false, defaultValue = "0") Short isPostPic

	) {
		videoService.modifyAutoAnalyseParam(caseid, userid, taskType, thickness, sensitivity, obj_enable, obj_type, enable_avgcolor,
				retrieve_avgcolor, enable_uppercolor, retrieve_uppercolor, enable_lowercolor, retrieve_lowercolor, enable_carnum, retrieve_carnum,
				task_priority, enable_search_by_image, request_image_url, request_image_data, request_mask_url, request_mask_data, isPostPic
				);
		return ResponseUtils.parse(new ResStatus(Status.MODIFY_SUCCESS));
	}

	/**
	 * 6.17修改监控点自动分析参数
	 * 
	 * @param cameraid
	 * @param userid
	 * @param UDR_exist
	 * @param UDR_setting
	 * @param summary_width
	 * @param summary_height
	 * @param isSetTripArea
	 * @param trip_area
	 * @param obj_search_by_mov
	 * @param obj_request_mov_vertics
	 * @return
	 */
	@RequestMapping(value = "server.php", params = { "command=ModifyAutoAnalyseParam4Camera" })
	@ResponseBody
	public String modifyAutoAnalyseParam4Camera(
			@RequestParam Long cameraid,
			@RequestParam Long userid,
			@RequestParam(required = false, value = "UDR_exist") Short udrExist,
			@RequestParam(required = false, value = "UDR_setting") String udrSetting,
			@RequestParam(required = false, value = "summary_width") Short summaryWidth,
			@RequestParam(required = false, value = "summary_height") Short summaryHeight,
			@RequestParam(required = false, value = "isSetTripArea") Short isSetTripArea,
			@RequestParam(required = false, value = "trip_area") String tripArea,
			@RequestParam(required = false, value = "obj_search_by_mov") Boolean objSearchByMov,
			@RequestParam(required = false, value = "obj_request_mov_vertics") String objRequestMovVertics,
			@RequestParam(required = false, value = "obj_request_mov_vertics_num") Integer objRequestMovVerticsNum) {

		videoService.modifyAutoAnalyseParam4Camera(cameraid, userid, udrExist, udrSetting, summaryWidth,
				summaryHeight, isSetTripArea, tripArea, objSearchByMov, objRequestMovVertics, objRequestMovVerticsNum);
		return ResponseUtils.parse(new ResStatus(Status.MODIFY_SUCCESS));
	}

	/**
	 * 6.18查询案件下的未分配视频列表
	 * 
	 * @param caseid
	 * @return
	 */
	@RequestMapping(value = "server.php", params = { "command=QueryUnAssignVideo" })
	@ResponseBody
	public String queryUnAssignVideo(
			@RequestParam Long caseid) {
		List<UnAssignVideoVo> uList = videoService.queryUnAssignVideo(caseid);
		TotalRes rs = new TotalRes(Status.MODIFY_SUCCESS, uList.size());
		return ResponseUtils.parse(rs, uList);
	}

	/**
	 *6.19任务分配
	 * 
	 * 参数可变，所以需要count来标识个数，userid所属的组须为分析员，即groupid=4
	 * 
	 * @param userid
	 * @param count参数个数
	 * @return
	 */
	@RequestMapping("assigningtask.php")
	@ResponseBody
	public String assigningtask(
			@RequestParam Long userid,
			@RequestParam Long count,
			HttpServletRequest req) {
		Long videoId;
		if (count == 0) {
			throw new ServiceException(Status.NO_TASK);
		}
		List<Long> videoIdList = new ArrayList<Long>();
		for (int i = 1; i <= count.intValue(); i++) {
			String value = req.getParameter("" + i);
			if (value == null) {
				throw new ServiceException(Status.PARAMETER_ERROR);
			}
			videoId = Long.valueOf(value);
			videoIdList.add(videoId);
		}
		videoService.assigningtask(userid, videoIdList);
		return ResponseUtils.parse(new ResStatus(Status.EXECUTE_SUCCESS));
	}

	/**
	 * 6.20查询未处理任务列表
	 * 
	 * @param userid
	 * @return
	 */
	@RequestMapping(value = "server.php", params = { "command=queryunhandledtask" })
	@ResponseBody
	public String queryunhandledtask(@RequestParam Long userid) {
		List<UnAssignVideoVo> uList = videoService.queryunhandledtask(userid);
		TotalRes rs = new TotalRes(Status.MODIFY_SUCCESS, uList.size());
		return ResponseUtils.parse(rs, uList);
	}

	/**
	 * 6.21修改处理任务的状态
	 * 
	 * 接受多个参数:uploadvideoid_1,uploadvideoid_2,uploadvideoid_3,...个数由count定
	 * 
	 * @param command
	 * @param count
	 * @return
	 */

	@RequestMapping("handletask.php")
	@ResponseBody
	public String handletask(
			@RequestParam(required = false, defaultValue = "0") Short command,
			@RequestParam Long count,
			HttpServletRequest req) {
		Long videoId;
		if (count == 0) {
			throw new ServiceException(Status.NO_TASK);
		}
		List<Long> videoIdList = new ArrayList<Long>();
		for (int i = 1; i <= count.intValue(); i++) {
			String value = req.getParameter("uploadvideoid_" + i);
			if (value == null) {
				throw new ServiceException(Status.PARAMETER_ERROR);
			}
			videoId = Long.valueOf(value);
			videoIdList.add(videoId);
		}
		videoService.modifyHandletask(command, videoIdList);
		return ResponseUtils.parse(new ResStatus(Status.MODIFY_SUCCESS));
	}

	/**
	 * 6.22查询任务分配列表
	 * 
	 * @param caseid
	 * @return
	 */
	@RequestMapping(value = "server.php", params = { "command=queryassignedtasklist" })
	@ResponseBody
	public String queryassignedtasklist(@RequestParam Long caseid) {
		List<AssignedtaskVo> avList = videoService.queryassignedtasklist(caseid);
		return ResponseUtils.parse(new ResStatus(Status.QUERY_SUCCESS), avList);
	}

	/**
	 * 6.23提交图片增强
	 * 
	 * @param type
	 * @param picFilename
	 * @param iWidth
	 * @param iHeight
	 * @param iWTDering
	 * @param iWTDenoise
	 * @param iUseGPU
	 * @param createTime
	 * @param priority
	 * @param density
	 * @return
	 */
	@RequestMapping("addPicEnhance.php")
	@ResponseBody
	public String addVideoEnhance(
			@RequestParam Short type,
			@RequestParam String picFilename,
			Integer iWidth,
			Integer iHeight,
			Short iWTDering,
			Short iWTDenoise,
			Short iUseGPU,
			@RequestParam Timestamp createTime,
			@RequestParam Short priority,
			@RequestParam(required = false, defaultValue = "0") Float density) {
		EnhanceTask e = videoService.addPicEnhance(type, picFilename, iWidth, iHeight, iWTDering, iWTDenoise, iUseGPU, createTime, priority, density);
		IdRes rs = new IdRes(Status.ADD_SUCCESS, e.getTaskId());
		return ResponseUtils.parse(rs);
	}

	/**
	 * 6.24提交视频增强
	 * 
	 * @param type
	 * @param videoid
	 * @param iWidth
	 * @param iHeight
	 * @param iWTDering
	 * @param iWTDenoise
	 * @param iUseGPU
	 * @param createTime
	 * @param priority
	 * @param density
	 * @return
	 */
	@RequestMapping(value = "server.php", params = { "command=AddVideoEnhance" })
	@ResponseBody
	public String AddVideoEnhance(
			@RequestParam Short type,
			@RequestParam Long videoid,
			@RequestParam String sourceUrl,
			Integer iWidth,
			Integer iHeight,
			Short iWTDering,
			Short iWTDenoise,
			Short iUseGPU,
			@RequestParam Timestamp createTime,
			@RequestParam Short priority,
			@RequestParam(required = false, defaultValue = "0") Float density) {
		EnhanceTask e = videoService.addVideoEnhance(type, videoid, sourceUrl, iWidth, iHeight, iWTDering, iWTDenoise, iUseGPU, createTime, priority, density);
		IdRes rs = new IdRes(Status.ADD_SUCCESS, e.getTaskId());
		return ResponseUtils.parse(rs);
	}

	/**
	 * 6.25查询增强进度
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "server.php", params = { "command=QueryEnhance" })
	@ResponseBody
	public String queryEnhance(
			@RequestParam Long id) {
		EnhanceTaskVo ev = videoService.queryEnhance(id);
		return ResponseUtils.parse(new ResStatus(Status.QUERY_SUCCESS), ev, false);
	}

	/**
	 * 6.26 查询视频增强列表
	 * 
	 * @param type
	 * @return
	 */
	@RequestMapping(value = "server.php", params = { "command=QueryVideoEnhanceList" })
	@ResponseBody
	public String queryVideoEnhanceList(
			@RequestParam Short type) {
		List<VideoEnhanceListVo> list = videoService.queryVideoEnhanceList(type);
		return ResponseUtils.parse(new ResStatus(Status.QUERY_SUCCESS), list);
	}

	/**
	 * 6.27 查询图片增强列表
	 * 
	 * @param type
	 * @return
	 */
	@RequestMapping(value = "server.php", params = { "command=QueryPicEnhanceList" })
	@ResponseBody
	public String queryPicEnhanceList(
			@RequestParam Short type) {
		List<PicEnhanceListVo> list = videoService.queryPicEnhanceList(type);
		return ResponseUtils.parse(new ResStatus(Status.QUERY_SUCCESS), list);
	}

	/**
	 * 6.28 删除增强任务
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "server.php", params = { "command=DeleteEnhanceTask" })
	@ResponseBody
	public String deleteEnhanceTask(
			@RequestParam Long id) {
		videoService.deleteEnhanceTask(id);
		return ResponseUtils.parse(new ResStatus(Status.DEL_SUCCESS));
	}

	/**
	 * 6.29 查询根视频下的子目录列表
	 * 
	 * @param videoid
	 * @param analyse_startindex
	 * @param analyse_count
	 * @param denoise_startindex
	 * @param denoise_count
	 * @param dehaze_startindex
	 * @param dehaze_count
	 * @param nightEnhance_startindex
	 * @param nightEnhance_count
	 * @return
	 */
	@RequestMapping(value = "querychildlist.php", params = { "command=QueryVideoInfo" })
	@ResponseBody
	public String querychildlist(
			@RequestParam Long videoid,
			@RequestParam(required = false, defaultValue = "0") Integer analyse_startindex,
			@RequestParam(required = false, defaultValue = "10") Integer analyse_count,
			Integer denoise_startindex,
			Integer denoise_count,
			Integer dehaze_startindex,
			Integer dehaze_count,
			Integer nightEnhance_startindex,
			Integer nightEnhance_count) {

		List list = videoService.querychildlist(videoid,
				analyse_startindex, analyse_count,
				denoise_startindex, denoise_count,
				dehaze_startindex, dehaze_count,
				nightEnhance_startindex, nightEnhance_count
				);

		return ResponseUtils.parse(new ResStatus(Status.QUERY_SUCCESS), list);
	}

	/**
	 * TODO 6.30 添加低分辨率人脸重建（以下简称FSR）任务
	 * 
	 * @param picFilename
	 *            图片文件名
	 * @param params
	 *            备用字段，参数设置，XML格式
	 * @return
	 */
	@RequestMapping("addFSRTask.php")
	@ResponseBody
	public String addFSRTask(
			@RequestParam String picFilename,
				String params) {
		Fsrtask f = videoService.addFSRTask(picFilename, params);

		return ResponseUtils.parse(new IdRes(Status.ADD_SUCCESS, f.getTaskid()));
	}

	/**
	 * 6.31 查询FSR列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "server.php", params = { "command=QueryFSRTaskList" })
	@ResponseBody
	public String queryFSRTaskList() {
		List list = videoService.queryFSRTaskList();
		return ResponseUtils.parse(new ResStatus(Status.QUERY_SUCCESS), list);
	}

	/**
	 * 6.32 查询FSR进度
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "server.php", params = { "command=QueryFSRTask" })
	@ResponseBody
	public String queryFSRTask(@RequestParam Integer id) {
		FsrtaskVo f = videoService.queryFSRTask(id);
		return ResponseUtils.parse(new ResStatus(Status.QUERY_SUCCESS), f, false);
	}

	/**
	 * 6.33 删除FSR任务
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "server.php", params = { "command=DeleteFSRTask" })
	@ResponseBody
	public String deleteFSRTask(@RequestParam Integer id) {
		videoService.deleteFSRTask(id);
		return ResponseUtils.parse(new ResStatus(Status.DEL_SUCCESS));
	}
}
