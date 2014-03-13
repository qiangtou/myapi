package cn.jiuling.distributedapi.Vo;

import java.sql.Timestamp;
import java.util.Date;

public class CaseVideoVo {
	/*
	 * (u.timestamp,u.recordTime,u.userUploadVideoId,u.status,u.progress,u.srcUrl
	 * ," + "u.destUrl)
	 */
	private Timestamp timestamp;
	private Timestamp recordTime;
	private Long userUploadVideoId;
	private Short status;
	private Short progress;
	private String srcUrl;
	private String destUrl;

	public CaseVideoVo(
			Date timestamp,
			Date recordTime,
			Long userUploadVideoId,
			Short status, Short progress,
			String srcUrl, String destUrl) {
		super();
		this.timestamp = new Timestamp(timestamp.getTime());
		this.recordTime = new Timestamp(recordTime.getTime());
		this.userUploadVideoId = userUploadVideoId;
		this.status = status;
		this.progress = progress;
		this.srcUrl = srcUrl;
		this.destUrl = destUrl;
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

	public Long getUserUploadVideoId() {
		return userUploadVideoId;
	}

	public void setUserUploadVideoId(Long userUploadVideoId) {
		this.userUploadVideoId = userUploadVideoId;
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

}
