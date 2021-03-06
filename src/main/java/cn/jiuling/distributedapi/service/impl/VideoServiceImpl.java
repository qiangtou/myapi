package cn.jiuling.distributedapi.service.impl;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import cn.jiuling.distributedapi.Vo.AnalyseVo;
import cn.jiuling.distributedapi.Vo.AssignedtaskVo;
import cn.jiuling.distributedapi.Vo.AutoAnalyseParamVo;
import cn.jiuling.distributedapi.Vo.Autoanalyseparam4cameraVo;
import cn.jiuling.distributedapi.Vo.DehazeVo;
import cn.jiuling.distributedapi.Vo.DenoiseVo;
import cn.jiuling.distributedapi.Vo.DownloadTasks4ListVo;
import cn.jiuling.distributedapi.Vo.DownloadTasksVo;
import cn.jiuling.distributedapi.Vo.EnhanceTaskVo;
import cn.jiuling.distributedapi.Vo.ExternalTaskStatusVo;
import cn.jiuling.distributedapi.Vo.ExttaskstatusVo;
import cn.jiuling.distributedapi.Vo.FsrtaskListVo;
import cn.jiuling.distributedapi.Vo.FsrtaskVo;
import cn.jiuling.distributedapi.Vo.HistoryTaskListVo;
import cn.jiuling.distributedapi.Vo.ListResultVo;
import cn.jiuling.distributedapi.Vo.NightEnhanceVo;
import cn.jiuling.distributedapi.Vo.PicEnhanceListVo;
import cn.jiuling.distributedapi.Vo.QueryTaskVo;
import cn.jiuling.distributedapi.Vo.RetrieveParamVo;
import cn.jiuling.distributedapi.Vo.ReturnData;
import cn.jiuling.distributedapi.Vo.SnapGenInfoVo;
import cn.jiuling.distributedapi.Vo.SnapshotFolderVo;
import cn.jiuling.distributedapi.Vo.SnapshotVo;
import cn.jiuling.distributedapi.Vo.Status;
import cn.jiuling.distributedapi.Vo.TaskDetailVo;
import cn.jiuling.distributedapi.Vo.TaskVo;
import cn.jiuling.distributedapi.Vo.TranscodeStatusVo;
import cn.jiuling.distributedapi.Vo.TripwireVo;
import cn.jiuling.distributedapi.Vo.UnAssignVideoVo;
import cn.jiuling.distributedapi.Vo.VideoEnhanceListVo;
import cn.jiuling.distributedapi.Vo.VideoVo;
import cn.jiuling.distributedapi.dao.AnalysisvideoDao;
import cn.jiuling.distributedapi.dao.AssigntaskDao;
import cn.jiuling.distributedapi.dao.Autoanalyseparam4cameraDao;
import cn.jiuling.distributedapi.dao.AutoanalyseparamDao;
import cn.jiuling.distributedapi.dao.CameraDao;
import cn.jiuling.distributedapi.dao.ConfigDao;
import cn.jiuling.distributedapi.dao.DownloadtasksDao;
import cn.jiuling.distributedapi.dao.EnhanceTaskDao;
import cn.jiuling.distributedapi.dao.ExternaltaskDao;
import cn.jiuling.distributedapi.dao.ExttaskstatusDao;
import cn.jiuling.distributedapi.dao.FsrtaskDao;
import cn.jiuling.distributedapi.dao.GeneratevideoDao;
import cn.jiuling.distributedapi.dao.ScheduletasksDao;
import cn.jiuling.distributedapi.dao.VideoDao;
import cn.jiuling.distributedapi.exception.ServiceException;
import cn.jiuling.distributedapi.model.Analysisvideo;
import cn.jiuling.distributedapi.model.Assigntask;
import cn.jiuling.distributedapi.model.Autoanalyseparam;
import cn.jiuling.distributedapi.model.Autoanalyseparam4camera;
import cn.jiuling.distributedapi.model.Camera;
import cn.jiuling.distributedapi.model.Config;
import cn.jiuling.distributedapi.model.Downloadtasks;
import cn.jiuling.distributedapi.model.EnhanceTask;
import cn.jiuling.distributedapi.model.Externaltask;
import cn.jiuling.distributedapi.model.Exttaskstatus;
import cn.jiuling.distributedapi.model.Fsrtask;
import cn.jiuling.distributedapi.model.Generatevideo;
import cn.jiuling.distributedapi.model.Scheduletasks;
import cn.jiuling.distributedapi.model.Useruploadvideo;
import cn.jiuling.distributedapi.service.VideoService;
import cn.jiuling.distributedapi.utils.ConfigUtils;
import cn.jiuling.distributedapi.utils.DiskSpaceUtils;
import cn.jiuling.distributedapi.utils.FileUtils;
import cn.jiuling.distributedapi.utils.PathUtils;
import cn.jiuling.distributedapi.utils.RegUtils;
import cn.jiuling.distributedapi.utils.ResponseUtils;

@Service("videoService")
public class VideoServiceImpl implements VideoService {
	@Resource
	private VideoDao videoDao;
	@Resource
	private DownloadtasksDao downloadtasksDao;
	@Resource
	private ScheduletasksDao scheduletasksDao;
	@Resource
	private ConfigDao configDao;
	@Resource
	private ExternaltaskDao externaltaskDao;
	@Resource
	private ExttaskstatusDao exttaskstatusDao;
	@Resource
	private AnalysisvideoDao analysisvideoDao;
	@Resource
	private GeneratevideoDao generatevideoDao;
	@Resource
	private AutoanalyseparamDao autoanalyseparamDao;
	@Resource
	private Autoanalyseparam4cameraDao autoanalyseparam4cameraDao;
	@Resource
	private AssigntaskDao assigntaskDao;
	@Resource
	private EnhanceTaskDao enhanceTaskDao;
	@Resource
	private FsrtaskDao fsrtaskDao;
	@Resource
	private CameraDao cameraDao;

	@Override
	public List queryVideo(Long cameraid, Long userid) {
		try {
			List list = videoDao.queryVideo(cameraid, userid);
			return copyList(list);
		} catch (Exception e) {
			throw new ServiceException(Status.QUERY_SUCCESS, e);
		}
	}

	private List copyList(List list) {
		List newList = new ArrayList();
		VideoVo cv;
		Config c = configDao.getConfig();
		String datapath = c.getDataPath();
		String destUrl = "";
		String downloadURL;
		if (list.size() > 0) {
			for (int i = 0, j = list.size(); i < j; i++) {
				cv = new VideoVo();
				Useruploadvideo source = (Useruploadvideo) list.get(i);
				BeanUtils.copyProperties(source, cv);
				// from sp_QueryVideo.sql:
				// right(destUrl,char_length(destUrl)-char_length(data_path)-11)
				destUrl = source.getDestUrl();
				downloadURL = destUrl.substring(datapath.length() + 11);
				cv.setDownloadURL(downloadURL);
				newList.add(cv);
			}
		}
		return newList;
	}

	@Override
	public void modifyVideo(Long videoid, Timestamp recordTime, Long userid) {
		try {
			Useruploadvideo v = videoDao.load(videoid);
			v.setRecordTime(recordTime);
			v.setUserid(userid);
			videoDao.update(v);
		} catch (Exception e) {
			throw new ServiceException(Status.MODIFY_ERROR, e);
		}

	}

	@Override
	public long add3rdVideo(Long cameraId, String srcUrl, String platformName, Short isAutoSubmit) {
		try {
			long id = 0;
			if (StringUtils.isEmpty(platformName)) {
				platformName = srcUrl.startsWith("http") ? "http链接" : "";
			}

			if (srcUrl.contains("schedule=1")) {
				Scheduletasks s = new Scheduletasks();
				int startIndex = srcUrl.indexOf("starttime=");
				int endIndex = srcUrl.indexOf("endtime=");
				if (startIndex > -1 && endIndex > -1) {
					String startTime = srcUrl.substring(startIndex + 10, 8);
					String endTime = srcUrl.substring(startIndex + 8, 8);
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					s.setEndTime(new Time(sdf.parse(endTime).getTime()));
					s.setStartTime(new Time(sdf.parse(startTime).getTime()));
				}

				// LastSubmitTime default '00:00:00'#上次任务提交的时间
				s.setLastSubmitTime(new Timestamp(0L));
				s.setCameraId(cameraId);
				s.setSrcUrl(srcUrl);
				s.setPlatformName(platformName);
				s.setIsAutoSubmit(isAutoSubmit);
				scheduletasksDao.save(s);
				id = s.getId();
			} else {
				Downloadtasks d = new Downloadtasks();
				d.setCameraId(cameraId);
				d.setSrcUrl(srcUrl);
				d.setPlatformName(platformName);
				d.setIsAutoSubmit(isAutoSubmit);
				downloadtasksDao.save(d);
				id = d.getId();
			}
			return id;
		} catch (Exception e) {
			throw new ServiceException(Status.ADD_ERROR, e);
		}
	}

