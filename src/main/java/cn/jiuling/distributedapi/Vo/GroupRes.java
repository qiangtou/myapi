package cn.jiuling.distributedapi.Vo;

public class GroupRes extends ResStatus {
	@Node("groupid")
	private Integer groupId;

	public GroupRes(Integer groupId) {
		super();
		this.groupId = groupId;
	}

	public GroupRes() {
		super();
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

}
