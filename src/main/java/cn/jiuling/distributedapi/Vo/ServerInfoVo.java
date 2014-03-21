package cn.jiuling.distributedapi.Vo;

public class ServerInfoVo {
	@Node("server_version")
	private String serveVersion;
	@Node("ukey_deadline")
	private String ukeyDeadline;

	public String getServeVersion() {
		return serveVersion;
	}

	public void setServeVersion(String serveVersion) {
		this.serveVersion = serveVersion;
	}

	public String getUkeyDeadline() {
		return ukeyDeadline;
	}

	public void setUkeyDeadline(String ukeyDeadline) {
		this.ukeyDeadline = ukeyDeadline;
	}

}
