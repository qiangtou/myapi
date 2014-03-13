package cn.jiuling.distributedapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Generatevideo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "generatevideo")
public class Generatevideo implements java.io.Serializable {

	// Fields

	private Long generateId;
	private Long analysisId;
	private Short generateStatusFlag;
	private Short genCmd;
	private Short disorderProgress;
	private Short taskPriority;
	private Short frmPeriodType;
	private Long startFrm;
	private Long startFrmIdxRef;
	private Long startFrmPts;
	private Long endFrm;
	private Long endFrmIdxRef;
	private Long endFrmPts;
	private Short objRequestType;
	private Boolean objSearchByAvgColor;
	private Short objRequestColorB;
	private Short objRequestColorG;
	private Short objRequestColorR;
	private Boolean objSearchByUpperColor;
	private Short objRequestUpperB;
	private Short objRequestUpperG;
	private Short objRequestUpperR;
	private Boolean objSearchByLowerColor;
	private Short objRequestLowerB;
	private Short objRequestLowerG;
	private Short objRequestLowerR;
	private Float rbgToleranceInPct;
	private Boolean objSearchByHeight;
	private Float objRequestObjHeight;
	private Boolean objSearchByMov;
	private String objRequestMovVertics;
	private Integer objRequestMovVerticsNum;
	private Short tripAreaIsValid;
	private String tripAreaSetting;
	private Boolean objSearchByLicense;
	private String objRequestLicense;
	private Short compressDensity;
	private Short sumVSm;
	private Boolean isRetrieveObj;
	private Boolean isGenSumVideo;
	private String sumFilename;
	private String sumDestAbsPath;
	private String sumMetadataFilename;
	private Integer sumTubeNum;
	private Short sumFrmWidth;
	private Short sumFrmHeight;
	private Integer sumFrmNum;
	private Float sumFrmRate;
	private Integer lastErrCode;
	private String lastErrMsg;
	private Integer retryCount;
	private Short snapType;
	private Short objSearchByRegion;
	private String objRequestRegion;

	// Constructors

	/** default constructor */
	public Generatevideo() {
	}

	/** minimal constructor */
	public Generatevideo(Long analysisId) {
		this.analysisId = analysisId;
	}

	/** full constructor */
	public Generatevideo(Long analysisId, Short generateStatusFlag, Short genCmd, Short disorderProgress, Short taskPriority, Short frmPeriodType,
			Long startFrm, Long startFrmIdxRef, Long startFrmPts, Long endFrm, Long endFrmIdxRef, Long endFrmPts, Short objRequestType,
			Boolean objSearchByAvgColor, Short objRequestColorB, Short objRequestColorG, Short objRequestColorR, Boolean objSearchByUpperColor,
			Short objRequestUpperB, Short objRequestUpperG, Short objRequestUpperR, Boolean objSearchByLowerColor, Short objRequestLowerB,
			Short objRequestLowerG, Short objRequestLowerR, Float rbgToleranceInPct, Boolean objSearchByHeight, Float objRequestObjHeight,
			Boolean objSearchByMov, String objRequestMovVertics, Integer objRequestMovVerticsNum, Short tripAreaIsValid, String tripAreaSetting,
			Boolean objSearchByLicense, String objRequestLicense, Short compressDensity, Short sumVSm, Boolean isRetrieveObj, Boolean isGenSumVideo,
			String sumFilename, String sumDestAbsPath, String sumMetadataFilename, Integer sumTubeNum, Short sumFrmWidth, Short sumFrmHeight,
			Integer sumFrmNum, Float sumFrmRate, Integer lastErrCode, String lastErrMsg, Integer retryCount, Short snapType, Short objSearchByRegion,
			String objRequestRegion) {
		this.analysisId = analysisId;
		this.generateStatusFlag = generateStatusFlag;
		this.genCmd = genCmd;
		this.disorderProgress = disorderProgress;
		this.taskPriority = taskPriority;
		this.frmPeriodType = frmPeriodType;
		this.startFrm = startFrm;
		this.startFrmIdxRef = startFrmIdxRef;
		this.startFrmPts = startFrmPts;
		this.endFrm = endFrm;
		this.endFrmIdxRef = endFrmIdxRef;
		this.endFrmPts = endFrmPts;
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
		this.tripAreaIsValid = tripAreaIsValid;
		this.tripAreaSetting = tripAreaSetting;
		this.objSearchByLicense = objSearchByLicense;
		this.objRequestLicense = objRequestLicense;
		this.compressDensity = compressDensity;
		this.sumVSm = sumVSm;
		this.isRetrieveObj = isRetrieveObj;
		this.isGenSumVideo = isGenSumVideo;
		this.sumFilename = sumFilename;
		this.sumDestAbsPath = sumDestAbsPath;
		this.sumMetadataFilename = sumMetadataFilename;
		this.sumTubeNum = sumTubeNum;
		this.sumFrmWidth = sumFrmWidth;
		this.sumFrmHeight = sumFrmHeight;
		this.sumFrmNum = sumFrmNum;
		this.sumFrmRate = sumFrmRate;
		this.lastErrCode = lastErrCode;
		this.lastErrMsg = lastErrMsg;
		this.retryCount = retryCount;
		this.snapType = snapType;
		this.objSearchByRegion = objSearchByRegion;
		this.objRequestRegion = objRequestRegion;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "GenerateID", unique = true, nullable = false)
	public Long getGenerateId() {
		return this.generateId;
	}

