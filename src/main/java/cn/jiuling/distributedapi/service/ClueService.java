package cn.jiuling.distributedapi.service;

import java.sql.Timestamp;
import java.util.List;

import cn.jiuling.distributedapi.Vo.GisVo;
import cn.jiuling.distributedapi.model.Material;

public interface ClueService {

	public Material addvideomaterial(String title, Long tubeid, Long compid, Integer startframe, Integer framecount, Float framerate, Timestamp startcalibtime,
			Timestamp endcalibtime, Long cameraid, Short infoclass, String filename, String flownumber, Long videoid, Long clueid, Long caseid,
			String description, Short suspected, Short tagstyle, String tagtext, String style, String picname, Integer userid);

	public void deletematerial(Long id);

	public void modifyMaterial(Long materialid, String title, Long tubeid, Integer compid, Timestamp starttime, Integer framesnumber, Float framerate,
			String cameratitle, Short infoclass, Long videoid, Long clueid, String description, Short suspected, String style, Integer startframe,
			Integer framecount, Timestamp endcalibtime, Short tagstyle, String tagtext);

	public List queryMaterial(Short type, Long id);

	public GisVo queryGis(Short operateType, Short showType, Long objectId, Short objectType, Float xPos, Float yPos, Integer zoomLevel, String objectDesc);

	public Object queryGisGetObject(Integer caseId);

	public void saveOrUpdateClueStyle(String cluestyle);

	public String queryClueStyle();

}
