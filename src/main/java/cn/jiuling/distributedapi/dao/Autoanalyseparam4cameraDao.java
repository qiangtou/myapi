package cn.jiuling.distributedapi.dao;

import cn.jiuling.distributedapi.model.Autoanalyseparam4camera;

public interface Autoanalyseparam4cameraDao extends BaseDao<Autoanalyseparam4camera> {

	public Autoanalyseparam4camera findByCameraIdAndUserId(Long cameraid, Long userid);

}
