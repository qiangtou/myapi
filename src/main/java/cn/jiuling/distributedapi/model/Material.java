package cn.jiuling.distributedapi.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Material entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tbl_material")
public class Material implements java.io.Serializable {

	// Fields

	private Long id;
	private String title;
	private Long tubeId;
	private Long compId;
	private Integer startframe;
	private Integer frameCount;
	private Float frameRate;
	private Timestamp startcalibtime;
	private Timestamp endcalibtime;
	private Long cameraid;
	private Short infoclass;
	private String filename;
	private String picname;
	private Long flownumber;
	private Long videoId;
	private Long clueId;
	private String style;
	private String description;
	private Short suspected;
	private Short tagstyle;
	private String tagtext;
	private Short edited;
	private Timestamp editTime;
	private Long editorId;

	// Constructors

	/** default constructor */
	public Material() {
	}

	/** minimal constructor */
	public Material(String title, Long tubeId, Long compId, Integer startframe, Integer frameCount, Float frameRate, Timestamp startcalibtime,
			Timestamp endcalibtime, Long cameraid, Short infoclass, String filename, Long flownumber, Long videoId, Long clueId, String style,
			String description, Short suspected, Short tagstyle, String tagtext, Short edited, Timestamp editTime, Long editorId) {
		this.title = title;
		this.tubeId = tubeId;
		this.compId = compId;
		this.startframe = startframe;
		this.frameCount = frameCount;
		this.frameRate = frameRate;
		this.startcalibtime = startcalibtime;
		this.endcalibtime = endcalibtime;
		this.cameraid = cameraid;
		this.infoclass = infoclass;
		this.filename = filename;
		this.flownumber = flownumber;
		this.videoId = videoId;
		this.clueId = clueId;
		this.style = style;
		this.description = description;
		this.suspected = suspected;
		this.tagstyle = tagstyle;
		this.tagtext = tagtext;
		this.edited = edited;
		this.editTime = editTime;
		this.editorId = editorId;
	}

	/** full constructor */
	public Material(String title, Long tubeId, Long compId, Integer startframe, Integer frameCount, Float frameRate, Timestamp startcalibtime,
			Timestamp endcalibtime, Long cameraid, Short infoclass, String filename, String picname, Long flownumber, Long videoId, Long clueId, String style,
			String description, Short suspected, Short tagstyle, String tagtext, Short edited, Timestamp editTime, Long editorId) {
		this.title = title;
		this.tubeId = tubeId;
		this.compId = compId;
		this.startframe = startframe;
		this.frameCount = frameCount;
		this.frameRate = frameRate;
		this.startcalibtime = startcalibtime;
		this.endcalibtime = endcalibtime;
		this.cameraid = cameraid;
		this.infoclass = infoclass;
		this.filename = filename;
		this.picname = picname;
		this.flownumber = flownumber;
		this.videoId = videoId;
		this.clueId = clueId;
		this.style = style;
		this.description = description;
		this.suspected = suspected;
		this.tagstyle = tagstyle;
		this.tagtext = tagtext;
		this.edited = edited;
		this.editTime = editTime;
		this.editorId = editorId;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "title", nullable = false, length = 2048)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "TubeID", nullable = false)
	public Long getTubeId() {
		return this.tubeId;
	}

	public void setTubeId(Long tubeId) {
		this.tubeId = tubeId;
	}

	@Column(name = "CompID", nullable = false)
	public Long getCompId() {
		return this.compId;
	}

	public void setCompId(Long compId) {
		this.compId = compId;
	}

	@Column(name = "startframe", nullable = false)
	public Integer getStartframe() {
		return this.startframe;
	}

	public void setStartframe(Integer startframe) {
		this.startframe = startframe;
	}

	@Column(name = "FrameCount", nullable = false)
	public Integer getFrameCount() {
		return this.frameCount;
	}

	public void setFrameCount(Integer frameCount) {
		this.frameCount = frameCount;
	}

	@Column(name = "FrameRate", nullable = false, precision = 12, scale = 0)
	public Float getFrameRate() {
		return this.frameRate;
	}

	public void setFrameRate(Float frameRate) {
		this.frameRate = frameRate;
	}

	@Column(name = "startcalibtime", nullable = false, length = 19)
	public Timestamp getStartcalibtime() {
		return this.startcalibtime;
	}

	public void setStartcalibtime(Timestamp startcalibtime) {
		this.startcalibtime = startcalibtime;
	}

	@Column(name = "endcalibtime", nullable = false, length = 19)
	public Timestamp getEndcalibtime() {
		return this.endcalibtime;
	}

	public void setEndcalibtime(Timestamp endcalibtime) {
		this.endcalibtime = endcalibtime;
	}

	@Column(name = "cameraid", nullable = false)
	public Long getCameraid() {
		return this.cameraid;
	}

	public void setCameraid(Long cameraid) {
		this.cameraid = cameraid;
	}

	@Column(name = "Infoclass", nullable = false)
	public Short getInfoclass() {
		return this.infoclass;
	}

	public void setInfoclass(Short infoclass) {
		this.infoclass = infoclass;
	}

	@Column(name = "filename", nullable = false, length = 512)
	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	@Column(name = "picname", length = 512)
	public String getPicname() {
		return this.picname;
	}

	public void setPicname(String picname) {
		this.picname = picname;
	}

	@Column(name = "flownumber", nullable = false)
	public Long getFlownumber() {
		return this.flownumber;
	}

	public void setFlownumber(Long flownumber) {
		this.flownumber = flownumber;
	}

	@Column(name = "VideoID", nullable = false)
	public Long getVideoId() {
		return this.videoId;
	}

	public void setVideoId(Long videoId) {
		this.videoId = videoId;
	}

	@Column(name = "ClueID", nullable = false)
	public Long getClueId() {
		return this.clueId;
	}

	public void setClueId(Long clueId) {
		this.clueId = clueId;
	}

	@Column(name = "style", nullable = false)
	public String getStyle() {
		return this.style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	@Column(name = "description", nullable = false)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "Suspected", nullable = false)
	public Short getSuspected() {
		return this.suspected;
	}

	public void setSuspected(Short suspected) {
		this.suspected = suspected;
	}

	@Column(name = "tagstyle", nullable = false)
	public Short getTagstyle() {
		return this.tagstyle;
	}

	public void setTagstyle(Short tagstyle) {
		this.tagstyle = tagstyle;
	}

	@Column(name = "tagtext", nullable = false)
	public String getTagtext() {
		return this.tagtext;
	}

	public void setTagtext(String tagtext) {
		this.tagtext = tagtext;
	}

	@Column(name = "Edited", nullable = false)
	public Short getEdited() {
		return this.edited;
	}

	public void setEdited(Short edited) {
		this.edited = edited;
	}

	@Column(name = "EditTime", nullable = false, length = 19)
	public Timestamp getEditTime() {
		return this.editTime;
	}

	public void setEditTime(Timestamp editTime) {
		this.editTime = editTime;
	}

	@Column(name = "EditorID", nullable = false)
	public Long getEditorId() {
		return this.editorId;
	}

	public void setEditorId(Long editorId) {
		this.editorId = editorId;
	}

}