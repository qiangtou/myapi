package cn.jiuling.distributedapi.dao;

import java.util.List;

import cn.jiuling.distributedapi.Vo.CaseVo;
import cn.jiuling.distributedapi.model.Case;

public interface CaseDao extends BaseDao<Case> {

	List<CaseVo> query(Integer startindex, Integer count, Integer sorttype, Integer isDescend);

}
