package cn.jiuling.distributedapi.Vo;

public class ClueStyleRes extends ResStatus {
	private String cluestyle;

	public ClueStyleRes(Status s, String clueStyle) {
		super(s);
		this.cluestyle = clueStyle;
	}

	public String getCluestyle() {
		return cluestyle;
	}

	public void setCluestyle(String cluestyle) {
		this.cluestyle = cluestyle;
	}
}
