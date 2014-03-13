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
 * Tube entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tube")
public class Tube implements java.io.Serializable {

	// Fields

	private Long tubeId;
	private Long analysisId;
	private Short objDetStatusFlag;
	private Short detCmd;
	private Short detPriority;
	private Boolean isGenSnapshot;
	private Integer tubeId_1;
	private Long startFrmIdxOrg;
	private Long startFrmIdxRefOrg;
	private Long startFrmPtsOrg;
	private Long endFrmIdxOrg;
	private Long endFrmIdxRefOrg;
	private Long endFrmPtsOrg;
	private Long numFrmOrg;
	private Long tubeFileOffset;
	private Integer tubeDataLen;
	private Integer tubeMaskDataLen;
	private Integer tubeColorDataLen;
	private Integer objTypeFv;
	private String objMovDirFv;
	private Short objMaxBbWidth;
	private Short objMaxBbHeight;
	private Short compSnapshotNum;
	private String compSnapshotInfo;
	private String tbiFilename;
	private Integer lastErrCode;
	private String lastErrMsg;
	private Short retryCount;
	private Set<Tubesnapshotinfo> tubesnapshotinfos = new HashSet<Tubesnapshotinfo>(0);

	// Constructors

	/** default constructor */
	public Tube() {
	}

	/** minimal constructor */
	public Tube(Long analysisId, Integer tubeId_1) {
		this.analysisId = analysisId;
		this.tubeId_1 = tubeId_1;
	}

