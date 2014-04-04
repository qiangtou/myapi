package cn.jiuling.distributedapi.dao;

import java.util.List;

import cn.jiuling.distributedapi.model.Gis;

public interface GisDao extends BaseDao<Gis> {

	public void deleteByCameraId(Long id);

	public void deleteByCaseId(Long id);

	public List queryGis(Short oBJECTTYPECASE, Long caseId);

	public List getCasesInfo();

	public List getCaseAndCamerasInfo(Integer caseId);

	public Gis getCasesInfo(Integer caseId);

}