	@Override
	public DownloadTasksVo query3rdVideoStatus(Long id) {
		try {
			Downloadtasks d = downloadtasksDao.load(id);
			DownloadTasksVo dv = new DownloadTasksVo();
			BeanUtils.copyProperties(d, dv);
			return dv;
		} catch (Exception e) {
			throw new ServiceException(Status.QUERY_ERROR, e);
		}
	}

	@Override
	public List query3rdVideoList(Long cameraid, Short status, Timestamp start, Timestamp end, Integer index, Integer count) {
		try {
			List list = downloadtasksDao.query3rdVideoList(cameraid, status, start, end, index, count);
			return copy3rdVideoList(list);
		} catch (Exception e) {
			throw new ServiceException(Status.QUERY_ERROR, e);
		}

	}

	private List copy3rdVideoList(List list) {
		List newList = new ArrayList();
		DownloadTasks4ListVo cv;
		if (list.size() > 0) {
			for (int i = 0, j = list.size(); i < j; i++) {
				cv = new DownloadTasks4ListVo();
				BeanUtils.copyProperties(list.get(i), cv);
				newList.add(cv);
			}
		}
		return newList;
	}

	@Override
	public ListResultVo queryTaskList(String userid, Integer status, Timestamp startTime, Timestamp endTime, Integer startIndex, Integer count) {
		try {
			List<HistoryTaskListVo> list = downloadtasksDao.queryHistoryTaskListList(userid, status, startTime, endTime);
			int k = 0;
			HistoryTaskListVo h;
			List newList = new ArrayList();
			int totalCount = list.size();
			if (count < 0) {
				count = totalCount;
			}
			for (int i = 0, j = totalCount; i < j; i++) {
				h = list.get(i);
				ExternalTaskStatusVo ets = translateExternalTaskStatus(h);
				Short taskStatus = ets.getStatus();
				if (status != -1 && taskStatus.intValue() != status.intValue()) {
					continue;
				}
				if (i >= startIndex && k < count) {
					TaskVo t = new TaskVo();
					/*$resultArray[$index]['flowNumber'] = $row['flowNumber'];
					$resultArray[$index]['type'] = $row['taskType'];
					$resultArray[$index]['srcURI'] = $row['sourceUrl'];
					$resultArray[$index]['destURI'] = $row['localFilename'];
					$resultArray[$index]['UserUploadVideoId'] = $row['UserUploadVideoId'];
					
					$resultArray[$index]['status'] = $retArray['status'];
					$resultArray[$index]['progress'] = $retArray['progress'];
					if($retArray['status'] == 7 || $retArray['status'] == 5)
					{
						$resultArray[$index]['progress'] = $row['progress'];
					}*/
					t.setFlowNumber(h.getFlowNumber());
					t.setType(h.getTaskType());
					t.setSrcURL(h.getSourceUrl());
					t.setDestURL(h.getLocalFilename());
					t.setUserUploadVideoId(h.getUserUploadVideoId());
					t.setStatus(taskStatus);
					t.setProgress(ets.getProgress().shortValue());
					if (taskStatus == 7 || taskStatus == 5) {
						t.setProgress(h.getProgress().shortValue());
					}
					newList.add(t);
				}

			}
			ListResultVo result = new ListResultVo(totalCount, newList);
			result.setCount(count);
			return result;
		} catch (Exception e) {
			throw new ServiceException(Status.QUERY_ERROR, e);
		}
	}

	private ExternalTaskStatusVo translateExternalTaskStatus(HistoryTaskListVo h) {

		Short downloadStatus = h.getDownloadStatus();
		Integer userUploadVideoId = h.getUserUploadVideoId();
		Short status = 0;
		Integer progress = 0;
		if (downloadStatus == 1) {
			if (userUploadVideoId == 0) {
				// $UserUploadVideoId == 0，说明正在下载
				status = 1;
				progress = getDownloadProgress(h.getFlowNumber()).intValue();
			} else if (userUploadVideoId > 0) {
				// $UserUploadVideoId > 0 说明值有效且有转码任务
				TranscodeStatusVo t = queryTranscodeStatus(userUploadVideoId.longValue());
				Short transcodeStatus = t.getStatus();
				if (transcodeStatus == 0 || transcodeStatus == 2)// 等待转码和正在转码
				{
					status = 3;// 正在转码
					progress = t.getProgress().intValue();
				}
				if (transcodeStatus == 3) {
					status = 4;// 转码失败
				}
			}
		} else if (downloadStatus == 2) {// 下载和转码都成功了
			Long genFlag = h.getGenFlag();
			Long analyFlag = h.getAnalyFlag();
			if (analyFlag == 5 && genFlag == 5) {
				status = 8;// 分析失败
			} else if (genFlag == 1) {
				status = 7;// 分析成功
			} else {
				status = 5;// 分析成功
			}
		} else if (downloadStatus == 3) {
			// 下载失败
			status = 2;
		}
		ExternalTaskStatusVo e = new ExternalTaskStatusVo(status, progress);
		return e;
	}

	/**
	 * 从tbl_DownloadTasks里面找progress
	 * 
	 * @param flowNumber
	 * @return
	 */
	private Short getDownloadProgress(String flowNumber) {
		Downloadtasks d = downloadtasksDao.findBy("extTaskID", Long.valueOf(flowNumber));
		return d.getProgress();
	}

