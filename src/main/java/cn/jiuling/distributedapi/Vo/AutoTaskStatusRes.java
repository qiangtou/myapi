package cn.jiuling.distributedapi.Vo;

public class AutoTaskStatusRes extends ResStatus {
	private Short status;

	public AutoTaskStatusRes(Status s, Short status) {
		super(s);
		this.status = status;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

}
