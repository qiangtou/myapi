package cn.jiuling.distributedapi.service;

import java.util.List;

import cn.jiuling.distributedapi.Vo.DeletedObjVo;
import cn.jiuling.distributedapi.Vo.StatusInfoVo;
import cn.jiuling.distributedapi.Vo.SummaryResolutionVo;

public interface SysService {

	public StatusInfoVo queryStatusinfo();

	public void emptyfiledata();

	public void delete(Short type, Long id);

	public void addBackDeletedObj(Short type, Long id);

	public List<SummaryResolutionVo> querySummaryResolution();

	public String queryTubeBasicInfoFilename(String flowNumber, Long tubeID);

	public Short queryAutoTaskStatus(Long caseid, Long userid);

	public List<DeletedObjVo> queryDeletedObj();

}
