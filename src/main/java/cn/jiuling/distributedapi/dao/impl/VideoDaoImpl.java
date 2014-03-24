package cn.jiuling.distributedapi.dao.impl;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import cn.jiuling.distributedapi.Vo.ListResultVo;
import cn.jiuling.distributedapi.Vo.SnapGenInfoVo;
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

	@Override
	public Useruploadvideo getBySrcAndDest(String srcURI, String destURI) {
		/*$command = "select UserUploadVideoId from UserUploadVideo where destURL = '$destURI' AND srcURL = '$srcURI'";
		*/
		Useruploadvideo u = null;
		String queryString = "from Useruploadvideo u where u.srcUrl=? and u.destUrl=?";
		List<Useruploadvideo> list = super.getHibernateTemplate().find(queryString, new String[] { srcURI, destURI });
		if (list.size() > 0) {
			u = list.get(0);
		}
		return u;
	}

	@Override
	public ListResultVo queryUploadFileList(String userid, Integer status, Long startTime, Long endTime, Integer index, Integer count) {

		if (StringUtils.isEmpty(userid)) {
			userid = "1";
		}
		String userQuery = "";
		if (!"super".equals(userid)) {
			userQuery = " userid=" + userid + " and ";
		}
		String statusQuery = "";
		if (status == -1) {// 所有状态
			statusQuery = "";
		} else if (status == 5) { // 转码成功未提交
			statusQuery = " status=1 and ";
		} else if (status == 101) {// 转码中和等待转码
			statusQuery = " (status=0 or status=2 or status=5 or status=6) and ";
		} else {
			statusQuery = " status=" + status + " and ";
		}
		if (endTime == null) {
			endTime = System.currentTimeMillis();
		}
		if (startTime == null) {
			startTime = 0L;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String start = sdf.format(new Date(startTime));
		String end = sdf.format(new Date(endTime));
		String queryString = " from Useruploadvideo where " + userQuery + statusQuery +
				"timestamp>='" + start + "' and timestamp<='" + end + "'";

		Long totalCount = super.getCount(queryString);

		/*UploadtasklistVo(Long userUploadVideoId, Short status, Short progress, String srcUrl, String destUrl) {
		*/
		queryString = "select new cn.jiuling.distributedapi.Vo.UploadtasklistVo(userUploadVideoId,status,progress,srcUrl,destUrl) " + queryString;
		List list = super.find(queryString, index, count);
		ListResultVo l = new ListResultVo();
		l.setList(list);
		l.setCount(count);
		l.setTotalCount(totalCount.intValue());
		return l;
	}

	@Override
	public SnapGenInfoVo querySnapGenInfo(Integer userUploadVideoId, Integer taskId) {
		String queryString;
		if (userUploadVideoId == 0) {
			queryString = "select new cn.jiuling.distributedapi.Vo.SnapGenInfoVo( " +
					"g.analysisvideo.snapshotFolder,g.analysisvideo.outputWidth," +
					"g.analysisvideo.outputHeight,g.analysisvideo.orgvideolist.frmRate," +
					"a.recordTime,e.objType,0) " +
					"from Generatevideo g ,Externaltask e,AnalysisTime a " +
					"where g.generateId=? and g.generateId=e.taskId and e.flowNumber=a.flowNumber";
		} else {
			queryString = "select new cn.jiuling.distributedapi.Vo.SnapGenInfoVo( " +
					"g.analysisvideo.snapshotFolder,g.analysisvideo.outputWidth," +
					"g.analysisvideo.outputHeight,g.analysisvideo.orgvideolist.frmRate," +
					"u.recordTime,e.objType,e.taskType) " +
					"from Generatevideo g ,Externaltask e,Useruploadvideo u " +
					"where g.generateId=? and g.generateId=e.taskId and e.userUploadVideoId=u.userUploadVideoId";
		}
		List list = super.getHibernateTemplate().find(queryString, taskId.longValue());
		if (list.size() > 0) {
			return (SnapGenInfoVo) list.get(0);
		}
		return null;
	}

	@Override
	public List getVideosByCase(Integer caseid, Integer userid) {

		/*		SELECT 
				u.useruploadvideoid, 
				u.destURL, 
				u.frame_rate, 
				a.taskType, 
				a.run_time_speed, 
				a.thickness, 
				a.sensitivity, 
				a.obj_enable, 
				a.obj_type, 
				a.enable_avgcolor, 
				a.retrieve_avgcolor, 
				a.enable_uppercolor, 
				a.retrieve_uppercolor, 
				a.enable_lowercolor, 
				a.retrieve_lowercolor, 
				a.enable_carnum, 
				a.retrieve_carnum, 
				a.task_priority,
				a.enable_search_by_image, 
				a.request_image_url, 
				a.request_image_data, 
				a.request_mask_url,
				a.request_mask_data
				FROM useruploadvideo u, tbl_case c, tbl_camera m, tbl_AutoAnalyseParam a
				WHERE c.id = caseid AND m.caseid = c.id AND u.cameraid = m.id 
				AND a.caseid = caseid AND a.userid = userid AND m.is_deleted <> 1 AND u.is_deleted <> 1 AND u.status = 1; 
		*/

		String queryString = "select new Externaltask("
				+ "u.userUploadVideoId," +
										"u.destUrl," +
										"u.frameRate," +
										"a.taskType," +
										"a.runTimeSpeed,"
										+ "a.thickness," +
										"a.sensitivity," +
										"a.objEnable, " +
										"a.objType," +
										"a.enableAvgcolor, "
										+ "a.retrieveAvgcolor, " +
										"a.enableUppercolor, " +
										"a.retrieveUppercolor, " +
										"a.enableLowercolor, "
										+ "a.retrieveLowercolor, " +
										"a.enableCarnum, " +
										"a.retrieveCarnum, " +
										"a.taskPriority, "
										+ "a.enableSearchByImage, " +
										"a.requestImageUrl, " +
										"a.requestImageData," +
										" a.requestMaskUrl," +
										"a.requestMaskData" +
											") " +
				" from Useruploadvideo u,Case c,Camera m,Autoanalyseparam a " +
				"where c.id=? and m.caseId=c.id and u.cameraId=m.id and a.caseid=? and a.userid=? " +
				"and m.isDeleted!=1 and u.isDeleted!=1 and u.status=1";
		List list = getHibernateTemplate().find(queryString, new Object[] { caseid.longValue(), caseid.longValue(), userid.longValue() });
		return list;
	}

	@Override
	public List getVideosByCamera(Integer cameraid, Integer userid) {
		/*		SELECT u.useruploadvideoid,
				 u.destURL,
				 u.frame_rate,
				 a.taskType,
				 a.run_time_speed,
				 a.thickness,
				 a.sensitivity,
				 a.obj_enable,
				 a.obj_type,
				 a.enable_avgcolor,
				 a.retrieve_avgcolor,
				 a.enable_uppercolor, 
				 a.retrieve_uppercolor,
				 a.enable_lowercolor,
				 a.retrieve_lowercolor,
				 a.enable_carnum,
				 a.retrieve_carnum,
				 a.task_priority,
				 b.UDR_exist,
				 b.UDR_setting,
				 b.summary_width,
				 b.summary_height,
				 b.isSetTripArea, 
				 b.trip_area,
				 b.obj_search_by_mov,
				 b.obj_request_mov_vertics,
				 b.obj_request_mov_vertics_num,
				 a.enable_search_by_image,
				 a.request_image_url,
				 a.request_image_data,
				 a.request_mask_url,
				 a.request_mask_data
				      FROM useruploadvideo u,
				 tbl_case c,
				 tbl_camera m,
				 tbl_AutoAnalyseParam a,
				 tbl_AutoAnalyseParam4Camera b  
				      WHERE m.id = cameraid AND m.caseid = c.id AND u.cameraid = m.id 
				      AND a.caseid = c.id AND a.userid = userid 
				      and u.is_deleted <> 1 and u.status = 1 and b.cameraid = m.id and b.userid = userid;
		*/
		String queryString = "	SELECT "
				+ "u.userUploadVideoId,"
				+ "u.destUrl,"
				+ "u.frameRate,"
				+ "a.taskType,"
				+ "a.runTimeSpeed,"
				+ "a.thickness,"
				+ "a.sensitivity,"
				+ "a.objEnable,"
				+ "a.objType,"
				+ "a.enableAvgcolor,"
				+ "a.retrieveAvgcolor,"
				+ "a.enableUppercolor, "
				+ "a.retrieveUppercolor,"
				+ "a.enableLowercolor,"
				+ "a.retrieveLowercolor,"
				+ "a.enableCarnum,"
				+ "a.retrieveCarnum,"
				+ "a.taskPriority,"
				+ "b.udrExist,"
				+ "b.udrSetting,"
				+ "b.summaryWidth,"
				+ "b.summaryHeight,"
				+ "b.isSetTripArea, "
				+ "b.tripArea,"
				+ "b.objSearchByMov,"
				+ "b.objRequestMovVertics,"
				+ "b.objRequestMovVerticsNum,"
				+ "a.enableSearchByImage, "
				+ "a.requestImageUrl, "
				+ "a.requestImageData,"
				+ "a.requestMaskUrl,"
				+ "a.requestMaskData"
				+ " from Useruploadvideo u,Case c,Camera m,Autoanalyseparam a"
				+ ", Autoanalyseparam4camera b "
				+ " WHERE m.id = ? AND m.caseId = c.id AND u.cameraId = m.id "
				+ "AND a.caseid = c.id AND a.userid = ? and u.isDeleted <> 1 "
				+ "and u.status = 1 and b.cameraid = m.id and b.userid = ?";

		List list = getHibernateTemplate().find(queryString, new Object[] { cameraid.longValue(), userid.longValue(), userid.longValue() });
		return list;
	}
}
