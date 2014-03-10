package cn.jiuling.distributedapi.dao;

import java.util.List;

import cn.jiuling.distributedapi.Vo.CaseGroupVo;
import cn.jiuling.distributedapi.model.CaseGroup;

public interface CaseGroupDao extends BaseDao<CaseGroup> {

	public List<CaseGroupVo> queryCaseGroup();

}
