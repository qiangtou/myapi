package cn.jiuling.distributedapi.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Externaltask entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "externaltask")
public class Externaltask implements java.io.Serializable {

	// Fields

	private Long extTaskId;
	private Integer userUploadVideoId;
	private String userid;
	private Short configStatus;
	private String flowNumber;
	private Short taskType;
	private Integer taskPriority;
	private String linkFlowNumber;
	private String filename;
	private Integer fileSize;
	private String sourceUrl;
	private Short thickness;
	private Float framerate;
	private Integer sensitivity;
	private Integer runTimeSpeed;
	private Short udrExist;
	private String udrSetting;
	private Short isRegSet;
	private Short isContain;
	private Short clockwisePoint1X;
	private Short clockwisePoint1Y;
	private Short clockwisePoint2X;
	private Short clockwisePoint2Y;
	private Short clockwisePoint3X;
	private Short clockwisePoint3Y;
	private Short clockwisePoint4X;
	private Short clockwisePoint4Y;
	private Short objEnable;
	private Short objType;
	private Short objSubtype;
	private Short colorTolerance;
	private Short enableAvgcolor;
	private Integer retrieveAvgcolor;
	private Short enableUppercolor;
	private Integer retrieveUppercolor;
	private Short enableLowercolor;
	private Integer retrieveLowercolor;
	private Short enableCarnum;
	private String retrieveCarnum;
	private Short carnumStatus;
	private Short objHeight;
	private Short objWidth;
	private Short objDepth;
	private Integer timePeirodIndicator;
	private Integer timePeirodStart;
	private Integer timePeirodEnd;
	private Integer startFrame;
	private Integer endFrame;
	private String localFilename;
	private Integer taskId;
	private Short downloadStatus;
	private String destPath;
	private String udrVerticesNum;
	private String udrVertices;
	private Integer objRequestType;
	private Boolean objSearchByAvgColor;
	private Float objRequestColorB;
	private Float objRequestColorG;
	private Float objRequestColorR;
	private Boolean objSearchByUpperColor;
	private Float objRequestUpperB;
	private Float objRequestUpperG;
	private Float objRequestUpperR;
	private Boolean objSearchByLowerColor;
	private Float objRequestLowerB;
	private Float objRequestLowerG;
	private Float objRequestLowerR;
	private Float rbgToleranceInPct;
	private Boolean objSearchByHeight;
	private Float objRequestObjHeight;
	private Boolean objSearchByMov;
	private String objRequestMovVertics;
	private Integer objRequestMovVerticsNum;
	private Short summaryWidth;
	private Short summaryHeight;
	private Short isSetTripArea;
	private String tripArea;
	private Short snapType;
	private String taskName;
	private Short enableSearchByImage;
	private String requestImageUrl;
	private String requestImageData;
	private String requestMaskUrl;
	private String requestMaskData;
	private Float dropFrmRate;
	private Short searchScope;
	private Timestamp timestamp;
	private String testflag;

	// Constructors

	/** default constructor */
	public Externaltask() {
	}

