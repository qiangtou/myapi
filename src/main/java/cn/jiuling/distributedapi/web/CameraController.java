package cn.jiuling.distributedapi.web;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.jiuling.distributedapi.Vo.CameraRes;
import cn.jiuling.distributedapi.Vo.ResStatus;
import cn.jiuling.distributedapi.Vo.Status;
import cn.jiuling.distributedapi.model.Camera;
import cn.jiuling.distributedapi.model.User;
import cn.jiuling.distributedapi.service.CameraService;
import cn.jiuling.distributedapi.utils.ResponseUtils;

@Controller
@RequestMapping(value = "server.php", produces = "text/html;charset=utf-8")
public class CameraController extends BaseController {
	@Resource
	private CameraService cameraService;

	@RequestMapping(params = { "command=AddCamera" })
	@ResponseBody
	public String addCamera(@RequestParam Long caseid, @RequestParam String cameratitle,
			@RequestParam Short cameratype, String serialnumber, @RequestParam String location,
			@RequestParam Float direction, @RequestParam Float longitude, @RequestParam Float latitude,
			@RequestParam String description, Timestamp createtime, @RequestParam Integer calibration, Short video_type) {
		Camera c = new Camera(caseid, cameratitle, cameratype, serialnumber, location,
					direction, longitude, latitude, description, createtime,
					calibration, video_type);
		cameraService.addCamera(c);
		CameraRes rs = new CameraRes(Status.ADD_SUCCESS, c);
		return ResponseUtils.parse(rs);
	}

	@RequestMapping(params = { "command=ModifyCamera" })
	@ResponseBody
	public String modifyCamera(@RequestParam Long cameraid, String cameratitle, Short cameratype, String serialnumber, String location,
			Float direction, Float longitude, Float latitude, String description,
			Integer calibration, Short video_type) {
		Camera c = new Camera(null, cameratitle, cameratype, serialnumber, location,
				direction, longitude, latitude, description, null,
				calibration, video_type);
		c.setId(cameraid);
		cameraService.modifyCamera(c);
		ResStatus rs = new ResStatus(Status.MODIFY_SUCCESS);
		return ResponseUtils.parse(rs);
	}

	/**
	 * 查询案件下的监控点
	 * 
	 * @param caseid
	 * @return
	 */
	@RequestMapping(params = "command=QueryCamera")
	@ResponseBody
	public String queryCamera(@RequestParam Long caseid) {
		List list = cameraService.queryCameraByCaseId(caseid);
		ResStatus rs = new ResStatus(Status.QUERY_SUCCESS);
		return ResponseUtils.parse(rs, list);
	}

	/**
	 * 查询监控点信息
	 * 
	 * @param cameraid
	 * @return
	 */
	@RequestMapping(params = "command=QueryCameraInfo")
	@ResponseBody
	public String queryCameraInfo(@RequestParam Long cameraid) {
		List list = cameraService.queryCameraByCameraid(cameraid);
		ResStatus rs = new ResStatus(Status.QUERY_SUCCESS);
		return ResponseUtils.parse(rs, list);
	}

	/**
	 * 查询监控点信息
	 * 
	 * @param cameraid
	 * @return
	 */
	@RequestMapping(value = "/jjjj.do", params = "command=ttt")
	@ResponseBody
	public String fdsgsdfddCamera(@RequestParam Long caseid, @RequestParam String cameratitle,
			@RequestParam(required = false, defaultValue = "77") Short serialnumber) {
		log.info("caseid:" + caseid);
		log.info("cameratitle:" + cameratitle);
		log.info("serialnumber:" + serialnumber);

		ResStatus rs = new ResStatus(Status.QUERY_SUCCESS);
		return ResponseUtils.parse(rs, new User());
	}

}
