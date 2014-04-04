package cn.jiuling.distributedapi.Vo;

public class GisVo {
	/*	if($isObjectExistsOnMap) {
			echo "vIsObjectExistsOnMap = true;";
		} else {
			echo "vIsObjectExistsOnMap = false;";
		}
		if($isParentCaseExistsOnMap) {
			echo "vIsParentCaseExistsOnMap = true;";
		} else {
			echo "vIsParentCaseExistsOnMap = false;";
		}
		echo "vOperateType = ".$operateType.";";
		echo "vShowType = ".$showType.";";
		echo "vObjectType = ".$objectType.";";
		echo "vObjectId = ".$objectId.";";
		echo "vCaseId = ".$caseId.";";
		echo "vObjectDesc = '".$objectDesc."';";
		
		echo "vXPosition = ".$xPosition.";";
		echo "vYPosition = '".$yPosition."';";*/
	private boolean isObjectExistsOnMap;
	private boolean isParentCaseExistsOnMap;
	private Short operateType;
	private Short showType;
	private Short objectType;
	private Long objectId;
	private Long caseId;
	private String objectDesc;
	private Float xPosition;
	private Float yPosition;
	private Integer zoomLevel;

	/*String gis_init_longitude = ConfigUtils.getValue("gis_init_longitude");
	String gis_init_latitude = ConfigUtils.getValue("gis_init_latitude");*/
	private String initLongitude;
	private String initLatitude;

	public String getInitLongitude() {
		return initLongitude;
	}

	public void setInitLongitude(String initLongitude) {
		this.initLongitude = initLongitude;
	}

	public String getInitLatitude() {
		return initLatitude;
	}

	public void setInitLatitude(String initLatitude) {
		this.initLatitude = initLatitude;
	}

	public Integer getZoomLevel() {
		return zoomLevel;
	}

	public void setZoomLevel(Integer zoomLevel) {
		this.zoomLevel = zoomLevel;
	}

	public boolean getIsObjectExistsOnMap() {
		return isObjectExistsOnMap;
	}

	public void setIsObjectExistsOnMap(boolean isObjectExistsOnMap) {
		this.isObjectExistsOnMap = isObjectExistsOnMap;
	}

	public boolean getIsParentCaseExistsOnMap() {
		return isParentCaseExistsOnMap;
	}

	public void setIsParentCaseExistsOnMap(boolean isParentCaseExistsOnMap) {
		this.isParentCaseExistsOnMap = isParentCaseExistsOnMap;
	}

	public Short getOperateType() {
		return operateType;
	}

	public void setOperateType(Short operateType) {
		this.operateType = operateType;
	}

	public Short getShowType() {
		return showType;
	}

	public void setShowType(Short showType) {
		this.showType = showType;
	}

	public Short getObjectType() {
		return objectType;
	}

	public void setObjectType(Short objectType) {
		this.objectType = objectType;
	}

	public Long getObjectId() {
		return objectId;
	}

	public void setObjectId(Long objectId) {
		this.objectId = objectId;
	}

	public Long getCaseId() {
		return caseId;
	}

	public void setCaseId(Long caseId) {
		this.caseId = caseId;
	}

	public String getObjectDesc() {
		return objectDesc;
	}

	public void setObjectDesc(String objectDesc) {
		this.objectDesc = objectDesc;
	}

	public Float getxPosition() {
		return xPosition;
	}

	public void setxPosition(Float xPosition) {
		this.xPosition = xPosition;
	}

	public Float getyPosition() {
		return yPosition;
	}

	public void setyPosition(Float yPosition) {
		this.yPosition = yPosition;
	}

}