	/**
	 * 逻辑来自
	 * http://192.168.1.200:8000/svn/RD/src/trunk/VideoSearch_v3.0/src/server
	 * /web/ASTVS_database_API_HHC.php
	 */
	@Override
	public Externaltask submitTask(Integer userUploadVideoId, Short type, Short runTimeSpeed, String filename, Integer fileSize, String sourceUrl,
			Short thickness,
			Short sensitivity, Short framerateNu, Short objEnable, Short objType, Short objSubtype, Short colorTolerance, Integer retrieveAvgcolor,
			Integer retrieveUppercolor, Integer retrieveLowercolor, Integer retrieveCarnum, Short objHeight, Short objWidth, Short objDepth,
			Integer startFrame, Integer endFrame, Short tripwireX1, Short tripwireY1, Short tripwireX2, Short tripwireY2, Short tripwireCrossdir,
			Short summaryHeight, Short summaryWidth, Short isSetTripArea, String tripArea, Short uDRExist, String uDRSetting, Short taskPriority,
			Short snapType,
			String taskName, Short enableSearchByImage, String requestImageUrl, String requestMaskUrl, Integer userid, Short isAutoAnalyse,
			Short clockwise_point1_x,
			Short clockwise_point1_y,
			Short clockwise_point2_x,
			Short clockwise_point2_y,
			Short clockwise_point3_x,
			Short clockwise_point3_y,
			Short clockwise_point4_x,
			Short clockwise_point4_y,
			Short isRegSet, String flowNumber, Short isContain) {
		try {
			// 检测空间
			if (!DiskSpaceUtils.IsSummarySpaceEnough()) {
				throw new ServiceException(Status.DISK_SPACE_IS_NOT_ENOUGHT);
			}
			// userUploadVideoId sourceUrl必须取一个,为了获得sourceUrl
			if ("0".equals(userUploadVideoId) && "".equals(sourceUrl)) {
				throw new ServiceException("UserUploadVideoId and sourceUrl must be assign one");
			}

			if (clockwise_point1_x <= 0 &&
					clockwise_point1_y <= 0 &&
					clockwise_point2_x <= 0 &&
					clockwise_point2_y <= 0 &&
					clockwise_point3_x <= 0 &&
					clockwise_point3_y <= 0 &&
					clockwise_point4_x <= 0 &&
					clockwise_point4_y <= 0) {
				isRegSet = 0;
				clockwise_point1_x = -1;
				clockwise_point1_y = -1;
				clockwise_point2_x = -1;
				clockwise_point2_y = -1;
				clockwise_point3_x = -1;
				clockwise_point3_y = -1;
				clockwise_point4_x = -1;
				clockwise_point4_y = -1;
			}
			// 除1外的状态全部为0
			objEnable = objEnable == 1 ? objEnable : Short.valueOf("0");
			// 如果是浓缩，obj_type必须为0;
			if (type == 2 && objEnable == 0) {
				objType = 0;
			}

			if (objSubtype == 1) {
				objSubtype = 1;
			} else if (objSubtype == 2) {
				objSubtype = 2;
			} else {
				objSubtype = 0;
			}
			if (sensitivity < 0 || sensitivity > 5) {
				sensitivity = 2;
			}
			if (colorTolerance < 0 || colorTolerance > 10000) {
				colorTolerance = 0;
			}
			Short enableAvgcolor = 0;
			if (retrieveAvgcolor != 0) {
				enableAvgcolor = 1;
			}
			Short enableUppercolor = 0;
			if (retrieveUppercolor != 0) {
				enableUppercolor = 1;
			}
			Short enableLowercolor = 0;
			if (retrieveLowercolor != 0) {
				enableLowercolor = 1;
			}
			Short enableCarnum = 0;
			if (retrieveCarnum != 0) {
				enableCarnum = 1;
			}
			if (endFrame < 0) {
				endFrame = 5400000;
			}
			String obj_request_mov_vertics = "";
			Integer obj_request_mov_vertics_num = 0;
			boolean obj_search_by_mov = false;
			if (tripwireX1 != 0 || tripwireX2 != 0 || tripwireY1 != 0 || tripwireY2 != 0) {
				TripwireVo tv = new TripwireVo(tripwireX1, tripwireX2, tripwireY1, tripwireY2, tripwireCrossdir);
				obj_request_mov_vertics = ResponseUtils.parse(tv).toString();
				obj_request_mov_vertics_num = 2;
				obj_search_by_mov = true;
			}
			// 如果是奇数，则取最近的偶数。
			// -应LaM的要求,分析模块输出分辨率必须为偶数
			if ((summaryHeight & 1) == 1) {
				summaryHeight++;
			}
			if ((summaryWidth & 1) == 1) {
				summaryWidth++;
			}
			if (null == taskName) {
				switch (type) {
				case 0:
					taskName = "检索任务";
					break;
				case 1:
					taskName = "浓缩检索任务";
					break;
				default:
					taskName = "浓缩任务";
					break;
				}
			}

			if (type != 2 && enableSearchByImage == 1) {
				String ftpPath = RegUtils.getFtpPath();
				String dataPath = RegUtils.getDataPath() + "\\AstVS_1v2\\orgpics";
				FileUtils.createDir(dataPath);
				// 转移图片
				FileUtils.copy(ftpPath + requestImageUrl, dataPath + requestImageUrl);
				// 转移掩码文件
				FileUtils.copy(ftpPath + requestMaskUrl, dataPath + requestMaskUrl);
			}
			// 把一根线转成两根?
			String localFileName = "";
			if (sourceUrl.startsWith("file:\\")) {
				if (sourceUrl.indexOf("\\\\") == -1) {
					sourceUrl = sourceUrl.replace("\\", "\\\\");
				}
				localFileName = sourceUrl.substring(7);
			}

			Timestamp record_Time;
			if (!StringUtils.isEmpty(localFileName)) {
				// 000#20#208.208.81.30#20130917143226396#20131011174125.ts
				// 取最后一个井号到句号之前的东西转成时间
				int periodIndex = localFileName.lastIndexOf(".");
				int numbersignIndex = localFileName.lastIndexOf("#");
				String time = localFileName.substring(numbersignIndex, periodIndex);
				record_Time = parse(time);
			} else {
				record_Time = new Timestamp(System.currentTimeMillis());
			}

			Short downloadStatus = 0;
			if (FileUtils.isExistFile(localFileName)) {
				downloadStatus = 2;
			} else if (userUploadVideoId != 0) {
				Useruploadvideo v = videoDao.load(userUploadVideoId);
				Short status = v.getStatus();
				String destURL = v.getDestUrl();
				String srcURL = v.getSrcUrl();
				localFileName = destURL.replace("\\", "\\\\");
				sourceUrl = srcURL.replace("\\", "\\\\");
				if (status == 1) {
					// 转码成功
					downloadStatus = 2;
				} else {
					// 没有转码成功的，设置转码完成后自动提交
					downloadStatus = 1;
					v.setIsAutoSubmit(Useruploadvideo.AUTOSUBMIT);
					videoDao.update(v);
				}
			}

			// 任务重命名
			long taskCount = externaltaskDao.findByTaskNameAndUserUploadVideoId(userUploadVideoId, taskName);
			taskName += (taskCount + 1);
			taskName = taskName.replace("\\", "\\\\'");
			taskName = taskName.replace("'", "\'");

			/*$sql= "INSERT INTO externaltask(userid,taskType,UserUploadVideoId,flowNumber,sourceUrl, thickness, sensitivity, run_time_speed, isRegSet, isContain,clockwise_point1_x, clockwise_point1_y, clockwise_point2_x, clockwise_point2_y, clockwise_point3_x, clockwise_point3_y, clockwise_point4_x, clockwise_point4_y,
				obj_enable, obj_type, obj_subtype, color_tolerance, enable_avgcolor, retrieve_avgcolor, enable_uppercolor, retrieve_uppercolor, enable_lowercolor, retrieve_lowercolor, enable_carnum, retrieve_carnum, objHeight, objWidth, objDepth,startFrame,endFrame,localFilename,
				obj_search_by_mov, obj_request_mov_vertics, obj_request_mov_vertics_num, summary_height, summary_width,isSetTripArea,trip_area,UDR_exist,UDR_setting,task_priority,snap_type,taskName,
				enable_search_by_image, request_image_url, request_mask_url, request_image_data, request_mask_data,drop_frm_rate)
			VALUES
			('$userid',$taskType,$UserUploadVideoId, 
			'$flowNumber','$sourceUrl', $thickness, $sensitivity, $run_time_speed, $isRegSet, $isContain,
			$clockwise_point1_x, $clockwise_point1_y,
			$clockwise_point2_x, $clockwise_point2_y, $clockwise_point3_x, $clockwise_point3_y, $clockwise_point4_x, $clockwise_point4_y,
			*/
			Externaltask e = new Externaltask();
			e.setUserid("" + userid);
			e.setTaskType(type);
			e.setUserUploadVideoId(userUploadVideoId);
			e.setFlowNumber(flowNumber);
			e.setSourceUrl(sourceUrl);
			e.setThickness(thickness);
			e.setSensitivity(sensitivity.intValue());
			e.setRunTimeSpeed(runTimeSpeed.intValue());
			e.setIsRegSet(isRegSet);
			e.setIsContain(isContain);
			e.setClockwisePoint1X(clockwise_point1_x);
			e.setClockwisePoint1Y(clockwise_point1_y);
			e.setClockwisePoint2X(clockwise_point2_x);
			e.setClockwisePoint2Y(clockwise_point2_y);
			e.setClockwisePoint3X(clockwise_point3_x);
			e.setClockwisePoint3Y(clockwise_point3_y);
			e.setClockwisePoint4X(clockwise_point4_x);
			e.setClockwisePoint4Y(clockwise_point4_y);
			/*$obj_enable, $obj_type, $obj_subtype, $color_tolerance, $enable_avgcolor, $retrieve_avgcolor, $enable_uppercolor, $retrieve_uppercolor,
			$enable_lowercolor, $retrieve_lowercolor, $enable_carnum, '$retrieve_carnum', $objHeight, $objWidth,$objDepth,
			$startFrame,$endFrame,'$localFilename',
						*/
			e.setObjEnable(objEnable);
			e.setObjType(objType);
			e.setObjSubtype(objSubtype);
			e.setColorTolerance(colorTolerance);
			e.setEnableAvgcolor(enableAvgcolor);
			e.setRetrieveAvgcolor(retrieveAvgcolor);
			e.setEnableUppercolor(enableUppercolor);
			e.setRetrieveUppercolor(retrieveUppercolor);
			e.setEnableLowercolor(enableLowercolor);
			e.setRetrieveLowercolor(retrieveLowercolor);
			e.setEnableCarnum(enableCarnum);
			e.setRetrieveCarnum("" + retrieveCarnum);
			e.setObjHeight(objHeight);
			e.setObjWidth(objWidth);
			e.setObjDepth(objDepth);
			e.setStartFrame(startFrame);
			e.setEndFrame(endFrame);
			e.setLocalFilename(localFileName);
			/*	$obj_search_by_mov, '$obj_request_mov_vertics', $obj_request_mov_vertics_num, 
			 * $summary_height, $summary_width,$isSetTripArea,'$trip_area',$UDR_exist,'$UDR_setting',
			 * $task_priority,$snap_type,'$handled_taskName', $enable_search_by_image, 
			 * '$request_image_url', '$request_mask_url', '$request_image_data', '$request_mask_data',$drop_frm_rate)";
			*/
			e.setObjSearchByMov(obj_search_by_mov);
			e.setObjRequestMovVertics(obj_request_mov_vertics);
			e.setObjRequestMovVerticsNum(obj_request_mov_vertics_num);
			e.setSummaryHeight(summaryHeight);
			e.setSummaryWidth(summaryWidth);
			e.setIsSetTripArea(isSetTripArea);
			e.setTripArea(tripArea);
			e.setUdrExist(uDRExist);
			e.setUdrSetting(uDRSetting);
			e.setTaskPriority(taskPriority.intValue());
			e.setSnapType(snapType);
			e.setTaskName(taskName);
			e.setEnableSearchByImage(enableSearchByImage);
			e.setRequestImageUrl(requestImageUrl);
			e.setRequestMaskUrl(requestMaskUrl);

			e.setDropFrmRate(0f);
			e.setCarnumStatus(Short.valueOf("0"));
			e.setFramerate(25f);
			e.setTimePeirodEnd(0);
			e.setTimePeirodIndicator(0);
			e.setTimePeirodStart(0);
			e.setTimestamp(new Timestamp(System.currentTimeMillis()));
			externaltaskDao.save(e);
			e.setFlowNumber("" + e.getExtTaskId());
			externaltaskDao.update(e);
			return e;
		} catch (Exception e) {
			throw new ServiceException(Status.ADD_ERROR, e);
		}

	}

