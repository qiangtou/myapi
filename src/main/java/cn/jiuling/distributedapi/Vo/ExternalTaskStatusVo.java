package cn.jiuling.distributedapi.Vo;

public class ExternalTaskStatusVo {
	private Short status;
	private Integer progress;

	public ExternalTaskStatusVo(Short status, Integer progress) {
		super();
		this.status = status;
		this.progress = progress;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public Integer getProgress() {
		return progress;
	}

	public void setProgress(Integer progress) {
		this.progress = progress;
	}

}
