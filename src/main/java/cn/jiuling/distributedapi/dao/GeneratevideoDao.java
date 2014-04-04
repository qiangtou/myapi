package cn.jiuling.distributedapi.dao;

import cn.jiuling.distributedapi.model.Generatevideo;

public interface GeneratevideoDao extends BaseDao<Generatevideo> {

	public void updateStatus(Integer taskId);

	public void updateStatusByVideoId(Long id);

	public void updateStatusByCameraId(Long id);

	public void updateStatusByCaseId(Long id);

	public Generatevideo findByFlownumber(String flownumber);

}
