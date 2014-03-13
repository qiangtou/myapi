package cn.jiuling.distributedapi.Vo;

import java.sql.Timestamp;

public class CameraVo {
	@Node("cameraid")
	private Long id;
	@Node("cameratitle")
	private String title;
	private String location;
	private Float direction;
	@Node("cameratype")
	private Short type;
	private String serialnumber;
	private Float longitude;
	private Float latitude;
	private String description;
	private Timestamp createtime;
	private Integer calibration;
	@Node("video_type")
	private Short videoType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Float getDirection() {
		return direction;
	}

	public void setDirection(Float direction) {
		this.direction = direction;
	}

	public Short getType() {
		return type;
	}

	public void setType(Short type) {
		this.type = type;
	}

	public String getSerialnumber() {
		return serialnumber;
	}

	public void setSerialnumber(String serialnumber) {
		this.serialnumber = serialnumber;
	}

	public Float getLongitude() {
		return longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

	public Float getLatitude() {
		return latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public Integer getCalibration() {
		return calibration;
	}

	public void setCalibration(Integer calibration) {
		this.calibration = calibration;
	}

	public Short getVideoType() {
		return videoType;
	}

	public void setVideoType(Short videoType) {
		this.videoType = videoType;
	}
}
