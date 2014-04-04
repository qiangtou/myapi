package cn.jiuling.distributedapi.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import cn.jiuling.distributedapi.Vo.QueryTaskVo;
import cn.jiuling.distributedapi.Vo.ReturnData;
import cn.jiuling.distributedapi.dao.ExternaltaskDao;
import cn.jiuling.distributedapi.model.Externaltask;

@Repository("externaltaskDao")
public class ExternaltaskDaoImpl extends BaseDaoImpl<Externaltask> implements ExternaltaskDao {

	@Override
	public Long findByTaskNameAndUserUploadVideoId(Serializable id, String taskName) {
		Long count = 0l;
		String queryString = " select count(e.extTaskId) from Externaltask e where e.userUploadVideoId=? and e.taskName like ?";
		List list = getHibernateTemplate().find(queryString, new Object[] { id, taskName + "%" });
		count = (Long) list.get(0);
		return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<QueryTaskVo> queryTask(Integer uploadvideoid, String dataPath) {
		/* ' select  et.flowNumber, 
		v.genFlag,
		et.taskType, 
		Concat(''',@data_path, ''',v.filename),
		REPLACE(v.filename,''\\AstVS_1v2'','''') ,
		REPLACE(REPLACE(v.filename, ''.avi'', ''.dat''),''\\AstVS_1v2'','''') ,
		v.progress,
		et.taskName
		from externaltask et, exttaskstatus v
		where et.flowNumber = v.flowNumber 
		and et.UserUploadVideoID = ', @VideoID,' order by et.extTaskId desc');
		*/

		String queryString = "select new cn.jiuling.distributedapi.Vo.QueryTaskVo(e.flowNumber,s.id.genFlag,e.taskType," +
				"s.id.filename,s.id.progress,e.taskName) " +
				"from Externaltask e, Exttaskstatus s where e.userUploadVideoId=? and e.flowNumber=s.id.flowNumber order by e.extTaskId desc";
		// queryString =
		// "from Externaltask e, Exttaskstatus s where e.userUploadVideoId=? and e.flowNumber=s.id.flowNumber order by e.extTaskId desc";
		// List l = getHibernateTemplate().find(queryString, uploadvideoid);

		List<QueryTaskVo> list = getHibernateTemplate().find(queryString, uploadvideoid);

		QueryTaskVo q;
		if (list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				q = list.get(i);
				q.setSummarySrcURI(dataPath + q.getSummarySrcURI());
			}
		}
		return list;
	}

	@Override
	public Externaltask getLastTask(Integer videoid) {
		List list = find("from Externaltask e where e.userUploadVideoId=" + videoid + " order by e.extTaskId desc", 0, 1);
		if (list.size() > 0) {
			return (Externaltask) list.get(0);
		}
		return null;
	}

	@Override
	public ReturnData findAnalyse(Long videoid, Integer index, Integer count) {
		/*SELECT flownumber, g.generate_status_flag
		FROM externaltask e, generatevideo g
		WHERE useruploadvideoid = $videoid AND e.taskid = g.generateid
		ORDER BY flownumber DESC
		LIMIT $analyse_startindex,$analyse_count*/

		String queryString = "select new cn.jiuling.distributedapi.Vo.AnalyseEleVo(e.flowNumber,g.generateStatusFlag) from Externaltask e,Generatevideo g where g.generateId=e.taskId and e.userUploadVideoId="
				+ videoid;
		Long totalCount = super.getCount(queryString);
		List list = super.find(queryString, index, count);
		ReturnData rd = new ReturnData(totalCount, list);
		return rd;
	}

	@Override
	public void deleteByVideoId(Long id) {
		/*		 DELETE externaltask
				    FROM useruploadvideo, externaltask
				    WHERE useruploadvideo.UserUploadVideoId = externaltask.UserUploadVideoId
				        AND useruploadvideo.UserUploadVideoId = @videoid;*/
		String queryString = "select e from Externaltask e,Useruploadvideo u where e.userUploadVideoId=u.userUploadVideoId and u.userUploadVideoId=?";
		List list = getHibernateTemplate().find(queryString, id);
		getHibernateTemplate().deleteAll(list);
	}

	@Override
	public void deleteByCameraId(Long id) {
		/* DELETE externaltask
		    FROM tbl_camera, useruploadvideo, externaltask
		    WHERE tbl_camera.ID=useruploadvideo.CameraID 
		        AND useruploadvideo.UserUploadVideoId = externaltask.UserUploadVideoId
		        AND tbl_camera.ID = @cameraid;*/
		String queryString = "select e from Externaltask e,Camera c,Useruploadvideo u " +
				"where c.id=? and c.id= u.cameraId and e.userUploadVideoId=u.userUploadVideoId";
		List list = getHibernateTemplate().find(queryString, id);
		getHibernateTemplate().deleteAll(list);
	}

	@Override
	public void deleteByCaseId(Long id) {
		/*DELETE externaltask
		   FROM tbl_case, tbl_camera, useruploadvideo, externaltask
		   WHERE tbl_case.ID = tbl_camera.caseID AND tbl_camera.ID=useruploadvideo.CameraID 
		       AND useruploadvideo.UserUploadVideoId = externaltask.UserUploadVideoId
		       AND tbl_case.ID = @caseid;*/
		String queryString = "select e from Case ca,Externaltask e,Camera c,Useruploadvideo u " +
				"where ca.id=? and ca.id=c.caseId and c.id= u.cameraId and e.userUploadVideoId=u.userUploadVideoId";
		List list = getHibernateTemplate().find(queryString, id);
		getHibernateTemplate().deleteAll(list);
	}

}
