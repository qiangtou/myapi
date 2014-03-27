package cn.jiuling.distributedapi.Vo;

public class AnalyseEleVo {
	private Object flownumber;
	private Object status;

	public Object getFlownumber() {
		return flownumber;
	}

	public void setFlownumber(Object flownumber) {
		this.flownumber = flownumber;
	}

	public Object getStatus() {
		return status;
	}

	public void setStatus(Object status) {
		this.status = status;
	}

	public AnalyseEleVo(Object flownumber, Object status) {
		super();
		this.flownumber = flownumber;
		this.status = status;
	}

}