	public Externaltask(
			Long userUploadVideoId,
			String localFilename,
			Integer framerate,
			Short taskType,
			Short runTimeSpeed,
			Short thickness,
			Integer sensitivity,
			Short objEnable,
			Short objType,
			Short enableAvgcolor,
			Integer retrieveAvgcolor,
			Short enableUppercolor,
			Integer retrieveUppercolor,
			Short enableLowercolor,
			Integer retrieveLowercolor,
			Short enableCarnum,
			String retrieveCarnum,
			Integer taskPriority,
			Short enableSearchByImage,
			String requestImageUrl,
			String requestImageData,
			String requestMaskUrl,
			String requestMaskData

	) {
		super();
		this.userUploadVideoId = userUploadVideoId.intValue();
		this.localFilename = localFilename;
		this.framerate = framerate != null ? framerate.floatValue() : null;
		this.taskType = taskType;
		this.runTimeSpeed = (int) runTimeSpeed;
		this.thickness = thickness;
		this.sensitivity = sensitivity;
		this.taskPriority = taskPriority;
		this.objEnable = objEnable;
		this.objType = objType;
		this.enableAvgcolor = enableAvgcolor;
		this.retrieveAvgcolor = retrieveAvgcolor;
		this.enableUppercolor = enableUppercolor;
		this.retrieveUppercolor = retrieveUppercolor;
		this.enableLowercolor = enableLowercolor;
		this.retrieveLowercolor = retrieveLowercolor;
		this.enableCarnum = enableCarnum;
		this.retrieveCarnum = retrieveCarnum;
		this.enableSearchByImage = enableSearchByImage;
		this.requestImageUrl = requestImageUrl;
		this.requestImageData = requestImageData;
		this.requestMaskUrl = requestMaskUrl;
		this.requestMaskData = requestMaskData;

		// 下面是初始化默认值
		this.setLinkFlowNumber("0");
		this.setFilename("1.avi");
		this.setFileSize(24560000);
		this.setSourceUrl("file://" + this.localFilename);
		this.setIsRegSet(Short.valueOf("0"));
		this.setIsContain(Short.valueOf("1"));
		this.setClockwisePoint1X(Short.valueOf("-1"));
		this.setClockwisePoint1Y(Short.valueOf("-1"));
		this.setClockwisePoint2X(Short.valueOf("-1"));
		this.setClockwisePoint2Y(Short.valueOf("-1"));
		this.setClockwisePoint3X(Short.valueOf("-1"));
		this.setClockwisePoint3Y(Short.valueOf("-1"));
		this.setClockwisePoint4X(Short.valueOf("-1"));
		this.setClockwisePoint4Y(Short.valueOf("-1"));

		this.setObjSubtype(Short.valueOf("0"));
		this.setColorTolerance(Short.valueOf("0"));
		this.setObjHeight(Short.valueOf("0"));
		this.setObjWidth(Short.valueOf("0"));
		this.setObjDepth(Short.valueOf("0"));
		this.setStartFrame(0);
		this.setEndFrame(5400000);
		this.setDownloadStatus(Short.valueOf("2"));
		this.setObjSearchByMov(false);
		this.setObjRequestMovVertics(" ");
		this.setObjRequestMovVerticsNum(0);
		this.setSummaryHeight(Short.valueOf("-1"));
		this.setSummaryWidth(Short.valueOf("-1"));
		this.setIsSetTripArea(Short.valueOf("0"));
		this.setTripArea("0");
		this.setUdrExist(Short.valueOf("0"));
		this.setUdrSetting("");

		this.setConfigStatus(Short.valueOf("0"));
		this.setCarnumStatus(Short.valueOf("0"));
		this.setSnapType(Short.valueOf("0"));
		this.setTimePeirodEnd(0);
		this.setTimePeirodIndicator(0);
		this.setTimePeirodStart(0);
		this.setDropFrmRate(0f);
		this.setSearchScope(Short.valueOf("0"));

		this.setTestflag("-");
		this.setTimestamp(new Timestamp(System.currentTimeMillis()));

	}

