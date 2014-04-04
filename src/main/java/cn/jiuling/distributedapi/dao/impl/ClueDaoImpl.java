package cn.jiuling.distributedapi.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.jiuling.distributedapi.dao.ClueDao;
import cn.jiuling.distributedapi.model.Clue;

@Repository("clueDao")
public class ClueDaoImpl extends BaseDaoImpl<Clue> implements ClueDao {

	@Override
	public Clue findByCase(Long caseid) {
		/*SELECT c.id INTO @clueid FROM tbl_Clue c WHERE c.caseid = @caseid 
		AND c.classified = 255 LIMIT 1; */
		String queryString = "from Clue c where c.caseId=? and c.classified=255";

		List list = super.getHibernateTemplate().find(queryString, caseid);
		if (list.size() > 0) {
			return (Clue) list.get(0);
		}
		return null;
	}

}
