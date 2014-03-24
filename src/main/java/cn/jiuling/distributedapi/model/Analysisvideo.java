package cn.jiuling.distributedapi.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Analysisvideo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "analysisvideo")
public class Analysisvideo implements java.io.Serializable {

	// Fields

	private Long analysisId;
	private Orgvideolist orgvideolist;
	private Short analyStatusFlag;
	private Short analyCmd;
	private Short analyProgress;
	private Integer processedFramePts;
	private Short runTimeSpeed;
	private Short outputWidth;
	private Short outputHeight;
	private Float dropFrmRate;
	private Short sensitivity;
	private String dataFilename;
	private String bkgimgFilename;
	private String snapshotFolder;
	private String datatableFilename;
	private String completeTbiFilename;
	private String obiFilename;
	private Short udrExist;
	private String udrSetting;
	private Boolean udrIsInterest;
	private Short udrPolygonNum;
	private String udrVerticesNum;
	private String udrVertices;
	private Long analyStartFrm;
	private Long analyStartFrmIdxRef;
	private Long analyStartFrmPts;
	private Long analyEndFrm;
	private Long analyEndFrmIdxRef;
	private Long analyEndFrmPts;
	private Short analyFes;
	private Integer lastErrCode;
	private String lastErrMsg;
	private Short retryCount;
	private Timestamp createTime;
	private Set<Tube> tubes = new HashSet<Tube>(0);
	private Set<Bkgimage> bkgimages = new HashSet<Bkgimage>(0);
	private Set<Generatevideo> generatevideos = new HashSet<Generatevideo>(0);

	// Constructors

	/** default constructor */
	public Analysisvideo() {
	}

	public Analysisvideo(Short outputWidth, Short outputHeight) {
		super();
		this.outputWidth = outputWidth;
		this.outputHeight = outputHeight;
	}

	/** minimal constructor */
	public Analysisvideo(Orgvideolist orgvideolist, Timestamp createTime) {
		this.orgvideolist = orgvideolist;
		this.createTime = createTime;
	}

	/** full constructor */
	public Analysisvideo(Orgvideolist orgvideolist, Short analyStatusFlag, Short analyCmd, Short analyProgress, Integer processedFramePts, Short runTimeSpeed,
			Short outputWidth, Short outputHeight, Float dropFrmRate, Short sensitivity, String dataFilename, String bkgimgFilename, String snapshotFolder,
			String datatableFilename, String completeTbiFilename, String obiFilename, Short udrExist, String udrSetting, Boolean udrIsInterest,
			Short udrPolygonNum, String udrVerticesNum, String udrVertices, Long analyStartFrm, Long analyStartFrmIdxRef, Long analyStartFrmPts,
			Long analyEndFrm, Long analyEndFrmIdxRef, Long analyEndFrmPts, Short analyFes, Integer lastErrCode, String lastErrMsg, Short retryCount,
			Timestamp createTime, Set<Tube> tubes, Set<Bkgimage> bkgimages, Set<Generatevideo> generatevideos) {
		this.orgvideolist = orgvideolist;
		this.analyStatusFlag = analyStatusFlag;
		this.analyCmd = analyCmd;
		this.analyProgress = analyProgress;
		this.processedFramePts = processedFramePts;
		this.runTimeSpeed = runTimeSpeed;
		this.outputWidth = outputWidth;
		this.outputHeight = outputHeight;
		this.dropFrmRate = dropFrmRate;
		this.sensitivity = sensitivity;
		this.dataFilename = dataFilename;
		this.bkgimgFilename = bkgimgFilename;
		this.snapshotFolder = snapshotFolder;
		this.datatableFilename = datatableFilename;
		this.completeTbiFilename = completeTbiFilename;
		this.obiFilename = obiFilename;
		this.udrExist = udrExist;
		this.udrSetting = udrSetting;
		this.udrIsInterest = udrIsInterest;
		this.udrPolygonNum = udrPolygonNum;
		this.udrVerticesNum = udrVerticesNum;
		this.udrVertices = udrVertices;
		this.analyStartFrm = analyStartFrm;
		this.analyStartFrmIdxRef = analyStartFrmIdxRef;
		this.analyStartFrmPts = analyStartFrmPts;
		this.analyEndFrm = analyEndFrm;
		this.analyEndFrmIdxRef = analyEndFrmIdxRef;
		this.analyEndFrmPts = analyEndFrmPts;
		this.analyFes = analyFes;
		this.lastErrCode = lastErrCode;
		this.lastErrMsg = lastErrMsg;
		this.retryCount = retryCount;
		this.createTime = createTime;
		this.tubes = tubes;
		this.bkgimages = bkgimages;
		this.generatevideos = generatevideos;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "AnalysisID", unique = true, nullable = false)
	public Long getAnalysisId() {
		return this.analysisId;
	}