	/**
	 * 20131011174125->Timestamp
	 * 
	 * @param time
	 *            格式形如20131011174125
	 * @return Timestamp实例
	 */
	private Timestamp parse(String time) {
		Timestamp record_Time = null;
		try {
			record_Time = new Timestamp(
					Integer.valueOf(time.substring(0, 4)) - 1900,
					Integer.valueOf(time.substring(4, 6)) - 1,
					Integer.valueOf(time.substring(6, 8)),
					Integer.valueOf(time.substring(8, 10)),
					Integer.valueOf(time.substring(10, 12)),
					Integer.valueOf(time.substring(12, 14)), 0);
		} catch (Exception e) {

		}
		return record_Time;
	}

	@Override
	public Useruploadvideo addTranscodeTask(Long userid, String srcName, Short isAutoSubmit) {
		try {
			if (!DiskSpaceUtils.IsTranscodeSpaceEnough()) {
				throw new ServiceException(Status.DISK_SPACE_IS_NOT_ENOUGHT);
			}
			String basedir = PathUtils.getWebRoot();
			basedir = basedir + File.separator + "orgvideos" + File.separator + userid + File.separator;
			FileUtils.createDir(basedir);
			String vedeoName;
			String srcURI;
			String destURI;

			if (FileUtils.isExistFile(srcName)) {
				vedeoName = FileUtils.getFileName(srcName);
				srcURI = srcName;
				destURI = basedir + vedeoName;
			} else {
				String ftpFold = RegUtils.getFtpPath();
				String userPath = ftpFold + File.separator + userid;
				srcURI = userPath + File.separator + srcName;
				destURI = basedir + srcName;

				FileUtils.createDir(userPath);
				String srcFile = ftpFold + File.separator + srcName;
				if (!FileUtils.isExistFile(srcFile)) {
					if (!FileUtils.isExistFile(srcURI)) {
						throw new ServiceException(Status.SRCFILE_IS_NOT_EXIST);
					}
				} else {
					File newFile = FileUtils.copy(srcFile, srcURI);
					srcURI = newFile.getAbsolutePath();
				}
			}

			// 判断文件名是否合法
			if (srcURI.indexOf("'") > -1) {
				throw new ServiceException(Status.SRCFILE_ISNOT_VALID);
			}
			destURI = FileUtils.getNoRepeatFilename(destURI).getAbsolutePath();
			Useruploadvideo u = videoDao.getBySrcAndDest(srcURI, destURI);
			if (u != null) {
				throw new ServiceException(Status.TASK_REPEAT);
			}

			Timestamp timeFromFile = parse(srcURI);
			Timestamp t = null != timeFromFile ? timeFromFile : new Timestamp(0);
			/*INSERT INTO UserUploadVideo(CameraID,timestamp,record_time,userid,srcURL,destURL,status,last_err_code,
				    last_err_msg,progress,retry_count,last_try_video_vendor_type, isAutoSubmit)
				    VALUES(0,now(),'$record_time',$UserId,'$srcURI','$destURI',0,0,'',0,0,-1,$isAutoSubmit)";
			*/
			Short zero = Short.valueOf("0");
			Useruploadvideo useruploadvideo = new Useruploadvideo
					(0L, new Timestamp(System.currentTimeMillis()), t, userid, srcURI, destURI, zero, 0, "", zero, 0, -1, isAutoSubmit,
							zero, "--", 0, 0, 25, null, null);
			videoDao.save(useruploadvideo);
			return useruploadvideo;
		} catch (Exception e) {
			throw new ServiceException(Status.ADD_ERROR, e);
		}

	}

	@Override
	public ExttaskstatusVo queryExttaskstatus(String flowNumber) {
		try {
			Exttaskstatus e = exttaskstatusDao.getExttaskstatus(flowNumber);
			if (e == null) {
				throw new ServiceException(Status.OBJECT_IS_NOT_EXIST);
			}
			ExttaskstatusVo v = new ExttaskstatusVo();
			v.setStatus(e.getId().getGenFlag());
			v.setDescription("unknown");
			v.setProcess(e.getId().getProgress());
			String filename = e.getId().getFilename();
			filename = filename.substring(filename.indexOf("\\", 2));
			v.setSummaryurl(filename);
			Config c = configDao.getConfig();
			String datapath = c.getDataPath();
			String summaryurl = datapath + "\\AstVS_1v2" + filename;
			v.setSummaryurl(summaryurl);
			return v;
		} catch (Exception e) {
			throw new ServiceException(Status.QUERY_ERROR, e);
		}
	}

	@Override
	public List<QueryTaskVo> queryTask(Integer uploadvideoid) {
		try {
			Config c = configDao.getConfig();
			return externaltaskDao.queryTask(uploadvideoid, c.getDataPath());
		} catch (Exception e) {
			throw new ServiceException(Status.QUERY_ERROR, e);
		}
	}

	@Override
	public TranscodeStatusVo queryTranscodeStatus(Long userUploadVideoId) {
		try {
			Config c = configDao.getConfig();
			String dataPath = c.getDataPath();
			Useruploadvideo v = videoDao.load(userUploadVideoId);
			Externaltask externaltask = externaltaskDao.findBy("userUploadVideoId", userUploadVideoId.intValue());
			// 查到数据就是1
			Integer submit = null != externaltask ? 1 : 0;
			TranscodeStatusVo t = new TranscodeStatusVo();
			/*$resultArray['status'] = $row['status'];
			$resultArray['srcURI'] = $row['srcURL'];
			$resultArray['destURI'] = $row['destURL'];
			$resultArray['downloadURI'] = $row['downloadURI'];
			$resultArray['progress'] = $row['progress'];
			$resultArray['submit'] = $submit;
			
			*/
			Short status = v.getStatus();
			Short progress = v.getProgress();
			t.setStatus(status);
			t.setSrcURI(v.getSrcUrl());
			t.setDestURI(v.getDestUrl());
			/*dataPath:D:/VideoInvestigation/VIServer/DAT
			 *destUrl:'D:/VideoInvestigation/VIServer/DAT/123456789/ooo.avi'
			 */
			t.setDownloadURI(v.getDestUrl().substring(v.getDestUrl().length() - dataPath.length() - 11));
			t.setProgress(progress);
			t.setSubmit(submit.shortValue());
			/*if(($row['status'] == 1) && ($row['progress'] == 100))
			{
			  $command = "select resolution, duration, space, frame_rate FROM useruploadvideo where useruploadvideoid = $UserUploadVideoId";
			  $result = mysql_query($command);
			  $row = mysql_fetch_array($result);
			  $resultArray['resolution'] = $row['resolution'];
			  $resultArray['duration'] = $row['duration'];
			  $resultArray['space'] = $row['space'];
			  $resultArray['frame_rate'] = $row['frame_rate'];
			}*/
			if (status == 1 && progress == 100) {
				t.setResolution(v.getResolution());
				t.setDuration(v.getDuration());
				t.setSpace(v.getSpace());
				t.setFrame_rate(v.getFrameRate());
			}
			return t;
		} catch (Exception e) {
			throw new ServiceException(Status.QUERY_ERROR, e);
		}
	}

	@Override
	public TaskDetailVo queryTaskDetail(String flowNumber) {
		try {
			Externaltask e = externaltaskDao.get(Long.valueOf(flowNumber));
			if (null == e) {
				throw new ServiceException(Status.OBJECT_IS_NOT_EXIST);
			}
			TaskDetailVo taskDetailVo = new TaskDetailVo();
			BeanUtils.copyProperties(e, taskDetailVo);
			Analysisvideo analysisvideo = analysisvideoDao.getHeightAndwidth(flowNumber);
			if (analysisvideo != null) {
				taskDetailVo.setSummaryHeight(analysisvideo.getOutputHeight());
				taskDetailVo.setSummaryWidth(analysisvideo.getOutputWidth());
			}
			return taskDetailVo;
		} catch (Exception e) {
			throw new ServiceException(Status.QUERY_ERROR, e);
		}
	}

	@Override
	public ListResultVo getuploadtasklist(String userid, Integer status, Long startTime, Long endTime, Integer index, Integer count) {
		try {

			ListResultVo result = videoDao.queryUploadFileList(userid, status, startTime, endTime, index, count);

			// TODO 这里的totalcount,if(status==5)的情况还要去查一库。。。。。
			int totalcount = 0;

			return result;
		} catch (Exception e) {
			throw new ServiceException(Status.QUERY_ERROR, e);
		}
	}

