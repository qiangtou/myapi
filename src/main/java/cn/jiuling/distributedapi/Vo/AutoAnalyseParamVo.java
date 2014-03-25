package cn.jiuling.distributedapi.Vo;

public class AutoAnalyseParamVo {
	/*	<taskType>2</taskType>	 
		  <thickness>0</thickness>
		  <sensitivity>0</sensitivity>		  
		  <obj_enable>0</obj_enable>
		  <obj_type>0</obj_type>
		  
		  <enable_avgcolor>0</enable_avgcolor>
		  <retrieve_avgcolor>0</retrieve_avgcolor>
		  <enable_uppercolor>0</enable_uppercolor>
		  <retrieve_uppercolor>0</retrieve_uppercolor>
		  <enable_lowercolor>0</enable_lowercolor>
		  <retrieve_lowercolor>0</retrieve_lowercolor>
		  <enable_carnum>0</enable_carnum>
		  <retrieve_carnum>0</retrieve_carnum>
		  
		<task_priority>1</task_priority>
		<enable_search_by_image>0</enable_search_by_image>
		<request_mask_url></request_mask_url>
		<request_image_download_url></request_image_download_url>
		<request_mask_download_url></request_mask_download_url>*/

	private Short taskType;
	private Short thickness;
	@Node("obj_enable")
	private Short objEnable;
	@Node("obj_Type")
	private Short objType;
	@Node("enable_avgcolor")
	private Short enableAvgcolor;
	@Node("retrieve_avgcolor")
	private Integer retrieveAvgcolor;
	@Node("enable_uppercolor")
	private Short enableUppercolor;
	@Node("retrieve_uppercolor")
	private Integer retrieveUppercolor;
	@Node("enable_lowercolor")
	private Short enableLowercolor;
	@Node("retrieve_lowercolor")
	private Integer retrieveLowercolor;
	@Node("enable_carnum")
	private Short enableCarnum;
	@Node("retrieve_carnum")
	private String retrieveCarnum;
	@Node("task_priority")
	private Integer taskPriority;
	@Node("enable_search_by_image")
	private Short enableSearchByImage;
	@Node("request_image_url")
	private String requestImageUrl;
	@Node("request_mask_url")
	private String requestMaskUrl;
	@Node("request_image_download_url")
	private String requestImageDownloadUrl;
	@Node("request_mask_download_url")
	private String requestMaskDownloadUrl;

	public Short getTaskType() {
		return taskType;
	}

	public void setTaskType(Short taskType) {
		this.taskType = taskType;
	}

	public Short getThickness() {
		return thickness;
	}

	public void setThickness(Short thickness) {
		this.thickness = thickness;
	}

	public Short getObjEnable() {
		return objEnable;
	}

	public void setObjEnable(Short objEnable) {
		this.objEnable = objEnable;
	}

	public Short getObjType() {
		return objType;
	}

	public void setObjType(Short objType) {
		this.objType = objType;
	}

	public Short getEnableAvgcolor() {
		return enableAvgcolor;
	}

	public void setEnableAvgcolor(Short enableAvgcolor) {
		this.enableAvgcolor = enableAvgcolor;
	}

	public Integer getRetrieveAvgcolor() {
		return retrieveAvgcolor;
	}

	public void setRetrieveAvgcolor(Integer retrieveAvgcolor) {
		this.retrieveAvgcolor = retrieveAvgcolor;
	}

	public Short getEnableUppercolor() {
		return enableUppercolor;
	}

	public void setEnableUppercolor(Short enableUppercolor) {
		this.enableUppercolor = enableUppercolor;
	}

	public Integer getRetrieveUppercolor() {
		return retrieveUppercolor;
	}

	public void setRetrieveUppercolor(Integer retrieveUppercolor) {
		this.retrieveUppercolor = retrieveUppercolor;
	}

	public Short getEnableLowercolor() {
		return enableLowercolor;
	}

	public void setEnableLowercolor(Short enableLowercolor) {
		this.enableLowercolor = enableLowercolor;
	}

	public Integer getRetrieveLowercolor() {
		return retrieveLowercolor;
	}

	public void setRetrieveLowercolor(Integer retrieveLowercolor) {
		this.retrieveLowercolor = retrieveLowercolor;
	}

	public Short getEnableCarnum() {
		return enableCarnum;
	}

	public void setEnableCarnum(Short enableCarnum) {
		this.enableCarnum = enableCarnum;
	}

	public String getRetrieveCarnum() {
		return retrieveCarnum;
	}

	public void setRetrieveCarnum(String retrieveCarnum) {
		this.retrieveCarnum = retrieveCarnum;
	}

	public Integer getTaskPriority() {
		return taskPriority;
	}

	public void setTaskPriority(Integer taskPriority) {
		this.taskPriority = taskPriority;
	}

	public Short getEnableSearchByImage() {
		return enableSearchByImage;
	}

	public void setEnableSearchByImage(Short enableSearchByImage) {
		this.enableSearchByImage = enableSearchByImage;
	}

	public String getRequestImageUrl() {
		return requestImageUrl;
	}

	public void setRequestImageUrl(String requestImageUrl) {
		this.requestImageUrl = requestImageUrl;
	}

	public String getRequestMaskUrl() {
		return requestMaskUrl;
	}

	public void setRequestMaskUrl(String requestMaskUrl) {
		this.requestMaskUrl = requestMaskUrl;
	}

	public String getRequestImageDownloadUrl() {
		return requestImageDownloadUrl;
	}

	public void setRequestImageDownloadUrl(String requestImageDownloadUrl) {
		this.requestImageDownloadUrl = requestImageDownloadUrl;
	}

	public String getRequestMaskDownloadUrl() {
		return requestMaskDownloadUrl;
	}

	public void setRequestMaskDownloadUrl(String requestMaskDownloadUrl) {
		this.requestMaskDownloadUrl = requestMaskDownloadUrl;
	}
}
