package cn.jiuling.distributedapi.dao;

import cn.jiuling.distributedapi.Vo.ReturnData;
import cn.jiuling.distributedapi.model.EnhanceTask;

public interface EnhanceTaskDao extends BaseDao<EnhanceTask> {

	public ReturnData findByEnhanceType(String string, Integer startindex, Integer count);

}