	/** full constructor */
	public Externaltask(Integer userUploadVideoId, String userid, Short configStatus, String flowNumber, Short taskType, Integer taskPriority,
			String linkFlowNumber, String filename, Integer fileSize, String sourceUrl, Short thickness, Float framerate, Integer sensitivity,
			Integer runTimeSpeed, Short udrExist, String udrSetting, Short isRegSet, Short isContain, Short clockwisePoint1X, Short clockwisePoint1Y,
			Short clockwisePoint2X, Short clockwisePoint2Y, Short clockwisePoint3X, Short clockwisePoint3Y, Short clockwisePoint4X, Short clockwisePoint4Y,
			Short objEnable, Short objType, Short objSubtype, Short colorTolerance, Short enableAvgcolor, Integer retrieveAvgcolor, Short enableUppercolor,
			Integer retrieveUppercolor, Short enableLowercolor, Integer retrieveLowercolor, Short enableCarnum, String retrieveCarnum, Short carnumStatus,
			Short objHeight, Short objWidth, Short objDepth, Integer timePeirodIndicator, Integer timePeirodStart, Integer timePeirodEnd, Integer startFrame,
			Integer endFrame, String localFilename, Integer taskId, Short downloadStatus, String destPath, String udrVerticesNum, String udrVertices,
			Integer objRequestType, Boolean objSearchByAvgColor, Float objRequestColorB, Float objRequestColorG, Float objRequestColorR,
			Boolean objSearchByUpperColor, Float objRequestUpperB, Float objRequestUpperG, Float objRequestUpperR, Boolean objSearchByLowerColor,
			Float objRequestLowerB, Float objRequestLowerG, Float objRequestLowerR, Float rbgToleranceInPct, Boolean objSearchByHeight,
			Float objRequestObjHeight, Boolean objSearchByMov, String objRequestMovVertics, Integer objRequestMovVerticsNum, Short summaryWidth,
			Short summaryHeight, Short isSetTripArea, String tripArea, Short snapType, String taskName, Short enableSearchByImage, String requestImageUrl,
			String requestImageData, String requestMaskUrl, String requestMaskData, Float dropFrmRate, Short searchScope, Timestamp timestamp, String testflag) {
		this.userUploadVideoId = userUploadVideoId;
		this.userid = userid;
		this.configStatus = configStatus;
		this.flowNumber = flowNumber;
		this.taskType = taskType;
		this.taskPriority = taskPriority;
		this.linkFlowNumber = linkFlowNumber;
		this.filename = filename;
		this.fileSize = fileSize;
		this.sourceUrl = sourceUrl;
		this.thickness = thickness;
		this.framerate = framerate;
		this.sensitivity = sensitivity;
		this.runTimeSpeed = runTimeSpeed;
		this.udrExist = udrExist;
		this.udrSetting = udrSetting;
		this.isRegSet = isRegSet;
		this.isContain = isContain;
		this.clockwisePoint1X = clockwisePoint1X;
		this.clockwisePoint1Y = clockwisePoint1Y;
		this.clockwisePoint2X = clockwisePoint2X;
		this.clockwisePoint2Y = clockwisePoint2Y;
		this.clockwisePoint3X = clockwisePoint3X;
		this.clockwisePoint3Y = clockwisePoint3Y;
		this.clockwisePoint4X = clockwisePoint4X;
		this.clockwisePoint4Y = clockwisePoint4Y;
		this.objEnable = objEnable;
		this.objType = objType;
		this.objSubtype = objSubtype;
		this.colorTolerance = colorTolerance;
		this.enableAvgcolor = enableAvgcolor;
		this.retrieveAvgcolor = retrieveAvgcolor;
		this.enableUppercolor = enableUppercolor;
		this.retrieveUppercolor = retrieveUppercolor;
		this.enableLowercolor = enableLowercolor;
		this.retrieveLowercolor = retrieveLowercolor;
		this.enableCarnum = enableCarnum;
		this.retrieveCarnum = retrieveCarnum;
		this.carnumStatus = carnumStatus;
		this.objHeight = objHeight;
		this.objWidth = objWidth;
		this.objDepth = objDepth;
		this.timePeirodIndicator = timePeirodIndicator;
		this.timePeirodStart = timePeirodStart;
		this.timePeirodEnd = timePeirodEnd;
		this.startFrame = startFrame;
		this.endFrame = endFrame;
		this.localFilename = localFilename;
		this.taskId = taskId;
		this.downloadStatus = downloadStatus;
		this.destPath = destPath;
		this.udrVerticesNum = udrVerticesNum;
		this.udrVertices = udrVertices;
		this.objRequestType = objRequestType;
		this.objSearchByAvgColor = objSearchByAvgColor;
		this.objRequestColorB = objRequestColorB;
		this.objRequestColorG = objRequestColorG;
		this.objRequestColorR = objRequestColorR;
		this.objSearchByUpperColor = objSearchByUpperColor;
		this.objRequestUpperB = objRequestUpperB;
		this.objRequestUpperG = objRequestUpperG;
		this.objRequestUpperR = objRequestUpperR;
		this.objSearchByLowerColor = objSearchByLowerColor;
		this.objRequestLowerB = objRequestLowerB;
		this.objRequestLowerG = objRequestLowerG;
		this.objRequestLowerR = objRequestLowerR;
		this.rbgToleranceInPct = rbgToleranceInPct;
		this.objSearchByHeight = objSearchByHeight;
		this.objRequestObjHeight = objRequestObjHeight;
		this.objSearchByMov = objSearchByMov;
		this.objRequestMovVertics = objRequestMovVertics;
		this.objRequestMovVerticsNum = objRequestMovVerticsNum;
		this.summaryWidth = summaryWidth;
		this.summaryHeight = summaryHeight;
		this.isSetTripArea = isSetTripArea;
		this.tripArea = tripArea;
		this.snapType = snapType;
		this.taskName = taskName;
		this.enableSearchByImage = enableSearchByImage;
		this.requestImageUrl = requestImageUrl;
		this.requestImageData = requestImageData;
		this.requestMaskUrl = requestMaskUrl;
		this.requestMaskData = requestMaskData;
		this.dropFrmRate = dropFrmRate;
		this.searchScope = searchScope;
		this.timestamp = timestamp;
		this.testflag = testflag;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "extTaskID", unique = true, nullable = false)
	public Long getExtTaskId() {
		return this.extTaskId;
	}