	public void setGenerateId(Long generateId) {
		this.generateId = generateId;
	}

	@Column(name = "AnalysisID", nullable = false)
	public Long getAnalysisId() {
		return this.analysisId;
	}

	public void setAnalysisId(Long analysisId) {
		this.analysisId = analysisId;
	}

	@Column(name = "generate_status_flag")
	public Short getGenerateStatusFlag() {
		return this.generateStatusFlag;
	}

	public void setGenerateStatusFlag(Short generateStatusFlag) {
		this.generateStatusFlag = generateStatusFlag;
	}

	@Column(name = "gen_cmd")
	public Short getGenCmd() {
		return this.genCmd;
	}

	public void setGenCmd(Short genCmd) {
		this.genCmd = genCmd;
	}

	@Column(name = "disorder_progress")
	public Short getDisorderProgress() {
		return this.disorderProgress;
	}

	public void setDisorderProgress(Short disorderProgress) {
		this.disorderProgress = disorderProgress;
	}

	@Column(name = "task_priority")
	public Short getTaskPriority() {
		return this.taskPriority;
	}

	public void setTaskPriority(Short taskPriority) {
		this.taskPriority = taskPriority;
	}

	@Column(name = "frm_period_type")
	public Short getFrmPeriodType() {
		return this.frmPeriodType;
	}

	public void setFrmPeriodType(Short frmPeriodType) {
		this.frmPeriodType = frmPeriodType;
	}

	@Column(name = "start_frm")
	public Long getStartFrm() {
		return this.startFrm;
	}

	public void setStartFrm(Long startFrm) {
		this.startFrm = startFrm;
	}

	@Column(name = "start_frm_idx_ref")
	public Long getStartFrmIdxRef() {
		return this.startFrmIdxRef;
	}

	public void setStartFrmIdxRef(Long startFrmIdxRef) {
		this.startFrmIdxRef = startFrmIdxRef;
	}

	@Column(name = "start_frm_pts")
	public Long getStartFrmPts() {
		return this.startFrmPts;
	}

	public void setStartFrmPts(Long startFrmPts) {
		this.startFrmPts = startFrmPts;
	}

	@Column(name = "end_frm")
	public Long getEndFrm() {
		return this.endFrm;
	}

	public void setEndFrm(Long endFrm) {
		this.endFrm = endFrm;
	}

	@Column(name = "end_frm_idx_ref")
	public Long getEndFrmIdxRef() {
		return this.endFrmIdxRef;
	}

	public void setEndFrmIdxRef(Long endFrmIdxRef) {
		this.endFrmIdxRef = endFrmIdxRef;
	}

	@Column(name = "end_frm_pts")
	public Long getEndFrmPts() {
		return this.endFrmPts;
	}

	public void setEndFrmPts(Long endFrmPts) {
		this.endFrmPts = endFrmPts;
	}

	@Column(name = "obj_request_type")
	public Short getObjRequestType() {
		return this.objRequestType;
	}

	public void setObjRequestType(Short objRequestType) {
		this.objRequestType = objRequestType;
	}

