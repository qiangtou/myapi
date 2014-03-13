package cn.jiuling.distributedapi.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.springframework.stereotype.Repository;

import cn.jiuling.distributedapi.dao.VideoDao;
import cn.jiuling.distributedapi.model.Useruploadvideo;

@Repository("videoDao")
public class VideoDaoImpl extends BaseDaoImpl<Useruploadvideo> implements VideoDao {
	public List queryVideo(Long cameraid, Long userid) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Useruploadvideo.class);
		criteria.add(Property.forName("cameraId").eq(cameraid));
		if (null != userid && userid > 0) {
			criteria.add(Property.forName("userid").eq(userid));
		}
		return getHibernateTemplate().findByCriteria(criteria);
	}
}
