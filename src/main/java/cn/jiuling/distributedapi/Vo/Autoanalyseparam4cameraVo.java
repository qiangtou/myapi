package cn.jiuling.distributedapi.Vo;

public class Autoanalyseparam4cameraVo {
	/*	<ID></ID>
	<cameraid></cameraid>
	<userid></userid>
	<UDR_exist></UDR_exist>
	<UDR_setting></UDR_setting>
	<summary_width></summary_width>
	<summary_height></summary_height>
	<isSetTripArea></isSetTripArea>
	<trip_area></trip_area>
	<obj_search_by_mov></obj_search_by_mov>
	<obj_request_mov_vertics></obj_request_mov_vertics>
	<obj_request_mov_vertics_num></obj_request_mov_vertics_num>
	*/
	@Node("ID")
	private Long id;
	private Long cameraid;
	private Long userid;
	@Node("UDR_exist")
	private Short udrExist;
	@Node("UDR_setting")
	private String udrSetting;
	@Node("summary_width")
	private Short summaryWidth;
	@Node("summary_height")
	private Short summaryHeight;
	private Short isSetTripArea;
	@Node("trip_area")
	private String tripArea;
	@Node("obj_search_by_mov")
	private Boolean objSearchByMov;
	@Node("obj_request_mov_vertics")
	private String objRequestMovVertics;
	@Node("obj_request_mov_vertics_num")
	private Integer objRequestMovVerticsNum;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCameraid() {
		return cameraid;
	}

	public void setCameraid(Long cameraid) {
		this.cameraid = cameraid;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public Short getUdrExist() {
		return udrExist;
	}

	public void setUdrExist(Short udrExist) {
		this.udrExist = udrExist;
	}

	public String getUdrSetting() {
		return udrSetting;
	}

	public void setUdrSetting(String udrSetting) {
		this.udrSetting = udrSetting;
	}

	public Short getSummaryWidth() {
		return summaryWidth;
	}

	public void setSummaryWidth(Short summaryWidth) {
		this.summaryWidth = summaryWidth;
	}

	public Short getSummaryHeight() {
		return summaryHeight;
	}

	public void setSummaryHeight(Short summaryHeight) {
		this.summaryHeight = summaryHeight;
	}

	public Short getIsSetTripArea() {
		return isSetTripArea;
	}

	public void setIsSetTripArea(Short isSetTripArea) {
		this.isSetTripArea = isSetTripArea;
	}

	public String getTripArea() {
		return tripArea;
	}

	public void setTripArea(String tripArea) {
		this.tripArea = tripArea;
	}

	public Boolean getObjSearchByMov() {
		return objSearchByMov;
	}

	public void setObjSearchByMov(Boolean objSearchByMov) {
		this.objSearchByMov = objSearchByMov;
	}

	public String getObjRequestMovVertics() {
		return objRequestMovVertics;
	}

	public void setObjRequestMovVertics(String objRequestMovVertics) {
		this.objRequestMovVertics = objRequestMovVertics;
	}

	public Integer getObjRequestMovVerticsNum() {
		return objRequestMovVerticsNum;
	}

	public void setObjRequestMovVerticsNum(Integer objRequestMovVerticsNum) {
		this.objRequestMovVerticsNum = objRequestMovVerticsNum;
	}
}
