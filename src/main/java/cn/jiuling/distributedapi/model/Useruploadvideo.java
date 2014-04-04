package cn.jiuling.distributedapi.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Useruploadvideo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "useruploadvideo")
public class Useruploadvideo implements java.io.Serializable {

	public static final Short AUTOSUBMIT = 2;
	public static final Short NON_AutoSubmit = 0;
	// Fields

	private Long userUploadVideoId;
	private Long cameraId;
	private Timestamp timestamp;
	private Timestamp recordTime;
	private Long userid;
	private String srcUrl;
	private String destUrl;
	private Short status;
	private Integer lastErrCode;
	private String lastErrMsg;
	private Short progress;
	private Integer retryCount;
	private Integer lastTryVideoVendorType;
	private Short isAutoSubmit;
	private Short isDeleted;
	private String resolution;
	private Integer duration;
	private Integer space;
	private Integer frameRate;
	private Short videoType;
	private String videoConfig;

	// Constructors

	/** default constructor */
	public Useruploadvideo() {
		// 初始化默认值
		this.status = 0;
		this.lastErrCode = 0;
		this.lastErrMsg = "";
		this.progress = 0;
		this.retryCount = 0;
		this.lastTryVideoVendorType = -1;
		this.duration = 0;
		this.frameRate = 25;
		this.isDeleted = 0;
		this.resolution = "--";
		this.space = 0;
	}

	/** minimal constructor */
	public Useruploadvideo(Long cameraId, Timestamp timestamp, Timestamp recordTime, Long userid, String srcUrl, String destUrl, Short status,
			Integer lastErrCode, String lastErrMsg, Short progress, Integer retryCount, Integer lastTryVideoVendorType, Short isAutoSubmit, Short isDeleted,
			String resolution, Integer duration, Integer space, Integer frameRate) {
		this.cameraId = cameraId;
		this.timestamp = timestamp;
		this.recordTime = recordTime;
		this.userid = userid;
		this.srcUrl = srcUrl;
		this.destUrl = destUrl;
		this.status = status;
		this.lastErrCode = lastErrCode;
		this.lastErrMsg = lastErrMsg;
		this.progress = progress;
		this.retryCount = retryCount;
		this.lastTryVideoVendorType = lastTryVideoVendorType;
		this.isAutoSubmit = isAutoSubmit;
		this.isDeleted = isDeleted;
		this.resolution = resolution;
		this.duration = duration;
		this.space = space;
		this.frameRate = frameRate;
	}

	// (long, Timestamp, Timestamp, Long, String, String, Short, int, String,

	// int, int, int, Short, int, String, int, int, int, null, null)
	/** full constructor */
	public Useruploadvideo(Long cameraId, Timestamp timestamp, Timestamp recordTime, Long userid, String srcUrl, String destUrl, Short status,
			Integer lastErrCode, String lastErrMsg,

			Short progress, Integer retryCount, Integer lastTryVideoVendorType, Short isAutoSubmit, Short isDeleted,
			String resolution, Integer duration, Integer space, Integer frameRate, Short videoType, String videoConfig) {
		this.cameraId = cameraId;
		this.timestamp = timestamp;
		this.recordTime = recordTime;
		this.userid = userid;
		this.srcUrl = srcUrl;
		this.destUrl = destUrl;
		this.status = status;
		this.lastErrCode = lastErrCode;
		this.lastErrMsg = lastErrMsg;
		this.progress = progress;
		this.retryCount = retryCount;
		this.lastTryVideoVendorType = lastTryVideoVendorType;
		this.isAutoSubmit = isAutoSubmit;
		this.isDeleted = isDeleted;
		this.resolution = resolution;
		this.duration = duration;
		this.space = space;
		this.frameRate = frameRate;
		this.videoType = videoType;
		this.videoConfig = videoConfig;
	}

