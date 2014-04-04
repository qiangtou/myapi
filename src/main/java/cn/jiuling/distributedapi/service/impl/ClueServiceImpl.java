package cn.jiuling.distributedapi.service.impl;

import java.io.File;
import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import cn.jiuling.distributedapi.Vo.CaseAndCamerasInfoRetVo;
import cn.jiuling.distributedapi.Vo.CaseInfoRetVo;
import cn.jiuling.distributedapi.Vo.CaseInfoVo;
import cn.jiuling.distributedapi.Vo.GisVo;
import cn.jiuling.distributedapi.Vo.Status;
import cn.jiuling.distributedapi.dao.CameraDao;
import cn.jiuling.distributedapi.dao.ClueDao;
import cn.jiuling.distributedapi.dao.CluestyleDao;
import cn.jiuling.distributedapi.dao.GeneratevideoDao;
import cn.jiuling.distributedapi.dao.GisDao;
import cn.jiuling.distributedapi.dao.MaterialDao;
import cn.jiuling.distributedapi.dao.TubesnapshotinfoDao;
import cn.jiuling.distributedapi.exception.ServiceException;
import cn.jiuling.distributedapi.model.Camera;
import cn.jiuling.distributedapi.model.Clue;
import cn.jiuling.distributedapi.model.Cluestyle;
import cn.jiuling.distributedapi.model.Generatevideo;
import cn.jiuling.distributedapi.model.Gis;
import cn.jiuling.distributedapi.model.Material;
import cn.jiuling.distributedapi.model.Tubesnapshotinfo;
import cn.jiuling.distributedapi.service.ClueService;
import cn.jiuling.distributedapi.utils.ConfigUtils;
import cn.jiuling.distributedapi.utils.FileUtils;
import cn.jiuling.distributedapi.utils.RegUtils;

@Service("clueService")
public class ClueServiceImpl implements ClueService {

	@Resource
	private ClueDao clueDao;
	@Resource
	private CameraDao cameraDao;
	@Resource
	private MaterialDao materialDao;
	@Resource
	private GeneratevideoDao generatevideoDao;
	@Resource
	private TubesnapshotinfoDao tubesnapshotinfoDao;
	@Resource
	private GisDao gisDao;
	@Resource
	private CluestyleDao cluestyleDao;

	/**
	 * 素材文件转移操作
	 * 
	 * 将注册表中的路径加上\\AstVS_1v2\\material\\, 并且将这个路径的盘符替换成传入的路径的盘符,
	 * 将文件复制到这个新生成的目录中去
	 * 
	 * @param filePath
	 *            传入绝对路径
	 * @return
	 * @throws Exception
	 */
	private File moveFile(String filePath) throws Exception {
		if (StringUtils.isEmpty(filePath)) {
			return null;
		}

		String dataPath = RegUtils.getDataPath() + "\\AstVS_1v2\\material\\";
		String orgDisk = FileUtils.getDisk(filePath);
		String dataPathDisk = FileUtils.getDisk(dataPath);
		dataPath = dataPath.replace(dataPathDisk, orgDisk);
		FileUtils.createDir(dataPath);
		return FileUtils.copy(filePath, dataPath + FileUtils.getFileName(filePath));
	}

