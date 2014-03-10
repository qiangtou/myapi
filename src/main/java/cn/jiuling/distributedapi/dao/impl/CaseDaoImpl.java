package cn.jiuling.distributedapi.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import cn.jiuling.distributedapi.Vo.CaseVo;
import cn.jiuling.distributedapi.dao.CaseDao;
import cn.jiuling.distributedapi.model.Case;

@Repository("caseDao")
public class CaseDaoImpl extends BaseDaoImpl<Case> implements CaseDao {

	public List<CaseVo> query(Integer startindex, Integer count, Integer sorttype, Integer isDescend) {
		// TODO queryCase

		DetachedCriteria criteria = DetachedCriteria.forClass(Case.class);
		/**
		 * 0:createtime 1:ocurredtime 2:style 3:class 4:serialnumber
		 */
		String sortBy = "createtime";

		if (null == isDescend) {
			isDescend = Integer.valueOf(-1);
		}
		if (null == count) {
			count = Integer.valueOf(1);
		}

		// 0升序,1降序,默认降序
		Order order = isDescend == 0 ? Order.asc(sortBy) : Order.desc(sortBy);
		criteria.addOrder(order);
		List caseList = getHibernateTemplate().findByCriteria(criteria, startindex, count);
		return caseList;
	}
}
