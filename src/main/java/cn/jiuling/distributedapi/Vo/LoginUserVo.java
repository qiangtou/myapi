package cn.jiuling.distributedapi.Vo;

public class LoginUserVo {
	private Integer userid;
	@Node("role")
	private Integer groupId;
	private Short singleormulti;
	@Node("task_priority")
	private Integer taskPriority;

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public Short getSingleormulti() {
		return singleormulti;
	}

	public void setSingleormulti(Short singleormulti) {
		this.singleormulti = singleormulti;
	}

	public Integer getTaskPriority() {
		return taskPriority;
	}

	public void setTaskPriority(Integer taskPriority) {
		this.taskPriority = taskPriority;
	}

}
