package cn.jiuling.distributedapi.Vo;

import java.sql.Timestamp;

public class DownloadTasks4ListVo {
	/*	<id></id>//下载任务的id
		<status></status>
		    <progress></progress>
		<platformname></platformname>
		<submitTime ></submitTime>
		<filePath></filePath>
		<srcURL></srcURL>
	*/
	private Long id;
	private Short status;
	private Short progress;
	@Node("platformname")
	private String platformName;
	private Timestamp submitTime;
	@Node("srcURL")
	private String srcUrl;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getPlatformName() {
		return platformName;
	}

	public void setPlatformName(String platformName) {
		this.platformName = platformName;
	}

	public Timestamp getSubmitTime() {
		return submitTime;
	}

	public void setSubmitTime(Timestamp submitTime) {
		this.submitTime = submitTime;
	}

	public String getSrcUrl() {
		return srcUrl;
	}

	public void setSrcUrl(String srcUrl) {
		this.srcUrl = srcUrl;
	}

}
