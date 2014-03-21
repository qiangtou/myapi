package cn.jiuling.distributedapi.Vo;

public class HistoryTaskListVo {
	/*	es.id.analyFlag,
	 * es.id.genFlag,
	 * es.id.progress,
	 * et.flowNumber, 
	 * et.taskType,
	 * et.sourceUrl,
	 * et.localFilename,
	 * et.userUploadVideoId,
	 * et.downloadStatus
		*/

	private Long analyFlag;
	private Long genFlag;
	private Double progress;
	private String flowNumber;
	private Short taskType;
	private String sourceUrl;
	private String localFilename;
	private Integer userUploadVideoId;
	private Short downloadStatus;

	public Long getAnalyFlag() {
		return analyFlag;
	}

	public void setAnalyFlag(Long analyFlag) {
		this.analyFlag = analyFlag;
	}

	public Long getGenFlag() {
		return genFlag;
	}

	public void setGenFlag(Long genFlag) {
		this.genFlag = genFlag;
	}

	public Double getProgress() {
		return progress;
	}

	public void setProgress(Double progress) {
		this.progress = progress;
	}

	public String getFlowNumber() {
		return flowNumber;
	}

	public void setFlowNumber(String flowNumber) {
		this.flowNumber = flowNumber;
	}

	public Short getTaskType() {
		return taskType;
	}

	public void setTaskType(Short taskType) {
		this.taskType = taskType;
	}

	public String getSourceUrl() {
		return sourceUrl;
	}

	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}

	public String getLocalFilename() {
		return localFilename;
	}

	public void setLocalFilename(String localFilename) {
		this.localFilename = localFilename;
	}

	public Integer getUserUploadVideoId() {
		return userUploadVideoId;
	}

	public void setUserUploadVideoId(Integer userUploadVideoId) {
		this.userUploadVideoId = userUploadVideoId;
	}

	public HistoryTaskListVo(Long analyFlag, Long genFlag, Double progress, String flowNumber, Short taskType, String sourceUrl, String localFilename,
			Integer userUploadVideoId, Short downloadStatus) {
		super();
		this.analyFlag = analyFlag;
		this.genFlag = genFlag;
		this.progress = progress;
		this.flowNumber = flowNumber;
		this.taskType = taskType;
		this.sourceUrl = sourceUrl;
		this.localFilename = localFilename;
		this.userUploadVideoId = userUploadVideoId;
		this.downloadStatus = downloadStatus;
	}

	public Short getDownloadStatus() {
		return downloadStatus;
	}

	public void setDownloadStatus(Short downloadStatus) {
		this.downloadStatus = downloadStatus;
	}

	public HistoryTaskListVo(Object analyFlag, Object genFlag, Object progress, Object flowNumber, Object taskType, Object sourceUrl, Object localFilename,
			Object userUploadVideoId, Object downloadStatus) {
		super();
		this.analyFlag = (Long) analyFlag;
		this.genFlag = (Long) genFlag;
		this.progress = (Double) progress;
		this.flowNumber = (String) flowNumber;
		this.taskType = (Short) taskType;
		this.sourceUrl = (String) sourceUrl;
		this.localFilename = (String) localFilename;
		this.userUploadVideoId = (Integer) userUploadVideoId;
		this.downloadStatus = (Short) downloadStatus;
	}
}
