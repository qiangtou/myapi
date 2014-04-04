package cn.jiuling.distributedapi.service;

import java.sql.Timestamp;
import java.util.List;

import cn.jiuling.distributedapi.Vo.AssignedtaskVo;
import cn.jiuling.distributedapi.Vo.AutoAnalyseParamVo;
import cn.jiuling.distributedapi.Vo.Autoanalyseparam4cameraVo;
import cn.jiuling.distributedapi.Vo.DownloadTasksVo;
import cn.jiuling.distributedapi.Vo.EnhanceTaskVo;
import cn.jiuling.distributedapi.Vo.ExttaskstatusVo;
import cn.jiuling.distributedapi.Vo.FsrtaskVo;
import cn.jiuling.distributedapi.Vo.ListResultVo;
import cn.jiuling.distributedapi.Vo.PicEnhanceListVo;
import cn.jiuling.distributedapi.Vo.QueryTaskVo;
import cn.jiuling.distributedapi.Vo.TaskDetailVo;
import cn.jiuling.distributedapi.Vo.TranscodeStatusVo;
import cn.jiuling.distributedapi.Vo.UnAssignVideoVo;
import cn.jiuling.distributedapi.Vo.VideoEnhanceListVo;
import cn.jiuling.distributedapi.model.EnhanceTask;
import cn.jiuling.distributedapi.model.Externaltask;
import cn.jiuling.distributedapi.model.Fsrtask;
import cn.jiuling.distributedapi.model.Useruploadvideo;

public interface VideoService {
	public List queryVideo(Long cameraid, Long userid);

	public void modifyVideo(Long videoid, Timestamp recordTime, Long userid);

	public long add3rdVideo(Long cameraid, String srcurl, String platformname, Short isautosubmit);

	public DownloadTasksVo query3rdVideoStatus(Long id);

	public List query3rdVideoList(Long cameraid, Short status, Timestamp start, Timestamp end, Integer index, Integer count);

	public ListResultVo queryTaskList(String userid, Integer status, Timestamp startTime, Timestamp endTime, Integer index, Integer count);

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
			Short isRegSet, String flowNumber, Short isContain);

	public Useruploadvideo addTranscodeTask(Long userid, String srcName, Short isAutoSubmit);

	public ExttaskstatusVo queryExttaskstatus(String flowNumber);

	public List<QueryTaskVo> queryTask(Integer uploadvideoid);

	/**
	 * 查找转码状态
	 * 
	 * @param uploadvideoid
	 * @return
	 */
	public TranscodeStatusVo queryTranscodeStatus(Long uploadvideoid);

	public TaskDetailVo queryTaskDetail(String flowNumber);

	public ListResultVo getuploadtasklist(String userid, Integer status, Long startTime, Long endTime, Integer index, Integer count);

	public String getsnapshotzipurl(String flownumber, String snapshotType, Short sortType, Short sortOrder, Short objType, Short objSize, String rgbInfo,
			Short objType2);

	public String getOrgvideoFragmenturl(String filename, Integer ss, Integer endpos);

	public TaskDetailVo queryLastCfgInfo(Integer videoid);

	public void addAutoAnalyse4Case(Integer caseid, Integer userid);

	public void addAutoAnalyse4Camera(Integer cameraid, Integer userid);

	public AutoAnalyseParamVo queryAutoAnalyseParam(Long caseid, Long userid);

	public Autoanalyseparam4cameraVo queryAutoAnalyseParam4Camera(Long cameraid, Long userid);

	public void modifyAutoAnalyseParam(Long caseid, Long userid, Short taskType, Short thickness, Integer sensitivity, Short objEnable, Short objType,
			Short enableAvgcolor,
			Integer retrieveAvgcolor, Short enableUppercolor, Integer retrieveUppercolor, Short enableLowercolor, Integer retrieveLowercolor,
			Short enableCarnum, String retrieveCarnum, Integer taskPriority, Short enableSearchByImage, String requestImageUrl, String requestImageData,
			String requestMaskUrl, String requestMaskData, Short isPostPic);

	public void modifyAutoAnalyseParam4Camera(Long cameraid, Long userid, Short udrExist, String udrSetting, Short summaryWidth, Short summaryHeight,
			Short isSetTripArea, String tripArea, Boolean objSearchByMov, String objRequestMovVertics, Integer objRequestMovVerticsNum);

	public List<UnAssignVideoVo> queryUnAssignVideo(Long caseid);

	public void assigningtask(Long userid, List<Long> videoIdList);

	public List<UnAssignVideoVo> queryunhandledtask(Long userid);

	public void modifyHandletask(Short command, List<Long> videoIdList);

	public List<AssignedtaskVo> queryassignedtasklist(Long caseid);

	public EnhanceTask addPicEnhance(Short type, String picFilename, Integer iWidth, Integer iHeight, Short iWTDering, Short iWTDenoise, Short iUseGPU,
			Timestamp createTime, Short priority, Float density);

	public EnhanceTask addVideoEnhance(Short type, Long videoid, String sourceUrl, Integer iWidth, Integer iHeight, Short iWTDering, Short iWTDenoise,
			Short iUseGPU, Timestamp createTime, Short priority, Float density);

	public EnhanceTaskVo queryEnhance(Long id);

	public List<VideoEnhanceListVo> queryVideoEnhanceList(Short type);

	public List<PicEnhanceListVo> queryPicEnhanceList(Short type);

	public void deleteEnhanceTask(Long id);

	public List querychildlist(Long videoid, Integer analyseStartindex, Integer analyseCount, Integer denoiseStartindex, Integer denoiseCount,
			Integer dehazeStartindex, Integer dehazeCount, Integer nightEnhanceStartindex, Integer nightEnhanceCount);

	public Fsrtask addFSRTask(String picFilename, String params);

	public List queryFSRTaskList();

	public FsrtaskVo queryFSRTask(Integer id);

	public void deleteFSRTask(Integer id);

	public Useruploadvideo addvideo(Long cameraid, String videoFilename, Timestamp recordTime, Timestamp createtime, Short isautosubmit, Short videoType, Integer userId);

}
