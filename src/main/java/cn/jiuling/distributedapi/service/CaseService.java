package cn.jiuling.distributedapi.service;

import java.util.List;

import cn.jiuling.distributedapi.Vo.CaseGroupVo;
import cn.jiuling.distributedapi.Vo.CaseVo;
import cn.jiuling.distributedapi.model.Case;
import cn.jiuling.distributedapi.model.CaseGroup;

public interface CaseService {

	public CaseGroup addCaseGroup(String username, String grouptitle, String description);

	public void deleteCaseGroup(Long groupid);

	public void modifyCaseGroup(CaseGroup caseGroup);

	public List<CaseGroupVo> queryCaseGroup();

	public void addCase(Case c);

	public void modifyCase(Case c);

	public List<CaseVo> queryCase(Integer startindex, Integer count, Integer sorttype, Integer isDescend);

}
