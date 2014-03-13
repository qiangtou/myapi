package cn.jiuling.distributedapi.dao;

import java.util.List;

import cn.jiuling.distributedapi.model.Useruploadvideo;

public interface VideoDao extends BaseDao<Useruploadvideo> {

	public List queryVideo(Long cameraid, Long userid);

}
