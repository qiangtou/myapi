package cn.jiuling.distributedapi.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import cn.jiuling.distributedapi.Vo.CaseGroupVo;
import cn.jiuling.distributedapi.Vo.CaseReportVo;
import cn.jiuling.distributedapi.Vo.CaseVideoVo;
import cn.jiuling.distributedapi.Vo.CaseVo;
import cn.jiuling.distributedapi.Vo.Status;
import cn.jiuling.distributedapi.dao.CaseDao;
import cn.jiuling.distributedapi.dao.CaseGroupDao;
import cn.jiuling.distributedapi.dao.UserDao;
import cn.jiuling.distributedapi.exception.ServiceException;
import cn.jiuling.distributedapi.model.Case;
import cn.jiuling.distributedapi.model.CaseGroup;
import cn.jiuling.distributedapi.model.User;
import cn.jiuling.distributedapi.service.CaseService;

@Service("caseService")
public class CaseServiceImpl implements CaseService {
	@Resource
	private CaseGroupDao caseGroupDao;
	@Resource
	private UserDao userDao;
	@Resource
	private CaseDao caseDao;

	@Override
	public CaseGroup addCaseGroup(String username, String grouptitle, String description) {
		try {
			User user = userDao.findByUserName(username);
			if (user == null) {
				throw new ServiceException(Status.CREATOR_IS_NULL);
			}
			CaseGroup ug = new CaseGroup(user.getUserId(), grouptitle, description);
			caseGroupDao.save(ug);
			return ug;
		} catch (Exception e) {
			throw new ServiceException(Status.ADD_ERROR, e);
		}
	}

	@Override
	public void deleteCaseGroup(Long groupid) {
		try {
			CaseGroup g = caseGroupDao.load(groupid);
			caseGroupDao.delete(g);
		} catch (Exception e) {
			throw new ServiceException(Status.DEL_ERROR, e);
		}
	}

	@Override
	public void modifyCaseGroup(CaseGroup caseGroup) {
		try {
			CaseGroup g = caseGroupDao.load(caseGroup.getId());
			g.setTitle(caseGroup.getTitle());
			g.setDescription(caseGroup.getDescription());
			caseGroupDao.update(g);
		} catch (Exception e) {
			throw new ServiceException(Status.MODIFY_ERROR, e);
		}
	}

	@Override
	public List<CaseGroupVo> queryCaseGroup() {
		try {
			return caseGroupDao.queryCaseGroup();
		} catch (Exception e) {
			throw new ServiceException(Status.QUERY_ERROR, e);
		}
	}

	@Override
	public void addCase(Case c) {
		try {
			caseDao.save(c);
		} catch (Exception e) {
			throw new ServiceException(Status.ADD_ERROR, e);
		}

	}

	@Override
	public void modifyCase(Case newCase) {
		try {
			Case c = caseDao.load(newCase.getId());
			// Long caseid, Long parentid, String casetitle, String location,
			// Integer casestyle, Timestamp occurredtime, String description,
			// @RequestParam("class") String class_, Long groupid, String
			// serialnumber
			c.setParentId(newCase.getParentId());
			c.setTitle(newCase.getTitle());
			c.setLocation(newCase.getLocation());
			c.setStyle(newCase.getStyle());
			c.setOccurredtime(newCase.getOccurredtime());
			c.setDescription(newCase.getDescription());
			c.setClass_(newCase.getClass_());
			c.setCaseGroupId(newCase.getCaseGroupId());
			c.setSerialnumber(newCase.getSerialnumber());
			caseDao.update(c);
		} catch (Exception e) {
			throw new ServiceException(Status.MODIFY_ERROR, e);
		}

	}

	@Override
	public List<CaseVo> queryCase(Integer startindex, Integer count, Integer sorttype, Integer isDescend) {
		try {
			List list = caseDao.query(startindex, count, sorttype, isDescend);
			return copyList(list);
		} catch (Exception e) {
			throw new ServiceException(Status.QUERY_ERROR, e);
		}
	}

	private List<CaseVo> copyList(List list) {
		List<CaseVo> caseList = new ArrayList<CaseVo>();
		Case c;
		CaseVo cv;
		if (list.size() > 0) {
			for (int i = 0, j = list.size(); i < j; i++) {
				c = (Case) list.get(i);
				cv = new CaseVo();
				BeanUtils.copyProperties(c, cv);
				caseList.add(cv);
			}
		}
		return caseList;
	}

	@Override
	public List<CaseVo> searchCase(Integer type, String value, Timestamp time, Integer startindex, Integer count) {
		try {
			List list = caseDao.searchCase(type, value, time, startindex, count);
			return copyList(list);
		} catch (Exception e) {
			throw new ServiceException(Status.QUERY_ERROR, e);
		}
	}

	@Override
	public CaseVo queryCaseInfo(Long caseid) {
		try {
			Case c = caseDao.load(caseid);
			CaseVo cv = new CaseVo();
			BeanUtils.copyProperties(c, cv);
			return cv;
		} catch (Exception e) {
			throw new ServiceException(Status.QUERY_ERROR, e);
		}
	}

	@Override
	public CaseVideoVo queryCaseVideo(Long caseid) {
		try {
			CaseVideoVo c = caseDao.queryCaseVideo(caseid);
			return c;
		} catch (Exception e) {
			throw new ServiceException(Status.QUERY_ERROR, e);
		}
	}

	@Override
	public CaseReportVo queryCaseReport(Long caseid) {
		// TODO queryCaseReport,表的含义还是需要解释
		return null;
	}
}
