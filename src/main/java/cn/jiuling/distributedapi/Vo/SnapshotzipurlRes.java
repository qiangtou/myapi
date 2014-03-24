package cn.jiuling.distributedapi.Vo;

public class SnapshotzipurlRes extends ResStatus {
	private String url;

	public SnapshotzipurlRes(Status s, String url) {
		super(s);
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
