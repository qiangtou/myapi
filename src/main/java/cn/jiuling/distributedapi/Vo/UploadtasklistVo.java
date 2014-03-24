package cn.jiuling.distributedapi.Vo;

public class UploadtasklistVo {

	/* <UserUploadVideoId></UserUploadVideoId>
	 <status></status>
	 <srcURI></srcURI>
	 <destURI></destURI>
	 <progress></progress>*/

	@Node("UserUploadVideoId")
	private Long userUploadVideoId;
	private Short status;
	private Short progress;
	@Node("srcURI")
	private String srcUrl;
	@Node("destURI")
	private String destUrl;

	public UploadtasklistVo(Long userUploadVideoId, Short status, Short progress, String srcUrl, String destUrl) {
		super();
		this.userUploadVideoId = userUploadVideoId;
		this.status = status;
		this.progress = progress;
		this.srcUrl = srcUrl;
		this.destUrl = destUrl;
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
