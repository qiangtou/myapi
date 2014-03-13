package cn.jiuling.distributedapi.web;

import java.sql.Timestamp;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.jiuling.distributedapi.Vo.ResStatus;
import cn.jiuling.distributedapi.Vo.Status;
import cn.jiuling.distributedapi.model.Useruploadvideo;
import cn.jiuling.distributedapi.service.VideoService;
import cn.jiuling.distributedapi.utils.XmlUtil;

@Controller
@RequestMapping(produces = "text/html;charset=utf-8")
public class Video4AddController extends BaseController {
	@Resource
	private VideoService videoService;

	/**
	 * TODO 添加视频
	 * 
	 * @param cameraid
	 * @param video_filename
	 * @param record_time
	 * @param createtime
	 * @param isautosubmit
	 * @param video_type
	 * @return
	 */
	@RequestMapping("addvideo.php")
	@ResponseBody
	public String addvideo(@RequestParam Long cameraid, @RequestParam String video_filename, @RequestParam Timestamp record_time,
			Timestamp createtime, @RequestParam(required = false, defaultValue = "0") Short isautosubmit, Short video_type) {

		Useruploadvideo v = new Useruploadvideo(cameraid, video_filename, record_time,
					createtime, isautosubmit, video_type);

		ResStatus rs = new ResStatus(Status.VIDEO_QUERY_SUCCESS);
		return XmlUtil.parse(rs);
	}

}
