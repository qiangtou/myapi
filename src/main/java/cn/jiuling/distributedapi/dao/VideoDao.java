package cn.jiuling.distributedapi.dao;

import java.util.List;

import cn.jiuling.distributedapi.Vo.ListResultVo;
import cn.jiuling.distributedapi.Vo.SnapGenInfoVo;
import cn.jiuling.distributedapi.Vo.StatusInfoVo;
import cn.jiuling.distributedapi.Vo.UnAssignVideoVo;
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

}
