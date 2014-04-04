package cn.jiuling.distributedapi.Vo;

import java.sql.Timestamp;
import java.util.Date;

public class MaterialVo {
	@Node("materialid")
	private Long id;
	private String title;
	@Node("tubeid")
	private Long tubeId;
	@Node("compid")
	private Long compId;
	private Integer startframe;
	@Node("framecount")
	private Integer frameCount;
	@Node("framerate")
	private Float frameRate;
	private Timestamp startcalibtime;
	private Timestamp endcalibtime;
	private Long cameraid;
	private Short infoclass;
	@Node("videoid")
	private Long videoId;
	private Long flownumber;
	@Node("clueid")
	private Long clueId;
	private String style;
	private String description;
	private Short suspected;
	private Short edited;
	private Timestamp editTime;
	// 这2个是新增的属性,其实都是filename
	@Node("editor")
	private Long editorId;

	private String fileurl;
	private String playpath;// 绝对路经

	private Short tagstyle;
	private String tagtext;
	private String picPath;

	/*	m.id,m.title,m.tubeId,m.compId,m.startframe,m.frameCount,m.frameRate,m.startcalibtime,m.endcalibtime," +
		"ca.title,ca.id,m.infoclass,m.filename,m.flownumber,m.videoId,m.clueId,m.style,m.description," +
		"m.suspected,m.tagstyle,m.tagtext,m.edited,m.editTime,m.editorId,a.snapshotFolder,c.dataFolder
	*/
	public MaterialVo(Long id, String title, Long tubeId, Long compId, Integer startframe,
			Integer frameCount, Float frameRate, Date startcalibtime, Date endcalibtime, Long cameraid,
			Short infoclass, String fileName, Long flownumber, Long videoId, Long clueId,
			String style, String description, Short suspected, Short tagstyle, String tagtext,
			Short edited, Date editTime, Long editorId, String snapshotFolder, String dataFolder, String picname) {
		super();
		this.id = id;
		this.title = title;
		this.tubeId = tubeId;
		this.compId = compId;
		this.startframe = startframe;
		this.frameCount = frameCount;
		this.frameRate = frameRate;
		if (startcalibtime != null) {
			this.startcalibtime = (Timestamp) startcalibtime;
		}
		if (endcalibtime != null) {
			this.endcalibtime = (Timestamp) endcalibtime;
		}
		this.cameraid = cameraid;
		this.infoclass = infoclass;
		this.videoId = videoId;
		this.flownumber = flownumber;
		this.clueId = clueId;
		this.style = style;
		this.description = description;
		this.suspected = suspected;
		this.edited = edited;
		if (editTime != null) {
			this.editTime = (Timestamp) editTime;
		}
		this.tagstyle = tagstyle;
		this.tagtext = tagtext;

		this.fileurl = fileName;
		this.playpath = fileName;
		this.editorId = editorId;

		if (picname != null) {
			String picPath = "/";
			try {
				picPath = snapshotFolder.substring(dataFolder.length() + 2) + "/";
			} catch (Exception e) {
			}
			this.picPath = "data/" + picPath + picname;
		}
	}

	public Long getEditorId() {
		return editorId;
	}

	public void setEditorId(Long editorId) {
		this.editorId = editorId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getTubeId() {
		return tubeId;
	}

	public void setTubeId(Long tubeId) {
		this.tubeId = tubeId;
	}

	public Long getCompId() {
		return compId;
	}

	public void setCompId(Long compId) {
		this.compId = compId;
	}

	public Integer getStartframe() {
		return startframe;
	}

	public void setStartframe(Integer startframe) {
		this.startframe = startframe;
	}

	public Integer getFrameCount() {
		return frameCount;
	}

	public void setFrameCount(Integer frameCount) {
		this.frameCount = frameCount;
	}

	public Float getFrameRate() {
		return frameRate;
	}

	public void setFrameRate(Float frameRate) {
		this.frameRate = frameRate;
	}

	public Timestamp getStartcalibtime() {
		return startcalibtime;
	}

	public void setStartcalibtime(Timestamp startcalibtime) {
		this.startcalibtime = startcalibtime;
	}

	public Timestamp getEndcalibtime() {
		return endcalibtime;
	}

	public void setEndcalibtime(Timestamp endcalibtime) {
		this.endcalibtime = endcalibtime;
	}

	public Long getCameraid() {
		return cameraid;
	}

	public void setCameraid(Long cameraid) {
		this.cameraid = cameraid;
	}

	public Short getInfoclass() {
		return infoclass;
	}

	public void setInfoclass(Short infoclass) {
		this.infoclass = infoclass;
	}

	public Long getVideoId() {
		return videoId;
	}

	public void setVideoId(Long videoId) {
		this.videoId = videoId;
	}

	public Long getFlownumber() {
		return flownumber;
	}

	public void setFlownumber(Long flownumber) {
		this.flownumber = flownumber;
	}

	public Long getClueId() {
		return clueId;
	}

	public void setClueId(Long clueId) {
		this.clueId = clueId;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Short getSuspected() {
		return suspected;
	}

	public void setSuspected(Short suspected) {
		this.suspected = suspected;
	}

	public Short getEdited() {
		return edited;
	}

	public void setEdited(Short edited) {
		this.edited = edited;
	}

	public Timestamp getEditTime() {
		return editTime;
	}

	public void setEditTime(Timestamp editTime) {
		this.editTime = editTime;
	}

	public String getFileurl() {
		return fileurl;
	}

	public void setFileurl(String fileurl) {
		this.fileurl = fileurl;
	}

	public String getPlaypath() {
		return playpath;
	}

	public void setPlaypath(String playpath) {
		this.playpath = playpath;
	}

	public Short getTagstyle() {
		return tagstyle;
	}

	public void setTagstyle(Short tagstyle) {
		this.tagstyle = tagstyle;
	}

	public String getTagtext() {
		return tagtext;
	}

	public void setTagtext(String tagtext) {
		this.tagtext = tagtext;
	}
}
