package cn.jiuling.distributedapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Tubesnapshotinfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tubesnapshotinfo")
public class Tubesnapshotinfo implements java.io.Serializable {

	// Fields

	private Long tubeSnapshotId;
	private Tube tube;
	private Long frameIdx;
	private Long frameIdxRef;
	private Long framePts;
	private Long numOfFrm;
	private Short componentId;
	private Long appearStartFrmIdx;
	private Long appearStartFrmIdxRef;
	private Long appearStartFrmPts;
	private Short width;
	private Short height;
	private Short bbUlX;
	private Short bbUlY;
	private String filename;

	// Constructors

	/** default constructor */
	public Tubesnapshotinfo() {
	}

	/** minimal constructor */
	public Tubesnapshotinfo(Tube tube, Long frameIdx, Long numOfFrm, Short componentId) {
		this.tube = tube;
		this.frameIdx = frameIdx;
		this.numOfFrm = numOfFrm;
		this.componentId = componentId;
	}

	/** full constructor */
	public Tubesnapshotinfo(Tube tube, Long frameIdx, Long frameIdxRef, Long framePts, Long numOfFrm, Short componentId, Long appearStartFrmIdx,
			Long appearStartFrmIdxRef, Long appearStartFrmPts, Short width, Short height, Short bbUlX, Short bbUlY, String filename) {
		this.tube = tube;
		this.frameIdx = frameIdx;
		this.frameIdxRef = frameIdxRef;
		this.framePts = framePts;
		this.numOfFrm = numOfFrm;
		this.componentId = componentId;
		this.appearStartFrmIdx = appearStartFrmIdx;
		this.appearStartFrmIdxRef = appearStartFrmIdxRef;
		this.appearStartFrmPts = appearStartFrmPts;
		this.width = width;
		this.height = height;
		this.bbUlX = bbUlX;
		this.bbUlY = bbUlY;
		this.filename = filename;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TubeSnapshotID", unique = true, nullable = false)
	public Long getTubeSnapshotId() {
		return this.tubeSnapshotId;
	}

	public void setTubeSnapshotId(Long tubeSnapshotId) {
		this.tubeSnapshotId = tubeSnapshotId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TubeID", nullable = false)
	public Tube getTube() {
		return this.tube;
	}

	public void setTube(Tube tube) {
		this.tube = tube;
	}

	@Column(name = "frame_idx", nullable = false)
	public Long getFrameIdx() {
		return this.frameIdx;
	}

	public void setFrameIdx(Long frameIdx) {
		this.frameIdx = frameIdx;
	}

	@Column(name = "frame_idx_ref")
	public Long getFrameIdxRef() {
		return this.frameIdxRef;
	}

	public void setFrameIdxRef(Long frameIdxRef) {
		this.frameIdxRef = frameIdxRef;
	}

	@Column(name = "frame_pts")
	public Long getFramePts() {
		return this.framePts;
	}

	public void setFramePts(Long framePts) {
		this.framePts = framePts;
	}

	@Column(name = "num_of_frm", nullable = false)
	public Long getNumOfFrm() {
		return this.numOfFrm;
	}

	public void setNumOfFrm(Long numOfFrm) {
		this.numOfFrm = numOfFrm;
	}

	@Column(name = "component_id", nullable = false)
	public Short getComponentId() {
		return this.componentId;
	}

	public void setComponentId(Short componentId) {
		this.componentId = componentId;
	}

	@Column(name = "appear_start_frm_idx")
	public Long getAppearStartFrmIdx() {
		return this.appearStartFrmIdx;
	}

	public void setAppearStartFrmIdx(Long appearStartFrmIdx) {
		this.appearStartFrmIdx = appearStartFrmIdx;
	}

	@Column(name = "appear_start_frm_idx_ref")
	public Long getAppearStartFrmIdxRef() {
		return this.appearStartFrmIdxRef;
	}

	public void setAppearStartFrmIdxRef(Long appearStartFrmIdxRef) {
		this.appearStartFrmIdxRef = appearStartFrmIdxRef;
	}

	@Column(name = "appear_start_frm_pts")
	public Long getAppearStartFrmPts() {
		return this.appearStartFrmPts;
	}

	public void setAppearStartFrmPts(Long appearStartFrmPts) {
		this.appearStartFrmPts = appearStartFrmPts;
	}

	@Column(name = "width")
	public Short getWidth() {
		return this.width;
	}

	public void setWidth(Short width) {
		this.width = width;
	}

	@Column(name = "height")
	public Short getHeight() {
		return this.height;
	}

	public void setHeight(Short height) {
		this.height = height;
	}

	@Column(name = "bb_ul_x")
	public Short getBbUlX() {
		return this.bbUlX;
	}

	public void setBbUlX(Short bbUlX) {
		this.bbUlX = bbUlX;
	}

	@Column(name = "bb_ul_y")
	public Short getBbUlY() {
		return this.bbUlY;
	}

	public void setBbUlY(Short bbUlY) {
		this.bbUlY = bbUlY;
	}

	@Column(name = "filename")
	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

}