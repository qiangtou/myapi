package cn.jiuling.distributedapi.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Downloadtasks entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tbl_downloadtasks")
public class Downloadtasks implements java.io.Serializable {

	// Fields

	private Long id;
	private Long cameraId;
	private Long extTaskId;
	private String platformName;
	private String srcUrl;
	private String filePath;
	private Short status;
	private Short progress;
	private Long speed;
	private Short isAutoSubmit;
	private Integer errcode;
	private String errMsg;
	private Timestamp submitTime;

	// Constructors

	/** default constructor */
	public Downloadtasks() {
		// 默认值
		this.errcode = 0;
		this.cameraId = 0L;
		this.extTaskId = 0L;
		this.platformName = "";
		this.status = 0;
		this.progress = 0;
		this.speed = 0L;
		this.isAutoSubmit = 0;
		this.submitTime = new Timestamp(System.currentTimeMillis());
	}

	/** minimal constructor */
	public Downloadtasks(Long cameraId, Long extTaskId, String platformName, String srcUrl, Short status, Short progress, Long speed, Short isAutoSubmit,
			Integer errcode, Timestamp submitTime) {
		this.cameraId = cameraId;
		this.extTaskId = extTaskId;
		this.platformName = platformName;
		this.srcUrl = srcUrl;
		this.status = status;
		this.progress = progress;
		this.speed = speed;
		this.isAutoSubmit = isAutoSubmit;
		this.errcode = errcode;
		this.submitTime = submitTime;
	}

	/** full constructor */
	public Downloadtasks(Long cameraId, Long extTaskId, String platformName, String srcUrl, String filePath, Short status, Short progress, Long speed,
			Short isAutoSubmit, Integer errcode, String errMsg, Timestamp submitTime) {
		this.cameraId = cameraId;
		this.extTaskId = extTaskId;
		this.platformName = platformName;
		this.srcUrl = srcUrl;
		this.filePath = filePath;
		this.status = status;
		this.progress = progress;
		this.speed = speed;
		this.isAutoSubmit = isAutoSubmit;
		this.errcode = errcode;
		this.errMsg = errMsg;
		this.submitTime = submitTime;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "CameraID", nullable = false)
	public Long getCameraId() {
		return this.cameraId;
	}

	public void setCameraId(Long cameraId) {
		this.cameraId = cameraId;
	}

	@Column(name = "extTaskID", nullable = false)
	public Long getExtTaskId() {
		return this.extTaskId;
	}

	public void setExtTaskId(Long extTaskId) {
		this.extTaskId = extTaskId;
	}

	@Column(name = "PlatformName", nullable = false, length = 48)
	public String getPlatformName() {
		return this.platformName;
	}

	public void setPlatformName(String platformName) {
		this.platformName = platformName;
	}

	@Column(name = "srcURL", nullable = false, length = 16777215)
	public String getSrcUrl() {
		return this.srcUrl;
	}

	public void setSrcUrl(String srcUrl) {
		this.srcUrl = srcUrl;
	}

	@Column(name = "filePath", length = 16777215)
	public String getFilePath() {
		return this.filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	@Column(name = "status", nullable = false)
	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	@Column(name = "progress", nullable = false)
	public Short getProgress() {
		return this.progress;
	}

	public void setProgress(Short progress) {
		this.progress = progress;
	}

	@Column(name = "speed", nullable = false)
	public Long getSpeed() {
		return this.speed;
	}

	public void setSpeed(Long speed) {
		this.speed = speed;
	}

	@Column(name = "isAutoSubmit", nullable = false)
	public Short getIsAutoSubmit() {
		return this.isAutoSubmit;
	}

	public void setIsAutoSubmit(Short isAutoSubmit) {
		this.isAutoSubmit = isAutoSubmit;
	}

	@Column(name = "errcode", nullable = false)
	public Integer getErrcode() {
		return this.errcode;
	}

	public void setErrcode(Integer errcode) {
		this.errcode = errcode;
	}

	@Column(name = "errMsg")
	public String getErrMsg() {
		return this.errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	@Column(name = "submit_time", nullable = false, length = 19)
	public Timestamp getSubmitTime() {
		return this.submitTime;
	}

	public void setSubmitTime(Timestamp submitTime) {
		this.submitTime = submitTime;
	}

}