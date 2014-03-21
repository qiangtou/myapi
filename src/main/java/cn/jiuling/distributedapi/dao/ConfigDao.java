package cn.jiuling.distributedapi.dao;

import cn.jiuling.distributedapi.model.Config;

public interface ConfigDao extends BaseDao<Config> {

	public Config getConfig();
}
