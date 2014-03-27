package cn.jiuling.distributedapi.Vo;

public class FsrtaskVo {
	/*	  <taskID>3</taskID> 
		  <stateFlag>0</stateFlag> 
		  <progress>0</progress> 
		  <sourceUrl>D:\VideoInvestigation\VIServer\DAT\AstVS_1v2\orgpics\mask(5).jpg</sourceUrl> 
		  <downloadUrl>orgpics\mask(5).jpg</downloadUrl> 
		  <resultPath>D:\VideoInvestigation\VIServer\DAT\AstVS_1v2\orgpics\mask(5)_res.jpg</resultPath> 
		  <resultUrl /> 
		  <params>null</params> 
	*/
	@Node("taskID")
	private Integer taskid;
	@Node("stateFlag")
	private Integer status;
	private Integer progress;

	private String resultUrl;
	private String downloadUrl;
	@Node("resultPath")
	private String resultpath;
	private String sourceUrl;

	private String params;

	public Integer getTaskid() {
		return taskid;
	}

	public void setTaskid(Integer taskid) {
		this.taskid = taskid;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getProgress() {
		return progress;
	}

	public void setProgress(Integer progress) {
		this.progress = progress;
	}

	public String getResultUrl() {
		return resultUrl;
	}

	public void setResultUrl(String resultUrl) {
		this.resultUrl = resultUrl;
	}

	public String getDownloadUrl() {
		return downloadUrl;
	}

	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}

	public String getResultpath() {
		return resultpath;
	}

	public void setResultpath(String resultpath) {
		this.resultpath = resultpath;
	}

	public String getSourceUrl() {
		return sourceUrl;
	}

	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

}
