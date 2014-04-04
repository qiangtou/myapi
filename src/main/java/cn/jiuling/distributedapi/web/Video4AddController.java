package cn.jiuling.distributedapi.web;

import java.sql.Timestamp;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.jiuling.distributedapi.Vo.Status;
import cn.jiuling.distributedapi.Vo.VideoRes;
import cn.jiuling.distributedapi.model.Useruploadvideo;
import cn.jiuling.distributedapi.service.VideoService;
import cn.jiuling.distributedapi.utils.ResponseUtils;

@Controller
@RequestMapping(produces = "text/html;charset=utf-8")
public class Video4AddController extends BaseController {
	@Resource
	private VideoService videoService;

	/**
	 * 5.1 添加视频
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
	public String addvideo(HttpSession session,
			@RequestParam Long cameraid,
			@RequestParam String video_filename,
			Timestamp record_time,
			Timestamp createtime,
			@RequestParam(required = false, defaultValue = "0") Short isautosubmit,
			@RequestParam(required = false, defaultValue = "0") Short video_type) {
		Integer userId = getUserId(session);
		if (record_time == null) {
			record_time = new Timestamp(0L);
		}
		if (createtime == null) {
			createtime = new Timestamp(System.currentTimeMillis());
		}
		Useruploadvideo v = videoService.addvideo(cameraid, video_filename, record_time,
					createtime, isautosubmit, video_type, userId);
		return ResponseUtils.parse(new VideoRes(Status.ADD_SUCCESS, v));
	}

}
