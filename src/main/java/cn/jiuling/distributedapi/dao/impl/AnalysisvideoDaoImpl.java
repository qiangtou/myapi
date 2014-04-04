package cn.jiuling.distributedapi.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.jiuling.distributedapi.dao.AnalysisvideoDao;
import cn.jiuling.distributedapi.model.Analysisvideo;

@Repository("analysisvideoDao")
public class AnalysisvideoDaoImpl extends BaseDaoImpl<Analysisvideo> implements AnalysisvideoDao {

	@Override
	public Analysisvideo getHeightAndwidth(String flowNumber) {
		/*select av.output_height,av.output_width 
		from externaltask et, generatevideo gv, analysisvideo av 
		where et.TaskID = gv.GenerateID and gv.AnalysisID = av.AnalysisID and et.flowNumber = '$myFlowNumber
		*/String queryString = "select new Analysisvideo(av.outputWidth,av.outputHeight) from Analysisvideo av,Generatevideo g,Externaltask e"
				+ " where e.flowNumber=? and av.analysisId=g.analysisvideo.analysisId and e.taskId=g.generateId ";
		List list = getHibernateTemplate().find(queryString, flowNumber);
		if (list.size() > 0) {
			return (Analysisvideo) list.get(0);
		}
		return null;
	}

	@Override
	public Analysisvideo findByFlowNumber(String flowNumber) {
		/*	select replace(av.complete_tbi_filename,''\\AstVS_1v2'','''') 
		 * from externaltask et, generatevideo gv, analysisvideo av 
		    where et.flowNumber = ',@FlowNumber, ' and et.TaskID = gv.GenerateID and gv.AnalysisID = av.AnalysisID'
		*/
		String queryString = "select g.analysisvideo from Generatevideo g,Externaltask e where e.taskId=g.generateId and e.flowNumber=?";
		List list = super.getHibernateTemplate().find(queryString, flowNumber);
		if (list.size() > 0) {
			return (Analysisvideo) list.get(0);
		}
		return null;
	}
}
