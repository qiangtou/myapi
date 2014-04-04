package cn.jiuling.distributedapi.dao;

import java.util.List;

import cn.jiuling.distributedapi.Vo.AssignedtaskVo;
import cn.jiuling.distributedapi.Vo.ListResultVo;
import cn.jiuling.distributedapi.Vo.PicEnhanceListVo;
import cn.jiuling.distributedapi.Vo.SnapGenInfoVo;
import cn.jiuling.distributedapi.Vo.SnapshotFolderVo;
import cn.jiuling.distributedapi.Vo.SnapshotVo;
import cn.jiuling.distributedapi.Vo.StatusInfoVo;
import cn.jiuling.distributedapi.Vo.UnAssignVideoVo;
import cn.jiuling.distributedapi.Vo.VideoEnhanceListVo;
import cn.jiuling.distributedapi.model.Useruploadvideo;

public interface VideoDao extends BaseDao<Useruploadvideo> {

	public List queryVideo(Long cameraid, Long userid);

	/**
	 * 检查磁盘空间及服务器LOAD状态
	 * 
	 * @return
	 */
	public StatusInfoVo getStatusInfo();

	public Useruploadvideo getBySrcAndDest(String srcURI, String destURI);

	public ListResultVo queryUploadFileList(String userid, Integer status, Long startTime, Long endTime, Integer index, Integer count);

	public SnapGenInfoVo querySnapGenInfo(Integer userUploadVideoId, Integer taskId);

	public List getVideosByCase(Integer caseid, Integer userid);

	public List getVideosByCamera(Integer cameraid, Integer userid);

	public List<UnAssignVideoVo> queryUnAssignVideo(Long caseid);

	public List<UnAssignVideoVo> queryunhandledtask(Long userid);

	public List<AssignedtaskVo> queryassignedtasklist(Long caseid);

	public List<VideoEnhanceListVo> queryVideoEnhanceList(String enhanceType);

	public List<PicEnhanceListVo> queryPicEnhanceList(String enhanceType);

	public void deleteByCameraId(Long id);

	public void deleteByCaseId(Long id);

	public Long queryAutoTask(Long caseid, Long userid);

	public List queryDeleted();

	public SnapshotFolderVo querySnapshotFolder(String flownumber);

	public SnapshotVo queryTubeSnapshot(Integer taskId, int index, int count, Short sortType, Short sortOrder, Short objType, Short objSize, String rgbInfo);

}