	/** full constructor */
	public Tube(Long analysisId, Short objDetStatusFlag, Short detCmd, Short detPriority, Boolean isGenSnapshot, Integer tubeId_1, Long startFrmIdxOrg,
			Long startFrmIdxRefOrg, Long startFrmPtsOrg, Long endFrmIdxOrg, Long endFrmIdxRefOrg, Long endFrmPtsOrg, Long numFrmOrg, Long tubeFileOffset,
			Integer tubeDataLen, Integer tubeMaskDataLen, Integer tubeColorDataLen, Integer objTypeFv, String objMovDirFv, Short objMaxBbWidth,
			Short objMaxBbHeight, Short compSnapshotNum, String compSnapshotInfo, String tbiFilename, Integer lastErrCode, String lastErrMsg, Short retryCount,
			Set<Tubesnapshotinfo> tubesnapshotinfos) {
		this.analysisId = analysisId;
		this.objDetStatusFlag = objDetStatusFlag;
		this.detCmd = detCmd;
		this.detPriority = detPriority;
		this.isGenSnapshot = isGenSnapshot;
		this.tubeId_1 = tubeId_1;
		this.startFrmIdxOrg = startFrmIdxOrg;
		this.startFrmIdxRefOrg = startFrmIdxRefOrg;
		this.startFrmPtsOrg = startFrmPtsOrg;
		this.endFrmIdxOrg = endFrmIdxOrg;
		this.endFrmIdxRefOrg = endFrmIdxRefOrg;
		this.endFrmPtsOrg = endFrmPtsOrg;
		this.numFrmOrg = numFrmOrg;
		this.tubeFileOffset = tubeFileOffset;
		this.tubeDataLen = tubeDataLen;
		this.tubeMaskDataLen = tubeMaskDataLen;
		this.tubeColorDataLen = tubeColorDataLen;
		this.objTypeFv = objTypeFv;
		this.objMovDirFv = objMovDirFv;
		this.objMaxBbWidth = objMaxBbWidth;
		this.objMaxBbHeight = objMaxBbHeight;
		this.compSnapshotNum = compSnapshotNum;
		this.compSnapshotInfo = compSnapshotInfo;
		this.tbiFilename = tbiFilename;
		this.lastErrCode = lastErrCode;
		this.lastErrMsg = lastErrMsg;
		this.retryCount = retryCount;
		this.tubesnapshotinfos = tubesnapshotinfos;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TubeID", unique = true, nullable = false)
	public Long getTubeId() {
		return this.tubeId;
	}

	public void setTubeId(Long tubeId) {
		this.tubeId = tubeId;
	}

	@Column(name = "AnalysisID", nullable = false)
	public Long getAnalysisId() {
		return this.analysisId;
	}

	public void setAnalysisId(Long analysisId) {
		this.analysisId = analysisId;
	}

	@Column(name = "obj_det_status_flag")
	public Short getObjDetStatusFlag() {
		return this.objDetStatusFlag;
	}

	public void setObjDetStatusFlag(Short objDetStatusFlag) {
		this.objDetStatusFlag = objDetStatusFlag;
	}

	@Column(name = "det_cmd")
	public Short getDetCmd() {
		return this.detCmd;
	}

	public void setDetCmd(Short detCmd) {
		this.detCmd = detCmd;
	}

	@Column(name = "det_priority")
	public Short getDetPriority() {
		return this.detPriority;
	}

	public void setDetPriority(Short detPriority) {
		this.detPriority = detPriority;
	}

	@Column(name = "is_gen_snapshot")
	public Boolean getIsGenSnapshot() {
		return this.isGenSnapshot;
	}

	public void setIsGenSnapshot(Boolean isGenSnapshot) {
		this.isGenSnapshot = isGenSnapshot;
	}

	@Column(name = "tube_id", nullable = false)
	public Integer getTubeId_1() {
		return this.tubeId_1;
	}

	public void setTubeId_1(Integer tubeId_1) {
		this.tubeId_1 = tubeId_1;
	}

	@Column(name = "start_frm_idx_org")
	public Long getStartFrmIdxOrg() {
		return this.startFrmIdxOrg;
	}

	public void setStartFrmIdxOrg(Long startFrmIdxOrg) {
		this.startFrmIdxOrg = startFrmIdxOrg;
	}

	@Column(name = "start_frm_idx_ref_org")
	public Long getStartFrmIdxRefOrg() {
		return this.startFrmIdxRefOrg;
	}

	public void setStartFrmIdxRefOrg(Long startFrmIdxRefOrg) {
		this.startFrmIdxRefOrg = startFrmIdxRefOrg;
	}

	@Column(name = "start_frm_pts_org")
	public Long getStartFrmPtsOrg() {
		return this.startFrmPtsOrg;
	}

	public void setStartFrmPtsOrg(Long startFrmPtsOrg) {
		this.startFrmPtsOrg = startFrmPtsOrg;
	}

	@Column(name = "end_frm_idx_org")
	public Long getEndFrmIdxOrg() {
		return this.endFrmIdxOrg;
	}

	public void setEndFrmIdxOrg(Long endFrmIdxOrg) {
		this.endFrmIdxOrg = endFrmIdxOrg;
	}

	@Column(name = "end_frm_idx_ref_org")
	public Long getEndFrmIdxRefOrg() {
		return this.endFrmIdxRefOrg;
	}

	public void setEndFrmIdxRefOrg(Long endFrmIdxRefOrg) {
		this.endFrmIdxRefOrg = endFrmIdxRefOrg;
	}

	@Column(name = "end_frm_pts_org")
	public Long getEndFrmPtsOrg() {
		return this.endFrmPtsOrg;
	}

	public void setEndFrmPtsOrg(Long endFrmPtsOrg) {
		this.endFrmPtsOrg = endFrmPtsOrg;
	}

	@Column(name = "num_frm_org")
	public Long getNumFrmOrg() {
		return this.numFrmOrg;
	}

	public void setNumFrmOrg(Long numFrmOrg) {
		this.numFrmOrg = numFrmOrg;
	}

	@Column(name = "tube_file_offset")
	public Long getTubeFileOffset() {
		return this.tubeFileOffset;
	}

	public void setTubeFileOffset(Long tubeFileOffset) {
		this.tubeFileOffset = tubeFileOffset;
	}

	@Column(name = "tube_data_len")
	public Integer getTubeDataLen() {
		return this.tubeDataLen;
	}

	public void setTubeDataLen(Integer tubeDataLen) {
		this.tubeDataLen = tubeDataLen;
	}

	@Column(name = "tube_mask_data_len")
	public Integer getTubeMaskDataLen() {
		return this.tubeMaskDataLen;
	}

	public void setTubeMaskDataLen(Integer tubeMaskDataLen) {
		this.tubeMaskDataLen = tubeMaskDataLen;
	}

	@Column(name = "tube_color_data_len")
	public Integer getTubeColorDataLen() {
		return this.tubeColorDataLen;
	}

	public void setTubeColorDataLen(Integer tubeColorDataLen) {
		this.tubeColorDataLen = tubeColorDataLen;
	}

	@Column(name = "obj_type_fv")
	public Integer getObjTypeFv() {
		return this.objTypeFv;
	}

	public void setObjTypeFv(Integer objTypeFv) {
		this.objTypeFv = objTypeFv;
	}

	@Column(name = "obj_mov_dir_fv")
	public String getObjMovDirFv() {
		return this.objMovDirFv;
	}

	public void setObjMovDirFv(String objMovDirFv) {
		this.objMovDirFv = objMovDirFv;
	}

	@Column(name = "obj_max_bb_width")
	public Short getObjMaxBbWidth() {
		return this.objMaxBbWidth;
	}

	public void setObjMaxBbWidth(Short objMaxBbWidth) {
		this.objMaxBbWidth = objMaxBbWidth;
	}

	@Column(name = "obj_max_bb_height")
	public Short getObjMaxBbHeight() {
		return this.objMaxBbHeight;
	}

	public void setObjMaxBbHeight(Short objMaxBbHeight) {
		this.objMaxBbHeight = objMaxBbHeight;
	}

	@Column(name = "comp_snapshot_num")
	public Short getCompSnapshotNum() {
		return this.compSnapshotNum;
	}

	public void setCompSnapshotNum(Short compSnapshotNum) {
		this.compSnapshotNum = compSnapshotNum;
	}

	@Column(name = "comp_snapshot_info")
	public String getCompSnapshotInfo() {
		return this.compSnapshotInfo;
	}

	public void setCompSnapshotInfo(String compSnapshotInfo) {
		this.compSnapshotInfo = compSnapshotInfo;
	}

	@Column(name = "tbi_filename")
	public String getTbiFilename() {
		return this.tbiFilename;
	}

	public void setTbiFilename(String tbiFilename) {
		this.tbiFilename = tbiFilename;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tube")
	public Set<Tubesnapshotinfo> getTubesnapshotinfos() {
		return this.tubesnapshotinfos;
	}

	public void setTubesnapshotinfos(Set<Tubesnapshotinfo> tubesnapshotinfos) {
		this.tubesnapshotinfos = tubesnapshotinfos;
	}

}