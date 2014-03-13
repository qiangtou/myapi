package cn.jiuling.distributedapi.Vo;

import cn.jiuling.distributedapi.model.Useruploadvideo;

public class VideoRes extends ResStatus {
	private Long uploadvideoid;

	public VideoRes(Status cameraAddSuccess, Useruploadvideo c) {
		super(cameraAddSuccess);
		this.uploadvideoid = c.getUserUploadVideoId();
	}

	public Long getUploadvideoid() {
		return uploadvideoid;
	}

	public void setUploadvideoid(Long uploadvideoid) {
		this.uploadvideoid = uploadvideoid;
	}
}
