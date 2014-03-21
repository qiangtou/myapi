package cn.jiuling.distributedapi.dao;

import java.sql.Timestamp;
import java.util.List;

import cn.jiuling.distributedapi.Vo.HistoryTaskListVo;
import cn.jiuling.distributedapi.model.Downloadtasks;

public interface DownloadtasksDao extends BaseDao<Downloadtasks> {

	public List query3rdVideoList(Long cameraid, Short status, Timestamp start, Timestamp end, Integer index, Integer count);

	public List<HistoryTaskListVo> queryHistoryTaskListList(String userid, Integer status, Timestamp startTime, Timestamp endTime);

}
