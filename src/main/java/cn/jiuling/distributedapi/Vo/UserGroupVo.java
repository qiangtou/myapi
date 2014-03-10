package cn.jiuling.distributedapi.Vo;

public class UserGroupVo {
	private Integer groupid;
	private String name;
	private String desc;

	public UserGroupVo(Integer groupid, String name, String desc) {
		super();
		this.groupid = groupid;
		this.name = name;
		this.desc = desc;
	}

	public Integer getGroupid() {
		return groupid;
	}

	public void setGroupid(Integer groupid) {
		this.groupid = groupid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