	@Override
	public String getsnapshotzipurl(String flownumber, String snapshotType, Short sortType, Short sortOrder, Short objType, Short objSize, String rgbInfo,
			Short objType2) {
		String downLoadUrl = "";
		if (!"tube".equals(snapshotType) && !"obj".equals(snapshotType)) {
			throw new ServiceException(Status.INVALID_VALUE);
		}

		Config c = configDao.getConfig();
		String dataPath = c.getDataPath();
		dataPath = dataPath + File.separator + "AstVS_1v2" + File.separator;
		// 取taskId
		Externaltask externaltask = externaltaskDao.findBy("flowNumber", flownumber);
		if (externaltask == null || externaltask.getUserUploadVideoId() == null) {
			throw new ServiceException(Status.OBJECT_IS_NOT_EXIST);
		}
		Integer taskId = externaltask.getTaskId();
		Short recordTimeType;

		Integer userUploadVideoId = externaltask.getUserUploadVideoId();
		SnapGenInfoVo sv = videoDao.querySnapGenInfo(userUploadVideoId, taskId);
		if (0 == userUploadVideoId) {
			recordTimeType = 2;
		} else {
			recordTimeType = 1;
		}
		if ("obj".equals(snapshotType)) {
			Externaltask e = externaltaskDao.findBy("taskId", taskId.longValue());
			RetrieveParamVo rp = getRetrieveParam(e);
			if (null == objType) {
				objType = rp.getObjType();
			}
			String nullValue = "null,null,null,null,null,null,null,null,null";
			if (StringUtils.isEmpty(rgbInfo)) {
				rgbInfo = rp.getRgbInfo();
			}
			if (null == sortType) {
				if (!nullValue.equals(rp.getRgbInfo())) {
					sortType = 4;
				} else {
					sortType = 1;
				}
			}
		}
		Short enableCarnum = 0;
		SnapshotVo snapshot;
		if ("tube".equals(snapshotType)) {
			snapshot = queryTubeSnapshot(taskId, 0, 10000, sortType, sortOrder, objType, objSize, rgbInfo);
		} else {
			snapshot = queryObjSnapshot(taskId, 0, 10000, sortType, sortOrder, objType, objSize, rgbInfo, objType2);
		}

		SnapshotFolderVo sf = videoDao.querySnapshotFolder(flownumber);
		// 去掉路径和扩展名
		String fileName = FileUtils.getNoExtName(sf.getLocalFilename());
		fileName = fileName + "_" + flownumber;

		String preFix = "obj".equals(snapshotType) ? "obj" : "all";
		fileName = preFix + sortType + sortOrder + objType + objSize + "_" + fileName; // 如果是目标快照,添加obj前缀
		deleteFile("zip", "zipSpace");
		String webRoot = PathUtils.getWebRoot() + File.separator;
		String tmpDir = webRoot;
		if (snapshot.getIsObjSnapReady() == 0) {
			tmpDir += fileName + "_" + System.currentTimeMillis();
			FileUtils.createDir(tmpDir);
			fileName = tmpDir + ".zip";
		} else if (snapshot.getIsObjSnapReady() == 1) {
			fileName = fileName + ".zip";
			String zipFile = webRoot + "zip" + File.separator + fileName;
			if (FileUtils.isExistFile(zipFile)) {
				try {
					downLoadUrl = "vsdownload:" + URLEncoder.encode(fileName, "UTF-8");
				} catch (UnsupportedEncodingException e) {
				}
				return downLoadUrl;
			}
		}
		return downLoadUrl;
	}

	/**
	 * 清理web根目录下的空间
	 * 
	 * @param toDelete
	 *            web根目录下要清理的文件夹名
	 * 
	 * @param compareKey
	 *            从xml里面通过compareKey取得大小,和toDelete比较, 要确保toDelete比这个值小,大了就删里面的文件
	 */
	private void deleteFile(String toDelete, String compareKey) {
		String file = PathUtils.getWebRoot() + File.separator + toDelete;
		File f = new File(file);
		if (f.exists()) {
			Double size = FileUtils.getDirSize(file);
			Integer orgvideofragmentSize = Integer.valueOf(ConfigUtils.getValue(compareKey));
			File fs[] = f.listFiles();
			for (int i = 0, j = fs.length; size.intValue() > orgvideofragmentSize.intValue() && i < j; i++) {
				File subFile = fs[i];
				size = size - FileUtils.getDirSize(subFile);
				subFile.delete();
			}
		}

	}

	private SnapshotVo queryObjSnapshot(Integer taskId, int i, int j, Short sortType, Short sortOrder, Short objType, Short objSize, String rgbInfo,
			Short objType2) {
		return null;
	}

	private SnapshotVo queryTubeSnapshot(Integer taskId, int index, int count, Short sortType, Short sortOrder, Short objType, Short objSize, String rgbInfo) {
		Generatevideo g = generatevideoDao.load(taskId.longValue());
		Short isAllSnapshots = 1;
		if (1 != g.getGenerateStatusFlag()) {
			isAllSnapshots = 0;
		}
		// ===== Query snapshot info =====
		SnapshotVo sv = new SnapshotVo();
		/* TODO queryTubeSnapshot 此处不影响结果
		videoDao.queryTubeSnapshot(taskId, index, count, sortType,
		 sortOrder, objType, objSize, rgbInfo);*/
		sv.setIsObjSnapReady(isAllSnapshots);
		return sv;

	}

	private RetrieveParamVo getRetrieveParam(Externaltask e) {
		RetrieveParamVo rp = new RetrieveParamVo();
		rp.setObjType(e.getObjType());
		String avgRgbInfo = getRgbInfo(e.getRetrieveAvgcolor());
		String upperRgbInfo = getRgbInfo(e.getRetrieveUppercolor());
		String lowerRgbInfo = getRgbInfo(e.getRetrieveLowercolor());
		rp.setRgbInfo(avgRgbInfo + "," + upperRgbInfo + "," + lowerRgbInfo);
		return rp;
	}

	private String getRgbInfo(Integer retrieveColor) {
		String rgbInfo;
		if (retrieveColor == 0) {
			rgbInfo = "null,null,null";
		} else {
			rgbInfo = ((retrieveColor & 0xff0000) >> 16) + "," + ((retrieveColor & 0xff00) >> 8) + "," + (retrieveColor & 0xff);
		}
		return rgbInfo;
	}

	@Override
	public String getOrgvideoFragmenturl(String filename, Integer ss, Integer endpos) {
		try {
			String url = "";
			if (!FileUtils.isExistFile(filename)) {
				return url;
			}
			deleteFile("videoclip", "orgvideofragment");
			// 创视频片段文件夹
			String base_dir = File.separator + "videoclip";
			String webRootPath = PathUtils.getWebRoot();
			String clipdir = webRootPath + base_dir;
			FileUtils.createDir(clipdir);

			String clipfile = FileUtils.getFileName(filename);
			String ext = ".avi";
			clipfile = clipfile + "_" + ss + "_" + endpos + ext;
			String clipname = clipdir + File.separator + clipfile;

			if (FileUtils.isExistFile(clipname)) {
				url = "/videoclip/" + clipfile;
				return url;
			};

			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
			String start = sdf.format(new Date(ss * 1000l));
			String end = sdf.format(new Date(endpos * 1000l));
			/*
			 * $cmd = '..\..\TranscoderService\ffmpeg  -ss ' . $startTime . ' -t ' . $endTime . ' -i  "' . $filename .' "   -vcodec  libx264 "' . $clipname . '"';
			 * php是放在web根目录的，也就是说从web根目录往上找两级
			 */
			File webRoot = new File(webRootPath);
			String cmd = webRoot.getParentFile().getParent() + "\\TranscoderService\\ffmpeg  -ss " + start + " -t " + end + " -i  \""
					+ filename + " \"   -vcodec  libx264 \"" + clipname + "\"";
			Runtime.getRuntime().exec("cmd.exe /C " + cmd);
			if (FileUtils.isExistFile(filename)) {
				url = "/videoclip/" + clipfile;
			}
			return url;

		} catch (Exception e) {
			throw new ServiceException(Status.QUERY_ERROR, e);
		}
	}

	@Override
	public TaskDetailVo queryLastCfgInfo(Integer videoid) {
		try {
			Useruploadvideo v = videoDao.get(videoid.longValue());
			Externaltask e = externaltaskDao.getLastTask(videoid);
			if (null == v || null == e) {
				throw new ServiceException(Status.NO_RESULT);
			}
			return queryTaskDetail(e.getFlowNumber());
		} catch (Exception e) {
			throw new ServiceException(Status.QUERY_ERROR, e);
		}
	}

