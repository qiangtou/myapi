package cn.jiuling.distributedapi.Vo;

@Node("task")
public class TaskVo {
	/*<task>
	<flowNumber></flowNumber>
	<status></status>
	<type><type>
	<srcURL><srcURL/>
	<destURL><destURL/>
	<UserUploadVideoId></UserUploadVideoId>
	<progress><progress>
	</task>*/

	private String flowNumber;
	private Short status;
	private Short type;
	private String srcURL;
	private String destURL;
	private Integer UserUploadVideoId;
	private Short progress;

	public TaskVo() {
		super();
	}

	public TaskVo(String flowNumber, Short status, Short type, String srcURL, String destURL, Integer userUploadVideoId, Short progress) {
		super();
		this.flowNumber = flowNumber;
		this.status = status;
		this.type = type;
		this.srcURL = srcURL;
		this.destURL = destURL;
		UserUploadVideoId = userUploadVideoId;
		this.progress = progress;
	}

	/*	es.id.analyFlag,es.id.genFlag,es.id.progress,et.flowNumber, 
	 * et.taskType,et.sourceUrl,et.localFilename,et.userUploadVideoId,
	 * et.downloadStatus*/

	public String getFlowNumber() {
		return flowNumber;
	}

	public void setFlowNumber(String flowNumber) {
		this.flowNumber = flowNumber;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public Short getType() {
		return type;
	}

	public void setType(Short type) {
		this.type = type;
	}

	public String getSrcURL() {
		return srcURL;
	}

	public void setSrcURL(String srcURL) {
		this.srcURL = srcURL;
	}

	public String getDestURL() {
		return destURL;
	}

	public void setDestURL(String destURL) {
		this.destURL = destURL;
	}

	public Integer getUserUploadVideoId() {
		return UserUploadVideoId;
	}

	public void setUserUploadVideoId(Integer userUploadVideoId) {
		UserUploadVideoId = userUploadVideoId;
	}

	public Short getProgress() {
		return progress;
	}

	public void setProgress(Short progress) {
		this.progress = progress;
	}
}
