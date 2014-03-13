package cn.jiuling.distributedapi.service;

import java.util.List;

import cn.jiuling.distributedapi.model.Camera;

public interface CameraService {
	public void addCamera(Camera c);

	public void modifyCamera(Camera c);

	public List queryCameraByCaseId(Long caseid);

	public List queryCameraByCameraid(Long cameraid);
}
