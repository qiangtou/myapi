package cn.jiuling.distributedapi.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Orgvideolist entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "orgvideolist")
public class Orgvideolist implements java.io.Serializable {

	// Fields

	private Long orgVideoId;
	private String videoFilename;
	private Short frmWidth;
	private Short frmHeight;
	private Float frmRate;
	private Short fileType;
	private Integer frmNum;
	private Integer timeDurationSec;
	private Set<Analysisvideo> analysisvideos = new HashSet<Analysisvideo>(0);

	// Constructors

	/** default constructor */
	public Orgvideolist() {
	}

	/** minimal constructor */
	public Orgvideolist(String videoFilename) {
		this.videoFilename = videoFilename;
	}

	/** full constructor */
	public Orgvideolist(String videoFilename, Short frmWidth, Short frmHeight, Float frmRate, Short fileType, Integer frmNum, Integer timeDurationSec,
			Set<Analysisvideo> analysisvideos) {
		this.videoFilename = videoFilename;
		this.frmWidth = frmWidth;
		this.frmHeight = frmHeight;
		this.frmRate = frmRate;
		this.fileType = fileType;
		this.frmNum = frmNum;
		this.timeDurationSec = timeDurationSec;
		this.analysisvideos = analysisvideos;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "OrgVideoID", unique = true, nullable = false)
	public Long getOrgVideoId() {
		return this.orgVideoId;
	}

	public void setOrgVideoId(Long orgVideoId) {
		this.orgVideoId = orgVideoId;
	}

	@Column(name = "video_filename", nullable = false)
	public String getVideoFilename() {
		return this.videoFilename;
	}

	public void setVideoFilename(String videoFilename) {
		this.videoFilename = videoFilename;
	}

	@Column(name = "frm_width")
	public Short getFrmWidth() {
		return this.frmWidth;
	}

	public void setFrmWidth(Short frmWidth) {
		this.frmWidth = frmWidth;
	}

	@Column(name = "frm_height")
	public Short getFrmHeight() {
		return this.frmHeight;
	}

	public void setFrmHeight(Short frmHeight) {
		this.frmHeight = frmHeight;
	}

	@Column(name = "frm_rate", precision = 12, scale = 0)
	public Float getFrmRate() {
		return this.frmRate;
	}

	public void setFrmRate(Float frmRate) {
		this.frmRate = frmRate;
	}

	@Column(name = "file_type")
	public Short getFileType() {
		return this.fileType;
	}

	public void setFileType(Short fileType) {
		this.fileType = fileType;
	}

	@Column(name = "frm_num")
	public Integer getFrmNum() {
		return this.frmNum;
	}

	public void setFrmNum(Integer frmNum) {
		this.frmNum = frmNum;
	}

	@Column(name = "time_duration_sec")
	public Integer getTimeDurationSec() {
		return this.timeDurationSec;
	}

	public void setTimeDurationSec(Integer timeDurationSec) {
		this.timeDurationSec = timeDurationSec;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "orgvideolist")
	public Set<Analysisvideo> getAnalysisvideos() {
		return this.analysisvideos;
	}

	public void setAnalysisvideos(Set<Analysisvideo> analysisvideos) {
		this.analysisvideos = analysisvideos;
	}

}