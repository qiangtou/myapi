package cn.jiuling.distributedapi.Vo;

import java.sql.Timestamp;

public class TaskDetailVo {
	@Node("type")
	private Short taskType;
	@Node("run_time_speed")
	private Integer runTimeSpeed;
	private String sourceUrl;
	private Short thickness;
	private Integer sensitivity;
	@Node("UDR_exist")
	private Short udrExist;
	@Node("UDR_setting")
	private String udrSetting;
	@Node("obj_enable")
	private Short objEnable;
	@Node("obj_type")
	private Short objType;
	@Node("obj_subtype")
	private Short objSubtype;
	@Node("color_tolerance")
	private Short colorTolerance;
	@Node("enable_avgcolor")
	private Short enableAvgcolor;
	@Node("retrieve_avgcolor")
	private Integer retrieveAvgcolor;

	@Node("enable_uppercolor")
	private Short enableUppercolor;
	@Node("retrieve_uppercolor")
	private Integer retrieveUppercolor;
	@Node("enable_lowercolor")
	private Short enableLowercolor;
	@Node("retrieve_lowercolor")
	private Integer retrieveLowercolor;
	@Node("enable_carnum")
	private Short enableCarnum;
	@Node("retrieve_carnum")
	private String retrieveCarnum;

	private Short objHeight;
	private Short objWidth;
	private Short objDepth;
	private Integer startFrame;
	private Integer endFrame;
	@Node("submitDate")
	private Timestamp timestamp;

	@Node("obj_request_mov_vertics")
	private String objRequestMovVertics;

	@Node("summary_height")
	private Short summaryWidth;
	@Node("summary_width")
	private Short summaryHeight;
	private Short isSetTripArea;
	@Node("trip_area")
	private String tripArea;

	@Node("task_priority")
	private Integer taskPriority;
	private String taskName;

	@Node("enable_search_by_image")
	private Short enableSearchByImage;
	@Node("request_image_url")
	private String requestImageUrl;
	@Node("request_mask_url")
	private String requestMaskUrl;
	@Node("snap_type")
	private Short snapType;
	@Node("drop_frm_rate")
	private Float dropFrmRate;

	public Short getTaskType() {
		return taskType;
	}

	public void setTaskType(Short taskType) {
		this.taskType = taskType;
	}

	public Integer getRunTimeSpeed() {
		return runTimeSpeed;
	}

	public void setRunTimeSpeed(Integer runTimeSpeed) {
		this.runTimeSpeed = runTimeSpeed;
	}

