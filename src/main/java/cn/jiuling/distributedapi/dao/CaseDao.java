package cn.jiuling.distributedapi.dao;

import java.sql.Timestamp;
import java.util.List;

import cn.jiuling.distributedapi.Vo.CaseVideoVo;
import cn.jiuling.distributedapi.model.Case;

public interface CaseDao extends BaseDao<Case> {

	public List<Case> query(Integer startindex, Integer count, Integer sorttype, Integer isDescend);

	public List<Case> searchCase(Integer type, String value, Timestamp time, Integer startindex, Integer count);

	public CaseVideoVo queryCaseVideo(Long caseid);

}
