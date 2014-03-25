package cn.jiuling.distributedapi.dao;

import cn.jiuling.distributedapi.model.Assigntask;

public interface AssigntaskDao extends BaseDao<Assigntask> {

	public Assigntask findByUserIdAndVideoId(Long userid, Long id);

}
