package cn.jiuling.distributedapi.Vo;

public class CaseRes extends ResStatus {
	@Node("caseid")
	private Long caseId;

	public CaseRes(Status status, Long caseId) {
		super(status);
		this.caseId = caseId;
	}

	public Long getCaseId() {
		return caseId;
	}

	public void setCaseId(Long caseId) {
		this.caseId = caseId;
	}

}
