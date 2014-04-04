package cn.jiuling.distributedapi.Vo;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class CaseAndCamerasInfoRetVo {
	private Integer ret;

	private CaseInfoVo CaseInfo;
	private List CameraInfoList;

	public Integer getRet() {
		return ret;
	}

	public void setRet(Integer ret) {
		this.ret = ret;
	}

	@JsonProperty("CaseInfo")
	public CaseInfoVo getCaseInfo() {
		return CaseInfo;
	}

	public void setCaseInfo(CaseInfoVo caseInfo) {
		CaseInfo = caseInfo;
	}

	@JsonProperty("CameraInfoList")
	public List getCameraInfoList() {
		return CameraInfoList;
	}

	public void setCameraInfoList(List cameraInfoList) {
		CameraInfoList = cameraInfoList;
	}

}
