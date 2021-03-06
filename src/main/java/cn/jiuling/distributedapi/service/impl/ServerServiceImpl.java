package cn.jiuling.distributedapi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.jiuling.distributedapi.dao.ServerDao;
import cn.jiuling.distributedapi.model.Server;
import cn.jiuling.distributedapi.service.ServerService;

@Service("serverService")
public class ServerServiceImpl implements ServerService {
	@Resource
	private ServerDao serverDao;

	public List<Server> getServerList(Integer deptId) {
		return serverDao.getServersByDeptId(deptId);
	}

	public void saveOrUpdate(Server server) {
		serverDao.saveOrUpdate(server);
	}

	public void enable(Server server) {
		server =serverDao.load(server.getId());
		server.setIsValid(Server.VALID);
		saveOrUpdate(server);
	}

	public void del(Server server) {
		server =serverDao.load(server.getId());
		serverDao.delete(server);
	}

	public Server updateServer(Server server) {
		Server s =serverDao.load(server.getId());
		s.setIpAddr(server.getIpAddr());
		s.setDeptId(server.getDeptId());
		s.setIsEnhance(server.getIsEnhance());
		serverDao.save(s);
		return s;
	}

	@Override
	public void disable(Server server) {
		server =serverDao.load(server.getId());
		server.setIsValid(Server.INVALID);
		saveOrUpdate(server);
		
	}
}
