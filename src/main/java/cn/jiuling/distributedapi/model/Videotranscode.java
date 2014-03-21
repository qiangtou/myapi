package cn.jiuling.distributedapi.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * MstVideotranscode entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "mst_videotranscode")
public class Videotranscode implements java.io.Serializable {

	// Fields

	private Long videoId;
	private Long cameraId;
	private Timestamp timestamp;
	private Timestamp recordTime;
	private Long userid;
	private String srcUrl;
	private String destUrl;
	private Short transServerId;
	private Long localVideoId;
	private Short status;
	private Short tryCount;
	private Short isAutoSubmit;
	private Short isDeleted;
	private String resolution;
	private Integer duration;
	private Integer space;
	private Integer frameRate;

	// Constructors

	/** default constructor */
	public Videotranscode() {
	}

	/** full constructor */
	public Videotranscode(Long cameraId, Timestamp timestamp, Timestamp recordTime, Long userid, String srcUrl, String destUrl, Short transServerId,
			Long localVideoId, Short status, Short tryCount, Short isAutoSubmit, Short isDeleted, String resolution, Integer duration, Integer space,
			Integer frameRate) {
		this.cameraId = cameraId;
		this.timestamp = timestamp;
		this.recordTime = recordTime;
		this.userid = userid;
		this.srcUrl = srcUrl;
		this.destUrl = destUrl;
		this.transServerId = transServerId;
		this.localVideoId = localVideoId;
		this.status = status;
		this.tryCount = tryCount;
		this.isAutoSubmit = isAutoSubmit;
		this.isDeleted = isDeleted;
		this.resolution = resolution;
		this.duration = duration;
		this.space = space;
		this.frameRate = frameRate;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "VideoID", unique = true, nullable = false)
	public Long getVideoId() {
		return this.videoId;
	}

	public void setVideoId(Long videoId) {
		this.videoId = videoId;
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

	@Column(name = "TransServerID", nullable = false)
	public Short getTransServerId() {
		return this.transServerId;
	}

	public void setTransServerId(Short transServerId) {
		this.transServerId = transServerId;
	}

	@Column(name = "LocalVideoID", nullable = false)
	public Long getLocalVideoId() {
		return this.localVideoId;
	}

	public void setLocalVideoId(Long localVideoId) {
		this.localVideoId = localVideoId;
	}

	@Column(name = "status", nullable = false)
	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	@Column(name = "TryCount", nullable = false)
	public Short getTryCount() {
		return this.tryCount;
	}

	public void setTryCount(Short tryCount) {
		this.tryCount = tryCount;
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

}