package cn.jiuling.distributedapi.dao;

import cn.jiuling.distributedapi.model.Autoanalyseparam;

public interface AutoanalyseparamDao extends BaseDao<Autoanalyseparam> {

	public Autoanalyseparam findByCaseIdAndUserId(Long caseid, Long userid);

}
