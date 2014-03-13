package cn.jiuling.distributedapi.service;

import java.sql.Timestamp;
import java.util.List;

import cn.jiuling.distributedapi.Vo.DownloadTasksVo;

public interface VideoService {
	public List queryVideo(Long cameraid, Long userid);

	public void modifyVideo(Long videoid, Timestamp recordTime, Long userid);

	public long add3rdVideo(Long cameraid, String srcurl, String platformname, Short isautosubmit);

	public DownloadTasksVo query3rdVideoStatus(Long id);

	public List query3rdVideoList(Long cameraid, Short status, Timestamp start, Timestamp end, Integer index, Integer count);
}
