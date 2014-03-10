package cn.jiuling.distributedapi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import cn.jiuling.distributedapi.Vo.CaseGroupVo;
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
	private final Logger log = Logger.getLogger(CaseServiceImpl.class);
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
			throw new ServiceException(Status.CASEGROUP_ADD_ERROR, e);
		}
	}

	@Override
	public void deleteCaseGroup(Long groupid) {
		try {
			CaseGroup g = caseGroupDao.find(groupid);
			if (g == null) {
				throw new ServiceException(Status.OBJECT_IS_NOT_EXIST);
			}
			caseGroupDao.delete(g);
		} catch (Exception e) {
			throw new ServiceException(Status.CASEGROUP_DEL_ERROR, e);
		}
	}

	@Override
	public void modifyCaseGroup(CaseGroup caseGroup) {
		try {
			CaseGroup g = caseGroupDao.find(caseGroup.getId());
			if (g == null) {
				throw new ServiceException(Status.OBJECT_IS_NOT_EXIST);
			}
			g.setTitle(caseGroup.getTitle());
			g.setDescription(caseGroup.getDescription());

			caseGroupDao.update(g);
		} catch (Exception e) {
			throw new ServiceException(Status.CASEGROUP_MODIFY_ERROR, e);
		}
	}

	@Override
	public List<CaseGroupVo> queryCaseGroup() {
		try {
			return caseGroupDao.queryCaseGroup();
		} catch (Exception e) {
			throw new ServiceException(Status.CASEGROUP_QUERY_ERROR, e);
		}
	}

	@Override
	public void addCase(Case c) {
		try {
			caseDao.save(c);
		} catch (Exception e) {
			throw new ServiceException(Status.CASE_ADD_ERROR, e);
		}

	}

	@Override
	public void modifyCase(Case newCase) {
		try {
			Case c = caseDao.find(newCase.getId());
			if (c == null) {
				throw new ServiceException(Status.OBJECT_IS_NOT_EXIST);
			}
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
			throw new ServiceException(Status.CASE_MODIFY_ERROR, e);
		}

	}

	@Override
	public List<CaseVo> queryCase(Integer startindex, Integer count, Integer sorttype, Integer isDescend) {
		try {
			return caseDao.query(startindex, count, sorttype, isDescend);
		} catch (Exception e) {
			throw new ServiceException(Status.CASE_QUERY_ERROR, e);
		}
	}
}