	public Useruploadvideo(Long cameraId, String videoFilename, Timestamp recordTime, Timestamp createtime,
			Short isAutoSubmit, Short videoType) {

	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "UserUploadVideoId", unique = true, nullable = false)
	public Long getUserUploadVideoId() {
		return this.userUploadVideoId;
	}

	public void setUserUploadVideoId(Long userUploadVideoId) {
		this.userUploadVideoId = userUploadVideoId;
	}

	@Column(name = "CameraID", nullable = false)
	public Long getCameraId() {
		return this.cameraId;
	}

	public void setCameraId(Long cameraId) {
		this.cameraId = cameraId;
	}

	@Column(name = "timestamp", nullable = false, length = 19)
	public Timestamp getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	@Column(name = "record_time", nullable = false, length = 19)
	public Timestamp getRecordTime() {
		return this.recordTime;
	}

	public void setRecordTime(Timestamp recordTime) {
		this.recordTime = recordTime;
	}

	@Column(name = "userid", nullable = false)
	public Long getUserid() {
		return this.userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	@Column(name = "srcURL", nullable = false, length = 1024)
	public String getSrcUrl() {
		return this.srcUrl;
	}

	public void setSrcUrl(String srcUrl) {
		this.srcUrl = srcUrl;
	}

	@Column(name = "destURL", nullable = false, length = 1024)
	public String getDestUrl() {
		return this.destUrl;
	}

	public void setDestUrl(String destUrl) {
		this.destUrl = destUrl;
	}

	@Column(name = "status", nullable = false)
	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	@Column(name = "last_err_code", nullable = false)
	public Integer getLastErrCode() {
		return this.lastErrCode;
	}

	public void setLastErrCode(Integer lastErrCode) {
		this.lastErrCode = lastErrCode;
	}

	@Column(name = "last_err_msg", nullable = false, length = 256)
	public String getLastErrMsg() {
		return this.lastErrMsg;
	}

	public void setLastErrMsg(String lastErrMsg) {
		this.lastErrMsg = lastErrMsg;
	}

	@Column(name = "progress", nullable = false)
	public Short getProgress() {
		return this.progress;
	}

	public void setProgress(Short progress) {
		this.progress = progress;
	}

	@Column(name = "retry_count", nullable = false)
	public Integer getRetryCount() {
		return this.retryCount;
	}

	public void setRetryCount(Integer retryCount) {
		this.retryCount = retryCount;
	}

	@Column(name = "last_try_video_vendor_type", nullable = false)
	public Integer getLastTryVideoVendorType() {
		return this.lastTryVideoVendorType;
	}

	public void setLastTryVideoVendorType(Integer lastTryVideoVendorType) {
		this.lastTryVideoVendorType = lastTryVideoVendorType;
	}

	@Column(name = "isAutoSubmit", nullable = false)
	public Short getIsAutoSubmit() {
		return this.isAutoSubmit;
	}

	public void setIsAutoSubmit(Short isAutoSubmit) {
		this.isAutoSubmit = isAutoSubmit;
	}

	@Column(name = "is_deleted", nullable = false)
	public Short getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(Short isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Column(name = "resolution", nullable = false, length = 56)
	public String getResolution() {
		return this.resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	@Column(name = "duration", nullable = false)
	public Integer getDuration() {
		return this.duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	@Column(name = "space", nullable = false)
	public Integer getSpace() {
		return this.space;
	}

	public void setSpace(Integer space) {
		this.space = space;
	}

	@Column(name = "frame_rate", nullable = false)
	public Integer getFrameRate() {
		return this.frameRate;
	}

	public void setFrameRate(Integer frameRate) {
		this.frameRate = frameRate;
	}

	@Column(name = "video_type")
	public Short getVideoType() {
		return this.videoType;
	}

	public void setVideoType(Short videoType) {
		this.videoType = videoType;
	}

	@Column(name = "video_config")
	public String getVideoConfig() {
		return this.videoConfig;
	}

	public void setVideoConfig(String videoConfig) {
		this.videoConfig = videoConfig;
	}

}