package cn.jiuling.distributedapi.web;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.jiuling.distributedapi.Vo.CaseGroupVo;
import cn.jiuling.distributedapi.Vo.CaseRes;
import cn.jiuling.distributedapi.Vo.CaseVideoVo;
import cn.jiuling.distributedapi.Vo.CaseVo;
import cn.jiuling.distributedapi.Vo.GroupRes;
import cn.jiuling.distributedapi.Vo.ResStatus;
import cn.jiuling.distributedapi.Vo.Status;
import cn.jiuling.distributedapi.model.Case;
import cn.jiuling.distributedapi.model.CaseGroup;
import cn.jiuling.distributedapi.service.CaseService;
import cn.jiuling.distributedapi.service.UserService;
import cn.jiuling.distributedapi.utils.ResponseUtils;

@Controller
@RequestMapping(value = "server.php", produces = "text/html;charset=utf-8")
public class CaseController extends BaseController {

	@Resource
	private UserService userService;
	@Resource
	private CaseService caseService;

	/**
	 * 新建案件组
	 * 
	 * @param username
	 * @param grouptitle
	 * @param description
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(params = { "command=AddCaseGroup" })
	@ResponseBody
	public String addCaseGroup(@RequestParam String username, @RequestParam String grouptitle, @RequestParam String description) {
		CaseGroup ug;
		ResStatus rs;
		ug = caseService.addCaseGroup(username, grouptitle, description);
		rs = new GroupRes(ug.getId().intValue());
		rs.setStatus(Status.ADD_SUCCESS);
		return ResponseUtils.parse(rs);
	}

	/**
	 * 删除案件组
	 * 
	 * @param groupid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(params = { "command=DeleteCaseGroup" })
	@ResponseBody
	public String deleteCaseGroup(@RequestParam Long groupid) throws Exception {
		caseService.deleteCaseGroup(groupid);
		ResStatus rs = new ResStatus(Status.DEL_SUCCESS);
		return ResponseUtils.parse(rs);
	}

	/**
	 * 修改案件组
	 * 
	 * @param groupid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(params = { "command=ModifyCaseGroup" })
	@ResponseBody
	public String modifyCaseGroup(@RequestParam Long groupid, String newtitle, String newdesc) throws Exception {
		CaseGroup caseGroup = new CaseGroup(groupid, newtitle, newdesc);
		caseService.modifyCaseGroup(caseGroup);
		ResStatus rs = new ResStatus(Status.MODIFY_SUCCESS);
		return ResponseUtils.parse(rs);
	}

	/**
	 * 查询案件组列表
	 * 
	 * @param groupid
	 * @param newtitle
	 * @param newdesc
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(params = { "command=QueryCaseGroup" })
	@ResponseBody
	public String queryCaseGroup() throws Exception {
		List<CaseGroupVo> caseGroupList = caseService.queryCaseGroup();
		ResStatus rs = new ResStatus(Status.QUERY_SUCCESS);
		return ResponseUtils.parse(rs, caseGroupList);
	}

	/**
	 * 新建案件
	 * 
	 * @param parentid
	 * @param casetitle
	 * @param location
	 * @param casestyle
	 * @param occurredtime
	 * @param description
	 * @param class_
	 * @param groupid
	 * @param serialnumber
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(params = { "command=AddCase" })
	@ResponseBody
	public String addCase(
			@RequestParam(required = false, defaultValue = "-1") Long parentid,
			@RequestParam String casetitle, @RequestParam String location,
			@RequestParam Integer casestyle, Timestamp occurredtime, @RequestParam String description,
			@RequestParam("class") String class_,
			@RequestParam(required = false, defaultValue = "-1") Long groupid,
			@RequestParam(required = false, defaultValue = "") String serialnumber) throws Exception {

		if (null == occurredtime) {
			occurredtime = new Timestamp(0L);
		}
		Case c = new Case(parentid, casetitle, location, casestyle, occurredtime, description,
					class_, groupid, serialnumber);
		caseService.addCase(c);
		CaseRes rs = new CaseRes(Status.ADD_SUCCESS, c.getId());
		return ResponseUtils.parse(rs);
	}

	/**
	 * 修改案件信息
	 * 
	 * @param caseid
	 * @param parentid
	 * @param casetitle
	 * @param location
	 * @param casestyle
	 * @param occurredtime
	 * @param description
	 * @param class_
	 * @param groupid
	 * @param serialnumber
	 * @return
	 */
	@RequestMapping(params = { "command=ModifyCase" })
	@ResponseBody
	public String modifyCase(@RequestParam Long caseid, Long parentid, String casetitle, String location, Integer casestyle, Timestamp occurredtime,
			String description, @RequestParam("class") String class_, Long groupid, String serialnumber) {
		Case c = new Case(parentid, casetitle, location, casestyle, occurredtime, description,
				class_, groupid, serialnumber);
		c.setId(caseid);
		caseService.modifyCase(c);
		ResStatus rs = new ResStatus(Status.MODIFY_SUCCESS);
		return ResponseUtils.parse(rs);
	}

	/**
	 * 查询案件列表
	 * 
	 * @param startindex
	 *            开始获取的序号(默认0)
	 * @param count
	 *            要获取的条数（默认全部）
	 * @param sorttype
	 *            排序类型(不填,默认按创建时间)
	 * @param is_descend
	 *            排列顺序(0升序,1降序,默认降序)
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(params = { "command=QueryCase" })
	@ResponseBody
	public String queryCase(
			@RequestParam(required = false, defaultValue = "0") Integer startindex,
			@RequestParam(required = false, defaultValue = "-1") Integer count,
			@RequestParam(required = false, defaultValue = "0") Integer sorttype,
			@RequestParam(required = false, defaultValue = "1") Integer is_descend) {

		List<CaseVo> list = caseService.queryCase(startindex, count, sorttype, is_descend);
		ResStatus rs = new ResStatus(Status.QUERY_SUCCESS);
		return ResponseUtils.parse(rs, list);
	}

	/**
	 * 搜索案件
	 * 
	 * @param type
	 * @param value
	 * @param value2
	 * @param startindex
	 * @param count
	 * @return
	 */
	@RequestMapping(params = { "command=SearchCase" })
	@ResponseBody
	public String searchCase(@RequestParam Integer type, @RequestParam String value, Timestamp value2,
			@RequestParam(required = false, defaultValue = "0") Integer startindex,
			@RequestParam(required = false, defaultValue = "-1") Integer count) {
		List<CaseVo> list = caseService.searchCase(type, value, value2, startindex, count);
		ResStatus rs = new ResStatus(Status.SEARCH_SUCCESS);
		return ResponseUtils.parse(rs, list);
	}

	/**
	 * 查询案件信息
	 * 
	 * @param caseid
	 * @return
	 */
	@RequestMapping(params = { "command=QueryCaseInfo" })
	@ResponseBody
	public String queryCaseInfo(@RequestParam Long caseid) {

		CaseVo c = caseService.queryCaseInfo(caseid);
		ResStatus rs = new ResStatus(Status.QUERY_SUCCESS);
		return ResponseUtils.parse(rs, c);
	}

	/**
	 * 查询案件下的视频列表
	 * 
	 * @param caseid
	 * @return
	 */
	@RequestMapping(params = { "command=QueryCaseVideo" })
	@ResponseBody
	public String queryCaseVideo(@RequestParam Long caseid) {
		CaseVideoVo c = caseService.queryCaseVideo(caseid);
		ResStatus rs = new ResStatus(Status.QUERY_SUCCESS);
		return ResponseUtils.parse(rs, c);
	}
}