	@Override
	public void addAutoAnalyse4Case(Integer caseid, Integer userid) {
		try {
			Externaltask e;
			List list = videoDao.getVideosByCase(caseid, userid);
			if (list.size() > 0) {
				for (int i = 0, j = list.size(); i < j; i++) {
					e = (Externaltask) list.get(i);
					short taskType = e.getTaskType();

					String taskName;
					/*  WHEN 0 THEN SET _taskName = '检索任务';
					  WHEN 1 THEN SET _taskName = '浓缩检索任务';
					  WHEN 2 THEN SET _taskName = '浓缩任务';*/
					if (taskType == 0) {
						taskName = "检索任务";
					} else if (taskType == 1) {
						taskName = "浓缩检索任务";
					} else if (taskType == 2) {
						taskName = "浓缩检索任务";
					} else {
						throw new ServiceException(Status.TASK_TYPE_ERRER);
					}

					long taskCount = externaltaskDao.findByTaskNameAndUserUploadVideoId(e.getUserUploadVideoId(), taskName);
					taskName = taskName + "(" + (taskCount + 1) + ")";
					e.setTaskName(taskName);
					e.setUserid("" + userid);
					e.setSourceUrl("file://" + e.getLocalFilename());
					externaltaskDao.save(e);
					e.setFlowNumber("" + e.getExtTaskId());
					externaltaskDao.update(e);
				}
			}

		} catch (Exception e) {
			throw new ServiceException(Status.ADD_ERROR, e);
		}
	}

	@Override
	public void addAutoAnalyse4Camera(Integer cameraid, Integer userid) {
		try {
			Externaltask e;
			List list = videoDao.getVideosByCamera(cameraid, userid);
			if (list.size() > 0) {
				for (int i = 0, j = list.size(); i < j; i++) {
					e = (Externaltask) list.get(i);
					short taskType = e.getTaskType();

					String taskName;
					/*  WHEN 0 THEN SET _taskName = '检索任务';
					  WHEN 1 THEN SET _taskName = '浓缩检索任务';
					  WHEN 2 THEN SET _taskName = '浓缩任务';*/
					if (taskType == 0) {
						taskName = "检索任务";
					} else if (taskType == 1) {
						taskName = "浓缩检索任务";
					} else if (taskType == 2) {
						taskName = "浓缩检索任务";
					} else {
						throw new ServiceException(Status.TASK_TYPE_ERRER);
					}

					long taskCount = externaltaskDao.findByTaskNameAndUserUploadVideoId(e.getUserUploadVideoId(), taskName);
					taskName = taskName + "(" + (taskCount + 1) + ")";
					e.setTaskName(taskName);
					e.setUserid("" + userid);
					e.setSourceUrl("file://" + e.getLocalFilename());
					externaltaskDao.save(e);
					e.setFlowNumber("" + e.getExtTaskId());
					externaltaskDao.update(e);
				}
			}
		} catch (Exception e) {
			throw new ServiceException(Status.ADD_ERROR, e);
		}

	}

	@Override
	public AutoAnalyseParamVo queryAutoAnalyseParam(Long caseid, Long userid) {
		try {
			Config c = configDao.getConfig();
			String dataPath = c.getDataPath();
			Autoanalyseparam a = autoanalyseparamDao.findByCaseIdAndUserId(caseid, userid);
			AutoAnalyseParamVo av = new AutoAnalyseParamVo();
			BeanUtils.copyProperties(a, av);
			int beginIndex = dataPath.length() + 11;
			String requestImageUrl = a.getRequestImageUrl();
			String ridUrl = requestImageUrl.length() >= beginIndex ? requestImageUrl.substring(beginIndex) : "";
			av.setRequestImageDownloadUrl(ridUrl);
			String requestMaskUrl = a.getRequestMaskUrl();
			String rmdURL = requestMaskUrl.length() > beginIndex ? requestMaskUrl.substring(beginIndex) : "";
			av.setRequestMaskDownloadUrl(rmdURL);
			return av;
		} catch (Exception e) {
			throw new ServiceException(Status.QUERY_ERROR, e);
		}
	}

	@Override
	public Autoanalyseparam4cameraVo queryAutoAnalyseParam4Camera(Long cameraid, Long userid) {
		try {
			Config c = configDao.getConfig();
			String dataPath = c.getDataPath();
			Autoanalyseparam4camera a = autoanalyseparam4cameraDao.findByCameraIdAndUserId(cameraid, userid);
			Autoanalyseparam4cameraVo av = new Autoanalyseparam4cameraVo();
			BeanUtils.copyProperties(a, av);
			return av;
		} catch (Exception e) {
			throw new ServiceException(Status.QUERY_ERROR, e);
		}
	}

	@Override
	public void modifyAutoAnalyseParam(Long caseid, Long userid, Short taskType, Short thickness, Integer sensitivity, Short objEnable, Short objType,
			Short enableAvgcolor,
			Integer retrieveAvgcolor, Short enableUppercolor, Integer retrieveUppercolor, Short enableLowercolor, Integer retrieveLowercolor,
			Short enableCarnum, String retrieveCarnum, Integer taskPriority, Short enableSearchByImage, String requestImageUrl, String requestImageData,
			String requestMaskUrl, String requestMaskData, Short isPostPic) {
		try {
			if (isPostPic == 1) {
				// 转移图片和掩码文件
				requestImageUrl = moveFile(requestImageUrl);
				requestMaskUrl = moveFile(requestMaskUrl);
			}
			Autoanalyseparam a = autoanalyseparamDao.findByCaseIdAndUserId(caseid, userid);
			if (a == null) {
				a = new Autoanalyseparam();
				a.setCaseid(caseid);
				a.setUserid(userid);
			}
			a.setTaskType(taskType);
			if (null != thickness) {
				a.setThickness(thickness);
			}
			if (null != thickness) {
				a.setThickness(thickness);
			}
			if (null != sensitivity) {
				a.setSensitivity(sensitivity);
			}
			if (null != objEnable) {
				a.setObjEnable(objEnable);
			}
			if (null != objType) {
				a.setObjType(objType);
			}
			if (null != enableAvgcolor) {
				a.setEnableAvgcolor(enableAvgcolor);
			}
			if (null != retrieveAvgcolor) {
				a.setRetrieveAvgcolor(retrieveAvgcolor);
			}
			if (null != enableUppercolor) {
				a.setEnableUppercolor(enableUppercolor);
			}
			if (null != retrieveUppercolor) {
				a.setRetrieveUppercolor(retrieveUppercolor);
			}
			if (null != enableLowercolor) {
				a.setEnableLowercolor(enableLowercolor);
			}
			if (null != retrieveLowercolor) {
				a.setRetrieveLowercolor(retrieveLowercolor);
			}
			if (null != enableCarnum) {
				a.setEnableCarnum(enableCarnum);
			}
			if (null != retrieveCarnum) {
				a.setRetrieveCarnum(retrieveCarnum);
			}
			if (null != taskPriority) {
				a.setTaskPriority(taskPriority);
			}
			if (null != enableSearchByImage) {
				a.setEnableSearchByImage(enableSearchByImage);
			}
			if (null != requestImageUrl) {
				a.setRequestImageUrl(requestImageUrl);
			}
			if (null != requestImageData) {
				a.setRequestImageData(requestImageData);
			}
			if (null != requestMaskUrl) {
				a.setRequestMaskUrl(requestMaskUrl);
			}
			if (null != requestMaskData) {
				a.setRequestMaskData(requestMaskData);
			}
			autoanalyseparamDao.saveOrUpdate(a);
		} catch (Exception e) {
			throw new ServiceException(Status.MODIFY_ERROR, e);
		}
	}

	/**
	 * 转移文件
	 * 
	 * @param filePath
	 * @return
	 * @throws Exception
	 */

	private File movefile(String filePath) throws Exception {
		if (StringUtils.isEmpty(filePath)) {
			return null;
		}
		String ftpPath = RegUtils.getFtpPath();
		if (!ftpPath.endsWith(File.separator)) {
			ftpPath += File.separator;
		}
		String dataPath = RegUtils.getDataPath() + "\\AstVS_1v2\\orgpics\\";
		FileUtils.createDir(dataPath);
		// 转移
		File newFile = FileUtils.copy(ftpPath + filePath, dataPath + filePath);
		// 如果复制到的地方已经有一份了,则在原来的地方再复制一份,
		String newName = newFile.getName();
		if (!newName.equals(filePath)) {
			FileUtils.copy(ftpPath + filePath, ftpPath + newName);
			filePath = newName;
		}
		return newFile;
	}

	private String moveFile(String filePath) throws Exception {
		if (StringUtils.isEmpty(filePath)) {
			return filePath;
		}
		String ftpPath = RegUtils.getFtpPath();
		if (!ftpPath.endsWith(File.separator)) {
			ftpPath += File.separator;
		}
		String dataPath = RegUtils.getDataPath() + "\\AstVS_1v2\\orgpics\\";
		FileUtils.createDir(dataPath);
		// 转移
		File newFile = FileUtils.copy(ftpPath + filePath, dataPath + filePath);
		// 如果复制到的地方已经有一份了,则在原来的地方再复制一份,
		String newName = newFile.getName();
		if (!newName.equals(filePath)) {
			FileUtils.copy(ftpPath + filePath, ftpPath + newName);
			filePath = newName;
		}
		return filePath;
	}

