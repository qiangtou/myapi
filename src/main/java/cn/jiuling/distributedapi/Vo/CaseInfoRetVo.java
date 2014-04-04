package cn.jiuling.distributedapi.Vo;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class CaseInfoRetVo {
	private Integer ret;
	private List CaseInfoList;

	public Integer getRet() {
		return ret;
	}

	public void setRet(Integer ret) {
		this.ret = ret;
	}

	@JsonProperty("CaseInfoList")
	public List getCaseInfoList() {
		return CaseInfoList;
	}

	public void setCaseInfoList(List caseInfoList) {
		CaseInfoList = caseInfoList;
	}

	public CaseInfoRetVo(Integer ret, List caseInfoList) {
		super();
		this.ret = ret;
		CaseInfoList = caseInfoList;
	}

	public CaseInfoRetVo() {
		super();
	}

}
