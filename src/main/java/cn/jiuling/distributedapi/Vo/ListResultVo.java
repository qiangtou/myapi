package cn.jiuling.distributedapi.Vo;

import java.util.List;

public class ListResultVo {

	private int totalCount;
	private int count;
	private List list;

	public ListResultVo() {
		super();
	}

	public ListResultVo(int totalCount, List list) {
		super();
		this.totalCount = totalCount;
		this.list = list;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}
}
