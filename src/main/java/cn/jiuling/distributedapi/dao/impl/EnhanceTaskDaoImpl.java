package cn.jiuling.distributedapi.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.jiuling.distributedapi.Vo.ReturnData;
import cn.jiuling.distributedapi.dao.EnhanceTaskDao;
import cn.jiuling.distributedapi.model.EnhanceTask;

@Repository("enhanceTaskDao")
public class EnhanceTaskDaoImpl extends BaseDaoImpl<EnhanceTask> implements EnhanceTaskDao {

	@Override
	public ReturnData findByEnhanceType(String enhanceType, Integer startindex, Integer count) {
		String queryString = "select new cn.jiuling.distributedapi.Vo.EnhanceTaskEleVo(e.taskId,e.stateFlag) from EnhanceTask e where e.enhanceType='"
				+ enhanceType + "'";
		Long totalCount = super.getCount(queryString);
		List list = super.find(queryString, startindex, count);
		ReturnData rd = new ReturnData(totalCount, list);
		return rd;
	}
}
