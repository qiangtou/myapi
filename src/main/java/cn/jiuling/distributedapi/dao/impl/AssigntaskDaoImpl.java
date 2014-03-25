package cn.jiuling.distributedapi.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.jiuling.distributedapi.dao.AssigntaskDao;
import cn.jiuling.distributedapi.model.Assigntask;

@Repository("assigntaskDao")
public class AssigntaskDaoImpl extends BaseDaoImpl<Assigntask> implements AssigntaskDao {

	@Override
	public Assigntask findByUserIdAndVideoId(Long userid, Long id) {
		String queryString = "from Assigntask a where a.userId=? and a.userUploadVideoId=?";
		List list = super.getHibernateTemplate().find(queryString, new Long[] { userid, id });
		if (list.size() > 0) {
			return (Assigntask) list.get(0);
		}
		return null;
	}

}
