package cn.jiuling.distributedapi.service;

import java.util.List;

import cn.jiuling.distributedapi.model.Server;

public interface ServerService {
	public List<Server> getServerList(Integer deptId);

	public void saveOrUpdate(Server server);

	public void enable(Server server);

	public void del(Server server);

	public Server updateServer(Server server);

	public void disable(Server server);
}
