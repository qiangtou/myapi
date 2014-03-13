package cn.jiuling.distributedapi.Vo;

public class ResStatus {

	@Node("ret")
	private Integer code;
	@Node("str_desc")
	private String desc;

	public ResStatus() {
	}

	public ResStatus(Status Status) {
		this.setStatus(Status);
	}

	public void setStatus(Status status) {
		this.code = status.getCode();
		this.desc = status.getDesc();
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
