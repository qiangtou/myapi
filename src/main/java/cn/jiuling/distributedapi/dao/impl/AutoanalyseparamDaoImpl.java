package cn.jiuling.distributedapi.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.jiuling.distributedapi.dao.AutoanalyseparamDao;
import cn.jiuling.distributedapi.model.Autoanalyseparam;

@Repository("autoanalyseparamDao")
public class AutoanalyseparamDaoImpl extends BaseDaoImpl<Autoanalyseparam> implements AutoanalyseparamDao {

	@Override
	public Autoanalyseparam findByCaseIdAndUserId(Long caseid, Long userid) {
		String queryString = "from Autoanalyseparam a where a.caseid=? and a.userid=?";
		List list = getHibernateTemplate().find(queryString, new Long[] { caseid, userid });

		if (list.size() > 0) {
			return (Autoanalyseparam) list.get(0);
		}
		return null;
	}

}
