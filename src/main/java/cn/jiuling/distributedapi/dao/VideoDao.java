package cn.jiuling.distributedapi.dao;

import java.util.List;

import cn.jiuling.distributedapi.Vo.StatusInfoVo;
import cn.jiuling.distributedapi.model.Useruploadvideo;

public interface VideoDao extends BaseDao<Useruploadvideo> {

	public List queryVideo(Long cameraid, Long userid);

	/**
	 * 检查磁盘空间及服务器LOAD状态
	 * 
	 * @return
	 */
	public StatusInfoVo getStatusInfo();

}