	@Column(name = "obj_search_by_avg_color")
	public Boolean getObjSearchByAvgColor() {
		return this.objSearchByAvgColor;
	}

	public void setObjSearchByAvgColor(Boolean objSearchByAvgColor) {
		this.objSearchByAvgColor = objSearchByAvgColor;
	}

	@Column(name = "obj_request_color_B")
	public Short getObjRequestColorB() {
		return this.objRequestColorB;
	}

	public void setObjRequestColorB(Short objRequestColorB) {
		this.objRequestColorB = objRequestColorB;
	}

	@Column(name = "obj_request_color_G")
	public Short getObjRequestColorG() {
		return this.objRequestColorG;
	}

	public void setObjRequestColorG(Short objRequestColorG) {
		this.objRequestColorG = objRequestColorG;
	}

	@Column(name = "obj_request_color_R")
	public Short getObjRequestColorR() {
		return this.objRequestColorR;
	}

	public void setObjRequestColorR(Short objRequestColorR) {
		this.objRequestColorR = objRequestColorR;
	}

	@Column(name = "obj_search_by_upper_color")
	public Boolean getObjSearchByUpperColor() {
		return this.objSearchByUpperColor;
	}

	public void setObjSearchByUpperColor(Boolean objSearchByUpperColor) {
		this.objSearchByUpperColor = objSearchByUpperColor;
	}

	@Column(name = "obj_request_upper_B")
	public Short getObjRequestUpperB() {
		return this.objRequestUpperB;
	}

	public void setObjRequestUpperB(Short objRequestUpperB) {
		this.objRequestUpperB = objRequestUpperB;
	}

	@Column(name = "obj_request_upper_G")
	public Short getObjRequestUpperG() {
		return this.objRequestUpperG;
	}

	public void setObjRequestUpperG(Short objRequestUpperG) {
		this.objRequestUpperG = objRequestUpperG;
	}

	@Column(name = "obj_request_upper_R")
	public Short getObjRequestUpperR() {
		return this.objRequestUpperR;
	}

	public void setObjRequestUpperR(Short objRequestUpperR) {
		this.objRequestUpperR = objRequestUpperR;
	}

	@Column(name = "obj_search_by_lower_color")
	public Boolean getObjSearchByLowerColor() {
		return this.objSearchByLowerColor;
	}

	public void setObjSearchByLowerColor(Boolean objSearchByLowerColor) {
		this.objSearchByLowerColor = objSearchByLowerColor;
	}

	@Column(name = "obj_request_lower_B")
	public Short getObjRequestLowerB() {
		return this.objRequestLowerB;
	}

	public void setObjRequestLowerB(Short objRequestLowerB) {
		this.objRequestLowerB = objRequestLowerB;
	}

	@Column(name = "obj_request_lower_G")
	public Short getObjRequestLowerG() {
		return this.objRequestLowerG;
	}

	public void setObjRequestLowerG(Short objRequestLowerG) {
		this.objRequestLowerG = objRequestLowerG;
	}

	@Column(name = "obj_request_lower_R")
	public Short getObjRequestLowerR() {
		return this.objRequestLowerR;
	}

