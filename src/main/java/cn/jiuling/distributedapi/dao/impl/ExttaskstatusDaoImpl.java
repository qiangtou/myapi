package cn.jiuling.distributedapi.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.jiuling.distributedapi.dao.ExttaskstatusDao;
import cn.jiuling.distributedapi.model.Exttaskstatus;

@Repository("exttaskstatusDao")
public class ExttaskstatusDaoImpl extends BaseDaoImpl<Exttaskstatus> implements ExttaskstatusDao {

	@Override
	public Exttaskstatus getExttaskstatus(String flowNumber) {
		String queryString = "from Exttaskstatus e where e.id.flowNumber=?";
		List<Exttaskstatus> list = getHibernateTemplate().find(queryString, flowNumber);
		return list.size() > 0 ? list.get(0) : null;
	}
}