	public void setAnalysisId(Long analysisId) {
		this.analysisId = analysisId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OrgVideoID", nullable = false)
	public Orgvideolist getOrgvideolist() {
		return this.orgvideolist;
	}

	public void setOrgvideolist(Orgvideolist orgvideolist) {
		this.orgvideolist = orgvideolist;
	}

	@Column(name = "analy_status_flag")
	public Short getAnalyStatusFlag() {
		return this.analyStatusFlag;
	}

	public void setAnalyStatusFlag(Short analyStatusFlag) {
		this.analyStatusFlag = analyStatusFlag;
	}

	@Column(name = "analy_cmd")
	public Short getAnalyCmd() {
		return this.analyCmd;
	}

	public void setAnalyCmd(Short analyCmd) {
		this.analyCmd = analyCmd;
	}

	@Column(name = "analy_progress")
	public Short getAnalyProgress() {
		return this.analyProgress;
	}

	public void setAnalyProgress(Short analyProgress) {
		this.analyProgress = analyProgress;
	}

	@Column(name = "processed_frame_pts")
	public Integer getProcessedFramePts() {
		return this.processedFramePts;
	}

	public void setProcessedFramePts(Integer processedFramePts) {
		this.processedFramePts = processedFramePts;
	}

	@Column(name = "run_time_speed")
	public Short getRunTimeSpeed() {
		return this.runTimeSpeed;
	}

	public void setRunTimeSpeed(Short runTimeSpeed) {
		this.runTimeSpeed = runTimeSpeed;
	}

	@Column(name = "output_width")
	public Short getOutputWidth() {
		return this.outputWidth;
	}

	public void setOutputWidth(Short outputWidth) {
		this.outputWidth = outputWidth;
	}

	@Column(name = "output_height")
	public Short getOutputHeight() {
		return this.outputHeight;
	}

	public void setOutputHeight(Short outputHeight) {
		this.outputHeight = outputHeight;
	}

	@Column(name = "drop_frm_rate", precision = 12, scale = 0)
	public Float getDropFrmRate() {
		return this.dropFrmRate;
	}

	public void setDropFrmRate(Float dropFrmRate) {
		this.dropFrmRate = dropFrmRate;
	}

	@Column(name = "sensitivity")
	public Short getSensitivity() {
		return this.sensitivity;
	}

	public void setSensitivity(Short sensitivity) {
		this.sensitivity = sensitivity;
	}

	@Column(name = "data_filename")
	public String getDataFilename() {
		return this.dataFilename;
	}

	public void setDataFilename(String dataFilename) {
		this.dataFilename = dataFilename;
	}

	@Column(name = "bkgimg_filename")
	public String getBkgimgFilename() {
		return this.bkgimgFilename;
	}

	public void setBkgimgFilename(String bkgimgFilename) {
		this.bkgimgFilename = bkgimgFilename;
	}

	@Column(name = "snapshot_folder")
	public String getSnapshotFolder() {
		return this.snapshotFolder;
	}

	public void setSnapshotFolder(String snapshotFolder) {
		this.snapshotFolder = snapshotFolder;
	}

	@Column(name = "datatable_filename")
	public String getDatatableFilename() {
		return this.datatableFilename;
	}

	public void setDatatableFilename(String datatableFilename) {
		this.datatableFilename = datatableFilename;
	}

	@Column(name = "complete_tbi_filename")
	public String getCompleteTbiFilename() {
		return this.completeTbiFilename;
	}

	public void setCompleteTbiFilename(String completeTbiFilename) {
		this.completeTbiFilename = completeTbiFilename;
	}

	@Column(name = "obi_filename")
	public String getObiFilename() {
		return this.obiFilename;
	}

	public void setObiFilename(String obiFilename) {
		this.obiFilename = obiFilename;
	}

	@Column(name = "UDR_exist")
	public Short getUdrExist() {
		return this.udrExist;
	}

	public void setUdrExist(Short udrExist) {
		this.udrExist = udrExist;
	}

	@Column(name = "UDR_setting")
	public String getUdrSetting() {
		return this.udrSetting;
	}

	public void setUdrSetting(String udrSetting) {
		this.udrSetting = udrSetting;
	}

	@Column(name = "UDR_is_interest")
	public Boolean getUdrIsInterest() {
		return this.udrIsInterest;
	}

	public void setUdrIsInterest(Boolean udrIsInterest) {
		this.udrIsInterest = udrIsInterest;
	}

	@Column(name = "UDR_polygon_num")
	public Short getUdrPolygonNum() {
		return this.udrPolygonNum;
	}

	public void setUdrPolygonNum(Short udrPolygonNum) {
		this.udrPolygonNum = udrPolygonNum;
	}

	@Column(name = "UDR_vertices_num")
	public String getUdrVerticesNum() {
		return this.udrVerticesNum;
	}

	public void setUdrVerticesNum(String udrVerticesNum) {
		this.udrVerticesNum = udrVerticesNum;
	}

	@Column(name = "UDR_vertices")
	public String getUdrVertices() {
		return this.udrVertices;
	}

	public void setUdrVertices(String udrVertices) {
		this.udrVertices = udrVertices;
	}

	@Column(name = "analy_start_frm")
	public Long getAnalyStartFrm() {
		return this.analyStartFrm;
	}

	public void setAnalyStartFrm(Long analyStartFrm) {
		this.analyStartFrm = analyStartFrm;
	}

	@Column(name = "analy_start_frm_idx_ref")
	public Long getAnalyStartFrmIdxRef() {
		return this.analyStartFrmIdxRef;
	}

	public void setAnalyStartFrmIdxRef(Long analyStartFrmIdxRef) {
		this.analyStartFrmIdxRef = analyStartFrmIdxRef;
	}

	@Column(name = "analy_start_frm_pts")
	public Long getAnalyStartFrmPts() {
		return this.analyStartFrmPts;
	}

	public void setAnalyStartFrmPts(Long analyStartFrmPts) {
		this.analyStartFrmPts = analyStartFrmPts;
	}

	@Column(name = "analy_end_frm")
	public Long getAnalyEndFrm() {
		return this.analyEndFrm;
	}

	public void setAnalyEndFrm(Long analyEndFrm) {
		this.analyEndFrm = analyEndFrm;
	}

	@Column(name = "analy_end_frm_idx_ref")
	public Long getAnalyEndFrmIdxRef() {
		return this.analyEndFrmIdxRef;
	}

	public void setAnalyEndFrmIdxRef(Long analyEndFrmIdxRef) {
		this.analyEndFrmIdxRef = analyEndFrmIdxRef;
	}

	@Column(name = "analy_end_frm_pts")
	public Long getAnalyEndFrmPts() {
		return this.analyEndFrmPts;
	}

	public void setAnalyEndFrmPts(Long analyEndFrmPts) {
		this.analyEndFrmPts = analyEndFrmPts;
	}

	@Column(name = "analy_FES")
	public Short getAnalyFes() {
		return this.analyFes;
	}

	public void setAnalyFes(Short analyFes) {
		this.analyFes = analyFes;
	}

	@Column(name = "last_err_code")
	public Integer getLastErrCode() {
		return this.lastErrCode;
	}

	public void setLastErrCode(Integer lastErrCode) {
		this.lastErrCode = lastErrCode;
	}

	@Column(name = "last_err_msg")
	public String getLastErrMsg() {
		return this.lastErrMsg;
	}

	public void setLastErrMsg(String lastErrMsg) {
		this.lastErrMsg = lastErrMsg;
	}

	@Column(name = "retry_count")
	public Short getRetryCount() {
		return this.retryCount;
	}

	public void setRetryCount(Short retryCount) {
		this.retryCount = retryCount;
	}

	@Column(name = "create_time", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "analysisvideo")
	public Set<Tube> getTubes() {
		return this.tubes;
	}

	public void setTubes(Set<Tube> tubes) {
		this.tubes = tubes;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "analysisvideo")
	public Set<Bkgimage> getBkgimages() {
		return this.bkgimages;
	}

	public void setBkgimages(Set<Bkgimage> bkgimages) {
		this.bkgimages = bkgimages;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "analysisvideo")
	public Set<Generatevideo> getGeneratevideos() {
		return this.generatevideos;
	}

	public void setGeneratevideos(Set<Generatevideo> generatevideos) {
		this.generatevideos = generatevideos;
	}

}