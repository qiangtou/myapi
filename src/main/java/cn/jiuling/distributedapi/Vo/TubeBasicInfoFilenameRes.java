package cn.jiuling.distributedapi.Vo;

public class TubeBasicInfoFilenameRes extends ResStatus {
	private String fileurl;

	public TubeBasicInfoFilenameRes(Status s, String fileUrl) {
		super(s);
		this.fileurl = fileUrl;
	}

	public String getFileurl() {
		return fileurl;
	}

	public void setFileurl(String fileurl) {
		this.fileurl = fileurl;
	}

}
