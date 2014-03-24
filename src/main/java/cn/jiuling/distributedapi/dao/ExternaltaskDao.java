package cn.jiuling.distributedapi.dao;

import java.io.Serializable;
import java.util.List;

import cn.jiuling.distributedapi.Vo.QueryTaskVo;
import cn.jiuling.distributedapi.model.Externaltask;

public interface ExternaltaskDao extends BaseDao<Externaltask> {
	/**
	 * 相同taskName前缀任务数.
	 * 
	 * 如taskName分别为:taskName1,taskName2,taskName3,则返回任务数量3
	 * 
	 * @param id
	 *            视频id
	 * @param taskName
	 *            任务名前缀
	 * @return
	 */
	public Long findByTaskNameAndUserUploadVideoId(Serializable id, String taskName);

	public List<QueryTaskVo> queryTask(Integer uploadvideoid, String dataPath);

	public Externaltask getLastTask(Integer videoid);

}
