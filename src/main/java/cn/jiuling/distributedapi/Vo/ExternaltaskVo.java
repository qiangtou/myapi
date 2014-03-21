package cn.jiuling.distributedapi.Vo;

public class ExternaltaskVo {
	private Integer code;
	private String flowNumber;
	private String msg;

	public ExternaltaskVo(Status s, String flowNumber) {
		super();
		this.flowNumber = flowNumber;
		this.code = s.getCode();
		this.msg = s.getDesc();
	}

	public String getFlowNumber() {
		return flowNumber;
	}

	public void setFlowNumber(String flowNumber) {
		this.flowNumber = flowNumber;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
