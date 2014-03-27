package cn.jiuling.distributedapi.Vo;

import java.util.List;

@Node("nightEnhance")
public class NightEnhanceVo {
	private Long totalcount;
	private List list;

	public NightEnhanceVo(ReturnData rd) {
		this.list = rd.getList();
		this.totalcount = rd.getTotalcount();
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
