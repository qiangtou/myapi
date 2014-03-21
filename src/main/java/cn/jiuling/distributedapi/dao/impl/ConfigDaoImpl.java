package cn.jiuling.distributedapi.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.jiuling.distributedapi.dao.ConfigDao;
import cn.jiuling.distributedapi.model.Config;

@Repository("configDao")
public class ConfigDaoImpl extends BaseDaoImpl<Config> implements ConfigDao {

	@Override
	public Config getConfig() {
		List<Config> list = super.getAll();
		Config c = list.get(0);
		String d = c.getDataPath();
		/*if (!d.endsWith("/")) {
			c.setDataPath(d + "/");
		}*/
		return c;
	}
}
