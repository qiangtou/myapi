package cn.jiuling.distributedapi.Vo;

import java.sql.Timestamp;

public class EnhanceTaskVo {
	/*<taskID>1</taskID>                          // int, 提交的taskID
	<enhanceType>dehaze</enhanceType>           // enhancement type
	<stateFlag>1</stateFlag>                    // int, 处理的状态, 0还未处理, 1成功处理, 2正在处理，其它: 处理失败
	<progress>100</progress>                    // int, 返回的处理进度, int，有效值 0 – 100
	<density>0.4</density>
	<createTime>2012-12-12+11-11-11</createTime>
	<priority>3</priority>
	<sourceUrl>c://orgpic//1_dehaze_boat.jpg</sourceUrl>
	<resultPath>file://c://..//astVideoEnhance//1_dehaze_boat.jpg</resultPath>   
	// 1_dehaze_boat.jpg, “1” is the taskID, “boat.jpg” is input filename
	<resultUrl>//astVideoEnhance//1_dehaze_boat.jpg</resultUrl>  // 如果stateFlag=1 and progress=100，表示处理结果的Url
	<videoid>1</videoid>*/
	@Node("taskID")
	private Long taskId;
	private String enhanceType;
	private Long stateFlag;
	private Short progress;
	private Float density;
	private Timestamp createTime;
	private Short priority;
	private String sourceUrl;
	private String resultPath;
	private Long videoid;

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public String getEnhanceType() {
		return enhanceType;
	}

	public void setEnhanceType(String enhanceType) {
		this.enhanceType = enhanceType;
	}

	public Long getStateFlag() {
		return stateFlag;
	}

	public void setStateFlag(Long stateFlag) {
		this.stateFlag = stateFlag;
	}

	public Short getProgress() {
		return progress;
	}

	public void setProgress(Short progress) {
		this.progress = progress;
	}

	public Float getDensity() {
		return density;
	}

	public void setDensity(Float density) {
		this.density = density;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Short getPriority() {
		return priority;
	}

	public void setPriority(Short priority) {
		this.priority = priority;
	}

	public String getSourceUrl() {
		return sourceUrl;
	}

	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}

	public String getResultPath() {
		return resultPath;
	}

	public void setResultPath(String resultPath) {
		this.resultPath = resultPath;
	}

	public Long getVideoid() {
		return videoid;
	}

	public void setVideoid(Long videoid) {
		this.videoid = videoid;
	}
}
