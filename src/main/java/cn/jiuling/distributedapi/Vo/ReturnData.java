package cn.jiuling.distributedapi.Vo;

import java.util.List;

public class ReturnData {
	private Long totalcount;
	private List list;

	public ReturnData(Long totalcount, List list) {
		super();
		this.totalcount = totalcount;
		this.list = list;
	}

	public ReturnData() {
		super();
	}

	public Long getTotalcount() {
		return totalcount;
	}

	public void setTotalcount(Long totalcount) {
		this.totalcount = totalcount;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}
}
