package cn.jiuling.distributedapi.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.jiuling.distributedapi.dao.SystemconfigDao;
import cn.jiuling.distributedapi.model.Systemconfig;

@Repository("systemconfigDao")
public class SystemconfigDaoImpl extends BaseDaoImpl<Systemconfig> implements SystemconfigDao {
	@Override
	public Systemconfig getSystemconfig() {
		List<Systemconfig> list = super.getAll();
		return list.get(0);
	}
}
