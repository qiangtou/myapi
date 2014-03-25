package cn.jiuling.distributedapi.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.jiuling.distributedapi.dao.Autoanalyseparam4cameraDao;
import cn.jiuling.distributedapi.model.Autoanalyseparam4camera;

@Repository("Autoanalyseparam4cameraDao")
public class Autoanalyseparam4cameraDaoImpl extends BaseDaoImpl<Autoanalyseparam4camera> implements Autoanalyseparam4cameraDao {

	@Override
	public Autoanalyseparam4camera findByCameraIdAndUserId(Long cameraid, Long userid) {
		String queryString = "from Autoanalyseparam4camera a where a.cameraid=? and a.userid=?";
		List list = getHibernateTemplate().find(queryString, new Long[] { cameraid, userid });

		if (list.size() > 0) {
			return (Autoanalyseparam4camera) list.get(0);
		}
		return null;
	}

}
