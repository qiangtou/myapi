package cn.jiuling.distributedapi.Vo;

import java.util.List;

@Node("analyse")
public class AnalyseVo {
	private Long totalcount;
	private List list;

	public AnalyseVo(ReturnData rd) {
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
