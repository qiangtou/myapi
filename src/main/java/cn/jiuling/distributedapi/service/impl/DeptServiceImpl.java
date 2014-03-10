package cn.jiuling.distributedapi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.jiuling.distributedapi.dao.DeptDao;
import cn.jiuling.distributedapi.model.Dept;
import cn.jiuling.distributedapi.service.DeptService;

@Service("deptService")
public class DeptServiceImpl implements DeptService {
	@Resource
	private DeptDao deptDao;

	public List<Dept> getDeptList() {
		return deptDao.getUnDeletedList();
	}

	public void saveOrUpdate(Dept dept) {
		deptDao.saveOrUpdate(dept);
	}

	public boolean delete(Integer deptId) {
		boolean hasServer=deptDao.hasServer(deptId);
		if(!hasServer){
			//修改删除状态
			Dept dept=deptDao.find(deptId);
			dept.setIsDelete(Dept.DELETE);
			deptDao.update(dept);
		}
		return !hasServer;
		
	}

}
