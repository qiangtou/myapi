package cn.jiuling.distributedapi.web;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.jiuling.distributedapi.Vo.ClueStyleRes;
import cn.jiuling.distributedapi.Vo.GisVo;
import cn.jiuling.distributedapi.Vo.MaterialRes;
import cn.jiuling.distributedapi.Vo.ResStatus;
import cn.jiuling.distributedapi.Vo.Status;
import cn.jiuling.distributedapi.model.Material;
import cn.jiuling.distributedapi.service.ClueService;
import cn.jiuling.distributedapi.utils.ResponseUtils;

@Controller
@RequestMapping(produces = "text/html;charset=utf-8")
public class ClueController extends BaseController {
	@Resource
	private ClueService clueService;

	/**
	 * 8.5新增视频素材
	 * 
	 * @param title
	 * @param tubeid
	 * @param compid
	 * @param startframe
	 * @param framecount
	 * @param framerate
	 * @param startcalibtime
	 * @param endcalibtime
	 * @param cameraid
	 * @param infoclass
	 * @param filename
	 * @param flownumber
	 * @param videoid
	 * @param clueid
	 * @param caseid
	 * @param description
	 * @param suspected
	 * @param tagstyle
	 * @param tagtext
	 * @param style
	 * @param picname
	 * @param session
	 * @return
	 */
	@RequestMapping("addvideomaterial.php")
	@ResponseBody
	public String addvideomaterial(@RequestParam String title,
			@RequestParam(required = false, defaultValue = "0") Long tubeid,
			@RequestParam(required = false, defaultValue = "0") Long compid,
			@RequestParam(required = false, defaultValue = "0") Integer startframe,
			@RequestParam(required = false, defaultValue = "0") Integer framecount,
			@RequestParam(required = false, defaultValue = "0") Float framerate,
				Timestamp startcalibtime,
				Timestamp endcalibtime,
			@RequestParam Long cameraid,
			@RequestParam Short infoclass,
			@RequestParam String filename,
			@RequestParam(required = false, defaultValue = "0") String flownumber,
			@RequestParam(required = false, defaultValue = "0") Long videoid,
			Long clueid,
			Long caseid,
			@RequestParam String description,
			@RequestParam Short suspected,
			@RequestParam Short tagstyle,
			@RequestParam(required = false, defaultValue = "") String tagtext,
			@RequestParam(required = false, defaultValue = "") String style,
			String picname, HttpSession session) {
		Integer userid = super.getUserId(session);
		if (startcalibtime == null) {
			startcalibtime = new Timestamp(0L);
		}
		if (endcalibtime == null) {
			endcalibtime = new Timestamp(0L);
		}
		Material m = clueService.addvideomaterial(title, tubeid, compid, startframe, framecount, framerate, startcalibtime,
				endcalibtime, cameraid, infoclass, filename, flownumber, videoid, clueid, caseid, description,
				suspected, tagstyle, tagtext, style, picname, userid);
		return ResponseUtils.parse(new MaterialRes(Status.ADD_SUCCESS, m.getId()));
	}

	/**
	 * 8.6删除素材
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("deletematerial.php")
	@ResponseBody
	public String deletematerial(@RequestParam Long id) {
		clueService.deletematerial(id);
		return ResponseUtils.parse(new ResStatus(Status.DEL_SUCCESS));
	}

	/**
	 * 8.7修改素材
	 * 
	 * @param materialid
	 * @param title
	 * @param tubeid
	 * @param compid
	 * @param starttime
	 * @param framesnumber
	 * @param framerate
	 * @param cameratitle
	 * @param infoclass
	 * @param videoid
	 * @param clueid
	 * @param description
	 * @param suspected
	 * @param style
	 * @return
	 */
	@RequestMapping(value = "server.php", params = { "command=ModifyMaterial" })
	@ResponseBody
	public String modifyMaterial(
			@RequestParam Long materialid,
			String title,
			Long tubeid,
			Integer compid,
			Timestamp starttime,
			Timestamp endcalibtime,
			Integer framesnumber,
			Float framerate,
			String cameratitle,
			Short infoclass,
			Long videoid,
			Long clueid,
			String description,
			Short suspected,
			String style,
			Integer startframe,
			Integer framecount,
			Short tagstyle,
			String tagtext

	) {
		clueService.modifyMaterial(materialid,
					title,
					tubeid,
					compid,
					starttime,
					framesnumber,
					framerate,
					cameratitle,
					infoclass,
					videoid,
					clueid,
					description,
					suspected,
					style, startframe, framecount, endcalibtime, tagstyle, tagtext);
		return ResponseUtils.parse(new ResStatus(Status.MODIFY_SUCCESS));
	}

	/**
	 * 8.8查询素材
	 * 
	 * @param type
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "server.php", params = { "command=QueryMaterial" })
	@ResponseBody
	public String queryMaterial(@RequestParam Short type, @RequestParam Long id) {
		List list = clueService.queryMaterial(type, id);
		return ResponseUtils.parse(new ResStatus(Status.MODIFY_SUCCESS), list);
	}

	/**
	 * 8.9 GIS地图位置
	 * 
	 * @param operateType
	 * @param showType
	 * @param objectId
	 * @param objectType
	 * @param xPos
	 * @param yPos
	 * @param zoomLevel
	 * @param objectDesc
	 * @return
	 */
	@RequestMapping("gis.php")
	public ModelAndView gis(
			@RequestParam(required = false, defaultValue = "0") Short operateType,
			@RequestParam(required = false, defaultValue = "1") Short showType,
			@RequestParam(required = false, defaultValue = "0") Long objectId,
			@RequestParam(required = false, defaultValue = "1") Short objectType,
			@RequestParam(required = false, defaultValue = "-1") Float xPos,
			@RequestParam(required = false, defaultValue = "-1") Float yPos,
			@RequestParam(required = false, defaultValue = "12") Integer zoomLevel,
			@RequestParam(required = false, defaultValue = "") String objectDesc) {
		GisVo g = clueService.queryGis(
				operateType, showType, objectId, objectType, xPos, yPos, zoomLevel, objectDesc
				);
		ModelAndView mv = new ModelAndView();
		mv.addObject("g", g);
		return mv;
	}

	@RequestMapping(value = "GisGetObject.php", produces = "application/json;charset=utf-8")
	@ResponseBody
	public Object gisGetObject(
			Integer caseId) {
		Object obj = clueService.queryGisGetObject(caseId);
		return obj;
	}

	/**
	 * 8.10导入线索类型
	 * 
	 * @param cluestyle
	 * @return
	 */
	@RequestMapping(value = "server.php", params = { "command=LoadInClueStyle" })
	@ResponseBody
	public String loadInClueStyle(@RequestParam String cluestyle) {
		clueService.saveOrUpdateClueStyle(cluestyle);
		return ResponseUtils.parse(new ResStatus(Status.EXECUTE_SUCCESS));
	}

	/**
	 * 8.11导出线索类型
	 * 
	 * @return
	 */
	@RequestMapping(value = "server.php", params = { "command=LoadOutClueStyle" })
	@ResponseBody
	public String exportClueStyle() {
		String clueStyle = clueService.queryClueStyle();
		return ResponseUtils.parse(new ClueStyleRes(Status.EXECUTE_SUCCESS, clueStyle));
	}
}
