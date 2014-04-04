package cn.jiuling.distributedapi.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import cn.jiuling.distributedapi.Vo.DeletedObjVo;
import cn.jiuling.distributedapi.Vo.Status;
import cn.jiuling.distributedapi.Vo.StatusInfoVo;
import cn.jiuling.distributedapi.Vo.SummaryResolutionVo;
import cn.jiuling.distributedapi.dao.AnalysisvideoDao;
import cn.jiuling.distributedapi.dao.BaseDao;
import cn.jiuling.distributedapi.dao.CameraDao;
import cn.jiuling.distributedapi.dao.CaseDao;
import cn.jiuling.distributedapi.dao.ConfigDao;
import cn.jiuling.distributedapi.dao.ExternaltaskDao;
import cn.jiuling.distributedapi.dao.GeneratevideoDao;
import cn.jiuling.distributedapi.dao.GisDao;
import cn.jiuling.distributedapi.dao.SystemconfigDao;
import cn.jiuling.distributedapi.dao.TubeDao;
import cn.jiuling.distributedapi.dao.VideoDao;
import cn.jiuling.distributedapi.dao.VlprTaskDao;
import cn.jiuling.distributedapi.exception.ServiceException;
import cn.jiuling.distributedapi.model.Analysisvideo;
import cn.jiuling.distributedapi.model.Camera;
import cn.jiuling.distributedapi.model.Case;
import cn.jiuling.distributedapi.model.Config;
import cn.jiuling.distributedapi.model.Externaltask;
import cn.jiuling.distributedapi.model.Systemconfig;
import cn.jiuling.distributedapi.model.Tube;
import cn.jiuling.distributedapi.model.Useruploadvideo;
import cn.jiuling.distributedapi.model.VlprTask;
import cn.jiuling.distributedapi.service.SysService;
import cn.jiuling.distributedapi.utils.DiskSpaceUtils;
import cn.jiuling.distributedapi.utils.FileUtils;
import cn.jiuling.distributedapi.utils.PathUtils;
import cn.jiuling.distributedapi.utils.RegUtils;

@Service("sysService")
public class SysServiceImpl implements SysService {
	private final Logger log = Logger.getLogger(SysServiceImpl.class);
	@Resource
	private VideoDao videoDao;
	@Resource
	private BaseDao baseDao;
	@Resource
	private ExternaltaskDao externaltaskDao;
	@Resource
	private GeneratevideoDao generatevideoDao;
	@Resource
	private CameraDao cameraDao;
	@Resource
	private ConfigDao configDao;
	@Resource
	private SystemconfigDao systemconfigDao;
	@Resource
	private GisDao gisDao;
	@Resource
	private CaseDao caseDao;
	@Resource
	private VlprTaskDao vlprTaskDao;
	@Resource
	private AnalysisvideoDao analysisvideoDao;
	@Resource
	private TubeDao tubeDao;

	@Override
	public StatusInfoVo queryStatusinfo() {
		try {
			StatusInfoVo s = videoDao.getStatusInfo();
			s.setSummarySpace(DiskSpaceUtils.getUsableSpace());
			long ftpSpace = DiskSpaceUtils.getUsableSpace(RegUtils.getFtpPath());
			s.setFtpSpace(ftpSpace);
			return s;
		} catch (Exception e) {
			throw new ServiceException(Status.QUERY_ERROR, e);
		}
	}

	@Override
	public void emptyfiledata() {
		try {
			// 清除表数据
			/*"analysisvideo","bkgimage","externaltask","generatevideo","object","objectframe","objectsearchresult",
			"orgvideolist","tube","tubesnapshotinfo","tubesuminfo","useruploadvideo"*/
			String toDeleteEntity = "Analysisvideo,Bkgimage,Externaltask,Generatevideo,Object,Objectframe,Objectsearchresult,Orgvideolist,Tube,Tubesnapshotinfo,Tubesuminfo,Useruploadvideo";
			String entityArr[] = toDeleteEntity.split(",");
			for (String entity : entityArr) {
				baseDao.deleteAllByEntity(entity);
			}

			// 删除文件夹及其子文件夹
			String toDeleteDir = "data,zip,temp,orgvideos,videoclip,result";
			String dirArr[] = toDeleteDir.split(",");
			String webRoot = PathUtils.getWebRoot();
			String path;
			for (String dir : dirArr) {
				path = webRoot + File.separator + dir;
				log.info("删除文件夹:" + path);
				FileUtils.deleteDirectory(path);
			}
			// 把ftp路径下面的文件也删掉
			String ftpPath = RegUtils.getFtpPath();
			log.info("删除ftp文件夹:" + ftpPath);
			FileUtils.deleteDirectory(ftpPath);

		} catch (Exception e) {
			throw new ServiceException(Status.EXECUTE_ERROR, e);
		}

	}

