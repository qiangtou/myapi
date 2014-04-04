package cn.jiuling.distributedapi.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.springframework.stereotype.Repository;

import cn.jiuling.distributedapi.dao.GisDao;
import cn.jiuling.distributedapi.model.Gis;

@Repository("gisDao")
public class GisDaoImpl extends BaseDaoImpl<Gis> implements GisDao {

	@Override
	public void deleteByCameraId(Long id) {
		/* DELETE tbl_gis
		    FROM tbl_camera, tbl_gis
		    WHERE tbl_camera.ID = @cameraid AND tbl_gis.objecttype = 2 AND tbl_gis.objectid = tbl_camera.id;*/
		String queryString = "select g from Gis g,Camera c where c.id=? and g.objectType=2 and c.id=g.objectId";
		List list = getHibernateTemplate().find(queryString, id);
		getHibernateTemplate().deleteAll(list);

	}

	@Override
	public void deleteByCaseId(Long id) {
		/* DELETE tbl_gis
		 FROM tbl_camera, tbl_case, tbl_gis
		 WHERE tbl_case.ID = @caseid AND tbl_camera.caseid = tbl_case.ID AND tbl_gis.objecttype = 2 AND tbl_gis.objectid = tbl_camera.id;
		*/
		String queryString = "select g from Gis g,Camera c,Case ca " +
				"where ca.id=? and ca.id=c.caseId and g.objectType=2 and c.id=g.objectId";
		List list = getHibernateTemplate().find(queryString, id);
		getHibernateTemplate().deleteAll(list);

		/*DELETE tbl_gis
		FROM tbl_case, tbl_gis
		WHERE tbl_case.ID = @caseid AND tbl_gis.objecttype = 1 AND tbl_gis.objectid = tbl_case.id;*/
		queryString = "select g from Gis g,Case ca " +
				"where ca.id=? and g.objectType=1 and ca.id=g.objectId";
		list = getHibernateTemplate().find(queryString, id);
		getHibernateTemplate().deleteAll(list);

	}

	@Override
	public List queryGis(Short objectType, Long caseId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Gis.class);
		if (objectType != null) {
			criteria.add(Property.forName("objectType").eq(objectType));
		}
		if (caseId != null) {
			criteria.add(Property.forName("objectId").eq(caseId));
		}
		return super.getHibernateTemplate().findByCriteria(criteria);
	}

	@Override
	public List getCasesInfo() {
		Short objectType = 1;

		String queryString = "select new cn.jiuling.distributedapi.Vo.CaseInfoVo(" +
				"g.objectId,g.longitude,g.latitude,g.objectDesc) from Gis g where g.objectType=?";
		return super.getHibernateTemplate().find(queryString, objectType);
	}

	@Override
	public List getCaseAndCamerasInfo(Integer caseId) {
		/*		$command = "SELECT 
					tbl_gis.objectId,
					tbl_gis.objectType,
					tbl_camera.CaseID,
					tbl_gis.longitude,
					tbl_gis.latitude,
					tbl_gis.objectDesc
					FROM
					tbl_gis ,
					tbl_camera
					WHERE tbl_gis.objectType=2 AND  tbl_gis.objectId=tbl_camera.ID AND tbl_camera.CaseID=".$CaseId;" +
							"
		*/
		String queryString = "select new cn.jiuling.distributedapi.Vo.CaseInfoVo(" +
				"g.objectId,g.longitude,g.latitude,g.objectDesc) from Gis g,Camera c " +
				"where g.objectType=2 and g.objectId=c.id and c.caseId=?";
		return super.getHibernateTemplate().find(queryString, caseId.longValue());
	}

	@Override
	public Gis getCasesInfo(Integer caseId) {
		String queryString = "from Gis g where g.objectType=1 and g.objectId=?";
		List list = super.getHibernateTemplate().find(queryString, caseId);
		if (list.size() > 0) {
			return (Gis) list.get(0);
		}
		return null;
	}

}
