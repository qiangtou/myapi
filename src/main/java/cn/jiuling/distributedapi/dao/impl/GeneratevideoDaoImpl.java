package cn.jiuling.distributedapi.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.jiuling.distributedapi.dao.GeneratevideoDao;
import cn.jiuling.distributedapi.model.Generatevideo;

@Repository("generatevideoDao")
public class GeneratevideoDaoImpl extends BaseDaoImpl<Generatevideo> implements GeneratevideoDao {

	@Override
	public void updateStatus(Integer taskId) {
		/*UPDATE externaltask,generatevideo set generatevideo.gen_cmd = 4, generatevideo.generate_status_flag = 4
		 WHERE externaltask.taskID = generatevideo.GenerateID 
		     AND externaltask.flownumber = @id;*/
		String queryString = "update Generatevideo g set g.genCmd=4 ,g.generateStatusFlag=4 where g.generateId=?";
		super.getHibernateTemplate().bulkUpdate(queryString, taskId.longValue());
	}

	@Override
	public void updateStatusByVideoId(Long id) {
		/*
		UPDATE useruploadvideo, externaltask, generatevideo  
		SET generatevideo.generate_status_flag = 4 
		WHERE useruploadvideo.UserUploadVideoId = externaltask.UserUploadVideoId
		AND externaltask.taskID = generatevideo.GenerateID 
		AND useruploadvideo.UserUploadVideoId = @videoid;*/
		String queryString = "update Useruploadvideo u,Generatevideo g,Externaltask e set g.generateStatusFlag=4 " +
				"where g.generateId=e.taskId and e.userUploadVideoId=u.userUploadVideoId and u.userUploadVideoId=?";
		super.getHibernateTemplate().bulkUpdate(queryString, id);
	}

	@Override
	public void updateStatusByCameraId(Long id) {
		/* UPDATE tbl_camera, useruploadvideo, externaltask, generatevideo  
		    SET generatevideo.generate_status_flag = 4 
		    WHERE tbl_camera.ID=useruploadvideo.CameraID 
		        AND useruploadvideo.UserUploadVideoId = externaltask.UserUploadVideoId
		        AND externaltask.taskID = generatevideo.GenerateID 
		        AND tbl_camera.ID = @cameraid;*/
		String queryString = "update Camera c ,Useruploadvideo u,Generatevideo g,Externaltask e set g.generateStatusFlag=4 " +
				"where c.id=? and u.cameraId=c.id and u.userUploadVideoId=e.userUploadVideoId and  g.generateId=e.taskId";
		super.getHibernateTemplate().bulkUpdate(queryString, id);

	}

	@Override
	public void updateStatusByCaseId(Long id) {
		/*UPDATE tbl_case, tbl_camera, useruploadvideo, externaltask, generatevideo  
		   SET generatevideo.generate_status_flag = 4
		   WHERE tbl_case.ID = tbl_camera.caseID AND tbl_camera.ID=useruploadvideo.CameraID 
		       AND useruploadvideo.UserUploadVideoId = externaltask.UserUploadVideoId
		       AND externaltask.taskID = generatevideo.GenerateID 
		       AND tbl_case.ID = @caseid;*/
		String queryString = "update Case ca, Camera c ,Useruploadvideo u,Generatevideo g,Externaltask e set g.generateStatusFlag=4 " +
				"where ca.id=? and ca.id=c.caseId and u.cameraId=c.id and u.userUploadVideoId=e.userUploadVideoId and  g.generateId=e.taskId";
		super.getHibernateTemplate().bulkUpdate(queryString, id);
	}

	@Override
	public Generatevideo findByFlownumber(String flownumber) {
		/* SELECT g.generate_status_flag INTO @generate_status_flag 
		 * FROM generatevideo g, externaltask et WHERE 
		 * et.flowNumber = flownumber and et.taskID = g.GenerateID;
		*/
		String queryString = "select g from Generatevideo g, Externaltask et " +
				"where g.generateId=et.taskId and et.flowNumber=?";
		List list = super.getHibernateTemplate().find(queryString, flownumber);
		if (list.size() > 0) {
			return (Generatevideo) list.get(0);
		}
		return null;
	}

}