	public void setExtTaskId(Long extTaskId) {
		this.extTaskId = extTaskId;
	}

	@Column(name = "UserUploadVideoId")
	public Integer getUserUploadVideoId() {
		return this.userUploadVideoId;
	}

	public void setUserUploadVideoId(Integer userUploadVideoId) {
		this.userUploadVideoId = userUploadVideoId;
	}

	@Column(name = "userid", length = 250)
	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Column(name = "configStatus")
	public Short getConfigStatus() {
		return this.configStatus;
	}

	public void setConfigStatus(Short configStatus) {
		this.configStatus = configStatus;
	}

	@Column(name = "flowNumber", length = 51)
	public String getFlowNumber() {
		return this.flowNumber;
	}

	public void setFlowNumber(String flowNumber) {
		this.flowNumber = flowNumber;
	}

	@Column(name = "taskType", nullable = false)
	public Short getTaskType() {
		return this.taskType;
	}

	public void setTaskType(Short taskType) {
		this.taskType = taskType;
	}

	@Column(name = "task_priority")
	public Integer getTaskPriority() {
		return this.taskPriority;
	}

	public void setTaskPriority(Integer taskPriority) {
		this.taskPriority = taskPriority;
	}

	@Column(name = "linkFlowNumber", length = 51)
	public String getLinkFlowNumber() {
		return this.linkFlowNumber;
	}

	public void setLinkFlowNumber(String linkFlowNumber) {
		this.linkFlowNumber = linkFlowNumber;
	}

	@Column(name = "filename", length = 256)
	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	@Column(name = "fileSize")
	public Integer getFileSize() {
		return this.fileSize;
	}

	public void setFileSize(Integer fileSize) {
		this.fileSize = fileSize;
	}

