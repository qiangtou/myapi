package cn.jiuling.distributedapi.dao;

import cn.jiuling.distributedapi.model.Tubesnapshotinfo;

public interface TubesnapshotinfoDao extends BaseDao<Tubesnapshotinfo> {

	public Tubesnapshotinfo findTubesnapshotinfo(String flownumber, Long tubeid, Long compid);

}
