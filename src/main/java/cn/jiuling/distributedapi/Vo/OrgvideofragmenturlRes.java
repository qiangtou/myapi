package cn.jiuling.distributedapi.Vo;

public class OrgvideofragmenturlRes extends ResStatus {
	private String url;

	public OrgvideofragmenturlRes(Status s) {
		super(s);
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
