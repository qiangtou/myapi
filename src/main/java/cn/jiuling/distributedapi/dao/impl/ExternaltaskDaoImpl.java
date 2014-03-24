package cn.jiuling.distributedapi.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import cn.jiuling.distributedapi.Vo.QueryTaskVo;
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

}
