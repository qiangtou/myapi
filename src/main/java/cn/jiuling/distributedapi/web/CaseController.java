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
import cn.jiuling.distributedapi.Vo.CaseVo;
import cn.jiuling.distributedapi.Vo.GroupRes;
import cn.jiuling.distributedapi.Vo.ResStatus;
import cn.jiuling.distributedapi.Vo.Status;
import cn.jiuling.distributedapi.model.Case;
import cn.jiuling.distributedapi.model.CaseGroup;
import cn.jiuling.distributedapi.service.CaseService;
import cn.jiuling.distributedapi.service.UserService;
import cn.jiuling.distributedapi.utils.XmlUtil;

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
	public String addCaseGroup(String username, String grouptitle, String description) throws Exception {
		CaseGroup ug;
		ResStatus rs;
		ug = caseService.addCaseGroup(username, grouptitle, description);
		rs = new GroupRes(ug.getId().intValue());
		rs.setStatus(Status.CASEGROUP_ADD_SUCCESS);
		return XmlUtil.parse(rs);
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
	public String deleteCaseGroup(Long groupid) throws Exception {
		caseService.deleteCaseGroup(groupid);
		ResStatus rs = new ResStatus(Status.CASEGROUP_DEL_SUCCESS);
		return XmlUtil.parse(rs);
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
	public String modifyCaseGroup(Long groupid, String newtitle, String newdesc) throws Exception {
		CaseGroup caseGroup = new CaseGroup(groupid, newtitle, newdesc);
		caseService.modifyCaseGroup(caseGroup);
		ResStatus rs = new ResStatus(Status.CASEGROUP_MODIFY_SUCCESS);
		return XmlUtil.parse(rs);
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
		ResStatus rs = new ResStatus(Status.CASEGROUP_QUERY_SUCCESS);
		return XmlUtil.parse(rs, caseGroupList);
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
	public String addCase(Long parentid, String casetitle, String location, Integer casestyle, Timestamp occurredtime, String description,
			@RequestParam("class") String class_, Long groupid, String serialnumber) throws Exception {
		Case c = new Case(parentid, casetitle, location, casestyle, occurredtime, description,
					class_, groupid, serialnumber);
		caseService.addCase(c);
		CaseRes rs = new CaseRes(Status.CASE_ADD_SUCCESS, c.getId());
		return XmlUtil.parse(rs);
	}

	@RequestMapping(params = { "command=ModifyCase" })
	@ResponseBody
	public String modifyCase(Long caseid, Long parentid, String casetitle, String location, Integer casestyle, Timestamp occurredtime, String description,
			@RequestParam("class") String class_, Long groupid, String serialnumber) {
		Case c = new Case(parentid, casetitle, location, casestyle, occurredtime, description,
				class_, groupid, serialnumber);
		c.setId(caseid);
		caseService.modifyCase(c);
		ResStatus rs = new ResStatus(Status.CASE_MODIFY_SUCCESS);
		return XmlUtil.parse(rs);
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
	public String queryCase(Integer startindex, Integer count, Integer sorttype, Integer is_descend) {

		List<CaseVo> list = caseService.queryCase(startindex, count, sorttype, is_descend);
		ResStatus rs = new ResStatus(Status.CASE_MODIFY_SUCCESS);
		return XmlUtil.parse(rs);
	}
}
