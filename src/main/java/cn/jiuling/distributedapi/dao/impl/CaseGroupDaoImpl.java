package cn.jiuling.distributedapi.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.jiuling.distributedapi.Vo.CaseGroupVo;
import cn.jiuling.distributedapi.dao.CaseGroupDao;
import cn.jiuling.distributedapi.model.CaseGroup;

@Repository("caseGroupDao")
public class CaseGroupDaoImpl extends BaseDaoImpl<CaseGroup> implements CaseGroupDao {

	@Override
	public List<CaseGroupVo> queryCaseGroup() {
		return getHibernateTemplate().find("select new cn.jiuling.distributedapi.Vo.CaseGroupVo(c.id,c.title,c.description,c.creator) from CaseGroup c");
	}

}
