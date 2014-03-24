package cn.jiuling.distributedapi.service;

import java.sql.Timestamp;
import java.util.List;

import cn.jiuling.distributedapi.Vo.DownloadTasksVo;
import cn.jiuling.distributedapi.Vo.ExttaskstatusVo;
import cn.jiuling.distributedapi.Vo.ListResultVo;
import cn.jiuling.distributedapi.Vo.QueryTaskVo;
import cn.jiuling.distributedapi.Vo.TaskDetailVo;
import cn.jiuling.distributedapi.Vo.TranscodeStatusVo;
import cn.jiuling.distributedapi.model.Externaltask;
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

}