	@Override
	public void delete(Short type, Long id) {
		try {
			if (type == 0) {
				deleteTask(id);
			} else if (type == 1) {
				deleteVideo(id);
			} else if (type == 2) {
				deleteCamera(id);
			} else if (type == 3) {
				deleteCase(id);
			} else if (type == 4) {
				deleteVLPRTask(id);
			} else if (type == 5) {
				deleteTask(id);
			} else {
				throw new ServiceException(Status.TYPE_ERROR);
			}
		} catch (Exception e) {
			throw new ServiceException(Status.EXECUTE_ERROR, e);
		}
	}

	private void deleteVLPRTask(Long id) throws IOException {
		VlprTask v = vlprTaskDao.get(id);
		if (v == null) {
			throw new ServiceException(Status.OBJECT_IS_NOT_EXIST);
		}
		v.setTaskFlag(Short.valueOf("2"));
		vlprTaskDao.update(v);
	}

	private void deleteCase(Long id) throws IOException {
		Case c = caseDao.get(id);
		if (c.getIsDeleted() == 0) {
			// 回收站模式
			c.setIsDeleted(Short.valueOf("1"));
			caseDao.update(c);
			return;
		}

		Config cc = configDao.getConfig();
		Systemconfig s = systemconfigDao.getSystemconfig();
		String dataPath = cc.getDataPath();
		String uploadDirectory = s.getId().getUploadDirectory();
		String separator = File.separator;
		String casePath = dataPath + separator + "AstVS_1v2" + separator + "orgvideos" + separator + c.getId();
		String srcCameraPath = uploadDirectory + c.getId();
		FileUtils.deleteDirectory(casePath);
		FileUtils.deleteDirectory(srcCameraPath);

		generatevideoDao.updateStatusByCaseId(id);
		externaltaskDao.deleteByCaseId(id);
		videoDao.deleteByCaseId(id);
		gisDao.deleteByCaseId(id);
		cameraDao.deleteByCaseId(id);
		caseDao.delete(c);

	}

	private void deleteCamera(Long id) throws IOException {
		Camera c = cameraDao.get(id);
		if (c.getIsDeleted() == 0) {
			// 回收站模式
			c.setIsDeleted(Short.valueOf("1"));
			cameraDao.update(c);
			return;
		}
		if (c.getCaseId() == null) {
			// caseId为空?
			throw new ServiceException(Status.DEL_ERROR);
		}
		Config cc = configDao.getConfig();
		Systemconfig s = systemconfigDao.getSystemconfig();
		String dataPath = cc.getDataPath();
		String uploadDirectory = s.getId().getUploadDirectory();
		String separator = File.separator;
		String cameraPath = dataPath + separator + "AstVS_1v2" + separator + "orgvideos" + separator + c.getCaseId() + separator + c.getId();
		String srcCameraPath = uploadDirectory + c.getCaseId() + separator + c.getId();
		FileUtils.deleteDirectory(cameraPath);
		FileUtils.deleteDirectory(srcCameraPath);

		generatevideoDao.updateStatusByCameraId(id);
		externaltaskDao.deleteByCameraId(id);
		videoDao.deleteByCameraId(id);
		gisDao.deleteByCameraId(id);
		cameraDao.delete(c);
	}

	private void deleteVideo(Long id) throws IOException {
		Useruploadvideo u = videoDao.load(id);
		if (u.getIsDeleted() == 0) {
			// 回收站模式
			u.setIsDeleted(Short.valueOf("1"));
			videoDao.update(u);
			return;
		}
		if (null == u.getCameraId()) {
			// cameraId为空??
			throw new ServiceException(Status.DEL_ERROR);
		}

		generatevideoDao.updateStatusByVideoId(id);
		externaltaskDao.deleteByVideoId(id);
		// 返回
		FileUtils.deleteFile(u.getSrcUrl());
		FileUtils.deleteFile(u.getDestUrl());
		videoDao.delete(u);
	}

	private void deleteTask(Long id) {
		Externaltask e = externaltaskDao.findBy("flownumber", id.toString());
		if (e == null) {
			throw new ServiceException(Status.OBJECT_IS_NOT_EXIST);
		}
		e.getTaskId();
		generatevideoDao.updateStatus(e.getTaskId());
		externaltaskDao.delete(e);
	}