	@Column(name = "sourceUrl", nullable = false, length = 8200)
	public String getSourceUrl() {
		return this.sourceUrl;
	}

	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}

	@Column(name = "thickness")
	public Short getThickness() {
		return this.thickness;
	}

	public void setThickness(Short thickness) {
		this.thickness = thickness;
	}

	@Column(name = "framerate", nullable = false, precision = 12, scale = 0)
	public Float getFramerate() {
		return this.framerate;
	}

	public void setFramerate(Float framerate) {
		this.framerate = framerate;
	}

	@Column(name = "sensitivity")
	public Integer getSensitivity() {
		return this.sensitivity;
	}

	public void setSensitivity(Integer sensitivity) {
		this.sensitivity = sensitivity;
	}

	@Column(name = "run_time_speed")
	public Integer getRunTimeSpeed() {
		return this.runTimeSpeed;
	}

	public void setRunTimeSpeed(Integer runTimeSpeed) {
		this.runTimeSpeed = runTimeSpeed;
	}

	@Column(name = "UDR_exist")
	public Short getUdrExist() {
		return this.udrExist;
	}

	public void setUdrExist(Short udrExist) {
		this.udrExist = udrExist;
	}

	@Column(name = "UDR_setting")
	public String getUdrSetting() {
		return this.udrSetting;
	}

	public void setUdrSetting(String udrSetting) {
		this.udrSetting = udrSetting;
	}

	@Column(name = "isRegSet")
	public Short getIsRegSet() {
		return this.isRegSet;
	}

	public void setIsRegSet(Short isRegSet) {
		this.isRegSet = isRegSet;
	}

	@Column(name = "isContain", nullable = false)
	public Short getIsContain() {
		return this.isContain;
	}

	public void setIsContain(Short isContain) {
		this.isContain = isContain;
	}

	@Column(name = "clockwise_point1_x")
	public Short getClockwisePoint1X() {
		return this.clockwisePoint1X;
	}

	public void setClockwisePoint1X(Short clockwisePoint1X) {
		this.clockwisePoint1X = clockwisePoint1X;
	}

	@Column(name = "clockwise_point1_y")
	public Short getClockwisePoint1Y() {
		return this.clockwisePoint1Y;
	}

	public void setClockwisePoint1Y(Short clockwisePoint1Y) {
		this.clockwisePoint1Y = clockwisePoint1Y;
	}

	@Column(name = "clockwise_point2_x")
	public Short getClockwisePoint2X() {
		return this.clockwisePoint2X;
	}

	public void setClockwisePoint2X(Short clockwisePoint2X) {
		this.clockwisePoint2X = clockwisePoint2X;
	}

	@Column(name = "clockwise_point2_y")
	public Short getClockwisePoint2Y() {
		return this.clockwisePoint2Y;
	}

	public void setClockwisePoint2Y(Short clockwisePoint2Y) {
		this.clockwisePoint2Y = clockwisePoint2Y;
	}

	@Column(name = "clockwise_point3_x")
	public Short getClockwisePoint3X() {
		return this.clockwisePoint3X;
	}

	public void setClockwisePoint3X(Short clockwisePoint3X) {
		this.clockwisePoint3X = clockwisePoint3X;
	}

	@Column(name = "clockwise_point3_y")
	public Short getClockwisePoint3Y() {
		return this.clockwisePoint3Y;
	}

	public void setClockwisePoint3Y(Short clockwisePoint3Y) {
		this.clockwisePoint3Y = clockwisePoint3Y;
	}

	@Column(name = "clockwise_point4_x")
	public Short getClockwisePoint4X() {
		return this.clockwisePoint4X;
	}

	public void setClockwisePoint4X(Short clockwisePoint4X) {
		this.clockwisePoint4X = clockwisePoint4X;
	}

	@Column(name = "clockwise_point4_y")
	public Short getClockwisePoint4Y() {
		return this.clockwisePoint4Y;
	}

	public void setClockwisePoint4Y(Short clockwisePoint4Y) {
		this.clockwisePoint4Y = clockwisePoint4Y;
	}

	@Column(name = "obj_enable", nullable = false)
	public Short getObjEnable() {
		return this.objEnable;
	}

	public void setObjEnable(Short objEnable) {
		this.objEnable = objEnable;
	}

	@Column(name = "obj_type", nullable = false)
	public Short getObjType() {
		return this.objType;
	}

	public void setObjType(Short objType) {
		this.objType = objType;
	}

	@Column(name = "obj_subtype", nullable = false)
	public Short getObjSubtype() {
		return this.objSubtype;
	}

	public void setObjSubtype(Short objSubtype) {
		this.objSubtype = objSubtype;
	}

	@Column(name = "color_tolerance", nullable = false)
	public Short getColorTolerance() {
		return this.colorTolerance;
	}

	public void setColorTolerance(Short colorTolerance) {
		this.colorTolerance = colorTolerance;
	}

	@Column(name = "enable_avgcolor", nullable = false)
	public Short getEnableAvgcolor() {
		return this.enableAvgcolor;
	}

	public void setEnableAvgcolor(Short enableAvgcolor) {
		this.enableAvgcolor = enableAvgcolor;
	}

	@Column(name = "retrieve_avgcolor", nullable = false)
	public Integer getRetrieveAvgcolor() {
		return this.retrieveAvgcolor;
	}

	public void setRetrieveAvgcolor(Integer retrieveAvgcolor) {
		this.retrieveAvgcolor = retrieveAvgcolor;
	}

	@Column(name = "enable_uppercolor", nullable = false)
	public Short getEnableUppercolor() {
		return this.enableUppercolor;
	}

	public void setEnableUppercolor(Short enableUppercolor) {
		this.enableUppercolor = enableUppercolor;
	}

	@Column(name = "retrieve_uppercolor", nullable = false)
	public Integer getRetrieveUppercolor() {
		return this.retrieveUppercolor;
	}

	public void setRetrieveUppercolor(Integer retrieveUppercolor) {
		this.retrieveUppercolor = retrieveUppercolor;
	}

	@Column(name = "enable_lowercolor", nullable = false)
	public Short getEnableLowercolor() {
		return this.enableLowercolor;
	}

	public void setEnableLowercolor(Short enableLowercolor) {
		this.enableLowercolor = enableLowercolor;
	}

	@Column(name = "retrieve_lowercolor", nullable = false)
	public Integer getRetrieveLowercolor() {
		return this.retrieveLowercolor;
	}

	public void setRetrieveLowercolor(Integer retrieveLowercolor) {
		this.retrieveLowercolor = retrieveLowercolor;
	}

	@Column(name = "enable_carnum", nullable = false)
	public Short getEnableCarnum() {
		return this.enableCarnum;
	}

	public void setEnableCarnum(Short enableCarnum) {
		this.enableCarnum = enableCarnum;
	}

	@Column(name = "retrieve_carnum", length = 32)
	public String getRetrieveCarnum() {
		return this.retrieveCarnum;
	}

	public void setRetrieveCarnum(String retrieveCarnum) {
		this.retrieveCarnum = retrieveCarnum;
	}

	@Column(name = "carnum_status", nullable = false)
	public Short getCarnumStatus() {
		return this.carnumStatus;
	}

	public void setCarnumStatus(Short carnumStatus) {
		this.carnumStatus = carnumStatus;
	}

	@Column(name = "objHeight", nullable = false)
	public Short getObjHeight() {
		return this.objHeight;
	}

	public void setObjHeight(Short objHeight) {
		this.objHeight = objHeight;
	}

	@Column(name = "objWidth", nullable = false)
	public Short getObjWidth() {
		return this.objWidth;
	}

	public void setObjWidth(Short objWidth) {
		this.objWidth = objWidth;
	}

	@Column(name = "objDepth", nullable = false)
	public Short getObjDepth() {
		return this.objDepth;
	}

	public void setObjDepth(Short objDepth) {
		this.objDepth = objDepth;
	}

	@Column(name = "timePeirod_Indicator", nullable = false)
	public Integer getTimePeirodIndicator() {
		return this.timePeirodIndicator;
	}

	public void setTimePeirodIndicator(Integer timePeirodIndicator) {
		this.timePeirodIndicator = timePeirodIndicator;
	}

	@Column(name = "timePeirod_start", nullable = false)
	public Integer getTimePeirodStart() {
		return this.timePeirodStart;
	}

	public void setTimePeirodStart(Integer timePeirodStart) {
		this.timePeirodStart = timePeirodStart;
	}

	@Column(name = "timePeirod_end", nullable = false)
	public Integer getTimePeirodEnd() {
		return this.timePeirodEnd;
	}

	public void setTimePeirodEnd(Integer timePeirodEnd) {
		this.timePeirodEnd = timePeirodEnd;
	}

	@Column(name = "startFrame", nullable = false)
	public Integer getStartFrame() {
		return this.startFrame;
	}

	public void setStartFrame(Integer startFrame) {
		this.startFrame = startFrame;
	}

	@Column(name = "endFrame", nullable = false)
	public Integer getEndFrame() {
		return this.endFrame;
	}

	public void setEndFrame(Integer endFrame) {
		this.endFrame = endFrame;
	}

	@Column(name = "localFilename", length = 250)
	public String getLocalFilename() {
		return this.localFilename;
	}

	public void setLocalFilename(String localFilename) {
		this.localFilename = localFilename;
	}

	@Column(name = "taskID")
	public Integer getTaskId() {
		return this.taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	@Column(name = "downloadStatus")
	public Short getDownloadStatus() {
		return this.downloadStatus;
	}

	public void setDownloadStatus(Short downloadStatus) {
		this.downloadStatus = downloadStatus;
	}

	@Column(name = "destPath", length = 250)
	public String getDestPath() {
		return this.destPath;
	}

	public void setDestPath(String destPath) {
		this.destPath = destPath;
	}

	@Column(name = "UDR_vertices_num")
	public String getUdrVerticesNum() {
		return this.udrVerticesNum;
	}

	public void setUdrVerticesNum(String udrVerticesNum) {
		this.udrVerticesNum = udrVerticesNum;
	}

	@Column(name = "UDR_vertices")
	public String getUdrVertices() {
		return this.udrVertices;
	}

	public void setUdrVertices(String udrVertices) {
		this.udrVertices = udrVertices;
	}

	@Column(name = "obj_request_type")
	public Integer getObjRequestType() {
		return this.objRequestType;
	}

	public void setObjRequestType(Integer objRequestType) {
		this.objRequestType = objRequestType;
	}

	@Column(name = "obj_search_by_avg_color")
	public Boolean getObjSearchByAvgColor() {
		return this.objSearchByAvgColor;
	}

	public void setObjSearchByAvgColor(Boolean objSearchByAvgColor) {
		this.objSearchByAvgColor = objSearchByAvgColor;
	}

	@Column(name = "obj_request_color_B", precision = 12, scale = 0)
	public Float getObjRequestColorB() {
		return this.objRequestColorB;
	}

	public void setObjRequestColorB(Float objRequestColorB) {
		this.objRequestColorB = objRequestColorB;
	}

	@Column(name = "obj_request_color_G", precision = 12, scale = 0)
	public Float getObjRequestColorG() {
		return this.objRequestColorG;
	}

	public void setObjRequestColorG(Float objRequestColorG) {
		this.objRequestColorG = objRequestColorG;
	}

	@Column(name = "obj_request_color_R", precision = 12, scale = 0)
	public Float getObjRequestColorR() {
		return this.objRequestColorR;
	}

	public void setObjRequestColorR(Float objRequestColorR) {
		this.objRequestColorR = objRequestColorR;
	}

	@Column(name = "obj_search_by_upper_color")
	public Boolean getObjSearchByUpperColor() {
		return this.objSearchByUpperColor;
	}

	public void setObjSearchByUpperColor(Boolean objSearchByUpperColor) {
		this.objSearchByUpperColor = objSearchByUpperColor;
	}

	@Column(name = "obj_request_upper_B", precision = 12, scale = 0)
	public Float getObjRequestUpperB() {
		return this.objRequestUpperB;
	}

	public void setObjRequestUpperB(Float objRequestUpperB) {
		this.objRequestUpperB = objRequestUpperB;
	}

	@Column(name = "obj_request_upper_G", precision = 12, scale = 0)
	public Float getObjRequestUpperG() {
		return this.objRequestUpperG;
	}

	public void setObjRequestUpperG(Float objRequestUpperG) {
		this.objRequestUpperG = objRequestUpperG;
	}

	@Column(name = "obj_request_upper_R", precision = 12, scale = 0)
	public Float getObjRequestUpperR() {
		return this.objRequestUpperR;
	}

	public void setObjRequestUpperR(Float objRequestUpperR) {
		this.objRequestUpperR = objRequestUpperR;
	}

	@Column(name = "obj_search_by_lower_color")
	public Boolean getObjSearchByLowerColor() {
		return this.objSearchByLowerColor;
	}

	public void setObjSearchByLowerColor(Boolean objSearchByLowerColor) {
		this.objSearchByLowerColor = objSearchByLowerColor;
	}

	@Column(name = "obj_request_lower_B", precision = 12, scale = 0)
	public Float getObjRequestLowerB() {
		return this.objRequestLowerB;
	}

	public void setObjRequestLowerB(Float objRequestLowerB) {
		this.objRequestLowerB = objRequestLowerB;
	}

	@Column(name = "obj_request_lower_G", precision = 12, scale = 0)
	public Float getObjRequestLowerG() {
		return this.objRequestLowerG;
	}

	public void setObjRequestLowerG(Float objRequestLowerG) {
		this.objRequestLowerG = objRequestLowerG;
	}

	@Column(name = "obj_request_lower_R", precision = 12, scale = 0)
	public Float getObjRequestLowerR() {
		return this.objRequestLowerR;
	}

	public void setObjRequestLowerR(Float objRequestLowerR) {
		this.objRequestLowerR = objRequestLowerR;
	}

	@Column(name = "RBG_tolerance_in_pct", precision = 12, scale = 0)
	public Float getRbgToleranceInPct() {
		return this.rbgToleranceInPct;
	}

	public void setRbgToleranceInPct(Float rbgToleranceInPct) {
		this.rbgToleranceInPct = rbgToleranceInPct;
	}

	@Column(name = "obj_search_by_height")
	public Boolean getObjSearchByHeight() {
		return this.objSearchByHeight;
	}

	public void setObjSearchByHeight(Boolean objSearchByHeight) {
		this.objSearchByHeight = objSearchByHeight;
	}

	@Column(name = "obj_request_obj_height", precision = 12, scale = 0)
	public Float getObjRequestObjHeight() {
		return this.objRequestObjHeight;
	}

	public void setObjRequestObjHeight(Float objRequestObjHeight) {
		this.objRequestObjHeight = objRequestObjHeight;
	}

	@Column(name = "obj_search_by_mov")
	public Boolean getObjSearchByMov() {
		return this.objSearchByMov;
	}

	public void setObjSearchByMov(Boolean objSearchByMov) {
		this.objSearchByMov = objSearchByMov;
	}

	@Column(name = "obj_request_mov_vertics")
	public String getObjRequestMovVertics() {
		return this.objRequestMovVertics;
	}

	public void setObjRequestMovVertics(String objRequestMovVertics) {
		this.objRequestMovVertics = objRequestMovVertics;
	}

	@Column(name = "obj_request_mov_vertics_num")
	public Integer getObjRequestMovVerticsNum() {
		return this.objRequestMovVerticsNum;
	}

	public void setObjRequestMovVerticsNum(Integer objRequestMovVerticsNum) {
		this.objRequestMovVerticsNum = objRequestMovVerticsNum;
	}

	@Column(name = "summary_width")
	public Short getSummaryWidth() {
		return this.summaryWidth;
	}

	public void setSummaryWidth(Short summaryWidth) {
		this.summaryWidth = summaryWidth;
	}

	@Column(name = "summary_height")
	public Short getSummaryHeight() {
		return this.summaryHeight;
	}

	public void setSummaryHeight(Short summaryHeight) {
		this.summaryHeight = summaryHeight;
	}

	@Column(name = "isSetTripArea")
	public Short getIsSetTripArea() {
		return this.isSetTripArea;
	}

	public void setIsSetTripArea(Short isSetTripArea) {
		this.isSetTripArea = isSetTripArea;
	}

	@Column(name = "trip_area")
	public String getTripArea() {
		return this.tripArea;
	}

	public void setTripArea(String tripArea) {
		this.tripArea = tripArea;
	}

	@Column(name = "snap_type", nullable = false)
	public Short getSnapType() {
		return this.snapType;
	}

	public void setSnapType(Short snapType) {
		this.snapType = snapType;
	}

	@Column(name = "taskName", length = 56)
	public String getTaskName() {
		return this.taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	@Column(name = "enable_search_by_image")
	public Short getEnableSearchByImage() {
		return this.enableSearchByImage;
	}

	public void setEnableSearchByImage(Short enableSearchByImage) {
		this.enableSearchByImage = enableSearchByImage;
	}

	@Column(name = "request_image_url")
	public String getRequestImageUrl() {
		return this.requestImageUrl;
	}

	public void setRequestImageUrl(String requestImageUrl) {
		this.requestImageUrl = requestImageUrl;
	}

	@Column(name = "request_image_data")
	public String getRequestImageData() {
		return this.requestImageData;
	}

	public void setRequestImageData(String requestImageData) {
		this.requestImageData = requestImageData;
	}

	@Column(name = "request_mask_url")
	public String getRequestMaskUrl() {
		return this.requestMaskUrl;
	}

	public void setRequestMaskUrl(String requestMaskUrl) {
		this.requestMaskUrl = requestMaskUrl;
	}

	@Column(name = "request_mask_data")
	public String getRequestMaskData() {
		return this.requestMaskData;
	}

	public void setRequestMaskData(String requestMaskData) {
		this.requestMaskData = requestMaskData;
	}

	@Column(name = "drop_frm_rate", precision = 12, scale = 0)
	public Float getDropFrmRate() {
		return this.dropFrmRate;
	}

	public void setDropFrmRate(Float dropFrmRate) {
		this.dropFrmRate = dropFrmRate;
	}

	@Column(name = "search_scope")
	public Short getSearchScope() {
		return this.searchScope;
	}

	public void setSearchScope(Short searchScope) {
		this.searchScope = searchScope;
	}

	@Column(name = "timestamp", nullable = false, length = 19)
	public Timestamp getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	@Column(name = "testflag", length = 10000)
	public String getTestflag() {
		return this.testflag;
	}

	public void setTestflag(String testflag) {
		this.testflag = testflag;
	}

}