	public String getSourceUrl() {
		return sourceUrl;
	}

	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}

	public Short getThickness() {
		return thickness;
	}

	public void setThickness(Short thickness) {
		this.thickness = thickness;
	}

	public Integer getSensitivity() {
		return sensitivity;
	}

	public void setSensitivity(Integer sensitivity) {
		this.sensitivity = sensitivity;
	}

	public Short getUdrExist() {
		return udrExist;
	}

	public void setUdrExist(Short udrExist) {
		this.udrExist = udrExist;
	}

	public String getUdrSetting() {
		return udrSetting;
	}

	public void setUdrSetting(String udrSetting) {
		this.udrSetting = udrSetting;
	}

	public Short getObjEnable() {
		return objEnable;
	}

	public void setObjEnable(Short objEnable) {
		this.objEnable = objEnable;
	}

	public Short getObjType() {
		return objType;
	}

	public void setObjType(Short objType) {
		this.objType = objType;
	}

	public Short getObjSubtype() {
		return objSubtype;
	}

	public void setObjSubtype(Short objSubtype) {
		this.objSubtype = objSubtype;
	}

	public Short getColorTolerance() {
		return colorTolerance;
	}

	public void setColorTolerance(Short colorTolerance) {
		this.colorTolerance = colorTolerance;
	}

	public Short getEnableAvgcolor() {
		return enableAvgcolor;
	}

	public void setEnableAvgcolor(Short enableAvgcolor) {
		this.enableAvgcolor = enableAvgcolor;
	}

	public Integer getRetrieveAvgcolor() {
		return retrieveAvgcolor;
	}

	public void setRetrieveAvgcolor(Integer retrieveAvgcolor) {
		this.retrieveAvgcolor = retrieveAvgcolor;
	}

	public Short getEnableUppercolor() {
		return enableUppercolor;
	}

	public void setEnableUppercolor(Short enableUppercolor) {
		this.enableUppercolor = enableUppercolor;
	}

	public Integer getRetrieveUppercolor() {
		return retrieveUppercolor;
	}

	public void setRetrieveUppercolor(Integer retrieveUppercolor) {
		this.retrieveUppercolor = retrieveUppercolor;
	}

	public Short getEnableLowercolor() {
		return enableLowercolor;
	}

	public void setEnableLowercolor(Short enableLowercolor) {
		this.enableLowercolor = enableLowercolor;
	}

	public Integer getRetrieveLowercolor() {
		return retrieveLowercolor;
	}

	public void setRetrieveLowercolor(Integer retrieveLowercolor) {
		this.retrieveLowercolor = retrieveLowercolor;
	}

	public Short getEnableCarnum() {
		return enableCarnum;
	}

	public void setEnableCarnum(Short enableCarnum) {
		this.enableCarnum = enableCarnum;
	}

	public String getRetrieveCarnum() {
		return retrieveCarnum;
	}

	public void setRetrieveCarnum(String retrieveCarnum) {
		this.retrieveCarnum = retrieveCarnum;
	}

	public Short getObjHeight() {
		return objHeight;
	}

	public void setObjHeight(Short objHeight) {
		this.objHeight = objHeight;
	}

	public Short getObjWidth() {
		return objWidth;
	}

	public void setObjWidth(Short objWidth) {
		this.objWidth = objWidth;
	}

	public Short getObjDepth() {
		return objDepth;
	}

	public void setObjDepth(Short objDepth) {
		this.objDepth = objDepth;
	}

	public Integer getStartFrame() {
		return startFrame;
	}

	public void setStartFrame(Integer startFrame) {
		this.startFrame = startFrame;
	}

	public Integer getEndFrame() {
		return endFrame;
	}

	public void setEndFrame(Integer endFrame) {
		this.endFrame = endFrame;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public String getObjRequestMovVertics() {
		return objRequestMovVertics;
	}

	public void setObjRequestMovVertics(String objRequestMovVertics) {
		this.objRequestMovVertics = objRequestMovVertics;
	}

	public Short getSummaryWidth() {
		return summaryWidth;
	}

	public void setSummaryWidth(Short summaryWidth) {
		this.summaryWidth = summaryWidth;
	}

	public Short getSummaryHeight() {
		return summaryHeight;
	}

	public void setSummaryHeight(Short summaryHeight) {
		this.summaryHeight = summaryHeight;
	}

	public Short getIsSetTripArea() {
		return isSetTripArea;
	}

	public void setIsSetTripArea(Short isSetTripArea) {
		this.isSetTripArea = isSetTripArea;
	}

	public String getTripArea() {
		return tripArea;
	}

	public void setTripArea(String tripArea) {
		this.tripArea = tripArea;
	}

	public Integer getTaskPriority() {
		return taskPriority;
	}

	public void setTaskPriority(Integer taskPriority) {
		this.taskPriority = taskPriority;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public Short getEnableSearchByImage() {
		return enableSearchByImage;
	}

	public void setEnableSearchByImage(Short enableSearchByImage) {
		this.enableSearchByImage = enableSearchByImage;
	}

	public String getRequestImageUrl() {
		return requestImageUrl;
	}

	public void setRequestImageUrl(String requestImageUrl) {
		this.requestImageUrl = requestImageUrl;
	}

	public String getRequestMaskUrl() {
		return requestMaskUrl;
	}

	public void setRequestMaskUrl(String requestMaskUrl) {
		this.requestMaskUrl = requestMaskUrl;
	}

	public Short getSnapType() {
		return snapType;
	}

	public void setSnapType(Short snapType) {
		this.snapType = snapType;
	}

	public Float getDropFrmRate() {
		return dropFrmRate;
	}

	public void setDropFrmRate(Float dropFrmRate) {
		this.dropFrmRate = dropFrmRate;
	}
}
