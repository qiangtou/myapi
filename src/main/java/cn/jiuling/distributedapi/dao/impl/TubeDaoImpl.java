package cn.jiuling.distributedapi.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.jiuling.distributedapi.dao.TubeDao;
import cn.jiuling.distributedapi.model.Tube;

@Repository("tubeDao")
public class TubeDaoImpl extends BaseDaoImpl<Tube> implements TubeDao {

	@Override
	public Tube findByFlowNumber(String flowNumber, Long tubeID) {
		/*	  select tb.tbi_filename into @tbi_filename
		        from externaltask et, generatevideo gv, tube tb
		             where et.flowNumber = @FlowNumber and et.TaskID = gv.GenerateID 
		             and gv.AnalysisID = tb.AnalysisID 
		                and tb.tube_id = @TubeID; */
		String queryString = "select tb from Externaltask et, Generatevideo gv, Tube tb where " +
				"et.flowNumber = ? and et.taskId = gv.generateId  and gv.analysisvideo= tb.analysisvideo  " +
				"and tb.tubeId =?";
		List list = super.getHibernateTemplate().find(queryString, new Object[] { flowNumber, tubeID });
		if (list.size() > 0) {
			return (Tube) list.get(0);
		}
		return null;
	}

}