	public void setObjRequestLowerR(Short objRequestLowerR) {
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

	@Column(name = "tripArea_is_valid")
	public Short getTripAreaIsValid() {
		return this.tripAreaIsValid;
	}

	public void setTripAreaIsValid(Short tripAreaIsValid) {
		this.tripAreaIsValid = tripAreaIsValid;
	}

	@Column(name = "tripArea_setting")
	public String getTripAreaSetting() {
		return this.tripAreaSetting;
	}

	public void setTripAreaSetting(String tripAreaSetting) {
		this.tripAreaSetting = tripAreaSetting;
	}

	@Column(name = "obj_search_by_license")
	public Boolean getObjSearchByLicense() {
		return this.objSearchByLicense;
	}

	public void setObjSearchByLicense(Boolean objSearchByLicense) {
		this.objSearchByLicense = objSearchByLicense;
	}

	@Column(name = "obj_request_license", length = 32)
	public String getObjRequestLicense() {
		return this.objRequestLicense;
	}

	public void setObjRequestLicense(String objRequestLicense) {
		this.objRequestLicense = objRequestLicense;
	}

	@Column(name = "compress_density")
	public Short getCompressDensity() {
		return this.compressDensity;
	}

	public void setCompressDensity(Short compressDensity) {
		this.compressDensity = compressDensity;
	}

	@Column(name = "sumV_sm")
	public Short getSumVSm() {
		return this.sumVSm;
	}

	public void setSumVSm(Short sumVSm) {
		this.sumVSm = sumVSm;
	}

	@Column(name = "is_retrieve_obj")
	public Boolean getIsRetrieveObj() {
		return this.isRetrieveObj;
	}

	public void setIsRetrieveObj(Boolean isRetrieveObj) {
		this.isRetrieveObj = isRetrieveObj;
	}

	@Column(name = "is_gen_sum_video")
	public Boolean getIsGenSumVideo() {
		return this.isGenSumVideo;
	}

	public void setIsGenSumVideo(Boolean isGenSumVideo) {
		this.isGenSumVideo = isGenSumVideo;
	}

	@Column(name = "sum_filename")
	public String getSumFilename() {
		return this.sumFilename;
	}

	public void setSumFilename(String sumFilename) {
		this.sumFilename = sumFilename;
	}

	@Column(name = "sum_dest_abs_path")
	public String getSumDestAbsPath() {
		return this.sumDestAbsPath;
	}

	public void setSumDestAbsPath(String sumDestAbsPath) {
		this.sumDestAbsPath = sumDestAbsPath;
	}

	@Column(name = "sum_metadata_filename")
	public String getSumMetadataFilename() {
		return this.sumMetadataFilename;
	}

	public void setSumMetadataFilename(String sumMetadataFilename) {
		this.sumMetadataFilename = sumMetadataFilename;
	}

	@Column(name = "sum_tube_num")
	public Integer getSumTubeNum() {
		return this.sumTubeNum;
	}

	public void setSumTubeNum(Integer sumTubeNum) {
		this.sumTubeNum = sumTubeNum;
	}

	@Column(name = "sum_frm_width")
	public Short getSumFrmWidth() {
		return this.sumFrmWidth;
	}

	public void setSumFrmWidth(Short sumFrmWidth) {
		this.sumFrmWidth = sumFrmWidth;
	}

	@Column(name = "sum_frm_height")
	public Short getSumFrmHeight() {
		return this.sumFrmHeight;
	}

	public void setSumFrmHeight(Short sumFrmHeight) {
		this.sumFrmHeight = sumFrmHeight;
	}

	@Column(name = "sum_frm_num")
	public Integer getSumFrmNum() {
		return this.sumFrmNum;
	}

	public void setSumFrmNum(Integer sumFrmNum) {
		this.sumFrmNum = sumFrmNum;
	}

	@Column(name = "sum_frm_rate", precision = 12, scale = 0)
	public Float getSumFrmRate() {
		return this.sumFrmRate;
	}

	public void setSumFrmRate(Float sumFrmRate) {
		this.sumFrmRate = sumFrmRate;
	}

	@Column(name = "last_err_code")
	public Integer getLastErrCode() {
		return this.lastErrCode;
	}

	public void setLastErrCode(Integer lastErrCode) {
		this.lastErrCode = lastErrCode;
	}

	@Column(name = "last_err_msg")
	public String getLastErrMsg() {
		return this.lastErrMsg;
	}

	public void setLastErrMsg(String lastErrMsg) {
		this.lastErrMsg = lastErrMsg;
	}

	@Column(name = "retry_count")
	public Integer getRetryCount() {
		return this.retryCount;
	}

	public void setRetryCount(Integer retryCount) {
		this.retryCount = retryCount;
	}

	@Column(name = "snap_type")
	public Short getSnapType() {
		return this.snapType;
	}

	public void setSnapType(Short snapType) {
		this.snapType = snapType;
	}

	@Column(name = "obj_search_by_region")
	public Short getObjSearchByRegion() {
		return this.objSearchByRegion;
	}

	public void setObjSearchByRegion(Short objSearchByRegion) {
		this.objSearchByRegion = objSearchByRegion;
	}

	@Column(name = "obj_request_region", length = 65535)
	public String getObjRequestRegion() {
		return this.objRequestRegion;
	}

	public void setObjRequestRegion(String objRequestRegion) {
		this.objRequestRegion = objRequestRegion;
	}

}