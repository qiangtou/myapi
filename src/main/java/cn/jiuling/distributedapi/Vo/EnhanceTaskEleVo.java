package cn.jiuling.distributedapi.Vo;

public class EnhanceTaskEleVo {
	private Object taskid;
	private Object status;

	public Object getFlownumber() {
		return taskid;
	}

	public void setFlownumber(Object flownumber) {
		this.taskid = flownumber;
	}

	public Object getStatus() {
		return status;
	}

	public void setStatus(Object status) {
		this.status = status;
	}

	public EnhanceTaskEleVo(Object taskid, Object status) {
		super();
		this.taskid = taskid;
		this.status = status;
	}

}
