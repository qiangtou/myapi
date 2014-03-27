package cn.jiuling.distributedapi.Vo;

public class FsrtaskListVo {
	/*<id>2</id> 
	  <resultPath>D:\VideoInvestigation\VIServer\DAT\AstVS_1v2\orgpics\10_130708123726_1_res.jpg</resultPath> 
	  <resultUrl>orgpics\10_130708123726_1_res.jpg</resultUrl> 
	  <orgPath>D:\VideoInvestigation\VIServer\DAT\AstVS_1v2\orgpics\10_130708123726_1.jpg</orgPath> 
	  <orgUrl>orgpics\10_130708123726_1.jpg</orgUrl> 
	  <status>0</status> 
	  <progress>0</progress> 
	  <params>null</params> */
	@Node("id")
	private Integer taskid;
	@Node("resultPath")
	private String resultpath;
	// 这三个是新的要处理的属性
	private String resultUrl;
	private String orgPath;
	private String orgUrl;

	private Integer status;
	private Integer progress;
	private String params;

	public Integer getTaskid() {
		return taskid;
	}

	public void setTaskid(Integer taskid) {
		this.taskid = taskid;
	}

	public String getResultpath() {
		return resultpath;
	}

	public void setResultpath(String resultpath) {
		this.resultpath = resultpath;
	}

	public String getResultUrl() {
		return resultUrl;
	}

	public void setResultUrl(String resultUrl) {
		this.resultUrl = resultUrl;
	}

	public String getOrgPath() {
		return orgPath;
	}

	public void setOrgPath(String orgPath) {
		this.orgPath = orgPath;
	}

	public String getOrgUrl() {
		return orgUrl;
	}

	public void setOrgUrl(String orgUrl) {
		this.orgUrl = orgUrl;
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

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

}
