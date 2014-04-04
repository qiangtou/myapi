package cn.jiuling.distributedapi.Vo;

import java.net.URLEncoder;

public class CaseInfoVo {
	private Integer objectId;
	private String longitude;
	private String latitude;
	private String objectDesc;

	public CaseInfoVo(Integer objectId, String longitude, String latitude, String objectDesc) {
		super();
		this.objectId = objectId;
		this.longitude = longitude;
		this.latitude = latitude;
		if (objectDesc != null) {
			try {
				this.objectDesc = URLEncoder.encode(objectDesc, "UTF-8");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public CaseInfoVo() {
	}

	public Integer getObjectId() {
		return objectId;
	}

	public void setObjectId(Integer objectId) {
		this.objectId = objectId;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getObjectDesc() {
		return objectDesc;
	}

	public void setObjectDesc(String objectDesc) {
		this.objectDesc = objectDesc;
	}

}