	@Override
	public void modifyAutoAnalyseParam4Camera(Long cameraid, Long userid, Short udrExist, String udrSetting, Short summaryWidth, Short summaryHeight,
			Short isSetTripArea, String tripArea, Boolean objSearchByMov, String objRequestMovVertics, Integer objRequestMovVerticsNum) {
		try {
			Autoanalyseparam4camera a = autoanalyseparam4cameraDao.findByCameraIdAndUserId(cameraid, userid);
			if (a == null) {
				a = new Autoanalyseparam4camera();
				a.setCameraid(cameraid);
				a.setUserid(userid);
			}
			if (null != udrExist) {
				a.setUdrExist(udrExist);
			}
			if (null != udrSetting) {
				a.setUdrSetting(udrSetting);
			}
			if (null != summaryWidth) {
				a.setSummaryWidth(summaryWidth);
			}
			if (null != summaryHeight) {
				a.setSummaryHeight(summaryHeight);
			}
			if (null != isSetTripArea) {
				a.setIsSetTripArea(isSetTripArea);
			}
			if (null != tripArea) {
				a.setTripArea(tripArea);
			}
			if (null != objSearchByMov) {
				a.setObjSearchByMov(objSearchByMov);
			}
			if (null != objRequestMovVertics) {
				a.setObjRequestMovVertics(objRequestMovVertics);
			}
			if (null != objRequestMovVerticsNum) {
				a.setObjRequestMovVerticsNum(objRequestMovVerticsNum);
			}
			autoanalyseparam4cameraDao.saveOrUpdate(a);
		} catch (Exception e) {
			throw new ServiceException(Status.MODIFY_ERROR, e);
		}
	}

	@Override
	public List<UnAssignVideoVo> queryUnAssignVideo(Long caseid) {
		try {
			return videoDao.queryUnAssignVideo(caseid);
		} catch (Exception e) {
			throw new ServiceException(Status.QUERY_ERROR, e);
		}
	}

	@Override
	public void assigningtask(Long userid, List<Long> videoIdList) {
		try {
			Assigntask a;
			for (Long id : videoIdList) {
				a = assigntaskDao.findByUserIdAndVideoId(userid, id);
				if (null == a) {
					a = new Assigntask(userid, id);
					assigntaskDao.save(a);
				}
			}
		} catch (Exception e) {
			throw new ServiceException(Status.EXECUTE_ERROR, e);
		}

	}

	@Override
	public List<UnAssignVideoVo> queryunhandledtask(Long userid) {
		try {
			return videoDao.queryunhandledtask(userid);
		} catch (Exception e) {
			throw new ServiceException(Status.QUERY_ERROR, e);
		}
	}

	@Override
	public void modifyHandletask(Short command, List<Long> videoIdList) {
		try {
			// command,0：处理完成 1：取消分配
			Assigntask a;
			for (Long id : videoIdList) {
				a = assigntaskDao.get(id);
				if (null != a) {
					if (command == 0) {
						a.setStatus(Assigntask.STATUS_HANDLED);
						a.setStatusDesc(Assigntask.HANDLED);
						assigntaskDao.update(a);
					} else if (command == 1) {
						assigntaskDao.delete(a);
					}
				}
			}
		} catch (Exception e) {
			throw new ServiceException(Status.MODIFY_ERROR, e);
		}

	}

	@Override
	public List<AssignedtaskVo> queryassignedtasklist(Long caseid) {
		try {
			return videoDao.queryassignedtasklist(caseid);
		} catch (Exception e) {
			throw new ServiceException(Status.QUERY_ERROR, e);
		}
	}

	@Override
	public EnhanceTask addPicEnhance(Short type, String picFilename, Integer iWidth, Integer iHeight, Short iWTDering, Short iWTDenoise, Short iUseGPU,
			Timestamp createTime, Short priority, Float density) {
		try {
			/* CASE _type
			     when 2 then SET @type =  'deblur';
			     when 3 then SET @type =  'dehaze';
			     when 4 then SET @type =  'nightEnhance';
			     ELSE SELECT 1021 INTO iErrorCode;
			     	LEAVE exit_label;
			     END CASE;*/
			String enhanceType = "";
			if (type == 2) {
				enhanceType = "deblur";
			} else if (type == 3) {
				enhanceType = "dehaze";
			} else if (type == 4) {
				enhanceType = "nightEnhance";
			} else {
				throw new ServiceException(Status.TYPE_ERROR);
			}
			// 转移图片
			picFilename = moveFile(picFilename);
			// 持久化
			EnhanceTask e = new EnhanceTask();
			e.setEnhanceType(enhanceType);
			e.setSourceUrl(picFilename);
			e.setIwidth(iWidth);
			e.setIheight(iHeight);
			e.setIwtdenoise(iWTDering);
			e.setIwtdenoise(iWTDenoise);
			e.setIuseGpu(iUseGPU);
			e.setCreateTime(createTime);
			e.setPriority(priority);
			e.setDensity(density);
			// 默认值
			e.setStateFlag(0L);
			e.setProgress(Short.valueOf("0"));
			e.setSrcType(Short.valueOf("1"));
			enhanceTaskDao.save(e);
			return e;
		} catch (Exception e) {
			throw new ServiceException(Status.ADD_ERROR, e);
		}
	}

	@Override
	public EnhanceTask addVideoEnhance(Short type, Long videoid, String sourceUrl, Integer iWidth, Integer iHeight, Short iWTDering, Short iWTDenoise,
			Short iUseGPU, Timestamp createTime, Short priority, Float density) {
		try {
			/*when 1 then SET @type =  'denoise';
			  when 3 then SET @type =  'dehaze';
			  when 4 then SET @type =  'nightEnhance';*/
			String enhanceType = "";
			if (type == 1) {
				enhanceType = "denoise";
			} else if (type == 3) {
				enhanceType = "dehaze";
			} else if (type == 4) {
				enhanceType = "nightEnhance";
			} else {
				throw new ServiceException(Status.TYPE_ERROR);
			}
			// 持久化
			EnhanceTask e = new EnhanceTask();
			e.setEnhanceType(enhanceType);
			e.setVideoid(videoid);
			e.setSourceUrl(sourceUrl);
			e.setIwidth(iWidth);
			e.setIheight(iHeight);
			e.setIwtdenoise(iWTDering);
			e.setIwtdenoise(iWTDenoise);
			e.setIuseGpu(iUseGPU);
			e.setCreateTime(createTime);
			e.setPriority(priority);
			e.setDensity(density);
			// 默认值
			e.setStateFlag(0L);
			e.setProgress(Short.valueOf("0"));
			e.setSrcType(Short.valueOf("2"));
			enhanceTaskDao.save(e);
			return e;
		} catch (Exception e) {
			throw new ServiceException(Status.ADD_ERROR, e);
		}

	}

	@Override
	public EnhanceTaskVo queryEnhance(Long id) {
		try {
			EnhanceTaskVo v = null;
			EnhanceTask e = enhanceTaskDao.get(id);
			if (e != null) {
				Long videoid = e.getVideoid();
				if (videoid != null) {
					Useruploadvideo uv = videoDao.get(videoid);
					if (e.getSrcType() == 2 && uv != null && uv.getStatus() == 0) {
						e.setStateFlag(0L);
						e.setProgress(Short.valueOf("0"));
					}
				}
				v = new EnhanceTaskVo();
				BeanUtils.copyProperties(e, v);
			} else {
				throw new ServiceException(Status.OBJECT_IS_NOT_EXIST);
			}
			return v;
		} catch (Exception e) {
			throw new ServiceException(Status.QUERY_ERROR, e);
		}
	}

	@Override
	public List<VideoEnhanceListVo> queryVideoEnhanceList(Short type) {
		try {
			String enhanceType = "";
			if (type == 1) {
				enhanceType = "denoise";
			} else if (type == 3) {
				enhanceType = "dehaze";
			} else if (type == 4) {
				enhanceType = "nightEnhance";
			} else {
				throw new ServiceException(Status.TYPE_ERROR);
			}
			return videoDao.queryVideoEnhanceList(enhanceType);
		} catch (Exception e) {
			throw new ServiceException(Status.QUERY_ERROR, e);
		}
	}

	@Override
	public List<PicEnhanceListVo> queryPicEnhanceList(Short type) {
		try {
			String enhanceType = "";
			if (type == 2) {
				enhanceType = "deblur";
			} else if (type == 3) {
				enhanceType = "dehaze";
			} else if (type == 4) {
				enhanceType = "nightEnhance";
			} else {
				throw new ServiceException(Status.TYPE_ERROR);
			}
			return videoDao.queryPicEnhanceList(enhanceType);
		} catch (Exception e) {
			throw new ServiceException(Status.QUERY_ERROR, e);
		}
	}

