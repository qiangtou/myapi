package cn.jiuling.distributedapi.Vo;

public class TotalRes extends ResStatus {
	private int totalcount;

	public TotalRes(Status status, int totalcount) {
		super(status);
		this.totalcount = totalcount;
	}

	public int getTotalcount() {
		return totalcount;
	}

	public void setTotalcount(int totalcount) {
		this.totalcount = totalcount;
	}
}