	@Override
	public void addBackDeletedObj(Short type, Long id) {
		try {
			/* CASE _type
			  WHEN 1 THEN UPDATE useruploadvideo u SET u.is_deleted = 0 WHERE u.useruploadvideoid = id; 
			  WHEN 2 THEN UPDATE tbl_camera m SET m.is_deleted = 0 WHERE m.id = id; 
				WHEN 3 THEN UPDATE tbl_case c SET c.is_deleted = 0 WHERE c.id = id; 
			  ELSE 
			    SELECT 1001 INTO iErrorCode;*/
			Short UN_DELETED = 0;
			if (type == 1) {
				Useruploadvideo u = videoDao.get(id);
				if (u != null) {
					u.setIsDeleted(UN_DELETED);
					videoDao.update(u);
				}
			} else if (type == 2) {
				Camera c = cameraDao.get(id);
				if (c != null) {
					c.setIsDeleted(UN_DELETED);
					cameraDao.update(c);
				}
			} else if (type == 3) {
				Case c = caseDao.get(id);
				c.setIsDeleted(UN_DELETED);
				caseDao.update(c);
			} else {
				throw new ServiceException(Status.TYPE_ERROR);
			}
		} catch (Exception e) {
			throw new ServiceException(Status.ADD_ERROR, e);
		}

	}

	@Override
	public List<SummaryResolutionVo> querySummaryResolution() {
		try {
			Short summaryResolution = 0;
			Systemconfig s = systemconfigDao.getSystemconfig();
			if (s != null) {
				summaryResolution = s.getId().getSummaryResolution();
				if (summaryResolution == null) {
					summaryResolution = 0;
				}
			}
			SummaryResolutionVo v;
			List<SummaryResolutionVo> list = new ArrayList<SummaryResolutionVo>();
			if (summaryResolution >= 0 && summaryResolution < 20) {
				v = new SummaryResolutionVo(0, "自适应", -1, -1);
				list.add(v);
				if (summaryResolution >= 0) {
					v = new SummaryResolutionVo(0, "cif(352*288)", 288, 352);
					list.add(v);
				}
				if (summaryResolution >= 1) {
					v = new SummaryResolutionVo(1, "4cif D1(704*576)", 576, 704);
					list.add(v);
				}
				if (summaryResolution >= 2) {
					v = new SummaryResolutionVo(2, "720P/i(1280*720)", 720, 1280);
					list.add(v);
				}
				if (summaryResolution >= 3) {
					v = new SummaryResolutionVo(3, "1080p/i(1920*1080)", 1080, 1920);
					list.add(v);
				}
			} else if (summaryResolution >= 20 && summaryResolution < 40) {
				if (summaryResolution >= 20) {
					v = new SummaryResolutionVo(0, "*/i(***)", 0, 0);
					list.add(v);
				}
				if (summaryResolution >= 20) {
					v = new SummaryResolutionVo(1, "cif(352*288)", 288, 352);
					list.add(v);
				}
			}
			return list;
		} catch (Exception e) {
			throw new ServiceException(Status.QUERY_ERROR, e);
		}
	}

	@Override
	public String queryTubeBasicInfoFilename(String flowNumber, Long tubeID) {
		try {
			Externaltask e = externaltaskDao.findBy("flowNumber", flowNumber);
			if (null == e) {
				throw new ServiceException(Status.OBJECT_IS_NOT_EXIST);
			}
			String fileUrl = "";
			if (tubeID == null) {
				// 查询任务内所有对象的tbi
				Analysisvideo a = analysisvideoDao.findByFlowNumber(flowNumber);
				if (a != null) {
					fileUrl = a.getCompleteTbiFilename();
					if (!StringUtils.isEmpty(fileUrl)) {
						fileUrl = fileUrl.replace(File.separator + "AstVS_1v2", "");
					}
				}
			} else {
				// 查询任务内单个对象的tbi
				Tube t = tubeDao.findByFlowNumber(flowNumber, tubeID);
				if (t != null) {
					fileUrl = t.getTbiFilename();
					if (!StringUtils.isEmpty(fileUrl)) {
						int index = fileUrl.indexOf("AstVS_1v2");
						if (index > -1) {
							fileUrl = fileUrl.substring(index + 9);
						}
					}
				}
			}
			return fileUrl;
		} catch (Exception e) {
			throw new ServiceException(Status.QUERY_ERROR, e);
		}

	}

	@Override
	public Short queryAutoTaskStatus(Long caseid, Long userid) {
		try {
			Long count = videoDao.queryAutoTask(caseid, userid);
			short status;
			if (count == 0) {
				status = 1;
			} else {
				status = 0;
			}
			return status;
		} catch (Exception e) {
			throw new ServiceException(Status.QUERY_ERROR, e);
		}
	}

	@Override
	public List<DeletedObjVo> queryDeletedObj() {
		try {
			List<DeletedObjVo> list = new ArrayList<DeletedObjVo>();
			List subList = videoDao.queryDeleted();
			list.addAll(subList);
			subList = caseDao.queryDeleted();
			list.addAll(subList);
			subList = cameraDao.queryDeleted();
			list.addAll(subList);
			return list;
		} catch (Exception e) {
			throw new ServiceException(Status.QUERY_ERROR, e);
		}
	}
}
