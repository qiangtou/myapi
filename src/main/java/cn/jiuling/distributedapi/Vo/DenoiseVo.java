package cn.jiuling.distributedapi.Vo;

import java.util.List;

@Node("denoise")
public class DenoiseVo {
	private Long totalcount;
	private List list;

	public DenoiseVo(ReturnData rd) {
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
