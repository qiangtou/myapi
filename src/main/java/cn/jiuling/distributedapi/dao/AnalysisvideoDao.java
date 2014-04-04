package cn.jiuling.distributedapi.dao;

import cn.jiuling.distributedapi.model.Analysisvideo;

public interface AnalysisvideoDao extends BaseDao<Analysisvideo> {

	public Analysisvideo getHeightAndwidth(String flowNumber);

	public Analysisvideo findByFlowNumber(String flowNumber);

}
