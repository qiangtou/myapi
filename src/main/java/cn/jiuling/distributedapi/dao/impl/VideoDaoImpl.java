package cn.jiuling.distributedapi.dao.impl;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.springframework.stereotype.Repository;

import cn.jiuling.distributedapi.Vo.StatusInfoVo;
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

	@Override
	public StatusInfoVo getStatusInfo() {
		/*transcoding            
		waitingTranscoding   
		analysising           
		waitinganAlysising     
			(select count(*) from useruploadvideo where status = 2 or status = 5),
		    (select count(*) from useruploadvideo where status = 0 or status = 6), 
		    (select count(*) from exttaskstatus where downloadStatus = 5),
		    (select count(*) from exttaskstatus where downloadStatus = 2) */

		final String queryString1 = "select "
				+ "count(if(u.`status`=0 or u.`status`=6,u.`status`,null)) as 'transcoding',"
				+ "count(if(u.`status`=2 or u.`status`=5,u.`status`,null)) as 'waitingTranscoding'"
				+ " from Useruploadvideo u";
		List list = exeSql(queryString1);
		StatusInfoVo s = new StatusInfoVo();
		Object[] result = (Object[]) list.get(0);

		BigInteger transcoding = (BigInteger) result[0];
		BigInteger waitingTranscoding = (BigInteger) result[1];
		s.setTranscoding(transcoding.longValue());
		s.setWaitingTranscoding(waitingTranscoding.longValue());

		final String queryString2 = "select " +
				"count(if(e.downloadStatus=5,e.downloadStatus,null)) as 'analysising'," +
				"count(if(e.downloadStatus=2,e.downloadStatus,null)) as 'waitinganAlysising'" +
				" from exttaskstatus e";
		list = exeSql(queryString2);
		result = (Object[]) list.get(0);

		BigInteger analysising = (BigInteger) result[0];
		BigInteger waitinganAlysising = (BigInteger) result[1];
		s.setAnalysising(analysising.longValue());
		s.setWaitinganAlysising(waitinganAlysising.longValue());
		return s;
	}
}
