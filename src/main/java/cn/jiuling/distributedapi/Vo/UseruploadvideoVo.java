package cn.jiuling.distributedapi.Vo;

public class UseruploadvideoVo {
	@Node("UserUploadVideoId")
	private Long userUploadVideoId;
	@Node("destURI")
	private String destUrl;

	public Long getUserUploadVideoId() {
		return userUploadVideoId;
	}

	public void setUserUploadVideoId(Long userUploadVideoId) {
		this.userUploadVideoId = userUploadVideoId;
	}

	public String getDestUrl() {
		return destUrl;
	}

	public void setDestUrl(String destUrl) {
		this.destUrl = destUrl;
	}

}
