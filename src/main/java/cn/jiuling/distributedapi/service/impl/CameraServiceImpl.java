package cn.jiuling.distributedapi.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import cn.jiuling.distributedapi.Vo.CameraVo;
import cn.jiuling.distributedapi.Vo.Status;
import cn.jiuling.distributedapi.dao.CameraDao;
import cn.jiuling.distributedapi.exception.ServiceException;
import cn.jiuling.distributedapi.model.Camera;
import cn.jiuling.distributedapi.service.CameraService;

@Service("cameraService")
public class CameraServiceImpl implements CameraService {

	@Resource
	private CameraDao cameraDao;

	@Override
	public void addCamera(Camera c) {
		try {
			cameraDao.save(c);
		} catch (Exception e) {
			throw new ServiceException(Status.CAMERA_ADD_ERROR, e);
		}

	}

	@Override
	public void modifyCamera(Camera c) {
		try {
			Camera camera = cameraDao.load(c.getId());
			BeanUtils.copyProperties(c, camera, new String[] { "caseId", "createtime", "ownerid", "isDeleted" });
			cameraDao.save(camera);
		} catch (Exception e) {
			throw new ServiceException(Status.CAMERA_MODIFY_ERROR, e);
		}

	}

	@Override
	public List queryCameraByCaseId(Long caseid) {
		try {
			List list = cameraDao.queryCamera("caseId", caseid);
			return copyList(list);
		} catch (Exception e) {
			throw new ServiceException(Status.CAMERA_QUERY_ERROR, e);
		}
	}

	private List copyList(List list) {
		List newList = new ArrayList();
		CameraVo cv;
		if (list.size() > 0) {
			for (int i = 0, j = list.size(); i < j; i++) {
				cv = new CameraVo();
				BeanUtils.copyProperties(list.get(i), cv);
				newList.add(cv);
			}
		}
		return newList;
	}

	@Override
	public List queryCameraByCameraid(Long cameraid) {
		try {
			List list = cameraDao.queryCamera("id", cameraid);
			return copyList(list);
		} catch (Exception e) {
			throw new ServiceException(Status.CAMERA_QUERY_ERROR, e);
		}
	}
}
