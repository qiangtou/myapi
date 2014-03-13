package cn.jiuling.distributedapi.service.impl;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import cn.jiuling.distributedapi.Vo.DownloadTasks4ListVo;
import cn.jiuling.distributedapi.Vo.DownloadTasksVo;
import cn.jiuling.distributedapi.Vo.Status;
import cn.jiuling.distributedapi.Vo.VideoVo;
import cn.jiuling.distributedapi.dao.DownloadtasksDao;
import cn.jiuling.distributedapi.dao.ScheduletasksDao;
import cn.jiuling.distributedapi.dao.VideoDao;
import cn.jiuling.distributedapi.exception.ServiceException;
import cn.jiuling.distributedapi.model.Downloadtasks;
import cn.jiuling.distributedapi.model.Scheduletasks;
import cn.jiuling.distributedapi.model.Useruploadvideo;
import cn.jiuling.distributedapi.service.VideoService;

@Service("videoService")
public class VideoServiceImpl implements VideoService {
	@Resource
	private VideoDao videoDao;
	@Resource
	private DownloadtasksDao downloadtasksDao;
	@Resource
	private ScheduletasksDao scheduletasksDao;

	@Override
	public List queryVideo(Long cameraid, Long userid) {
		try {
			List list = videoDao.queryVideo(cameraid, userid);
			return copyList(list);
		} catch (Exception e) {
			throw new ServiceException(Status.VIDEO_QUERY_SUCCESS, e);
		}
	}

	private List copyList(List list) {
		List newList = new ArrayList();
		VideoVo cv;
		if (list.size() > 0) {
			for (int i = 0, j = list.size(); i < j; i++) {
				cv = new VideoVo();
				BeanUtils.copyProperties(list.get(i), cv);
				// TODO 处理downloadURL
				newList.add(cv);
			}
		}
		return newList;
	}

	@Override
	public void modifyVideo(Long videoid, Timestamp recordTime, Long userid) {
		try {
			Useruploadvideo v = videoDao.load(videoid);
			v.setRecordTime(recordTime);
			v.setUserid(userid);
			videoDao.update(v);
		} catch (Exception e) {
			throw new ServiceException(Status.VIDEO_MODIFY_ERROR, e);
		}

	}

	@Override
	public long add3rdVideo(Long cameraId, String srcUrl, String platformName, Short isAutoSubmit) {
		try {
			// TODO add3rdVideo
			long id = 0;
			if (null == platformName) {
				platformName = srcUrl.startsWith("http") ? "http链接" : "";
			}

			if (srcUrl.contains("schedule=1")) {
				Scheduletasks s = new Scheduletasks();
				int startIndex = srcUrl.indexOf("starttime=");
				int endIndex = srcUrl.indexOf("endtime=");
				if (startIndex > -1 && endIndex > -1) {
					String startTime = srcUrl.substring(startIndex + 10, 8);
					String endTime = srcUrl.substring(startIndex + 8, 8);
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					s.setEndTime(new Time(sdf.parse(endTime).getTime()));
					s.setStartTime(new Time(sdf.parse(startTime).getTime()));
				}
				s.setCameraId(cameraId);
				s.setSrcUrl(srcUrl);
				s.setPlatformName(platformName);
				s.setIsAutoSubmit(isAutoSubmit);
				scheduletasksDao.save(s);
				id = s.getId();
			} else {
				Downloadtasks d = new Downloadtasks();
				d.setCameraId(cameraId);
				d.setSrcUrl(srcUrl);
				d.setPlatformName(platformName);
				d.setIsAutoSubmit(isAutoSubmit);
				downloadtasksDao.save(d);
				id = d.getId();
			}
			return id;
		} catch (Exception e) {
			throw new ServiceException(Status.VIDEO_ADD_ERROR, e);
		}
	}

	@Override
	public DownloadTasksVo query3rdVideoStatus(Long id) {
		try {
			Downloadtasks d = downloadtasksDao.load(id);
			DownloadTasksVo dv = new DownloadTasksVo();
			BeanUtils.copyProperties(d, dv);
			return dv;
		} catch (Exception e) {
			throw new ServiceException(Status.VIDEO_QUERY_ERROR, e);
		}
	}

	@Override
	public List query3rdVideoList(Long cameraid, Short status, Timestamp start, Timestamp end, Integer index, Integer count) {
		try {
			List list = downloadtasksDao.query3rdVideoList(cameraid, status, start, end, index, count);
			return copy3rdVideoList(list);
		} catch (Exception e) {
			throw new ServiceException(Status.VIDEO_QUERY_ERROR, e);
		}

	}

	private List copy3rdVideoList(List list) {
		List newList = new ArrayList();
		DownloadTasks4ListVo cv;
		if (list.size() > 0) {
			for (int i = 0, j = list.size(); i < j; i++) {
				cv = new DownloadTasks4ListVo();
				BeanUtils.copyProperties(list.get(i), cv);
				newList.add(cv);
			}
		}
		return newList;
	}

}
