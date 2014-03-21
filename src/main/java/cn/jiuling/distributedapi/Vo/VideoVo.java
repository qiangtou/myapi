package cn.jiuling.distributedapi.Vo;

import java.sql.Timestamp;

public class VideoVo {
	@Node("uploadvideoid")
	private Long userUploadVideoId;
	@Node("create_time")
	private Timestamp timestamp;
	@Node("record_time")
	private Timestamp recordTime;
	@Node("transcodestatus")
	private Short status;
	@Node("transcodeprocess")
	private Short progress;
	@Node("SrcUrl")
	private String srcUrl;
	@Node("DestUrl")
	private String destUrl;
	private String downloadURL;
	@Node("duration")
	private Integer duration;
	private Integer space;
	private String resolution;
	@Node("frame_rat")
	private Integer frameRate;

	public Long getUserUploadVideoId() {
		return userUploadVideoId;
	}

	public void setUserUploadVideoId(Long userUploadVideoId) {
		this.userUploadVideoId = userUploadVideoId;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public Timestamp getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(Timestamp recordTime) {
		this.recordTime = recordTime;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public Short getProgress() {
		return progress;
	}

	public void setProgress(Short progress) {
		this.progress = progress;
	}

	public String getSrcUrl() {
		return srcUrl;
	}

	public void setSrcUrl(String srcUrl) {
		this.srcUrl = srcUrl;
	}

	public String getDestUrl() {
		return destUrl;
	}

	public void setDestUrl(String destUrl) {
		this.destUrl = destUrl;
	}

	public String getDownloadURL() {
		return downloadURL;
	}

	public void setDownloadURL(String downloadURL) {
		this.downloadURL = downloadURL;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Integer getSpace() {
		return space;
	}

	public void setSpace(Integer space) {
		this.space = space;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public Integer getFrameRate() {
		return frameRate;
	}

	public void setFrameRate(Integer frameRate) {
		this.frameRate = frameRate;
	}
}