	@Override
	public Material addvideomaterial(String title, Long tubeid, Long compid, Integer startframe, Integer framecount, Float framerate, Timestamp startcalibtime,
			Timestamp endcalibtime, Long cameraid, Short infoclass, String filename, String flownumber, Long videoid, Long clueid, Long caseid,
			String description, Short suspected, Short tagstyle, String tagtext, String style, String picname, Integer userid) {
		try {
			File f = moveFile(filename);
			filename = f.getAbsolutePath();
			if (clueid == null) {
				Clue c = clueDao.findByCase(caseid);
				if (c == null) {
					throw new ServiceException(Status.OBJECT_IS_NOT_EXIST);
				}
				clueid = c.getId();
			}
			Camera ca = cameraDao.get(cameraid);
			if (ca == null) {
				throw new ServiceException(Status.OBJECT_IS_NOT_EXIST);
			}
			List mList = materialDao.findByTitleAndClueId(title, clueid);
			if (mList.size() > 0) {
				throw new ServiceException(Status.OBJECT_IS_EXIST);
			}
			Generatevideo g = generatevideoDao.findByFlownumber(flownumber);
			if (g == null || g.getGenerateStatusFlag() == null || g.getGenerateStatusFlag() == 4) {
				throw new ServiceException(Status.STATUS_ERROR);
			}

			if (StringUtils.isEmpty(picname)) {
				Tubesnapshotinfo t = tubesnapshotinfoDao.findTubesnapshotinfo(flownumber, tubeid, compid);
				if (t != null) {
					picname = t.getFilename();
				}
			}

			Material m = new Material();
			/*(title,tubeid,compid,startframe,framecount,framerate,cameraid,startcalibtime,endcalibtime,infoclass,filename,flownumber,videoid, clueid,    style,description,suspected,tagstyle,tagtext,Edited,EditTime,EditorID,picname) 
			  (@title,tubeid,compid,startframe,framecount,framerate,cameraid,startcalibtime,endcalibtime,infoclass,filename,flownumber,videoid,@clueid,cluestyle,description,suspected,tagstyle,tagtext,     0,   now(),  userid,picname);
			*/m.setTitle(title);
			m.setTubeId(tubeid);
			m.setCompId(compid);
			m.setStartframe(startframe);
			m.setFrameCount(framecount);
			m.setFrameRate(framerate);
			m.setCameraid(cameraid);
			m.setStartcalibtime(startcalibtime);
			m.setEndcalibtime(endcalibtime);
			m.setInfoclass(infoclass);
			m.setFilename(filename);
			m.setFlownumber(Long.valueOf(flownumber));
			m.setVideoId(videoid);
			m.setClueId(clueid);
			m.setStyle(style);
			m.setDescription(description);
			m.setSuspected(suspected);
			m.setTagstyle(tagstyle);
			m.setTagtext(tagtext);
			m.setEdited(Short.valueOf("0"));
			m.setEditTime(new Timestamp(System.currentTimeMillis()));
			if (userid == null) {
				userid = -1;
			}
			m.setEditorId(userid.longValue());
			m.setPicname(picname);
			materialDao.save(m);
			return m;
		} catch (Exception e) {
			throw new ServiceException(Status.ADD_ERROR, e);
		}
	}

	@Override
	public void deletematerial(Long id) {
		try {
			Material m = materialDao.get(id);
			if (m == null) {
				throw new ServiceException(Status.OBJECT_IS_NOT_EXIST);
			}
			String fileName = m.getFilename();
			FileUtils.deleteFile(fileName);
			materialDao.delete(m);
		} catch (Exception e) {
			throw new ServiceException(Status.DEL_ERROR, e);
		}
	}

	@Override
	public void modifyMaterial(Long materialid, String title, Long tubeid, Integer compid, Timestamp starttime, Integer framesnumber, Float framerate,
			String cameratitle, Short infoclass, Long videoid, Long clueid, String description, Short suspected, String style, Integer startframe,
			Integer framecount, Timestamp endcalibtime, Short tagstyle, String tagtext) {
		try {
			Material m = materialDao.get(materialid);
			if (m == null || m.getTitle() == null) {
				throw new ServiceException(Status.OBJECT_IS_NOT_EXIST);
			}
			if (title != null) {
				m.setTitle(title);
			}
			if (tubeid != null) {
				m.setTubeId(tubeid);
			}
			if (compid != null) {
				m.setCompId(clueid);
			}
			if (startframe != null) {
				m.setStartframe(startframe);
			}
			if (framecount != null) {
				m.setFrameCount(framecount);
			}
			if (framerate != null) {
				m.setFrameRate(framerate);
			}
			if (starttime != null) {
				m.setStartcalibtime(starttime);
			}
			if (endcalibtime != null) {
				m.setEndcalibtime(endcalibtime);
			}
			if (infoclass != null) {
				m.setInfoclass(infoclass);
			}
			if (clueid != null) {
				m.setClueId(clueid);
			}
			if (style != null) {
				m.setStyle(style);
			}
			if (description != null) {
				m.setDescription(description);
			}
			if (suspected != null) {
				m.setSuspected(suspected);
			}
			if (tagstyle != null) {
				m.setTagstyle(tagstyle);
			}
			if (tagtext != null) {
				m.setTagtext(tagtext);
			}
			materialDao.update(m);
		} catch (Exception e) {
			throw new ServiceException(Status.MODIFY_ERROR, e);
		}
	}

	@Override
	public List queryMaterial(Short type, Long id) {
		try {
			Clue clue = clueDao.findBy("caseId", id);
			if (clue == null) {
				throw new ServiceException(Status.OBJECT_IS_NOT_EXIST);
			}
			List list = materialDao.queryMaterial(id);
			return list;
		} catch (Exception e) {
			throw new ServiceException(Status.QUERY_ERROR, e);
		}
	}

