package cn.jiuling.distributedapi.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.jiuling.distributedapi.dao.TubesnapshotinfoDao;
import cn.jiuling.distributedapi.model.Tubesnapshotinfo;

@Repository("tubesnapshotinfoDao")
public class TubesnapshotinfoDaoImpl extends BaseDaoImpl<Tubesnapshotinfo> implements TubesnapshotinfoDao {

	@Override
	public Tubesnapshotinfo findTubesnapshotinfo(String flownumber, Long tubeid, Long compid) {
		/*SELECT tss.filename INTO picname
		FROM tubesnapshotinfo tss, tube t, exttaskstatus e, analysisvideo a
		WHERE e.flowNumber = flownumber
		AND e.AnalysisID = a.AnalysisID
		AND t.AnalysisID = a.AnalysisID
		AND t.TubeID = tss.TubeID
		AND t.tube_id = tubeid
		AND tss.component_id = compid;*/
		String queryString = "select new Tubesnapshotinfo(tss.filename) from Tubesnapshotinfo tss,Exttaskstatus e,Analysisvideo a " +
				"where e.id.flowNumber=? and e.id.analysisId=a.analysisId and tss.tube.analysisvideo=a " +
				"and tss.tube.tubeId_1=? and tss.componentId=?";
		List list = super.getHibernateTemplate().find(queryString, new Object[] { flownumber, tubeid.intValue(), compid.shortValue() });
		if (list.size() > 0) {
			return (Tubesnapshotinfo) list.get(0);
		}
		return null;
	}

}
