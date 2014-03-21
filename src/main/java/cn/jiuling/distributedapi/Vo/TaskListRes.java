package cn.jiuling.distributedapi.Vo;

public class TaskListRes extends ResStatus {
	private int totalcount;
	private int count;

	public TaskListRes(Status querySuccess, QueryTaskListResultVo result) {
		super(querySuccess);
		this.totalcount = result.getTotalCount();
		this.count = result.getCount();
	}

	public int getTotalcount() {
		return totalcount;
	}

	public void setTotalcount(int totalcount) {
		this.totalcount = totalcount;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
