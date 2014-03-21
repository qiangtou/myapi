package cn.jiuling.distributedapi.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.jiuling.distributedapi.Vo.Status;
import cn.jiuling.distributedapi.Vo.StatusInfoVo;
import cn.jiuling.distributedapi.dao.VideoDao;
import cn.jiuling.distributedapi.exception.ServiceException;
import cn.jiuling.distributedapi.service.SysService;
import cn.jiuling.distributedapi.utils.DiskSpaceUtils;
import cn.jiuling.distributedapi.utils.RegUtils;

@Service("sysService")
public class SysServiceImpl implements SysService {
	@Resource
	private VideoDao videoDao;

	@Override
	public StatusInfoVo statusinfo() {
		try {
			StatusInfoVo s = videoDao.getStatusInfo();
			s.setSummarySpace(DiskSpaceUtils.getUsableSpace());
			long ftpSpace = DiskSpaceUtils.getUsableSpace(RegUtils.getFtpPath());
			s.setFtpSpace(ftpSpace);
			return s;
		} catch (Exception e) {
			throw new ServiceException(Status.QUERY_ERROR, e);
		}
	}
}
