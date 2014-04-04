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

	@Override
	public void deleteByCaseId(Long id) {
		/*	 DELETE tbl_camera
			    FROM tbl_case, tbl_camera
			    WHERE tbl_case.ID = tbl_camera.caseID AND tbl_case.ID = @caseid;*/
		String queryString = "select c  from Camera c,Case ca "
				+ "where ca.id=c.caseId and ca.id=?";
		List list = getHibernateTemplate().find(queryString, id);
		getHibernateTemplate().deleteAll(list);
	}

	@Override
	public List queryDeleted() {
		/*SELECT id,title,createtime,2 FROM tbl_camera WHERE is_deleted = 1
		*/String queryString = "select new cn.jiuling.distributedapi.Vo.DeletedObjVo(" +
				"c.id,c.title,c.createtime,2) " +
				"from Camera c where c.isDeleted=1";
		return super.getHibernateTemplate().find(queryString);
	}
}
