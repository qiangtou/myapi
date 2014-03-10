package cn.jiuling.distributedapi.service;

import java.util.List;

import cn.jiuling.distributedapi.model.Dept;

public interface DeptService {
	public List<Dept> getDeptList();

	public void saveOrUpdate(Dept dept);

	public boolean delete(Integer deptId);
}
