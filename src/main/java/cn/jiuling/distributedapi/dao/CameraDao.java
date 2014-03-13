package cn.jiuling.distributedapi.dao;

import java.util.List;

import cn.jiuling.distributedapi.model.Camera;

public interface CameraDao extends BaseDao<Camera> {

	public List queryCamera(String name, Long value);

}
