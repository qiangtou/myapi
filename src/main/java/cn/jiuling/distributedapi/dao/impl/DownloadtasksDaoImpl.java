package cn.jiuling.distributedapi.dao.impl;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import cn.jiuling.distributedapi.Vo.HistoryTaskListVo;
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

	public List<HistoryTaskListVo> queryHistoryTaskListList(String userid, Integer status, Timestamp startTime, Timestamp endTime) {
		/*SELECT es.id.analyFlag,es.id.genFlag,es.id.progress,et.flowNumber, et.taskType,et.sourceUrl,et.localFilename,et.UserUploadVideoId ,
		 * et.downloadStatus FROM exttaskstatus es,externaltask et WHERE 
		es.id.flowNumber = et.flowNumber AND et.userid = '$userid' AND et.downloadStatus != 6*/

		if (null == startTime) {
			startTime = new Timestamp(0);
		}
		if (null == endTime) {
			endTime = new Timestamp(System.currentTimeMillis());
		}
		if (StringUtils.isEmpty(userid)) {
			userid = "super";
		}

		String queryString = "select new cn.jiuling.distributedapi.Vo.HistoryTaskListVo(es.id.analyFlag,es.id.genFlag,es.id.progress,et.flowNumber, et.taskType,et.sourceUrl,et.localFilename,et.userUploadVideoId,et.downloadStatus) "
				+ "from Exttaskstatus es,Externaltask et" +
				" where et.timestamp >='" + startTime + "' and et.timestamp<='" + endTime + "' and es.id.flowNumber=et.flowNumber and et.downloadStatus != 6";

		if (!"super".equals(userid)) {
			queryString += " and et.userid=" + userid;
		}
		/*		$resultArray[$index]['flowNumber'] = $row['flowNumber'];
				$resultArray[$index]['status'] = $retArray['status'];
				$resultArray[$index]['type'] = $row['taskType'];
				$resultArray[$index]['srcURI'] = $row['sourceUrl'];
				$resultArray[$index]['destURI'] = $row['localFilename'];
				$resultArray[$index]['UserUploadVideoId'] = $row['UserUploadVideoId'];
				$resultArray[$index]['progress'] = $retArray['progress'];
				if($retArray['status'] == 7 || $retArray['status'] == 5)
				{
					$resultArray[$index]['progress'] = $row['progress'];
				}*/

		List<HistoryTaskListVo> list = super.getHibernateTemplate().find(queryString);
		return list;

	}
}