	@Override
	public GisVo queryGis(Short operateType, Short showType, Long objectId, Short objectType, Float xPos, Float yPos, Integer zoomLevel, String objectDesc) {
		Short OPERATE_TYPE_SHOW = 0;
		Short OPERATE_TYPE_ADD_OBJECT = 1;
		Short OPERATE_TYPE_MOD_OBJECT = 2;

		Short SHOW_TYPE_ALL = 0;
		Short SHOW_TYPE_ALL_CASE = 1;
		Short SHOW_TYPE_ALL_CAMERA = 2;
		Short SHOW_TYPE_SINGLE_CASE = 3;
		Short SHOW_TYPE_SINGLE_CAMERA = 4;

		Short OBJECT_TYPE_CASE = 1;
		Short OBJECT_TYPE_CAMERA = 2;
		Short OBJECT_ID_INVALID = 0;
		Short DB_OBJECT_ID_ALL = null;
		Short DB_OBJECT_ID_INVALID = 0;

		try {
			String gis_init_longitude = ConfigUtils.getValue("gis_init_longitude");
			String gis_init_latitude = ConfigUtils.getValue("gis_init_latitude");
			Long caseId;
			if (objectType.intValue() == OBJECT_TYPE_CASE.intValue()) {
				caseId = objectId;
			} else {
				caseId = queryCameraDetailInfo(objectId);
			}
			boolean isObjectExistsOnMap = false;
			boolean isParentCaseExistsOnMap = false;
			List list;
			String objectTypeName = "";
			if (operateType.intValue() == OPERATE_TYPE_ADD_OBJECT.intValue()) {
				if (objectType.intValue() == OBJECT_TYPE_CASE.intValue()) {
					showType = SHOW_TYPE_ALL_CASE;
					objectTypeName = "案件";
				} else {
					showType = SHOW_TYPE_SINGLE_CASE;
					objectTypeName = "监控点";
					// 判断监控点所属的案件是否已添加到地图上了
					list = gisDao.queryGis(OBJECT_TYPE_CASE, caseId);
					isParentCaseExistsOnMap = list.size() > 0;
					// 查询监控点是否已添加到地图上了
					list = gisDao.queryGis(OBJECT_TYPE_CAMERA, caseId);
					isObjectExistsOnMap = list.size() > 0;
				}
			}

			GisVo g = new GisVo();
			/*boolean isObjectExistsOnMap;
			boolean isParentCaseExistsOnMap;
			Short operateType;
			Short showType;
			Short objectType;
			Long objectId;
			Long caseId;
			String objectDesc;
			Float xPosition;
			Float yPosition;*/
			g.setCaseId(caseId);
			g.setObjectType(objectType);
			g.setOperateType(operateType);
			g.setShowType(showType);
			g.setObjectDesc(objectDesc);
			g.setObjectId(objectId);
			g.setxPosition(xPos);
			g.setyPosition(yPos);
			g.setIsObjectExistsOnMap(isObjectExistsOnMap);
			g.setIsParentCaseExistsOnMap(isParentCaseExistsOnMap);
			g.setZoomLevel(zoomLevel);
			g.setInitLatitude(gis_init_latitude);
			g.setInitLongitude(gis_init_longitude);
			return g;
		} catch (Exception e) {
			throw new ServiceException(Status.QUERY_ERROR, e);
		}
	}

	private Long queryCameraDetailInfo(Long objectId) {
		Camera c = cameraDao.get(objectId);
		if (null == c) {
			throw new ServiceException(Status.OBJECT_IS_NOT_EXIST);
		}
		return c.getCaseId();
	}

	@Override
	public Object queryGisGetObject(Integer caseId) {
		try {
			List list;
			int size;
			if (caseId == null) {
				CaseInfoRetVo cv = new CaseInfoRetVo();
				list = gisDao.getCasesInfo();
				size = list.size();
				cv.setRet(size > 0 ? 1 : 0);
				cv.setCaseInfoList(list);
				return cv;
			} else {
				CaseAndCamerasInfoRetVo cv = new CaseAndCamerasInfoRetVo();
				Gis gis = gisDao.getCasesInfo(caseId);
				CaseInfoVo c = new CaseInfoVo();
				if (gis != null) {
					BeanUtils.copyProperties(gis, c);
					cv.setCaseInfo(c);
				}
				list = gisDao.getCaseAndCamerasInfo(caseId);
				size = list.size();
				cv.setRet(size > 0 ? 1 : 0);
				cv.setCameraInfoList(list);
				return cv;
			}
		} catch (Exception e) {
			throw new ServiceException(Status.QUERY_ERROR, e);
		}
	}

	@Override
	public void saveOrUpdateClueStyle(String cluestyle) {
		try {
			Cluestyle c = new Cluestyle();
			c.setId(1L);
			c.setTitle(cluestyle);
			cluestyleDao.saveOrUpdate(c);
		} catch (Exception e) {
			throw new ServiceException(Status.EXECUTE_ERROR, e);
		}

	}

	@Override
	public String queryClueStyle() {
		try {
			String clueStyle = "";
			Cluestyle c = cluestyleDao.get(1L);
			if (null != c) {
				clueStyle = c.getTitle();
			}
			return clueStyle;
		} catch (Exception e) {
			throw new ServiceException(Status.EXECUTE_ERROR, e);
		}
	}
}
