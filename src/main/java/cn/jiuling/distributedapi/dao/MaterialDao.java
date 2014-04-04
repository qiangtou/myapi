package cn.jiuling.distributedapi.dao;

import java.util.List;

import cn.jiuling.distributedapi.model.Material;

public interface MaterialDao extends BaseDao<Material> {

	public List findByTitleAndClueId(String title, Long clueid);

	public List queryMaterial(Long id);

}
