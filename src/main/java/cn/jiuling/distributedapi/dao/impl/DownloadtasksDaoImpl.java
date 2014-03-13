package cn.jiuling.distributedapi.dao.impl;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.springframework.stereotype.Repository;

import cn.jiuling.distributedapi.dao.DownloadtasksDao;
import cn.jiuling.distributedapi.model.Downloadtasks;

@Repository("downloadtasksDao")
public class DownloadtasksDaoImpl extends BaseDaoImpl<Downloadtasks> implements DownloadtasksDao {
	public List query3rdVideoList(Long cameraid, Short status, Timestamp start, Timestamp end,
			Integer startindex, Integer count) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Downloadtasks.class);
		if (-1 != status.shortValue()) {
			criteria.add(Property.forName("status").eq(status));
		}
		// 大于开始时间,小于结束时间
		criteria.add(Property.forName("cameraId").eq(cameraid));
		criteria.add(Property.forName("submitTime").ge(start));
		criteria.add(Property.forName("submitTime").le(end));
		return getHibernateTemplate().findByCriteria(criteria, startindex, count);
	}

}
