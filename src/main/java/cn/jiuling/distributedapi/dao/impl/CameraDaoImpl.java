package cn.jiuling.distributedapi.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.jiuling.distributedapi.dao.CameraDao;
import cn.jiuling.distributedapi.model.Camera;

@Repository("cameraDao")
public class CameraDaoImpl extends BaseDaoImpl<Camera> implements CameraDao {

	public List queryCamera(String name, Long value) {
		String queryString = "from Camera c where c." + name + "=:" + name;
		return getHibernateTemplate().findByNamedParam(queryString, name, value);
	}

}
