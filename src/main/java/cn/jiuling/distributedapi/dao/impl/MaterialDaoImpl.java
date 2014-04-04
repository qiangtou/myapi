package cn.jiuling.distributedapi.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.jiuling.distributedapi.dao.MaterialDao;
import cn.jiuling.distributedapi.model.Material;

@Repository("materialDao")
public class MaterialDaoImpl extends BaseDaoImpl<Material> implements MaterialDao {

	@Override
	public List findByTitleAndClueId(String title, Long clueid) {
		/*SELECT m.title FROM tbl_Material m where m.title = @title and m.clueid =@clueid*/
		String queryString = "from Material m where m.title=? and m.clueId=?";
		return super.getHibernateTemplate().find(queryString, new Object[] { title, clueid });
	}

	@Override
	public List queryMaterial(Long id) {
		/*	SELECT m.id,m.title,m.tubeid,m.compid,startframe,framecount,framerate,startcalibtime,endcalibtime, 
			cm.title, cm.id,infoclass,m.filename,m.filename,m.flownumber,m.videoid,m.clueid,m.style,m.description,
			suspected,tagstyle,tagtext,edited,m.edittime,m.editorid, CONCAT(''',' DATA/',''',
		RIGHT(a.snapshot_folder, CHAR_LENGTH(a.snapshot_folder)- CHAR_LENGTH(data_folder)-2),''','/',''',picname)
			from tbl_material m, tbl_camera cm, tbl_clue cl, exttaskstatus e, analysisvideo a, config
			where m.clueid = cl.id 
			and cm.caseid = cl.caseid 
			and m.clueid = ',id,'
			and m.cameraid = cm.id 
			and e.flowNumber = m.flownumber
			and e.AnalysisID = a.AnalysisID*/
		String queryString = "select new cn.jiuling.distributedapi.Vo.MaterialVo(" +
				"m.id,m.title,m.tubeId,m.compId,m.startframe,m.frameCount,m.frameRate,m.startcalibtime,m.endcalibtime," +
				"ca.id,m.infoclass,m.filename,m.flownumber,m.videoId,m.clueId,m.style,m.description," +
				"m.suspected,m.tagstyle,m.tagtext,m.edited,m.editTime,m.editorId,a.snapshotFolder,c.dataFolder,m.picname)" +
				"from Material m,Camera ca,Clue cl,Exttaskstatus e,Analysisvideo a,Config c " +
				"where m.clueId=cl.id and ca.caseId=cl.caseId and m.clueId=? and m.cameraid=ca.id " +
				"and e.id.flowNumber=m.flownumber and e.id.analysisId=a.analysisId";
		return super.getHibernateTemplate().find(queryString, id);
	}
}
