package cn.jiuling.distributedapi.dao;

import cn.jiuling.distributedapi.model.Clue;

public interface ClueDao extends BaseDao<Clue> {

	public Clue findByCase(Long caseid);

}
