package cn.jiuling.distributedapi.dao.impl;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;
import org.springframework.stereotype.Repository;

import cn.jiuling.distributedapi.Vo.CaseVideoVo;
import cn.jiuling.distributedapi.dao.CaseDao;
import cn.jiuling.distributedapi.model.Case;

@Repository("caseDao")
public class CaseDaoImpl extends BaseDaoImpl<Case> implements CaseDao {

	public List<Case> query(Integer startindex, Integer count, Integer sorttype, Integer isDescend) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Case.class);
		/**
		 * 0:createtime 1:ocurredtime 2:style 3:class 4:serialnumber
		 */
		String sortBys[] = { "createtime", "ocurredtime", "style", "class_", "serialnumber" };
		String sortBy = "createtime";
		if (sorttype >= 0 && sorttype < sortBys.length) {
			sortBy = sortBys[sorttype];
		}
		// 0升序,1降序,默认降序
		Order order = isDescend == 0 ? Order.asc(sortBy) : Order.desc(sortBy);
		criteria.addOrder(order);
		List caseList = getHibernateTemplate().findByCriteria(criteria, startindex, count);
		return caseList;
	}

	public List<Case> searchCase(Integer type, String value, Timestamp time, Integer startindex, Integer count) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Case.class);
		/*
		 * type 0 : 案件名 1 : 案发地点 2 : 案件类别 3 : 案发时间 4 : 描述 5 : 案件级别 6 : 案件编号
		 */
		String types[] = { "title", "location", "style", "ocurredtime", "description", "class", "serialnumber" };
		if (null != type && type >= 0 && type < types.length) {
			String property = types[type];
			criteria.add(Property.forName(property).eq(value));
		}
		return getHibernateTemplate().findByCriteria(criteria, startindex, count);
	}

	public CaseVideoVo queryCaseVideo(Long caseid) {
		// 
		/*
		 * select timestamp, record_time, UserUploadVideoId,status as
		 * transcodestatus, progress, srcURL, destURL from useruploadvideo uv
		 * where status<>3 and status<>4 and is_deleted <> 1 and uv.CameraID IN
		 * (SELECT ID FROM tbl_Camera WHERE CaseID = ', @CaseID,') order by
		 * timestamp DESC;
		 */
		String queryString = "select new cn.jiuling.distributedapi.Vo.CaseVideoVo"
				+ "(u.timestamp,u.recordTime,u.userUploadVideoId,u.status,u.progress,u.srcUrl,"
				+ "u.destUrl) from Useruploadvideo u where (u.status<3 or u.status>4)"
				+ " and u.isDeleted <> 1 and u.cameraId in (" +
						"SELECT c.id FROM Camera c WHERE c.caseId =:caseid )";
		List list = getHibernateTemplate().findByNamedParam(queryString, "caseid", caseid);
		return (CaseVideoVo) (list.size() > 0 ? list.get(0) : null);
	}
}
