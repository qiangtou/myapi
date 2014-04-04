package cn.jiuling.distributedapi.dao;

import cn.jiuling.distributedapi.model.Tube;

public interface TubeDao extends BaseDao<Tube> {

	Tube findByFlowNumber(String flowNumber, Long tubeID);

}
