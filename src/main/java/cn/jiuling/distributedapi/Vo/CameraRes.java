package cn.jiuling.distributedapi.Vo;

import cn.jiuling.distributedapi.model.Camera;

public class CameraRes extends ResStatus {
	private Long cameraid;

	public CameraRes(Status cameraAddSuccess, Camera c) {
		super(cameraAddSuccess);
		this.cameraid = c.getId();
	}

	public Long getCameraid() {
		return cameraid;
	}

	public void setCameraid(Long cameraid) {
		this.cameraid = cameraid;
	}

}
