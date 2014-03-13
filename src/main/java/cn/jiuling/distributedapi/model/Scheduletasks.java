package cn.jiuling.distributedapi.model;

import java.sql.Time;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Scheduletasks entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tbl_scheduletasks")
public class Scheduletasks implements java.io.Serializable {

	// Fields

	private Long id;
	private Long cameraId;
	private Time startTime;
	private Time endTime;
	private String srcUrl;
	private String platformName;
	private Short isAutoSubmit;
	private Timestamp lastSubmitTime;

	// Constructors

	/** default constructor */
	public Scheduletasks() {
	}

	/** minimal constructor */
	public Scheduletasks(Long cameraId, String srcUrl, String platformName, Short isAutoSubmit, Timestamp lastSubmitTime) {
		this.cameraId = cameraId;
		this.srcUrl = srcUrl;
		this.platformName = platformName;
		this.isAutoSubmit = isAutoSubmit;
		this.lastSubmitTime = lastSubmitTime;
	}

	/** full constructor */
	public Scheduletasks(Long cameraId, Time startTime, Time endTime, String srcUrl, String platformName, Short isAutoSubmit, Timestamp lastSubmitTime) {
		this.cameraId = cameraId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.srcUrl = srcUrl;
		this.platformName = platformName;
		this.isAutoSubmit = isAutoSubmit;
		this.lastSubmitTime = lastSubmitTime;
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

	@Column(name = "startTime", length = 8)
	public Time getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	@Column(name = "endTime", length = 8)
	public Time getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	@Column(name = "srcURL", nullable = false, length = 1024)
	public String getSrcUrl() {
		return this.srcUrl;
	}

	public void setSrcUrl(String srcUrl) {
		this.srcUrl = srcUrl;
	}

	@Column(name = "PlatformName", nullable = false, length = 48)
	public String getPlatformName() {
		return this.platformName;
	}

	public void setPlatformName(String platformName) {
		this.platformName = platformName;
	}

	@Column(name = "isAutoSubmit", nullable = false)
	public Short getIsAutoSubmit() {
		return this.isAutoSubmit;
	}

	public void setIsAutoSubmit(Short isAutoSubmit) {
		this.isAutoSubmit = isAutoSubmit;
	}

	@Column(name = "lastSubmitTime", nullable = false, length = 19)
	public Timestamp getLastSubmitTime() {
		return this.lastSubmitTime;
	}

	public void setLastSubmitTime(Timestamp lastSubmitTime) {
		this.lastSubmitTime = lastSubmitTime;
	}

}