	@Override
	public void deleteEnhanceTask(Long id) {
		try {
			EnhanceTask e = enhanceTaskDao.get(id);
			if (e == null) {
				throw new ServiceException(Status.OBJECT_IS_NOT_EXIST);
			}
			enhanceTaskDao.delete(e);
		} catch (Exception e) {
			throw new ServiceException(Status.DEL_ERROR, e);
		}

	}

	@Override
	public List querychildlist(Long videoid, Integer analyseStartindex, Integer analyseCount, Integer denoiseStartindex, Integer denoiseCount,
			Integer dehazeStartindex, Integer dehazeCount, Integer nightEnhanceStartindex, Integer nightEnhanceCount) {
		try {
			List list = new ArrayList();
			ReturnData rd = externaltaskDao.findAnalyse(videoid, analyseStartindex, analyseCount);
			list.add(new AnalyseVo(rd));
			boolean isQueryDenoise = isNotEmpty(denoiseStartindex, denoiseCount);
			boolean isQueryDehaze = isNotEmpty(dehazeStartindex, dehazeCount);
			boolean isQueryNightEnhance = isNotEmpty(nightEnhanceStartindex, nightEnhanceCount);

			if (isQueryDenoise) {
				rd = enhanceTaskDao.findByEnhanceType("denoise", denoiseStartindex, denoiseCount);
				list.add(new DenoiseVo(rd));
			}
			if (isQueryDehaze) {
				rd = enhanceTaskDao.findByEnhanceType("dehaze", dehazeStartindex, dehazeCount);
				list.add(new DehazeVo(rd));
			}
			if (isQueryNightEnhance) {
				rd = enhanceTaskDao.findByEnhanceType("nightEnhance", nightEnhanceStartindex, nightEnhanceCount);
				list.add(new NightEnhanceVo(rd));
			}
			return list;
		} catch (Exception e) {
			throw new ServiceException(Status.QUERY_ERROR, e);
		}

	}

	private boolean isNotEmpty(Integer startindex, Integer count) {
		return (startindex != null && count != null);
	}

	@Override
	public Fsrtask addFSRTask(String picFilename, String params) {
		try {
			File image = movefile(picFilename);
			/*$newfilename = $base_dir ."\\" .$newname.$ext;
			$desturl = $base_dir ."\\" .$newname."_res".$ext;*/

			String imagepath = image.getAbsolutePath();
			String ext = FileUtils.getExt(imagepath);
			String resultpath = imagepath.replace(ext, "_res" + ext);
			Fsrtask f = new Fsrtask();
			f.setImagepath(imagepath);
			f.setResultpath(resultpath);
			f.setParams(params);
			f.setStatus(0);
			f.setProgress(0);
			fsrtaskDao.save(f);
			return f;
		} catch (Exception e) {
			throw new ServiceException(Status.ADD_ERROR, e);
		}

	}

	@Override
	public List queryFSRTaskList() {
		try {
			Config c = configDao.getConfig();
			String dataPath = c.getDataPath();
			int len = dataPath.length() + 11;
			/*select taskid, 
			 * resultpath, 
			 * right(resultpath,char_length(resultpath)-char_length(data_path)-11), 
			 * imagepath, 
			 * right(imagepath,char_length(imagepath)-char_length(data_path)-11), 
			 * status, progress, 
			 * params from tbl_FSRTask, config');        
			*/
			FsrtaskListVo v;
			Fsrtask f;
			List<Fsrtask> list = fsrtaskDao.getAll();
			String resultpath;
			String imagepath;
			List newList = new ArrayList();
			for (int i = 0; i < list.size(); i++) {
				f = list.get(i);
				v = new FsrtaskListVo();
				BeanUtils.copyProperties(f, v);
				/*这三个是要处理的属性
				 resultUrl;
				 orgPath;
				 orgUrl;*/
				resultpath = f.getResultpath();
				imagepath = f.getImagepath();
				v.setResultUrl(resultpath.length() > len ? resultpath.substring(len) : resultpath);
				v.setOrgPath(imagepath);
				v.setOrgUrl(imagepath.length() > len ? imagepath.substring(len) : imagepath);
				newList.add(v);
			}
			return newList;
		} catch (Exception e) {
			throw new ServiceException(Status.QUERY_ERROR, e);
		}
	}

	@Override
	public FsrtaskVo queryFSRTask(Integer id) {
		try {
			Config c = configDao.getConfig();
			String dataPath = c.getDataPath();
			int len = dataPath.length() + 11;
			Fsrtask f = fsrtaskDao.get(id);
			if (null == f) {
				throw new ServiceException(Status.OBJECT_IS_NOT_EXIST);
			}
			FsrtaskVo v = new FsrtaskVo();

			BeanUtils.copyProperties(f, v);
			/*这三个是要处理的属性
			 resultUrl;
			 orgPath;
			 orgUrl;*/
			String resultpath = f.getResultpath();
			String imagepath = f.getImagepath();
			v.setSourceUrl(imagepath);
			v.setDownloadUrl(imagepath.length() > len ? imagepath.substring(len) : imagepath);
			v.setResultUrl(resultpath.length() > len ? resultpath.substring(len) : resultpath);
			return v;
		} catch (Exception e) {
			throw new ServiceException(Status.QUERY_ERROR, e);
		}
	}

	@Override
	public void deleteFSRTask(Integer id) {
		try {
			Fsrtask f = fsrtaskDao.get(id);
			if (null == f) {
				throw new ServiceException(Status.OBJECT_IS_NOT_EXIST);
			}
			fsrtaskDao.delete(f);
		} catch (Exception e) {
			throw new ServiceException(Status.DEL_ERROR, e);
		}
	}

	@Override
	public Useruploadvideo addvideo(Long cameraid, String videoFilename, Timestamp recordTime, Timestamp createtime, Short isautosubmit, Short videoType,
			Integer userId) {
		try {

			Camera c = cameraDao.get(cameraid);
			if (c == null) {
				throw new ServiceException(Status.OBJECT_IS_NOT_EXIST);
			}
			Long caseId = c.getCaseId();
			String srcName = videoFilename.trim();
			String srcURI;
			String destURI;
			String separator = File.separator;
			String dataPath = RegUtils.getDataPath() + "\\AstVS_1v2\\orgvideos\\" + caseId + separator + cameraid;
			if (FileUtils.isExistFile(srcName)) {
				// 如果传了一个绝对路径
				srcURI = srcName;
				destURI = dataPath + separator + FileUtils.getFileName(srcName);
			} else {
				// 就当是一个文件名吧
				FileUtils.createDir(dataPath);
				String ftpPath = RegUtils.getFtpPath();
				String ftpFold = ftpPath + separator + caseId + separator + cameraid;
				FileUtils.createDir(ftpFold);
				String ext = FileUtils.getExt(srcName);
				// 取得不包含扩展名的文件名
				String fileName = FileUtils.getNoExtName(srcName);

				File fFile = FileUtils.getNoRepeatFilename(ftpFold + separator + srcName);
				File dFile = FileUtils.getNoRepeatFilename(dataPath + separator + fileName + ".avi");

				String fName = FileUtils.getNoExtName(fFile.getAbsolutePath());
				String dName = FileUtils.getNoExtName(dFile.getAbsolutePath());
				if (fName.equals(dName)) {
					fileName = fName;
				} else {
					/**
					 * nn(0) vs nn(1) nn(0)
					 */
					String f = fName.substring(fileName.length()).replace("(", "").replace(")", "");
					String d = dName.substring(fileName.length()).replace("(", "").replace(")", "");
					if (f.length() == 0) {
						fileName = dName;
					} else if (d.length() == 0) {
						fileName = fName;
					} else {
						fileName = Integer.valueOf(d).intValue() > Integer.valueOf(f).intValue() ? fName : dName;
					}
				}
				String oldFtpFile = ftpPath + separator + fileName + ext;
				if (!srcName.equals(fileName + ext)) {
					FileUtils.copy(ftpPath + separator + srcName, oldFtpFile);
				}
				srcURI = ftpFold + separator + fileName + ext;
				destURI = dataPath + separator + fileName + ".avi";
				FileUtils.copy(oldFtpFile, srcURI);
			}

			/*(CameraID,    timestamp, record_time, userid, srcURL, destURL, status, last_err_code, last_err_msg, progress, retry_count, last_try_video_vendor_type, isAutoSubmit, video_type) 
			  (CameraID,   createtime, record_time, userid,@srcURL, @destURL,      0,             0,          '',        0,           0,                         -1, isAutoSubmit, video_type);
			*/
			userId = 1;
			Useruploadvideo u = new Useruploadvideo();
			u.setCameraId(cameraid);
			u.setTimestamp(createtime);
			u.setRecordTime(recordTime);
			u.setUserid(userId.longValue());
			u.setSrcUrl(srcURI);
			u.setDestUrl(destURI);
			u.setIsAutoSubmit(isautosubmit);
			u.setVideoType(videoType);

			videoDao.save(u);
			return u;
		} catch (Exception e) {
			throw new ServiceException(Status.ADD_ERROR, e);
		}
	}
}
