package cn.jiuling.distributedapi.Vo;

public class CaseReportVo {
	@Node("camera_location")
	private String location;// 监控点位置
	@Node("camera_type")
	private String type;// 监控点类型
	@Node("camera_resolution")
	private String resolution;// 监控点分辨率
	@Node("video_totalcount")
	private Long vedeoTotalcount;// 视频总数
	@Node("video_duration")
	private Long duration;// 视频总时长，单位/分钟
	@Node("video_space")
	private Long space;// 视频总容量，单位/M
	@Node("object_totalcount")
	private Long objectTotalcount;// 目标总数
	private String description;// 描述

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public Long getVedeoTotalcount() {
		return vedeoTotalcount;
	}

	public void setVedeoTotalcount(Long vedeoTotalcount) {
		this.vedeoTotalcount = vedeoTotalcount;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public Long getSpace() {
		return space;
	}

	public void setSpace(Long space) {
		this.space = space;
	}

	public Long getObjectTotalcount() {
		return objectTotalcount;
	}

	public void setObjectTotalcount(Long objectTotalcount) {
		this.objectTotalcount = objectTotalcount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
