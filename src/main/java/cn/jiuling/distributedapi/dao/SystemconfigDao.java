package cn.jiuling.distributedapi.dao;

import cn.jiuling.distributedapi.model.Systemconfig;

public interface SystemconfigDao extends BaseDao<Systemconfig> {
	public Systemconfig getSystemconfig();
}
